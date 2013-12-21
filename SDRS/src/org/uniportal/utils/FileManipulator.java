package org.uniportal.utils;

import java.io.File;
import java.io.FileInputStream;

public class FileManipulator {

	public static byte[] getFileByteRepresentation(String filePath) {
		File file = new File(filePath);
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
			return null;
		}
		return bFile;
	}
}
