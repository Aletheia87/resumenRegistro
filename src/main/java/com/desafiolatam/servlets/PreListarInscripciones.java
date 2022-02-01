package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;

@WebServlet("/PreListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		try {
			request.setAttribute("inscripciones", facade.obtieneInscripciones());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.getServletContext().getRequestDispatcher("/ListaInscripciones.jsp").forward(request, response);
	}
}
