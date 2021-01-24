package com.beegrinder.sw5e.powers;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
 *  the powers program is meant to collect the differences between the existing (xml) spell list
 *  and the spell list from sw5e.com (json)
 *  
 *  New/changed spells can be found more easily and have a set of actions added in the database.
 *  
 *  Once the reconciliation is complete, a clean set of updated spells can be generate for fantasy grounds
 *  
 */
public class powers {

	private static final String spellJsonFileName = "../sw5e-generator/spells.json";
	private static final String spellXmlFileName = "supplement_spells.xml";
	private static final String sql = "create table IF NOT EXISTS powers(" + "primary_key INTEGER PRIMARY KEY"
			+ ", name TEXT NOT NULL" + ", in_json INTEGER NULL" + ", in_xml INTEGER NULL"
			+ ", sw5e_description TEXT NULL" + ", description TEXT NULL" + ", actions TEXT null"
			+ ", casting_time text null, xml_casting_time text null" 
			+ ", duration text null, xml_duration text null" + ", power_group text null" 
			+ ", power_level integer null,xml_level integer null"
			+ ", range text null, xml_range text null" 
			+ ", school text null" + ", power_source text null" + ");";
	private static final String insertJsonSql = "insert into powers"
			+ "(name, in_json,sw5e_description, casting_time, duration, power_level, range, power_source,school,in_xml)"
			+ "values (?,?,?,?,?,?,?,?,?,?)";
	private static final String insertXmlSql = "insert into powers"
			+ "(name,in_json, in_xml,description, casting_time, duration, power_level, range, power_source,school,actions)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String updateXmlSql="update powers set "
			+" in_xml =?,description=?, xml_casting_time=?,xml_duration=?,xml_level=?,xml_range=?,actions=? "
			+"where primary_key = ?";
	private static final String findJsonRecordSql="select primary_key from powers where name = ?";
	private static List<Power> powerListsw5e = new ArrayList<>();
	private static List<Spell> spellListXml = new ArrayList<>();

	public static void main(String[] args) throws SQLException {
		Connection con = connect();
		try {
			spellListXml = getSpellsFromXml();
			loadSpellJsonFile();
			int c = insertPowerListsw5e(con);
			System.out.println("Added " + c + " spells from json.");
			int x = procesPowerListXml(con);
			System.out.println("Processed " + x + " spells from xml.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

	private static int procesPowerListXml(Connection con) {
		Integer count = 0;
		for(Spell s:spellListXml) {
			try {
				PreparedStatement findStatement=con.prepareStatement(findJsonRecordSql);
				findStatement.setString(1, s.name);
				Integer indexKey=0;
				ResultSet rs=findStatement.executeQuery();
				Integer rsSize=0;
				while(rs.next()) {
					indexKey=rs.getInt("primary_key");
					rsSize++;
				}
				if( rsSize == 0) {
//					System.out.println("Inserting");
					PreparedStatement insStmt=con.prepareStatement(insertXmlSql);
					//(name,in_json, in_xml,description, casting_time, duration, power_level, range, power_source,school)
					insStmt.setString(1, s.name);
					insStmt.setInt(2, 0);
					insStmt.setInt(3, 1);
					insStmt.setString(4, s.description);
					insStmt.setString(5, s.castingtime);
					insStmt.setString(6, s.duration);
					insStmt.setInt(7, s.level);
					insStmt.setString(8, s.range);
					insStmt.setString(9, s.source);
					insStmt.setString(10, s.school);
					insStmt.setString(11, s.actions);
					if(insStmt.executeUpdate()!=1) {
						throw new Exception("Bad insert. name: "+s.name);
					}
					insStmt.close();
					count++;
				} else if (rsSize == 1 ) {
//					System.out.println("Updating key: "+indexKey);
					PreparedStatement upStmt=con.prepareStatement(updateXmlSql);
					upStmt.setInt(1, 1);
					upStmt.setString(2, s.description);
					upStmt.setString(3, s.castingtime);
					upStmt.setString(4, s.duration);
					upStmt.setInt(5, s.level);
					upStmt.setString(6, s.range);
					upStmt.setString(7, s.actions);
					upStmt.setInt(8, indexKey);
					if(upStmt.executeUpdate()!=1) {
						throw new Exception("Bad update name: "+s.name+" key: "+indexKey);
					}
					upStmt.close();
					count++;
				} else {
					throw new Exception("Bad Result on query of name: "+s.name+" count:"+rsSize);
				}
				findStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return count;
	}

	private static int insertPowerListsw5e(Connection con) {

		int count = 1;


		for (Power p : powerListsw5e) {

			try {
				PreparedStatement stmt = con.prepareStatement(insertJsonSql);
				stmt.setString(1, p.getName());
				stmt.setInt(2, 1);
				stmt.setString(3, p.getDescription());
				stmt.setString(4, p.getCastingPeriodText());
				stmt.setString(5, p.getDuration());
				stmt.setInt(6, p.getLevel());
				stmt.setString(7, p.getRange());
				stmt.setString(8, p.getPowerType());
				if (p.getPowerType().equals("Force")) {
					stmt.setString(9, p.getForceAlignment());
				} else {
					stmt.setString(9, p.getPowerType());
				}
				stmt.setInt(10, 0);
				stmt.executeUpdate();
				stmt.close();
				count++;
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return count;
	}

	private static List<Spell> getSpellsFromXml() throws ParserConfigurationException, SAXException, IOException {
		List<Spell> retVal = new ArrayList<>();
		File file = new File(spellXmlFileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		Node rootNode = doc.getDocumentElement();
		NodeList nList = rootNode.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Spell curSpell = new Spell();
				NodeList spellnodelist = node.getChildNodes();
				for (int ii = 0; ii < spellnodelist.getLength(); ii++) {
					Node n = spellnodelist.item(ii);
					if (n.getNodeType() == Node.ELEMENT_NODE) {
						if (n.getNodeName().equals("actions")) {
							curSpell.actions = nodeToString(n);
						}
						if (n.getNodeName().equals("name")) {
							curSpell.name = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("cast")) {
							curSpell.cast = Integer.decode(n.getTextContent().trim());
						}
						if (n.getNodeName().equals("castingtime")) {
							curSpell.castingtime = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("components")) {
							curSpell.components = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("description")) {
							curSpell.description = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("duration")) {
							curSpell.duration = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("group")) {
							curSpell.group = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("level")) {
							curSpell.level = Integer.decode(n.getTextContent().trim());
						}
						if (n.getNodeName().equals("prepared")) {
							curSpell.prepared = Integer.decode(n.getTextContent().trim());
						}
						if (n.getNodeName().equals("range")) {
							curSpell.range = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("ritual")) {
							curSpell.ritual = Integer.decode(n.getTextContent().trim());
						}
						if (n.getNodeName().equals("school")) {
							curSpell.school = n.getTextContent().trim();
						}
						if (n.getNodeName().equals("source")) {
							curSpell.source = n.getTextContent().trim();
						}
					}

				}
				retVal.add(curSpell);
			}
		}
		return retVal;
	}

	private static String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "no");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException te) {
			System.out.println("nodeToString Transformer Exception");
		}
		return sw.toString().replaceAll("\t", "").replaceAll("\n", "").replaceAll("\r", "");
	}

	private static Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:powers.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			Statement s1 = conn.createStatement();
			s1.execute("drop table if exists powers;");
			s1.close();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return conn;
	}

	private static void loadSpellJsonFile() {
		try {
			Path filePath = Path.of(spellJsonFileName);
			String content = Files.readString(filePath, StandardCharsets.UTF_8);
			powerListsw5e = powerListFromJson(content);
		} catch (NoSuchFileException nsf) {
			nsf.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static List<Power> powerListFromJson(String powerJson) {

		List<Power> retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
//			TypeFactory typeFactory = objectMapper.getTypeFactory();	
		try {
			if (StringUtils.isBlank(powerJson)) {
				throw new Exception("Spell data is empty");
			}
			Power[] powerArray = objectMapper.readValue(powerJson, Power[].class);
			retVal = Arrays.asList(powerArray);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return retVal;
	}

}
