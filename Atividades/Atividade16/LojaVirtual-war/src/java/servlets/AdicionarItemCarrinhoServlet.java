package servlets;

import ejb.CarrinhoCompraLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdicionarItemCarrinhoServlet", urlPatterns = {"/carrinho/adicionar"})
public class AdicionarItemCarrinhoServlet extends HttpServlet {

    private CarrinhoCompraLocal carrinho;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        carrinho = (CarrinhoCompraLocal) request.getSession().getAttribute("ejb_stateful");

        if (carrinho == null) {
            try {
                Context contexto = new InitialContext();
                carrinho = (CarrinhoCompraLocal) contexto.lookup("java:global/Atividade16/CarrinhoEJB-ejb/CarrinhoCompraStateful!ejb.CarrinhoCompraLocal");
            } catch (NamingException e) {
                throw new ServletException(e);
            }
            request.getSession().setAttribute("ejb_stateful", carrinho);
        }

        String item = request.getParameter("item");
        carrinho.adicionarItem(item);

        List<String> lista = carrinho.listarItens();

        PrintWriter out = response.getWriter();

        if (lista.isEmpty()) {
            out.println("<p>Nenhum adicionado ao carrinho</p>");
        }

        lista.forEach((i) -> {
            out.println("<p>" + i + "</p>");
        });

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdicionarItemCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdicionarItemCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
