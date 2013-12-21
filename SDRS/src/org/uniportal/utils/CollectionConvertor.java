package org.uniportal.utils;

import java.util.List;

public class CollectionConvertor {

	/**
	 * Converts list of Object to the desired type T.
	 * 
	 * @param returnList
	 * @param List
	 *            <Object> objects
	 * @return List<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> List<T> convertToMyTypeList(
			List<T> returnList, List<Object> objects) {
		for (Object obj : objects) {
			returnList.add((T) obj);
		}
		return returnList;
	}
}
