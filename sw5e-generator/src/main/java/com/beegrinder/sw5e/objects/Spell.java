package com.beegrinder.sw5e.objects;

public class Spell implements Comparable<Spell>{

	private Integer primary_key;
	private String name;
	private Integer new_json;
	private Integer old_xml;
	private String sw5e_description;
	private String description;
	private String actions;
	private String casting_time;
	private String old_casting_time;
	private String duration;
	private String old_duration;
	private String power_group;
	private Integer power_level;
	private Integer old_level;
	private String range;
	private String old_range;
	private Integer concentration;
	private String school;
	private String power_source;
	private Integer special_spell;
	
	
	@Override
	public int compareTo(Spell o) {
		return this.name.compareTo(o.getName());
	}
	
	public Integer getPrimary_key() {
		return primary_key;
	}
	public void setPrimary_key(Integer primary_key) {
		this.primary_key = primary_key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNew_json() {
		return new_json;
	}
	public void setNew_json(Integer new_json) {
		this.new_json = new_json;
	}
	public Integer getOld_xml() {
		return old_xml;
	}
	public void setOld_xml(Integer old_xml) {
		this.old_xml = old_xml;
	}
	public String getSw5e_description() {
		return sw5e_description;
	}
	public void setSw5e_description(String sw5e_description) {
		this.sw5e_description = sw5e_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}
	public String getCasting_time() {
		return casting_time;
	}
	public void setCasting_time(String casting_time) {
		this.casting_time = casting_time;
	}
	public String getOld_casting_time() {
		return old_casting_time;
	}
	public void setOld_casting_time(String old_casting_time) {
		this.old_casting_time = old_casting_time;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getOld_duration() {
		return old_duration;
	}
	public void setOld_duration(String old_duration) {
		this.old_duration = old_duration;
	}
	public String getPower_group() {
		return power_group;
	}
	public void setPower_group(String power_group) {
		this.power_group = power_group;
	}
	public Integer getPower_level() {
		return power_level;
	}
	public void setPower_level(Integer power_level) {
		this.power_level = power_level;
	}
	public Integer getOld_level() {
		return old_level;
	}
	public void setOld_level(Integer old_level) {
		this.old_level = old_level;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getOld_range() {
		return old_range;
	}

	public void setOld_range(String old_range) {
		this.old_range = old_range;
	}

	public Integer getConcentration() {
		return concentration;
	}

	public void setConcentration(Integer concentration) {
		this.concentration = concentration;
	}

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPower_source() {
		return power_source;
	}
	public void setPower_source(String power_source) {
		this.power_source = power_source;
	}
	public Integer getSpecial_spell() {
		return special_spell;
	}
	public void setSpecial_spell(Integer special_spell) {
		this.special_spell = special_spell;
	}
	

}
