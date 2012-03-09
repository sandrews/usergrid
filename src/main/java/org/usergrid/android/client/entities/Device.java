package org.usergrid.android.client.entities;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;
import static org.usergrid.android.client.utils.JsonUtils.getStringProperty;
import static org.usergrid.android.client.utils.JsonUtils.setStringProperty;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Device extends Entity {

	public final static String ENTITY_TYPE = "device";

	public final static String PROPERTY_NAME = "name";

	public Device() {
		super();
		setType(ENTITY_TYPE);
	}

	public Device(Entity entity) {
		super();
		properties = entity.properties;
		setType(ENTITY_TYPE);
	}

	@Override
	@JsonIgnore
	public String getNativeType() {
		return ENTITY_TYPE;
	}

	@Override
	@JsonIgnore
	public List<String> getPropertyNames() {
		List<String> properties = super.getPropertyNames();
		properties.add(PROPERTY_NAME);
		return properties;
	}

	@JsonSerialize(include = NON_NULL)
	public String getName() {
		return getStringProperty(properties, PROPERTY_NAME);
	}

	public void setName(String name) {
		setStringProperty(properties, PROPERTY_NAME, name);
	}

}