package biblioteca.funcionario;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FuncionarioCRUD extends HttpServlet {

    /*--------- Atributos ---------*/
    private Funcionario funcionario;
    private FuncionarioDAO dao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        funcionario = new Funcionario();
        funcionario.setCodigo(request.getParameter("codigo") != null ? Integer.valueOf(request.getParameter("codigo")) : 0);
        funcionario.setEmail(request.getParameter("email") != null ? request.getParameter("email") : "");
        funcionario.setEndereco(request.getParameter("endereco") != null ? request.getParameter("endereco") : "");
        funcionario.setNome(request.getParameter("nome") != null ? request.getParameter("nome") : "");
        funcionario.setSenha(request.getParameter("senha") != null ? request.getParameter("senha") : "");

        dao = new FuncionarioDAO();
        if (request.getParameter("tipo") != null && request.getParameter("tipo").equals("cadastro")) {
            if (dao.inserir(funcionario)) {
                //RequestDispatcher dispatcher = request.getRequestDispatcher("pages/funcionario.jsp");
                //dispatcher.forward(request, response);
                response.sendRedirect("/biblioteca/pages/funcionario.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
