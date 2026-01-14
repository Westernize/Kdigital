package com.sayan.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletDiskFileUpload;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileUpload.do")
public class FileTestServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      if(JakartaServletDiskFileUpload.isMultipartContent(request)) {
         DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
         JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
         upload.setFileSizeMax(1024*1024);
         upload.setSizeMax(1024*1024);
         String uploadPath=("c:/upload");
         
         File uploadDir = new File(uploadPath);
         
         if(!uploadDir.exists()) {
            uploadDir.mkdir();
         }
         
         try {
            List<FileItem> formItems = upload.parseRequest(request);
            if(formItems !=null && formItems.size() >0) {
               for(FileItem item : formItems) {
                  String fileName = new File(item.getName()).getName();
                  item.write(Path.of(uploadPath, fileName));
                  
                  response.getWriter().println(String.format(
                        "File Name = %s, File Name = %s, File Size = %s"
                        ,item.getFieldName()
                        ,item.getName()
                        ,item.getSize()
                        ));
               }
            }
         }catch(Exception e) {
      }
}
        
   }

}

