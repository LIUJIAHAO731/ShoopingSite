package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Product;

/**
 * Servlet implementation class UpdateQuantityServlet
 */
@WebServlet("/update-quantity-servlet")
public class UpdateQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantityServlet() {
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
		// フォームから商品情報を取得
        String productNo = request.getParameter("productNo");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // セッションからカートを取得
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        // カート内の商品の数量を更新
        for (Product product : cart) {
            if (product.getProductNo().equals(productNo)) {
                product.setStock(quantity);
                break;
            }
        }

        // カート内の商品の合計金額を再計算
        int totalPrice = 0;
        for (Product product : cart) {
            int subtotal = product.getPrice() * product.getStock();
            product.setSubtotal(subtotal);
            totalPrice += subtotal;
        }

        // カート内の商品の合計金額をリクエスト属性に設定
        request.setAttribute("cartTotalPrice", totalPrice);

        // カート画面にフォワード
        request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
    }
	}


