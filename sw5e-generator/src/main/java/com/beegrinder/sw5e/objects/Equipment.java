package com.beegrinder.sw5e.objects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Equipment {

	public static final String WEAPON_CATEGORY = "Weapon";
	
	private boolean weapon;
	private boolean armor;
	
	private String name;
	private String description;
	private BigDecimal cost;
	private String equipmentCategory;
	private int damageNumberOfDice;
	private int damageDieModifier;
	private int damageDieType;
	private String damageType;
	private List<String> properties;
	private Map<String, String> propertiesMap;
	private String contentSource;

	/*
	 * Generated 
	 */
	
	public boolean isWeapon() {
		return weapon;
	}
	public void setWeapon(boolean weapon) {
		this.weapon = weapon;
	}
	public boolean isArmor() {
		return armor;
	}
	public void setArmor(boolean armor) {
		this.armor = armor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getEquipmentCategory() {
		return equipmentCategory;
	}
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
	public int getDamageNumberOfDice() {
		return damageNumberOfDice;
	}
	public void setDamageNumberOfDice(int damageNumberOfDice) {
		this.damageNumberOfDice = damageNumberOfDice;
	}
	public int getDamageDieModifier() {
		return damageDieModifier;
	}
	public void setDamageDieModifier(int damageDieModifier) {
		this.damageDieModifier = damageDieModifier;
	}
	public int getDamageDieType() {
		return damageDieType;
	}
	public void setDamageDieType(int damageDieType) {
		this.damageDieType = damageDieType;
	}
	public String getDamageType() {
		return damageType;
	}
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}
	public List<String> getProperties() {
		return properties;
	}
	public void setProperties(List<String> properties) {
		this.properties = properties;
	}
	public Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}
	public void setPropertiesMap(Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}
	public String getContentSource() {
		return contentSource;
	}
	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}
	
	
	
}
