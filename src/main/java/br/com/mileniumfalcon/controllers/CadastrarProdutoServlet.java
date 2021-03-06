package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
@WebServlet(name = "CadastrarProdutoServlet", urlPatterns = {"/backoffice/cadastrar-produto"})
public class CadastrarProdutoServlet extends HttpServlet {
    
    FuncionarioDAO fDao = new FuncionarioDAO();
    ProdutoDAO pDao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        ArrayList<String> filiais = fDao.getFiliais();

        request.setAttribute("filiaisAttr", filiais);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        double preco = Double.parseDouble(request.getParameter("preco"));
        double quantidade = Double.parseDouble(request.getParameter("quantidade"));
        String filialStr = request.getParameter("filial");

        Filial filial = fDao.getFilial(filialStr);

        Produto produto = new Produto(nome, tipo, quantidade, preco, filial);
        boolean salvou = pDao.salvar(produto);

        if (salvou) {
            request.setAttribute("criadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/backoffice.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
            dispatcher.forward(request, response);
        }
    }
}
