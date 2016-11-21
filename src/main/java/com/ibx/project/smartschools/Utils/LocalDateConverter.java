/**
 * 
 */
package com.ibx.project.smartschools.Utils;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author SANTOSH
 *
 */
@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	/**
	 * 
	 */
	public LocalDateConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Date convertToDatabaseColumn(LocalDate entityValue) {
		if(entityValue==null){
			 return null;
		}
		 return Date.valueOf(entityValue);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbdate) {
		if (dbdate == null) {
            return null;
        }
        return dbdate.toLocalDate();
	}

}
