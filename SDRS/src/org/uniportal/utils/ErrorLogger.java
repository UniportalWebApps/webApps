package org.uniportal.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.uniportal.ErrorLog.ErrorReport;

public class ErrorLogger {

	private static Logger logger = Logger
			.getLogger(ErrorLogger.class.getName());

	public static void LogIt(List<ErrorReport> errorList, String FilePath) {
		if (errorList == null) {
			return;
		}

		// Open file to write to.
		PrintWriter printWriter = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
			String filePathAndName = FilePath + "" + File.separatorChar
					+ "ErrorTrace_ON_" + sdf.format(new Date()) + ".xml";
			printWriter = new PrintWriter(new File(filePathAndName));
		} catch (FileNotFoundException e) {
			logger.error("Can not write to File Path : ");
		}

		int error_index = 1;
		StringBuilder sb = new StringBuilder("<ERROR_TRACE>");
		sb.append("<DATE_TIME>" + new Date() + "</DATE_TIME");
		sb.append("<Error_" + error_index + ">");
		for (ErrorReport error : errorList) {
			sb.append("<name>" + error.getName() + "</name>");
			sb.append("<code>" + error.getErrorCode() + "</code>");
			sb.append("<class>" + error.getGeneratingClass() + "</class>");
			sb.append("<method>" + error.getGeneratingMethod() + "</method>");
			sb.append("<message>" + error.getErrorMessage() + "</message>");
			sb.append("<Error_" + error_index + ">");
			error_index++;
		}
		sb.append("</ERROR_TRACE>");

		// write to the stream
		if (printWriter != null) {
			printWriter.println(sb.toString());
			printWriter.close();
		}

	}

}
