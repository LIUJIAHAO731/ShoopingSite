package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDAO;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
    	List<Product> productList = new ProductDAO().getAllProducts();
        String sort = request.getParameter("sort");
        
        if (sort != null) {
            if (sort.equals("priceAsc")) {
                productList.sort(Comparator.comparing(Product::getPrice));
            } else if (sort.equals("priceDesc")) {
                productList.sort(Comparator.comparing(Product::getPrice).reversed());
            } else if (sort.equals("nameAsc")) {
                productList.sort(Comparator.comparing(Product::getProductName));
            } else if (sort.equals("nameDesc")) {
                productList.sort(Comparator.comparing(Product::getProductName).reversed());
            }
        }
        
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/views/product_list.jsp").forward(request, response);
    }catch(SQLException e){
    	e.printStackTrace();
    }
    	
    }
}
