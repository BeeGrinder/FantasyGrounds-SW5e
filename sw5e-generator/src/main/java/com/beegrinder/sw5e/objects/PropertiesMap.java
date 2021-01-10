package com.beegrinder.sw5e.objects;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "Double"
})
public class PropertiesMap {

	@JsonProperty("Double")
	private String _double;
	@JsonIgnore
	private Map<String, String> additionalProperties = new HashMap<String, String>();

	@JsonProperty("Double")
	public String getDouble() {
		return _double;
	}

	@JsonProperty("Double")
	public void setDouble(String _double) {
		this._double = _double;
	}

	@JsonAnyGetter
	public Map<String, String> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, String value) {
		this.additionalProperties.put(name, value);
	}

}