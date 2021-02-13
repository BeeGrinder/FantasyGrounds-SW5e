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
 *  this program is to get data from the newer SW5e website json data and load it into a database along with 
 *  the old spell data from the fantasy ground sw5e module so they can be compared.
 *  
 *  This program should do minimal data manipulation to put the data in a good state, but how the data 
 *  is used and parsed should be in the sw5e-generator program which consumes the database made by this program.
 *  
 */
public class CreatePowerData {

	private static final String spellJsonFileName = "spells.json";
	private static final String spellXmlFileName = "supplement_spells.xml";
	private static final String sql = "create table IF NOT EXISTS powers(" + "primary_key INTEGER PRIMARY KEY"
			+ ", name TEXT NOT NULL" + ", new_json INTEGER DEFAULT 0" + ", old_xml INTEGER DEFAULT 0"
			+ ", sw5e_description TEXT NULL" + ", description TEXT NULL" + ", actions TEXT null"
			+ ", casting_time text null, old_casting_time text null" 
			+ ", duration text null, old_duration text null" + ", power_group text null" 
			+ ", power_level integer DEFAULT 0,old_level integer DEFAULT 0"
			+ ", range text null, old_range text null, concentration integer DEFAULT 0" 
			+ ", school text null" + ", power_source text null, special_spell integer DEFAULT 0" + ");";
	private static final String insertJsonSql = "insert into powers"
			+ "(name, new_json,sw5e_description, casting_time, duration, power_level, range, power_source,school,old_xml,concentration)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String insertXmlSql = "insert into powers"
			+ "(name,new_json, old_xml,description, casting_time, duration, power_level, range, power_source,school,actions)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String updateXmlSql="update powers set "
			+" old_xml =?,description=?, old_casting_time=?,old_duration=?,old_level=?,old_range=?,actions=? "
			+"where primary_key = ?";
	private static final String findJsonRecordSql="select primary_key from powers where name = ?";
	private static List<Power> powerListsw5e = new ArrayList<>();
	private static List<Spell> spellListXml = new ArrayList<>();

	public static void main(String[] args) throws SQLException {
		Connection con = connect();
		try {
			// read old FG XML file into objects
			spellListXml = getSpellsFromXml();
			// read json from sw5e website
			loadSpellJsonFile();
			// insert from sw5e site objects into db
			int c = insertPowerListsw5e(con);
			System.out.println("Added " + c + " spells from json.");
			// insert from old supplement xml into db
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

	private static int insertPowerListsw5e(Connection con) throws SQLException {

		int count = 1;
		PreparedStatement stmt=null;

		for (Power p : powerListsw5e) {
			if( p.getContentSource().equals("PHB")) {
				try {
					stmt = con.prepareStatement(insertJsonSql);
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
					stmt.setInt(11, p.getConcentration()?1:0);
					stmt.executeUpdate();
					stmt.close();
					count++;
				} catch (SQLException e) {
					e.printStackTrace();
					System.exit(1);
				} finally {
					stmt.close();
				}
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
