package com.fileupload;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jcp.xml.dsig.internal.dom.Utils;





@WebServlet("/uploadServlet")
//@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*200, maxRequestSize=1024*1024*200)
public class UploadServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
//    private static final String SAVE_DIR = "D:\\env\\apache\\tomcat-8.0.14\\apache-tomcat-8.0.14\\webapps\\wms\\videos\\";
    
    private static String uploadPath = "";
    private static String publishedUrl = "";
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doPost.....................");
    	response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
       
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );
    	
    	       String uploadPath = "c:\\walmart\\";
             
             try {
				List fileItems = upload.parseRequest(request);
				 Iterator i = fileItems.iterator();
				 while ( i.hasNext () ) 
			      {
			         FileItem fi = (FileItem)i.next();
			         if ( !fi.isFormField () )	
			         {
			            // Get the uploaded file parameters
			            String fieldName = fi.getFieldName();
			            String fileName = fi.getName();
			            String contentType = fi.getContentType();
			            boolean isInMemory = fi.isInMemory();
			            long sizeInBytes = fi.getSize();
			            // Write the file
			            if( fileName.lastIndexOf("\\") >= 0 ){
			               file = new File( uploadPath + 
			               fileName.substring( fileName.lastIndexOf("\\"))) ;
			            }else{
			               file = new File( uploadPath + 
			               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			            }
			            fi.write( file ) ;
			            pw.println("Uploaded Filename: " + fileName + "<br>");
			         }
			      }
			} catch (Exception e) {
				
				e.printStackTrace();
			}
     	
    	pw.close();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	pw.println("get method not allowed! ");
    	pw.close();
    }
    
       
}
