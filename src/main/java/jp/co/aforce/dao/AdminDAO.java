package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Admin;

public class AdminDAO extends DAO {

	public Admin search(String id, String pass) throws Exception {

		Admin admin = null;

		Connection con = getConnection();
		PreparedStatement st;
		String query = "SELECT * FROM admin WHERE id = ?";
		if (pass != null) {
			query += " AND pass = ?";
		}
		st = con.prepareStatement(query);
		st.setString(1, id);
		if (pass != null) {
			st.setString(2, pass);
		}
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			admin = new Admin();
			admin.setId(rs.getString("id"));
			admin.setPass(rs.getString("pass"));
		}

		st.close();
		con.close();
		return admin;
	}
}
