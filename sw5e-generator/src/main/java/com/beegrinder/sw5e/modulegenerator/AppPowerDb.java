package com.beegrinder.sw5e.modulegenerator;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Spell;

public class AppPowerDb {

	private static final String SQL_GET_SPELL_COUNT = "select count(*) cnt from powers where new_json=1";
	//private static final String getSpellsSQL = "select * from powers where new_json=1 and ifnull(special_spell,0) =0";
	private static final String SQL_GET_SPELLS = "select * from powers where (new_json=1 and ifnull(special_spell,0) =0) or (new_json =0 and name like '%:%')";
	private static final String SQL_CREATE_EQUIP_TABLE ="CREATE TABLE if not exists equipment(primary_key integer primary key,  name text not null,  description text,  cost integer,  weight text,  equipmentCategoryEnum integer,  equipmentCategory text,  damageNumberOfDice integer,  damageTypeEnum integer,  damageType text,  damageDieModifier integer,  weaponClassificationEnum integer,  weaponClassification text,  armorClassificationEnum integer,  armorClassification text,  damageDiceDieTypeEnum integer,  damageDieType integer,  propertiesJson text,  propertiesMapJson text,  modesJson text,  ac text,  stealthDisadvantage integer ,  contentTypeEnum integer ,  contentType text,  contentSourceEnum integer ,  contentSource text,  partitionKey text)";
	private static final String SQL_INSERT_EQUIP = "INSERT INTO equipment (name, description, cost, weight, equipmentCategoryEnum, equipmentCategory, damageNumberOfDice, damageTypeEnum, damageType, damageDieModifier, weaponClassificationEnum, weaponClassification, armorClassificationEnum, armorClassification, damageDiceDieTypeEnum, damageDieType, propertiesJson, propertiesMapJson, modesJson, ac, stealthDisadvantage, contentTypeEnum, contentType, contentSourceEnum, contentSource, partitionKey) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static void addEquipmentToDb(Equipment e) throws SQLException {
		PreparedStatement stmt=null;
		try {
			stmt=ModuleGenerator.conn.prepareStatement(SQL_INSERT_EQUIP);
			stmt.setString(1,e.getName());
			stmt.setString(2, e.getDescription());
			stmt.setInt(3, e.getCost());
			stmt.setString(4, e.getWeight());
			stmt.setInt(5, e.getEquipmentCategoryEnum());
			stmt.setString(6,e.getEquipmentCategory());
			stmt.setInt(7,  e.getDamageNumberOfDice());
			stmt.setInt(8,  e.getDamageTypeEnum());
			stmt.setString(9, e.getDamageType());
			stmt.setInt(10, e.getDamageDieModifier());
			stmt.setInt(11, e.getWeaponClassificationEnum());
			stmt.setString(12, e.getWeaponClassification());
			stmt.setInt(13, e.getArmorClassificationEnum());
			stmt.setString(14, e.getArmorClassification());
			stmt.setInt(15, e.getDamageDiceDieTypeEnum());
			stmt.setInt(16,  e.getDamageDieType());
			stmt.setString(17, e.getPropertiesJson());
			stmt.setString(18, e.getPropertiesMapJson());
			stmt.setString(19, e.getModesJson());
			stmt.setString(20, e.getAc());
			stmt.setBoolean(21, e.getStealthDisadvantage());
			stmt.setInt(22, e.getContentTypeEnum());
			stmt.setString(23, e.getContentType());
			stmt.setInt(24, e.getContentSourceEnum());
			stmt.setString(25, e.getContentSource());
			stmt.setString(26,  e.getPartitionKey());
			stmt.executeUpdate();
		}catch(Exception ex) {
			ModuleGenerator.addLogEntry("Error inserting to equipment table. "+ex.getMessage());
		}finally {
			if(stmt != null)stmt.close();
		}
	}
	
	public static void createEquipmentTable() throws SQLException {
		Statement stmt=null;
		try {
			stmt=ModuleGenerator.conn.createStatement();
			stmt.execute(SQL_CREATE_EQUIP_TABLE);
		}catch(Exception e) {
			ModuleGenerator.addLogEntry("Error creating equipment table. "+e.getMessage());
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
	
	public static void connect(String db) {
		// SQLite connection string
		String url = "jdbc:sqlite:"+db;
		if(ModuleGenerator.conn == null ) {
			try {
				ModuleGenerator.conn = DriverManager.getConnection(url);
				Statement s1 = ModuleGenerator.conn.createStatement();
				s1.execute("drop table if exists equipment;");
				s1.close();
			} catch (SQLException e) {
				ModuleGenerator.addLogEntry("Error opening power(spell) database.");
			}
		}
	}
	
	public static Integer getSpellCount() {
		Integer retVal=0;
		Statement stmt=null;
		try {
			stmt=ModuleGenerator.conn.createStatement();
			ResultSet rs=stmt.executeQuery(SQL_GET_SPELL_COUNT);
			while(rs.next()) {
				Integer count=rs.getInt("cnt");
				if(count != null) {
					retVal=count;
				}
			}
		} catch (SQLException e) {
			ModuleGenerator.addLogEntry("Error in power(spell) database.");
			ModuleGenerator.addLogEntry(e.getMessage());
		} finally {
			if(stmt!=null) {
				try {
				stmt.close();
				} catch (Exception e) {
					ModuleGenerator.addLogEntry("Unable to close statement getSpellCountSQL.");
				}
			}
		}
		return retVal;
	}

	public static void populateSpellList() {
		Statement stmt=null;
		ModuleGenerator.spellList.clear();
		try {
			stmt=ModuleGenerator.conn.createStatement();
			ResultSet rs=stmt.executeQuery(SQL_GET_SPELLS);
			while(rs.next()) {
				Spell sp = new Spell();
				sp.setPrimary_key(rs.getInt(1));
				sp.setName(rs.getString(2));
				sp.setNew_json(rs.getInt(3));
				sp.setOld_xml(rs.getInt(4));
				sp.setSw5e_description(rs.getString(5));
				sp.setDescription(rs.getString(6));
				sp.setActions(rs.getString(7));
				sp.setCasting_time(rs.getString(8));
				sp.setOld_casting_time(rs.getString(9));
				sp.setDuration(rs.getString(10));
				sp.setOld_duration(rs.getString(11));
				sp.setPower_group(rs.getString(12));
				sp.setPower_level(rs.getInt(13));
				sp.setOld_level(rs.getInt(14));
				sp.setRange(rs.getString(15));
				sp.setOld_range(rs.getString(16));
				sp.setConcentration(rs.getInt(17));
				sp.setSchool(rs.getString(18));
				sp.setPower_source(rs.getString(19));
				sp.setSpecial_spell(rs.getInt(20));
				ModuleGenerator.spellList.add(sp);
			}
		}catch (SQLException e) {
			ModuleGenerator.addLogEntry("Error in power(spell) database.");
			ModuleGenerator.addLogEntry(e.getMessage());
		} finally {
			if(stmt!=null) {
				try {
				stmt.close();
				} catch (Exception e) {
					ModuleGenerator.addLogEntry("Unable to close statement getSpellCountSQL.");
				}
			}
		}
	}

}
