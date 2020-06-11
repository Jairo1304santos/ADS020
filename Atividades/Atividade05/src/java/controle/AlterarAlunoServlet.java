package controle;

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

@WebServlet(name = "AlterarAlunoServlet", urlPatterns = {"/aluno/alterar"})
public class AlterarAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno aluno = new Aluno();
        AlunoBO bo = new AlunoBO();

        int id = Integer.parseInt(request.getParameter("id"));
        aluno.setId(id);
        try {
            aluno = bo.consultar(aluno);
        } catch (NegocioException e) {
            throw new ServletException("", e);
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Alunos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alterar Aluno</h1>");
            out.println("<form action=\"/Atividade05/aluno/alterar\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"id\" value='"+ aluno.getId()+"'/>");
            out.println("<div>");
            out.println("<label>Matrícula:</label>");
            out.println("<input type=\"text\" name=\"matricula\" size=\"15\" value='"+ aluno.getMatricula()+"'/>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Nome:</label>");
            out.println("<input type=\"text\" name=\"nome\" size=\"30\" value='"+ aluno.getNome()+"'/>");
            out.println("</div>");
            out.println("<input type=\"submit\" value=\"Salvar\"/>");
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
        aluno.setId(Integer.parseInt(request.getParameter("id")));
        aluno.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        aluno.setNome(request.getParameter("nome"));

        AlunoBO bo = new AlunoBO();

        try {
            bo.alterar(aluno);
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
