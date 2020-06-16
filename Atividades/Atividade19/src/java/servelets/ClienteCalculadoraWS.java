package servelets;

import cliente.CalculadoraWS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteCalculadoraWS", urlPatterns = {"/calculadora"})
public class ClienteCalculadoraWS extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CalculadoraWS_Service servico = new CalculadoraWS_Service();
        cliente.CalculadoraWS calculadora = servico.getCalculadoraWSPort();

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteCalculadoraWS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteCalculadoraWS at " + request.getContextPath() + "</h1>");
            out.println("2 + 2 é igual a " + calculadora.somarInteiros(2, 2) + "<br/>");
            out.println("2 - 2 é igual a " + calculadora.subtrairInteiros(2, 2) + "<br/>");
            out.println("2 x 2 é igual a " + calculadora.multiplicarInteiros(2, 2) + "<br/>");
            out.println("2 / 2 é igual a " + calculadora.dividirInteiros(2, 2) + "<br/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private static class CalculadoraWS_Service {

        public CalculadoraWS_Service() {
        }

        private CalculadoraWS getCalculadoraWSPort() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }

}
