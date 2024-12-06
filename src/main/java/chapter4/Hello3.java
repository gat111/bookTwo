package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hello3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet/JSP Sample Programs</title>");
        // CSSスタイルを追加
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f8ff; margin: 20px; }");
        out.println("h1 { color: #333; }");
        out.println("p { font-size: 16px; color: #555; }");
        out.println("button { background-color: #007BFF; color: white; border: none; padding: 10px 20px; cursor: pointer; }");
        out.println("button:hover { background-color: #0056b3; }");
        out.println("</style>");
        // JavaScriptを追加
        out.println("<script>");
        out.println("function showAlert() {");
        out.println("  alert('ボタンがクリックされました！');");
        out.println("}");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Servlet</h1>");
        out.println("<p>Hello!</p>");
        out.println("<p>こんにちは！</p>");
        out.println("<p>現在の日時: " + new Date() + "</p>");
        out.println("<button onclick='showAlert()'>クリックしてください</button>");
        out.println("</body>");
        out.println("</html>");
    }
}
