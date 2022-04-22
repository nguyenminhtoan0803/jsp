package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			object = tClass.getDeclaredConstructor().newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		}
		return object;
	}
}
