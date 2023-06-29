package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Member;
import jp.co.aforce.bean.Product;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/views/purchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
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
		HttpSession session = request.getSession();
		String paymentMethod = request.getParameter("paymentMethod");
		
		//カート内の情報を取得
		@SuppressWarnings("unchecked")
		List<Product>cart = (List<Product>)session.getAttribute("cart");
		//会員情報の獲得
		Member member = (Member)session.getAttribute("login");
		
		
		 if (cart == null || cart.isEmpty()) {
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('カート内に商品がないため購入確認画面へ進めません。'); window.location.href='../views/cart.jsp';</script>");
	            return;
	        }

	        // ログインチェック
	        if (member == null) {
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('ログインする必要があります。'); window.location.href='../views/login.jsp';</script>");
	            return;
	        }

	        if (paymentMethod != null) {
	            response.sendRedirect("/ShoppingSite/views/purchasecomplete.jsp");
	        } else {
	            request.setAttribute("errorMessage3", "支払方法を選択してください。");
	            request.getRequestDispatcher("purchase.jsp").forward(request, response);
	        }
	    }
}
		
		