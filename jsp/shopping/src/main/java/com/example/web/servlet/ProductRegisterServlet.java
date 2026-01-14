// src/main/java/com/example/web/servlet/ProductRegisterServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import com.example.web.dao.ProductDAO;
import com.example.web.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/productRegister.do")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1MB
    maxFileSize = 1024 * 1024 * 5,       // 5MB
    maxRequestSize = 1024 * 1024 * 10    // 10MB
)
public class ProductRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public ProductRegisterServlet() { super(); this.productDAO = new ProductDAO(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = null; double price = 0.0; String description = null; int stock = 0; String imageUrl = "noimage.gif";
        try {
            name = request.getParameter("name");
            try { price = Double.parseDouble(request.getParameter("price")); }
            catch (NumberFormatException e) { throw new IllegalArgumentException("가격은 숫자로 입력해주세요."); }
            description = request.getParameter("description");
            try { stock = Integer.parseInt(request.getParameter("stock")); }
            catch (NumberFormatException e) { throw new IllegalArgumentException("재고는 정수로 입력해주세요."); }

            Part filePart = request.getPart("productImage");
            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = getFileName(filePart);
                String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
                String uploadPath = request.getServletContext().getRealPath("/upload");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) { uploadDir.mkdirs(); }
                filePart.write(new File(uploadDir, savedFileName).getAbsolutePath());
                imageUrl = savedFileName;
            }

            String productId = UUID.randomUUID().toString();
            Product newProduct = new Product(productId, name, price, description, stock, imageUrl);
            
            if (productDAO.insertProduct(newProduct)) {
                response.sendRedirect("productList.do");
            } else {
                request.setAttribute("errorMessage", "상품 등록에 실패했습니다. 관리자에게 문의하세요.");
                request.getRequestDispatcher("productRegistrationForm.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.setAttribute("param.name", name); request.setAttribute("param.price", request.getParameter("price"));
            request.setAttribute("param.description", description); request.setAttribute("param.stock", request.getParameter("stock"));
            request.getRequestDispatcher("productRegistrationForm.jsp").forward(request, response);
            e.printStackTrace();
        } catch (Exception e) {
            request.setAttribute("errorMessage", "상품 등록 중 알 수 없는 오류가 발생했습니다: " + e.getMessage());
            request.getRequestDispatcher("productRegistrationForm.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
    private String getFileName(Part part) {
        if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
            return part.getSubmittedFileName();
        }
        String contentDisp = part.getHeader("content-disposition");
        for (String s : contentDisp.split(";")) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}