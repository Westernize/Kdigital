package com.saeyan.controller;
package com.example.servlet; // 실제 패키지명에 맞게 변경해주세요

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // 서블릿 3.0 이상에서 어노테이션 사용
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// cos.jar 라이브러리 import
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 * 파일 업로드를 처리하는 서블릿
 */
@WebServlet("/upload.do") // 이 어노테이션으로 URL 매핑을 설정합니다. web.xml 설정 불필요.
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * POST 방식으로 파일 업로드 요청이 들어오면 이 메소드가 실행됩니다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 응답 컨텐츠 타입 및 문자 인코딩 설정
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 1. 파일이 저장될 서버상의 실제 경로 가져오기
        // 예: WebContent/upload (또는 webapp/upload) 폴더
        // realPath는 톰캣이 배포된 경로 + upload 폴더가 됩니다.
        String saveDirectory = request.getServletContext().getRealPath("/upload");
        
        // 이클립스 개발 환경에서, 프로젝트 Run 시 Workspace 내부 경로로 지정되는 경우가 있습니다.
        // 정확한 경로를 확인하려면 System.out.println(saveDirectory); 로 확인해보세요.
        File fileSaveDir = new File(saveDirectory);
        if (!fileSaveDir.exists()) { // 저장 디렉토리가 없으면 생성
            fileSaveDir.mkdirs();
        }

        // 2. 업로드 파일의 최대 크기 설정 (10MB로 설정)
        // 최대 크기를 초과하면 IOException이 발생합니다.
        int maxPostSize = 10 * 1024 * 1024; // 10MB (바이트 단위)
        
        // 3. 문자 인코딩 설정
        String encoding = "UTF-8";

        MultipartRequest multi = null; // cos.jar의 핵심 객체

        try {
            // MultipartRequest 객체 생성 (파일 업로드 처리)
            // 생성자 파라미터: request, saveDirectory, maxPostSize, encoding, DefaultFileRenamePolicy
            // DefaultFileRenamePolicy: 파일명 중복 시 자동으로 이름을 변경 (예: file.txt -> file1.txt)
            multi = new MultipartRequest(
                        request,            // JSP의 request 객체
                        saveDirectory,      // 서버에 파일을 저장할 실제 경로
                        maxPostSize,        // 업로드 파일의 최대 크기
                        encoding,           // 인코딩 방식
                        new DefaultFileRenamePolicy() // 파일명 중복 방지 정책
                    );

            // ----- 파일 업로드 처리 완료 후, 일반 폼 데이터 및 파일 정보 가져오기 -----
            
            // 폼 필드 값 가져오기 (multi 객체를 통해 가져와야 합니다!)
            String uploader = multi.getParameter("uploader"); // <input type="text" name="uploader">

            out.println("<h3>파일 업로드 결과</h3>");
            out.println("<div style='border: 1px solid #d4edda; background-color: #d4edda; color: #155724; padding: 15px; border-radius: 8px;'>");
            out.println("<p>업로더: <strong>" + (uploader != null && !uploader.isEmpty() ? uploader : "익명") + "</strong></p>");

            // 업로드된 파일 정보 가져오기 (파일은 여러 개일 수 있으므로 Enumeration 사용)
            // input type="file"의 name 속성 값들을 가져옵니다.
            Enumeration<String> fileNames = multi.getFileNames();

            boolean fileUploaded = false;
            while (fileNames.hasMoreElements()) {
                String fileParamName = fileNames.nextElement(); // 폼에서 파일 input의 name (예: "uploadFile")
                
                // 원본 파일명 (사용자가 업로드한 파일명)
                String originalFileName = multi.getOriginalFileName(fileParamName);
                
                // 실제로 서버에 저장된 파일명 (DefaultFileRenamePolicy에 의해 변경될 수 있음)
                String filesystemFileName = multi.getFilesystemName(fileParamName);
                
                // 파일의 MIME 타입
                String contentType = multi.getContentType(fileParamName);

                if (originalFileName != null) { // 파일이 성공적으로 업로드되었을 경우
                    fileUploaded = true;
                    out.println("<p>원본 파일명: <strong>" + originalFileName + "</strong></p>");
                    out.println("<p>저장된 파일명: <strong>" + filesystemFileName + "</strong></p>");
                    out.println("<p>파일 타입: <strong>" + contentType + "</strong></p>");
                } else {
                    out.println("<p>파일 업로드를 하지 않았거나, 파일이 올바르지 않습니다.</p>");
                }
            }
            if(fileUploaded){
                out.println("<p>파일이 다음 경로에 성공적으로 저장되었습니다: <strong>" + saveDirectory + "</strong></p>");
            }

            out.println("</div>");

        } catch (IOException e) {
            // 파일 크기 초과, 쓰기 권한 없음 등 IO 관련 예외 처리
            out.println("<div style='border: 1px solid #f8d7da; background-color: #f8d7da; color: #721c24; padding: 15px; border-radius: 8px;'>");
            out.println("<h3>파일 업로드 실패!</h3>");
            if (e.getMessage().contains("exceeds allowable size")) {
                out.println("<p>업로드 파일의 크기가 너무 큽니다. (최대 " + (maxPostSize / (1024 * 1024)) + "MB)</p>");
            } else {
                out.println("<p>파일 업로드 중 오류가 발생했습니다: " + e.getMessage() + "</p>");
            }
            out.println("<p>문제가 계속되면 관리자에게 문의하세요.</p>");
            out.println("</div>");
            e.printStackTrace(); // 콘솔에 상세 에러 로그 출력
        } catch (Exception e) {
            // 기타 다른 예외 처리
            out.println("<div style='border: 1px solid #f8d7da; background-color: #f8d7da; color: #721c24; padding: 15px; border-radius: 8px;'>");
            out.println("<h3>알 수 없는 오류 발생!</h3>");
            out.println("<p>예외: " + e.getMessage() + "</p>");
            out.println("<p>문제가 계속되면 관리자에게 문의하세요.</p>");
            out.println("</div>");
            e.printStackTrace(); // 콘솔에 상세 에러 로그 출력
        }
    }
}