package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Product;

@WebServlet("/removeFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");

        if (productName != null && !productName.isEmpty()) {
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
            List<Product> cart = (List<Product>) session.getAttribute("cart");

            if (cart != null) {
                Iterator<Product> iterator = cart.iterator();
                while (iterator.hasNext()) {
                    Product product = iterator.next();
                    if (product.getProductName().equals(productName)) {
                        iterator.remove();
                        break;
                    }
                }

                session.setAttribute("cart", cart); // カート情報をセッションに更新
            }
        }

        response.sendRedirect(request.getContextPath() + "/views/cart.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

