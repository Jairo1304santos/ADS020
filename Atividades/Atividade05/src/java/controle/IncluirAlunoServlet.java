package controle;

import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;
import static sun.swing.SwingUtilities2.submit;


@WebServlet(name = "IncluirAlunoServlet", urlPatterns = {"/aluno/incluir"})
public class IncluirAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Alunos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Incluir Aluno</h1>");
            out.println("<form action=\"/Atividade05/aluno/incluir\" method=\"post\">");
            out.println("<div>");
            out.println("<label>Matrícula:</label>");
            out.println("<input type=\"text\" name=\"matricula\" size=\"15\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Nome:</label>");
            out.println("<input type=\"text\" name=\"nome\" size=\"30\">");
            out.println("</div>");
            out.println("<input type=\"submit\" values=\"Salvar\"/>");
            out.println("<a href=\"/Atividade05/aluno\">Desistir</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno aluno = new Aluno();
        AlunoBO bo = new AlunoBO();

        aluno.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        aluno.setNome(request.getParameter("nome"));

        try {
            bo.incluir(aluno);
        } catch (NegocioException e) {
            throw new ServletException("", e);

        }
        response.sendRedirect(request.getContextPath() + "/aluno");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
