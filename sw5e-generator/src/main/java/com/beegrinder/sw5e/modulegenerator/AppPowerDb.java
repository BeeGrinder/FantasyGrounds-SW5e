package com.beegrinder.sw5e.modulegenerator;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beegrinder.sw5e.objects.Spell;

public class AppPowerDb {

	private static final String getSpellCountSQL = "select count(*) cnt from powers where new_json=1";
	private static final String getSpellsSQL = "select * from powers where new_json=1 and ifnull(special_spell,0) =0";
	
	public static void connect(String db) {
		// SQLite connection string
		String url = "jdbc:sqlite:"+db;
		if(ModuleGenerator.conn == null ) {
			try {
				ModuleGenerator.conn = DriverManager.getConnection(url);
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
			ResultSet rs=stmt.executeQuery(getSpellCountSQL);
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
			ResultSet rs=stmt.executeQuery(getSpellsSQL);
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
