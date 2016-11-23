/**
 * 
 */
package com.ibx.project.smartschools.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author SANTOSH
 *
 */
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

	/**
	 * 
	 */
	public LocalTimeDeserializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocalTime deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
			throws IOException, JsonProcessingException {
		 DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
	        return LocalTime.parse(jsonparser.getText(),formatter);
	}

	
}
