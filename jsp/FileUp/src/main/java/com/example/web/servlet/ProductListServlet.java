package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.web.dao.ProductDAO;
import com.example.web.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * 등록된 상품 목록을 조회하여 productList.jsp로 전달하는 서블릿
 */
@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public ProductListServlet() {
        super();
        // 기본 생성자 사용하여 DAO 초기화
        this.productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 데이터베이스에서 모든 상품 목록을 가져옴
        List<Product> products = productDAO.getAllProducts();

        // request 속성에 상품 목록 저장 (JSP에서 사용하기 위함)
        request.setAttribute("products", products);

        // productList.jsp로 포워드
        request.getRequestDispatcher("productList.jsp").forward(request, response);
    }
}
