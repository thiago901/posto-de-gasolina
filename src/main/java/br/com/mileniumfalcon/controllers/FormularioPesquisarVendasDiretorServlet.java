package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.Venda;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "PesquisarVendasDiretor", urlPatterns = {"/diretor/relatorio-filial"})
public class FormularioPesquisarVendasDiretorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorios-diretor.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
