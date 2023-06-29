package jp.co.aforce.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.MemberDAO;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // フォームからの入力値を取得
            String id = request.getParameter("id");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");

            Member member = new Member();
            member.setId(id);
            member.setAddress(address);
            member.setPhone(phone);
            member.setMail(mail);
            member.setPass(pass);

            MemberDAO memberDAO = new MemberDAO();

            // メールアドレスの重複チェック
            Member existingEmailMember = memberDAO.searchByMail(mail);
            if (existingEmailMember != null) {
                response.sendRedirect("/ShoppingSite/views/error.jsp?message="
                        + URLEncoder.encode("同じメールアドレスの会員情報が既に存在します。", "UTF-8"));
                return;
            }

            // 電話番号の重複確認
            Member existingPhoneMember = memberDAO.searchByPhone(phone);
            if (existingPhoneMember != null) {
                response.sendRedirect("/ShoppingSite/views/error.jsp?message="
                        + URLEncoder.encode("同じ電話番号の会員情報が既に存在します。", "UTF-8"));
                return;
            }

            // 会員情報の重複チェック
            Member existingMember = memberDAO.searchById(id);
            if (existingMember != null) {
                response.sendRedirect("/ShoppingSite/views/error.jsp?message="
                        + URLEncoder.encode("同じ名前の会員情報が既に存在します。", "UTF-8"));
                return;
            }

            // 会員情報の登録
            int line = memberDAO.insert(member);
            if (line > 0) {
                // 登録成功時の処理
                HttpSession session = request.getSession();
                session.setAttribute("member", member);
                response.sendRedirect("/ShoppingSite/views/success.jsp"); // 登録成功時の遷移先ページ
            } else {
                response.sendRedirect("/ShoppingSite/views/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ShoppingSite/views/error.jsp"); // 登録失敗時の遷移先ページ
        }
    }
}
