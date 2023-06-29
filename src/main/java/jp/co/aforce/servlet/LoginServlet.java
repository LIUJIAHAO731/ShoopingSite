package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.MemberDAO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        MemberDAO dao = new MemberDAO();
        Member login;
        try {
            login = dao.search(id, pass);
            if (login != null) {
                session.setAttribute("login", login);
                session.setMaxInactiveInterval(1800); // セッションの有効期限を30分に設定
                request.getRequestDispatcher("/views/loginsuccess.jsp").forward(request, response);
            } else {
                session.setAttribute("errormsg", "ユーザIDもしくはパスワードが違います。");
                response.sendRedirect("/ShoppingSite/views/login.jsp"); // ログインページへのリダイレクト
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
