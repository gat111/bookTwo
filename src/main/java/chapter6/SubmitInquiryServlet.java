package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubmitInquiryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        // データの処理（例: データベースに保存、メール送信など）
        // ここでは簡単に結果を表示するだけにします

        // 応答の設定
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>お問い合わせ結果</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println(".container { max-width: 600px; }");
            out.println("h1 { color: #333; }");
            out.println("p { line-height: 1.6; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>お問い合わせありがとうございます。</h1>");
            out.println("<p>以下の内容でお問い合わせを受け付けました。</p>");
            out.println("<ul>");
            out.println("<li><strong>お名前:</strong> " + escapeHtml(name) + "</li>");
            out.println("<li><strong>メールアドレス:</strong> " + escapeHtml(email) + "</li>");
            out.println("<li><strong>お問い合わせの種類:</strong> " + escapeHtml(category) + "</li>");
            out.println("<li><strong>希望連絡日:</strong> " + escapeHtml(date) + "</li>");
            out.println("<li><strong>件名:</strong> " + escapeHtml(subject) + "</li>");
            out.println("<li><strong>お問い合わせ内容:</strong> " + escapeHtml(message) + "</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // 簡易的なHTMLエスケープ処理
    private String escapeHtml(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
