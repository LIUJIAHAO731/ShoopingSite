package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Admin;
import jp.co.aforce.dao.AdminDAO;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/views/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		 System.out.println("ID: " + id); // IDの値をログに出力
		  System.out.println("Password: " + pass); // パスワードの値をログに出力

		AdminDAO dao = new AdminDAO();

		try {

			Admin admin = dao.search(id, pass);
			
			if (admin != null) {
				session.setAttribute("admin", admin);
				session.setMaxInactiveInterval(1800); // セッションの有効期限を30分に設定
				request.getRequestDispatcher("/views/admin.jsp").forward(request, response);
			} else {
				session.setAttribute("errormsg6", "ユーザIDもしくはパスワードが違います。");
				response.sendRedirect("/ShoppingSite/views/login-admin.jsp"); // ログインページへのリダイレクト
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
