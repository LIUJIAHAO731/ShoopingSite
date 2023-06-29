package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart-servlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォームから商品情報を取得
	    String productNo = request.getParameter("productNo");
	    String productName = request.getParameter("productName");
	    String stockParam = request.getParameter("stock");
	    int stock = stockParam != null ? Integer.parseInt(stockParam) : 0;

	    String priceParam = request.getParameter("price");
	    int price = priceParam != null ? Integer.parseInt(priceParam) : 0;

	    String quantityParam = request.getParameter("quantity");
	    int quantity = quantityParam != null ? Integer.parseInt(quantityParam) : 0;

	    // 新しいProductインスタンスを作成
	    Product product = new Product();
	    product.setProductNo(productNo);
	    product.setProductName(productName);
	    product.setStock(stock);
	    product.setPrice(price);
	    product.setQuantity(quantity);

	    // セッションからカートを取得し、存在しない場合は新規作成
	    HttpSession session = request.getSession();
	    @SuppressWarnings("unchecked")
	    List<Product> cart = (List<Product>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<Product>();
	        session.setAttribute("cart", cart);
	    }

	    // カート内に同じ商品があるかチェック
	    boolean isExistingProduct = false;
	    for (Product existingProduct : cart) {
	        if (existingProduct.getProductNo().equals(productNo)) {
	            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
	            isExistingProduct = true;
	            break;
	        }
	    }

	    // カート内に同じ商品がない場合、商品をカートに追加
	    if (!isExistingProduct) {
	        cart.add(product);
	    }

	    // 商品一覧ページにリダイレクト
	    response.sendRedirect("/ShoppingSite/views/product_list.jsp");
	}
	}


