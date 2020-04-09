package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sistema Acadêmico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Efetuar Login</h1>");
            out.println("<form action=\"/Atividade06/login\" method=\"post\">");
            out.println("<div>");
            out.println("<label>Matrícula</label>");
            out.println("<input type=\"text\" name=\"matricula\" size=\"15\" value=\"\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Senha</label>");
            out.println("<input type=\"text\" name=\"senha\" size=\"15\" value=\"\">");
            out.println("</div>");
            out.println("<input type=\"submit\" value=\"Entrar\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        if (matricula == null || senha == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("autenticado", true);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
