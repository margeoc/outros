package br.wic.controlador;

import br.com.wic.DAO.Endereco;
import br.com.wic.DAO.EnderecoDAO;
import br.com.wic.DAO.Valida;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificaServico
 */
@WebServlet("/VerificaServico")
public class VerificaServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VerificaServico() {
        super();
         
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Valida v = new Valida();
		ArrayList<Endereco> lista = (ArrayList<Endereco>) v.statusServicos();
		request.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("resultado.jsp");
		view.forward(request, response);
	}

}
