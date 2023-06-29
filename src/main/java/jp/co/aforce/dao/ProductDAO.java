package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Product;

public class ProductDAO extends DAO {
	// 商品情報を全て取得するメソッド
	public List<Product> getAllProducts() throws SQLException {
		List<Product> productList = new ArrayList<>();
		String query = "SELECT * FROM goods";

		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Product product = new Product();
				product.setProductNo(rs.getString("no"));
				product.setProductName(rs.getString("m_name"));
				product.setStock(rs.getInt("stock"));
				product.setPrice(rs.getInt("price"));
				productList.add(product);
			}
			
		}

		return productList;
	}

	// 新商品を登録するメソッド
	public int insert(Product product) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();

			st = con.prepareStatement(
					"INSERT INTO goods (no, m_name , stock , price ) VALUES (?, ?, ?, ?)");
			st.setString(1, product.getProductNo());
			st.setString(2, product.getProductName());
			st.setInt(3, product.getStock());
			st.setInt(4, product.getPrice());

			int line = st.executeUpdate();

			return line;
		} finally {
			// リソースの解放
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
	
	 // 商品コードの重複チェックメソッド
    public boolean exists(String productNo) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            st = con.prepareStatement("SELECT * FROM goods WHERE no = ?");
            st.setString(1, productNo);
            rs = st.executeQuery();

            return rs.next(); // true if a record exists, false otherwise
        } finally {
            // リソースの解放
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

	// 更新機能
	public int update(Product existingProduct) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();

			st = con.prepareStatement(
					"UPDATE goods SET m_name = ?, stock = ?, price = ? WHERE no = ?");
			st.setString(1, existingProduct.getProductName());
			st.setInt(2, existingProduct.getStock());
			st.setInt(3, existingProduct.getPrice());
			st.setString(4, existingProduct.getProductNo());

			int line = st.executeUpdate();

			return line;
		} finally {
			// リソースの解放
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}



//商品番号による検索機能
		public Product searchByNo(String no) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			try {
				con = getConnection();

				st = con.prepareStatement("SELECT * FROM goods WHERE no = ?");
				st.setString(1, no);
				rs = st.executeQuery();

				if (rs.next()) {
					Product p = new Product();
					p.setProductNo(rs.getString("no"));
					p.setProductName(rs.getString("m_name"));
					p.setStock(rs.getInt("stock"));
					p.setPrice(rs.getInt("price"));
					

					return p;
				} else {
					return null;
				}
			} finally {
				// リソースの解放
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}}
		
			//商品番号による検索機能
			public Product searchByName(String name) throws SQLException {
				Connection con = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				try {
					con = getConnection();

					st = con.prepareStatement("SELECT * FROM goods WHERE m_name = ?");
					st.setString(1, name);
					rs = st.executeQuery();

					if (rs.next()) {
						Product p = new Product();
						p.setProductNo(rs.getString("no"));
						p.setProductName(rs.getString("m_name"));
						p.setStock(rs.getInt("stock"));
						p.setPrice(rs.getInt("price"));
						

						return p;
					} else {
						return null;
					}
				} finally {
					// リソースの解放
					if (rs != null) {
						rs.close();
					}
					if (st != null) {
						st.close();
					}
					if (con != null) {
						con.close();
					}
				}}
				
				
		
				
}
	 
