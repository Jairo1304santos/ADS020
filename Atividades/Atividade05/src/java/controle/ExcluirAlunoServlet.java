package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

@WebServlet(name = "ExcluirAlunoServlet", urlPatterns = {"/aluno/excluir"})
public class ExcluirAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno aluno = new Aluno();
        AlunoBO bo = new AlunoBO();
        int id = Integer.parseInt(request.getParameter("id"));
        aluno.setId(id);
        try {
            bo.excluir(aluno);
        } catch (NegocioException e) {
            throw new ServletException("", e);
        }
        response.sendRedirect(request.getContextPath() + "/aluno");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("Método não suportado");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
