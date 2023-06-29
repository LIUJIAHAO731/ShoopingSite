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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // フォームから送信された商品情報を取得
        String productNo = request.getParameter("productNo");
        String productName = request.getParameter("productName");
        String stockParam = request.getParameter("stock");
        String priceParam = request.getParameter("price");

        // 商品情報の更新処理を行うためのDAOオブジェクトを作成
        ProductDAO productDAO = new ProductDAO();

        try {
            // 既存の商品情報を検索
            Product existingProduct = productDAO.searchByNo(productNo);

            if (existingProduct != null) {
                // 商品情報の更新
                if (productName != null && !productName.isEmpty()) {
                    existingProduct.setProductName(productName);
                }
                if (stockParam != null && !stockParam.isEmpty()) {
                    int stock = Integer.parseInt(stockParam);
                    existingProduct.setStock(stock);
                }
                if (priceParam != null && !priceParam.isEmpty()) {
                    int price = Integer.parseInt(priceParam);
                    existingProduct.setPrice(price);
                }

                // 商品情報を更新
                int line = productDAO.update(existingProduct);

                if (line > 0) {
                    request.setAttribute("successMessage1", "商品情報を更新しました");
                } else {
                    request.setAttribute("errorMessage1", "商品情報の更新に失敗しました");
                }
            } else {
                request.setAttribute("errorMessage1", "指定された商品が見つかりませんでした");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage1", "商品情報の更新中にエラーが発生しました");
        }

        // 商品一覧画面にリダイレクト
        response.sendRedirect(request.getContextPath() + "/views/admin.jsp");
    }
}
		
				
			
