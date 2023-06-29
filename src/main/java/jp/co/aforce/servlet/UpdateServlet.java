
package jp.co.aforce.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.MemberDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 更新画面を表示するためのJSPに遷移
        request.getRequestDispatcher("/ShoppingSite/views/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        try {
            String id = request.getParameter("id");

            // 名前の入力値空きかどうかのエラーチェック
            if (id.isEmpty()) {
                response.sendRedirect("/ShoppingSite/views/update_error.jsp");
                return;
            }

            MemberDAO memberDAO = new MemberDAO();

            // 会員情報の検索
            Member existingMember = memberDAO.searchById(id);
            if (existingMember == null) {
                response.sendRedirect("/ShoppingSite/views/update_error.jsp?message="
                        + URLEncoder.encode("指定した会員番号の会員情報が存在しません。", "UTF-8"));
                return;
            }

            
            // 更新値を取得
            
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            String pass = request.getParameter("pass");

         // デバッグステートメントを追加
            System.out.println("Phone: " + phone);
            
          //電話番号が入力されたら
            if (phone != null && !phone.isEmpty()) {
                // 電話番号の桁数チェックを入れる
                if (phone.length() < 11 || phone.length() > 15) {
                    response.sendRedirect("/ShoppingSite/views/update_error.jsp?message="
                            + URLEncoder.encode("電話番号は11桁以上15桁以下で入力してください。", "UTF-8"));
                    return;
                }
                existingMember.setPhone(phone);
            }
            
            //メールアドレスが入力されたら
            if (mail != null && !mail.isEmpty()) {
                // メールアドレスの重複チェックを入れる
                Member existingEmailMember = memberDAO.searchByMail(mail);
                if (existingEmailMember != null) {
                    response.sendRedirect("/ShoppingSite/views/update_error.jsp?message="
                            + URLEncoder.encode("同じメールアドレスの会員情報が既に存在します。", "UTF-8"));
                    return;
                }
                existingMember.setMail(mail);
            }
            
            //パスワードが入力されたら
            if (pass != null && !pass.isEmpty()) {
            	
            	//パスワードがセットできるように
                existingMember.setPass(pass);
            }

            //既存のメンバー情報を更新するため、updateメソッドを呼び出し
            int line = memberDAO.update(existingMember);
         // デバッグステートメントを追加
            System.out.println("Updated rows: " + line);

            if (line > 0) {
                response.sendRedirect("/ShoppingSite/views/update_success.jsp");
            } else {
                response.sendRedirect("/ShoppingSite/views/update_error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ShoppingSite/views/update_error.jsp");
        }
    }
}
