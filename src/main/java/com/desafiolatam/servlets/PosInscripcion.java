package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.Facade;


@WebServlet("/PosInscripcion")
public class PosInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// obtengo los datos del formulario
		String nombre = request.getParameter("nombre");
		String celular = request.getParameter("telefono");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));
		// instancio el DTO y le asigno los datos
		InscripcionDTO dto = new InscripcionDTO();
		dto.setNombre(nombre);
		dto.setCelular(celular);
		dto.setIdCurso(idCurso);
		dto.setIdFormaDePago(idFormaDePago);
		// invoco al facade para procesar la inscripcion
		Facade facade = new Facade();
		int idInsc = 0;
		try {
			idInsc = facade.registrarInscripcion(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			request.setAttribute("idInsc", idInsc); 
			request.setAttribute("nombre", nombre); 
			request.setAttribute("telefono", celular);
			request.setAttribute("idCurso", idCurso);
			request.setAttribute("idFormaPago", idFormaDePago);
			request.getRequestDispatcher("/confirmacion.jsp").forward(request, response);
			
		 
		//Que pasa si no se ingresa el valor 

		// redirecciono el control hacia la siguiente vista,
		// es decir: hacia su servlet de pre-confirmacion
		
	}

}
