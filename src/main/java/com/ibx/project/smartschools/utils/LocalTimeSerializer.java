/**
 * 
 */
package com.ibx.project.smartschools.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author SANTOSH
 *
 */
public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

	/**
	 * 
	 */
	public LocalTimeSerializer() {
	}

	@Override
	public void serialize(LocalTime time, JsonGenerator jsonGenerator, SerializerProvider serializerprovider)
			throws IOException, JsonProcessingException {
		  jsonGenerator.writeString(time.toString());
		
	}

	

}
