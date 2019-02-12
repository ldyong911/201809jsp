package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//5MB = 5 * 1024 * 1024
//5MB = 5 * 1MB
//1MB = 1024KB
//1KB = 1024BYTE

@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_PATH = "d:/picture/";
	
	//로그 사용하기위해 사용하는 변수
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String contentType = request.getContentType();
		String userId = request.getParameter("userId");
		String fileUpload = request.getParameter("fileUpload");
		
//		System.out.println("userId : " + userId);
//		System.out.println("fileUpload : " + fileUpload);
		
		//low level ---> high level
		//하위 레벨은 상위 레벨을 포함하는 개념
		//로깅 레벨 info : logger.info(...), logger.warn(...), logger.error(...)
		//로깅 레벨 error : logger.error(...)
		//trace, debug, info, warn, error
		logger.debug("contentType: " + contentType);
		logger.debug("userId : " + userId);
		logger.debug("fileUpload : " + fileUpload);
		
		//part 정보 확인
		//request.getPart(name);
		//request.getParts();
		Collection<Part> parts = request.getParts();
		logger.debug("=================================================================");
		for(Part part : parts){
			logger.debug("partHeaderNames : {}", part.getHeaderNames());
			logger.debug("partName : {}", part.getName());
			logger.debug("Content-Disposition : {}", part.getHeader("Content-Disposition"));
		}
		logger.debug("=================================================================");
		
		Part fileUploadPart = request.getPart("fileUpload");
		//fileUploadPart.write("d:\\picture\\real.jpg");
		
		String contentDisposition = fileUploadPart.getHeader("Content-Disposition");
		logger.debug("Content-Disposition : {}", contentDisposition);
		
		//application
		//localhost/upload --> 물리적경로를 확인
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload"); //uri에 해당되는 실제 저장되는 톰캣 경로 
		logger.debug("path : {}", path);
		
		//파일사이즈가 0보다 클 경우만 업로드
		if(fileUploadPart.getSize() > 0){
			//첨부파일 파일명
			String filename = PartUtil.getFileNameFromPart(contentDisposition); //해당 파일명 얻는 메서드
			String uuidFilename = UUID.randomUUID().toString(); //랜덤으로 중복되지않게 id값 생성
			//fileUploadPart.write(UPLOAD_PATH + uuidFilename);
			
			//server.core\\tmp0\\wtpwebapps\\jsp\\uploadreal.jpg --> upload\real.jpg
			fileUploadPart.write(path + File.separator + uuidFilename); //os마다 경로구분자가 다르기때문에 File 클래스에서 제공되는 separator 사용
			fileUploadPart.delete(); //디스크 사용후 남아있는 데이터삭제
		}
		
		doGet(request, response);
	}

}