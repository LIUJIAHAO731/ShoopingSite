package jp.co.aforce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication implements Filter {
    
    public void init(FilterConfig config) throws ServletException {
        // 初期化処理
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // ログインチェック
        if (httpRequest.getSession().getAttribute("login") == null) {
            // 未ログインの場合、ログイン画面にリダイレクト
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        } else {
            // ログイン済みの場合、リクエストを処理する
            chain.doFilter(request, response);
        }
    }
    
    public void destroy() {
        // 終了処理
    }
}
