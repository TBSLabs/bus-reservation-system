package org.ticketbooking.common.utils;

import org.springframework.util.ObjectUtils;

public class ApplicationObjectUtils extends ObjectUtils {
	public static boolean isNull(Object object){
		return object==null;
	}
	public static boolean isNotNull(Object object){
		return !isNull(object);
	}
}
