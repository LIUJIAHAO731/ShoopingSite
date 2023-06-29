package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.bean.Member;

public class MemberDAO extends DAO {

	//登録機能
	public int insert(Member member) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();

			st = con.prepareStatement(
					"INSERT INTO member (id, address , phone, mail, pass) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, member.getId());
			st.setString(2, member.getAddress());
			st.setString(3, member.getPhone());
			st.setString(4, member.getMail());
			st.setString(5, member.getPass());
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

	//名前による検索機能
		public Member searchById(String id) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			try {
				con = getConnection();

				st = con.prepareStatement("SELECT * FROM member WHERE id = ?");
				st.setString(1, id);
				rs = st.executeQuery();

				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getString("id"));
					member.setAddress(rs.getString("address"));
					member.setPhone(rs.getString("phone"));
					member.setMail(rs.getString("mail"));
					member.setPass(rs.getString("pass"));

					return member;
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
			}
		}

	// メールアドレスによる検索機能
	public Member searchByMail(String mail) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			st = con.prepareStatement("SELECT * FROM member WHERE mail = ?");
			st.setString(1, mail);
			rs = st.executeQuery();

			if (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setMail(rs.getString("mail"));
				member.setPass(rs.getString("pass"));

				return member;
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
		}
	}

	// 更新機能
	public int update(Member existingMember) throws SQLException {
	    Connection con = null;
	    PreparedStatement st = null;
	    
	    try {
	        con = getConnection();
	        
	        st = con.prepareStatement(
	                "UPDATE member SET address = ?, phone = ?, mail = ?, pass = ? WHERE id = ?");
	        st.setString(1, existingMember.getAddress());
	        st.setString(2, existingMember.getPhone());
	        st.setString(3, existingMember.getMail());
	        st.setString(4, existingMember.getPass());
	        st.setString(5, existingMember.getId());
	        
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

	// 電話番号による検索機能
	public Member searchByPhone(String phone) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			st = con.prepareStatement("SELECT * FROM member WHERE phone = ?");
			st.setString(1, phone);
			rs = st.executeQuery();

			if (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setMail(rs.getString("mail"));
				member.setPass(rs.getString("pass"));

				return member;
			} else {
				return null;
			}
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

	
//ログイン機能
	public Member search(String id, String pass) throws Exception {
	    Member login = null;

	    Connection con = getConnection();
	    PreparedStatement st;
	    String query = "SELECT * FROM member WHERE id = ?";
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
	        login = new Member();
	        login.setId(rs.getString("id"));
	        login.setPass(rs.getString("pass"));
	    }

	    st.close();
	    con.close();
	    return login;
	}

}