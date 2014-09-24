package br.wic.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wic.DAO.EnderecoDAO;


public class GerenciaServicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GerenciaServicos() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		String arg = request.getParameter("arg");
		String argEntrada = request.getParameter("argEntrada");
		String metodo = request.getParameter("metodo");
		EnderecoDAO ed = new EnderecoDAO();
		ed.insere(url, arg, argEntrada, metodo);
		System.out.println("inserido");
		response.sendRedirect("/VerificaURL2/VerificaServico");
	}
}
