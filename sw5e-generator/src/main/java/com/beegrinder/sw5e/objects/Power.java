package com.beegrinder.sw5e.objects;

import java.util.HashMap;
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
  "powerTypeEnum",
  "powerType",
  "prerequisite",
  "level",
  "castingPeriodEnum",
  "castingPeriod",
  "castingPeriodText",
  "range",
  "duration",
  "concentration",
  "forceAlignmentEnum",
  "forceAlignment",
  "description",
  "higherLevelDescription",
  "contentTypeEnum",
  "contentType",
  "contentSourceEnum",
  "contentSource",
  "partitionKey",
  "rowKey",
  "timestamp",
  "eTag"
})
public class Power {

	@JsonProperty("name")
	private String name;
	@JsonProperty("powerTypeEnum")
	private Integer powerTypeEnum;
	@JsonProperty("powerType")
	private String powerType;
	@JsonProperty("prerequisite")
	private Object prerequisite;
	@JsonProperty("level")
	private Integer level;
	@JsonProperty("castingPeriodEnum")
	private Integer castingPeriodEnum;
	@JsonProperty("castingPeriod")
	private String castingPeriod;
	@JsonProperty("castingPeriodText")
	private String castingPeriodText;
	@JsonProperty("range")
	private String range;
	@JsonProperty("duration")
	private String duration;
	@JsonProperty("concentration")
	private Boolean concentration;
	@JsonProperty("forceAlignmentEnum")
	private Integer forceAlignmentEnum;
	@JsonProperty("forceAlignment")
	private String forceAlignment;
	@JsonProperty("description")
	private String description;
	@JsonProperty("higherLevelDescription")
	private Object higherLevelDescription;
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

	@JsonProperty("powerTypeEnum")
	public Integer getPowerTypeEnum() {
		return powerTypeEnum;
	}

	@JsonProperty("powerTypeEnum")
	public void setPowerTypeEnum(Integer powerTypeEnum) {
		this.powerTypeEnum = powerTypeEnum;
	}

	@JsonProperty("powerType")
	public String getPowerType() {
		return powerType;
	}

	@JsonProperty("powerType")
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	@JsonProperty("prerequisite")
	public Object getPrerequisite() {
		return prerequisite;
	}

	@JsonProperty("prerequisite")
	public void setPrerequisite(Object prerequisite) {
		this.prerequisite = prerequisite;
	}

	@JsonProperty("level")
	public Integer getLevel() {
		return level;
	}

	@JsonProperty("level")
	public void setLevel(Integer level) {
		this.level = level;
	}

	@JsonProperty("castingPeriodEnum")
	public Integer getCastingPeriodEnum() {
		return castingPeriodEnum;
	}

	@JsonProperty("castingPeriodEnum")
	public void setCastingPeriodEnum(Integer castingPeriodEnum) {
		this.castingPeriodEnum = castingPeriodEnum;
	}

	@JsonProperty("castingPeriod")
	public String getCastingPeriod() {
		return castingPeriod;
	}

	@JsonProperty("castingPeriod")
	public void setCastingPeriod(String castingPeriod) {
		this.castingPeriod = castingPeriod;
	}

	@JsonProperty("castingPeriodText")
	public String getCastingPeriodText() {
		return castingPeriodText;
	}

	@JsonProperty("castingPeriodText")
	public void setCastingPeriodText(String castingPeriodText) {
		this.castingPeriodText = castingPeriodText;
	}

	@JsonProperty("range")
	public String getRange() {
		return range;
	}

	@JsonProperty("range")
	public void setRange(String range) {
		this.range = range;
	}

	@JsonProperty("duration")
	public String getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@JsonProperty("concentration")
	public Boolean getConcentration() {
		return concentration;
	}

	@JsonProperty("concentration")
	public void setConcentration(Boolean concentration) {
		this.concentration = concentration;
	}

	@JsonProperty("forceAlignmentEnum")
	public Integer getForceAlignmentEnum() {
		return forceAlignmentEnum;
	}

	@JsonProperty("forceAlignmentEnum")
	public void setForceAlignmentEnum(Integer forceAlignmentEnum) {
		this.forceAlignmentEnum = forceAlignmentEnum;
	}

	@JsonProperty("forceAlignment")
	public String getForceAlignment() {
		return forceAlignment;
	}

	@JsonProperty("forceAlignment")
	public void setForceAlignment(String forceAlignment) {
		this.forceAlignment = forceAlignment;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("higherLevelDescription")
	public Object getHigherLevelDescription() {
		return higherLevelDescription;
	}

	@JsonProperty("higherLevelDescription")
	public void setHigherLevelDescription(Object higherLevelDescription) {
		this.higherLevelDescription = higherLevelDescription;
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