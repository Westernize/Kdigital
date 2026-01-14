package com.example.web.servlet;

// Jakarta EE 9+ (Tomcat 10+) 사용 시 jakarta.* 임포트
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part; // 파일 업로드 처리용 Part 인터페이스

// Tomcat 9 이하 (Java EE 8 이하) 사용 시 javax.* 임포트 (패키지명만 다름)
// import javax.servlet.ServletException;
// import javax.servlet.annotation.MultipartConfig;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.Part;

import com.example.web.dao.ProductDAO;
import com.example.web.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.UUID; // 고유 ID 생성을 위함 (상품 ID, 파일명 중복 방지)

/**
 * 상품 등록을 처리하는 서블릿
 */
@WebServlet("/productRegister.do") // URL 매핑 설정
@MultipartConfig( // 파일 업로드를 위한 설정 (Servlet 3.0+ 에서 필요)
    fileSizeThreshold = 1024 * 1024 * 1, // 1MB (임시 파일 생성 임계값)
    maxFileSize = 1024 * 1024 * 5,       // 5MB (단일 파일 최대 크기)
    maxRequestSize = 1024 * 1024 * 10    // 10MB (전체 요청 최대 크기)
)
public class ProductRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public ProductRegisterServlet() {
        super();
        this.productDAO = new ProductDAO(); // DAO 인스턴스 생성
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청 인코딩 설정 (한글 깨짐 방지)
        request.setCharacterEncoding("UTF-8");

        String name = null;
        double price = 0.0;
        String description = null;
        int stock = 0;
        String imageUrl = "noimage.gif"; // 이미지가 업로드되지 않은 경우 기본값

        try {
            // 1. 폼 필드 데이터 가져오기
            name = request.getParameter("name");
            // price는 String으로 오므로 double로 변환 (예외 처리)
            try {
                price = Double.parseDouble(request.getParameter("price"));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("가격은 숫자로 입력해주세요.");
            }
            description = request.getParameter("description");
            // stock도 String으로 오므로 int로 변환 (예외 처리)
            try {
                stock = Integer.parseInt(request.getParameter("stock"));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("재고는 정수로 입력해주세요.");
            }

            // 2. 파일 업로드 처리
            Part filePart = request.getPart("productImage"); // input name="productImage"에 해당

            if (filePart != null && filePart.getSize() > 0) { // 파일이 선택되고 내용이 있는 경우
                // 원본 파일 이름 추출
                String originalFileName = getFileName(filePart);
                // 파일명 중복 방지를 위한 고유 ID 생성 (UUID 사용)
                String savedFileName = UUID.randomUUID().toString() + 
                      "_" + originalFileName;

                // 파일이 저장될 서버의 실제 경로 (webapp/upload 폴더)
                String uploadPath = 
                      request.getServletContext().getRealPath("/upload");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) { // 폴더가 없으면 생성
                    uploadDir.mkdirs();
                }

                // 파일 저장
                filePart.write(new File(uploadDir, savedFileName).getAbsolutePath());
                imageUrl = savedFileName; // 저장된 파일명을 DB에 저장할 URL로 사용
                System.out.println("파일이 저장되었습니다: " + 
                new File(uploadDir, savedFileName).getAbsolutePath());
            } else {
                System.out.println("이미지가 업로드되지 않아 기본 이미지(noimage.gif) 사용");
            }

            
            // 3. Product 객체 생성 및 DB에 저장
            String productId = UUID.randomUUID().toString(); // 고유한 상품 ID 생성
            Product newProduct = 
                  new Product(productId, name, price, description, stock, imageUrl);
            
            boolean success = productDAO.insertProduct(newProduct);
 
            
            if (success) {
                System.out.println("새 상품이 성공적으로 DB에 등록되었습니다: " +
                      newProduct.getName());
                // 4. 상품 목록 페이지로 리다이렉트
                response.sendRedirect("productList.do");
            } else {
                // DB 저장 실패 시
                request.setAttribute("errorMessage", 
                      "상품 등록에 실패했습니다. 관리자에게 문의하세요.");
                // 사용자가 입력했던 값들을 유지하며 폼으로 다시 포워드 (sticky form)
                request.setAttribute("param.name", name);
                request.setAttribute("param.price", price);
                request.setAttribute("param.description", description);
                request.setAttribute("param.stock", stock);
                request.getRequestDispatcher("productRegistrationForm.jsp")
                .forward(request, response);
            }

        } catch (IllegalArgumentException e) {
            // 사용자 입력 값 오류 (가격, 재고 등)
            request.setAttribute("errorMessage", e.getMessage());
            // 입력 값 유지 (sticky form)
            request.setAttribute("param.name", name);
            request.setAttribute("param.price", request.getParameter("price")); 
            // 원본 문자열 유지
            request.setAttribute("param.description", description);
            request.setAttribute("param.stock", request.getParameter("stock")); 
            // 원본 문자열 유지
            request.getRequestDispatcher("productRegistrationForm.jsp")
            .forward(request, response);
        } catch (ServletException e) {
            // 파일 업로드 관련 오류 (예: 파일 크기 초과, MultipartConfig 오류)
            // request.getPart() 내부에서 발생하는 예외이므로 여기에 잡힘
            request.setAttribute("errorMessage", "파일 업로드 중 오류가 발생했습니다: " +
                     e.getMessage());
            // 입력 값 유지 (sticky form)
            request.setAttribute("param.name", name);
            request.setAttribute("param.price", request.getParameter("price"));
            request.setAttribute("param.description", description);
            request.setAttribute("param.stock", request.getParameter("stock"));
            request.getRequestDispatcher("productRegistrationForm.jsp")
               .forward(request, response);
            e.printStackTrace();
        } catch (IOException e) {
            // 파일 저장 오류 등 I/O 문제
            request.setAttribute("errorMessage", "파일 저장 중 오류가 발생했습니다: " + 
                  e.getMessage());
            // 입력 값 유지 (sticky form)
            request.setAttribute("param.name", name);
            request.setAttribute("param.price", request.getParameter("price"));
            request.setAttribute("param.description", description);
            request.setAttribute("param.stock", request.getParameter("stock"));
            request.getRequestDispatcher("productRegistrationForm.jsp")
               .forward(request, response);
            e.printStackTrace();
        } catch (Exception e) {
            // 기타 알 수 없는 오류
            request.setAttribute("errorMessage", "상품 등록 중 알 수 없는 오류가 발생했습니다: " + e.getMessage());
            // 입력 값 유지 (sticky form)
            request.setAttribute("param.name", name);
            request.setAttribute("param.price", request.getParameter("price"));
            request.setAttribute("param.description", description);
            request.setAttribute("param.stock", request.getParameter("stock"));
            request.getRequestDispatcher("productRegistrationForm.jsp")
            .forward(request, response);
            e.printStackTrace();
        }
    }

    /**
     * Part 객체에서 파일 이름을 추출하는 헬퍼 메소드 (Servlet 3.1+ 부터는 Part.getSubmittedFileName() 사용 가능)
     */
    private String getFileName(Part part) {
        // Servlet 3.1 이상 (Jakarta Servlet 4.0 이상)에서는 Part.getSubmittedFileName()을 사용하는 것이 좋습니다.
        // 현재 환경이 Servlet 3.0 이라면 아래 방식으로 수동 파싱해야 합니다.
        if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
            return part.getSubmittedFileName(); // Servlet 3.1+ (Jakarta 4.0+)
        }

        // Servlet 3.0을 위한 수동 파싱
        String contentDisp = part.getHeader("content-disposition");
        for (String s : contentDisp.split(";")) {
            if (s.trim().startsWith("filename")) {
                // 파일명 추출 (Windows 경로 역슬래시 및 따옴표 제거)
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}