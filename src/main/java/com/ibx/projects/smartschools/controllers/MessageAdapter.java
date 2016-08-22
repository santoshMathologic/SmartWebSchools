/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ibx.projects.smartschools.models.Role;

public class MessageAdapter implements JsonSerializer<Role> {

	
	@Override
	public JsonElement serialize(Role arg0, Type arg1, JsonSerializationContext arg2) {
		 JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("name", arg0.getName());
	        jsonObject.addProperty("Id", arg0.getId());
	        return jsonObject; 
	}
}