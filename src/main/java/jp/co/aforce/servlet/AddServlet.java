package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/views/addservlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
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
		// フォームから送信された商品情報を取得
		String productNo = request.getParameter("productNo");
		String productName = request.getParameter("productName");
		String stockParam = request.getParameter("stock");
		String priceParam = request.getParameter("price");

		// 在庫数と価格の入力値を整数に変換
		int stock;
		int price;

		try {
			stock = Integer.parseInt(stockParam);
			price = Integer.parseInt(priceParam);
		} catch (NumberFormatException e) {
			// 在庫数や価格が不正な形式の場合のエラーハンドリング
			// ここではデフォルトの値として 0 を設定しています
			stock = 0;
			price = 0;
		}

		// 商品情報のインスタンスを作成
		Product product = new Product();
		product.setProductNo(productNo);
		product.setProductName(productName);
		product.setStock(stock);
		product.setPrice(price);

		try {
			// 商品コードの重複チェック
			ProductDAO productDAO = new ProductDAO();
			if (productDAO.exists(productNo)) {
				// 重複がある場合はエラーメッセージを設定
				request.setAttribute("errorMessage", "商品コードが既に存在します。");
			} else {
				// 重複がない場合は商品を登録
				int line = productDAO.insert(product);
				if (line > 0) {
					// 登録成功のメッセージをセット
					request.setAttribute("successMessage", "商品の登録が成功しました。");
				} else {
					// 登録失敗のメッセージをセット
					request.setAttribute("errorMessage", "商品の登録中にエラーが発生しました。");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 登録失敗のメッセージをセット
			request.setAttribute("errorMessage", "商品の登録中にエラーが発生しました。");
		}

		// 商品一覧画面にフォワード
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
