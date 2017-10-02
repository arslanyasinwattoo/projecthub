package com.bnu.springdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for handling Date and Time. All methods are usually made static
 * in such classes
 */
public class DateTimeUtil {

	/**
	 * Creates a java.util.Date object by parsing a date value provided in a
	 * String in dd-MM-yyyy format
	 */
	public Date convertToDate(String dateStr) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(dateStr);
	}

	/**
	 * Creates a String object containing date value in dd-MM-yyyy format from a
	 * given java.util.Date object
	 */
	public String convertToString(Date date) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}

	/**
	 * Creates a java.sql.Date object from given java.util.Date object
	 */
	public java.sql.Date converToSQLDate(Date date) throws Exception {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * Creates a java.sql.Time object from given java.util.Date object
	 */
	public java.sql.Time converToSQLTime(Date date) throws Exception {
		return new java.sql.Time(date.getTime());
	}
}
