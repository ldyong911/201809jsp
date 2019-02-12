package kr.or.ddit.util;

public class PartUtil {
	
	public static String getFileNameFromPart(String contentDisposition) {
		String[] splits = contentDisposition.split("; ");
		String fileName = null;
		
		for(String split : splits){
			if(split.startsWith("filename=")){
				fileName = split.substring(split.indexOf("\"")+1, split.lastIndexOf("\""));
			}
		}
		
		return fileName;
	}

	public static String getFileNameFromPart2(String contentDisposition) {
		String[] contentArray = contentDisposition.split("; ");
		String fileNameFromPart = contentArray[2].split("=")[1];
		String fileName = fileNameFromPart.substring(1, fileNameFromPart.length()-1);
		
		return fileName;
	}
}