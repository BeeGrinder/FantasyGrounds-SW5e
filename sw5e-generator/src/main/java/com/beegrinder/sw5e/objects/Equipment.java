package com.beegrinder.sw5e.objects;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
Created with utility at http://www.jsonschema2pojo.org/
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "name",
  "description",
  "cost",
  "weight",
  "equipmentCategoryEnum",
  "equipmentCategory",
  "damageNumberOfDice",
  "damageTypeEnum",
  "damageType",
  "damageDieModifier",
  "weaponClassificationEnum",
  "weaponClassification",
  "armorClassificationEnum",
  "armorClassification",
  "damageDiceDieTypeEnum",
  "damageDieType",
  "properties",
  "propertiesJson",
  "propertiesMap",
  "propertiesMapJson",
  "modes",
  "modesJson",
  "ac",
  "strengthRequirement",
  "stealthDisadvantage",
  "contentTypeEnum",
  "contentType",
  "contentSourceEnum",
  "contentSource",
  "partitionKey",
  "rowKey",
  "timestamp",
  "eTag"
})
public class Equipment {

	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private Object description;
	@JsonProperty("cost")
	private Integer cost;
	@JsonProperty("weight")
	private String weight;
	@JsonProperty("equipmentCategoryEnum")
	private Integer equipmentCategoryEnum;
	@JsonProperty("equipmentCategory")
	private String equipmentCategory;
	@JsonProperty("damageNumberOfDice")
	private Integer damageNumberOfDice;
	@JsonProperty("damageTypeEnum")
	private Integer damageTypeEnum;
	@JsonProperty("damageType")
	private String damageType;
	@JsonProperty("damageDieModifier")
	private Integer damageDieModifier;
	@JsonProperty("weaponClassificationEnum")
	private Integer weaponClassificationEnum;
	@JsonProperty("weaponClassification")
	private String weaponClassification;
	@JsonProperty("armorClassificationEnum")
	private Integer armorClassificationEnum;
	@JsonProperty("armorClassification")
	private String armorClassification;
	@JsonProperty("damageDiceDieTypeEnum")
	private Integer damageDiceDieTypeEnum;
	@JsonProperty("damageDieType")
	private Integer damageDieType;
	@JsonProperty("properties")
	private List<String> properties = null;
	@JsonProperty("propertiesJson")
	private String propertiesJson;
	@JsonProperty("propertiesMap")
	private PropertiesMap propertiesMap;
	@JsonProperty("propertiesMapJson")
	private String propertiesMapJson;
	@JsonProperty("modes")
	private List<Object> modes = null;
	@JsonProperty("modesJson")
	private String modesJson;
	@JsonProperty("ac")
	private String ac;
	@JsonProperty("strengthRequirement")
	private Object strengthRequirement;
	@JsonProperty("stealthDisadvantage")
	private Boolean stealthDisadvantage;
	@JsonProperty("contentTypeEnum")
	private Integer contentTypeEnum;
	@JsonProperty("contentType")
	private String contentType;
	@JsonProperty("contentSourceEnum")
	private Integer contentSourceEnum;
	@JsonProperty("contentSource")
	private String contentSource;
	@JsonProperty("partitionKey")
	private String partitionKey;
	@JsonProperty("rowKey")
	private String rowKey;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("eTag")
	private String eTag;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public Object getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(Object description) {
		this.description = description;
	}

	@JsonProperty("cost")
	public Integer getCost() {
		return cost;
	}

	@JsonProperty("cost")
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@JsonProperty("weight")
	public String getWeight() {
		return weight;
	}

	@JsonProperty("weight")
	public void setWeight(String weight) {
		this.weight = weight;
	}

	@JsonProperty("equipmentCategoryEnum")
	public Integer getEquipmentCategoryEnum() {
		return equipmentCategoryEnum;
	}

	@JsonProperty("equipmentCategoryEnum")
	public void setEquipmentCategoryEnum(Integer equipmentCategoryEnum) {
		this.equipmentCategoryEnum = equipmentCategoryEnum;
	}

	@JsonProperty("equipmentCategory")
	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	@JsonProperty("equipmentCategory")
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	@JsonProperty("damageNumberOfDice")
	public Integer getDamageNumberOfDice() {
		return damageNumberOfDice;
	}

	@JsonProperty("damageNumberOfDice")
	public void setDamageNumberOfDice(Integer damageNumberOfDice) {
		this.damageNumberOfDice = damageNumberOfDice;
	}

	@JsonProperty("damageTypeEnum")
	public Integer getDamageTypeEnum() {
		return damageTypeEnum;
	}

	@JsonProperty("damageTypeEnum")
	public void setDamageTypeEnum(Integer damageTypeEnum) {
		this.damageTypeEnum = damageTypeEnum;
	}

	@JsonProperty("damageType")
	public String getDamageType() {
		return damageType;
	}

	@JsonProperty("damageType")
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	@JsonProperty("damageDieModifier")
	public Integer getDamageDieModifier() {
		return damageDieModifier;
	}

	@JsonProperty("damageDieModifier")
	public void setDamageDieModifier(Integer damageDieModifier) {
		this.damageDieModifier = damageDieModifier;
	}

	@JsonProperty("weaponClassificationEnum")
	public Integer getWeaponClassificationEnum() {
		return weaponClassificationEnum;
	}

	@JsonProperty("weaponClassificationEnum")
	public void setWeaponClassificationEnum(Integer weaponClassificationEnum) {
		this.weaponClassificationEnum = weaponClassificationEnum;
	}

	@JsonProperty("weaponClassification")
	public String getWeaponClassification() {
		return weaponClassification;
	}

	@JsonProperty("weaponClassification")
	public void setWeaponClassification(String weaponClassification) {
		this.weaponClassification = weaponClassification;
	}

	@JsonProperty("armorClassificationEnum")
	public Integer getArmorClassificationEnum() {
		return armorClassificationEnum;
	}

	@JsonProperty("armorClassificationEnum")
	public void setArmorClassificationEnum(Integer armorClassificationEnum) {
		this.armorClassificationEnum = armorClassificationEnum;
	}

	@JsonProperty("armorClassification")
	public String getArmorClassification() {
		return armorClassification;
	}

	@JsonProperty("armorClassification")
	public void setArmorClassification(String armorClassification) {
		this.armorClassification = armorClassification;
	}

	@JsonProperty("damageDiceDieTypeEnum")
	public Integer getDamageDiceDieTypeEnum() {
		return damageDiceDieTypeEnum;
	}

	@JsonProperty("damageDiceDieTypeEnum")
	public void setDamageDiceDieTypeEnum(Integer damageDiceDieTypeEnum) {
		this.damageDiceDieTypeEnum = damageDiceDieTypeEnum;
	}

	@JsonProperty("damageDieType")
	public Integer getDamageDieType() {
		return damageDieType;
	}

	@JsonProperty("damageDieType")
	public void setDamageDieType(Integer damageDieType) {
		this.damageDieType = damageDieType;
	}

	@JsonProperty("properties")
	public List<String> getProperties() {
		return properties;
	}

	@JsonProperty("properties")
	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	@JsonProperty("propertiesJson")
	public String getPropertiesJson() {
		return propertiesJson;
	}

	@JsonProperty("propertiesJson")
	public void setPropertiesJson(String propertiesJson) {
		this.propertiesJson = propertiesJson;
	}

	@JsonProperty("propertiesMap")
	public PropertiesMap getPropertiesMap() {
		return propertiesMap;
	}

	@JsonProperty("propertiesMap")
	public void setPropertiesMap(PropertiesMap propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	@JsonProperty("propertiesMapJson")
	public String getPropertiesMapJson() {
		return propertiesMapJson;
	}

	@JsonProperty("propertiesMapJson")
	public void setPropertiesMapJson(String propertiesMapJson) {
		this.propertiesMapJson = propertiesMapJson;
	}

	@JsonProperty("modes")
	public List<Object> getModes() {
		return modes;
	}

	@JsonProperty("modes")
	public void setModes(List<Object> modes) {
		this.modes = modes;
	}

	@JsonProperty("modesJson")
	public String getModesJson() {
		return modesJson;
	}

	@JsonProperty("modesJson")
	public void setModesJson(String modesJson) {
		this.modesJson = modesJson;
	}

	@JsonProperty("ac")
	public String getAc() {
		return ac;
	}

	@JsonProperty("ac")
	public void setAc(String ac) {
		this.ac = ac;
	}

	@JsonProperty("strengthRequirement")
	public Object getStrengthRequirement() {
		return strengthRequirement;
	}

	@JsonProperty("strengthRequirement")
	public void setStrengthRequirement(Object strengthRequirement) {
		this.strengthRequirement = strengthRequirement;
	}

	@JsonProperty("stealthDisadvantage")
	public Boolean getStealthDisadvantage() {
		return stealthDisadvantage;
	}

	@JsonProperty("stealthDisadvantage")
	public void setStealthDisadvantage(Boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}

	@JsonProperty("contentTypeEnum")
	public Integer getContentTypeEnum() {
		return contentTypeEnum;
	}

	@JsonProperty("contentTypeEnum")
	public void setContentTypeEnum(Integer contentTypeEnum) {
		this.contentTypeEnum = contentTypeEnum;
	}

	@JsonProperty("contentType")
	public String getContentType() {
		return contentType;
	}

	@JsonProperty("contentType")
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@JsonProperty("contentSourceEnum")
	public Integer getContentSourceEnum() {
		return contentSourceEnum;
	}

	@JsonProperty("contentSourceEnum")
	public void setContentSourceEnum(Integer contentSourceEnum) {
		this.contentSourceEnum = contentSourceEnum;
	}

	@JsonProperty("contentSource")
	public String getContentSource() {
		return contentSource;
	}

	@JsonProperty("contentSource")
	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	@JsonProperty("partitionKey")
	public String getPartitionKey() {
		return partitionKey;
	}

	@JsonProperty("partitionKey")
	public void setPartitionKey(String partitionKey) {
		this.partitionKey = partitionKey;
	}

	@JsonProperty("rowKey")
	public String getRowKey() {
		return rowKey;
	}

	@JsonProperty("rowKey")
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("eTag")
	public String getETag() {
		return eTag;
	}

	@JsonProperty("eTag")
	public void setETag(String eTag) {
		this.eTag = eTag;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}