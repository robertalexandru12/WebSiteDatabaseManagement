package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAOImpl.ConstructoriDaoImpl;
import pojo.Constructori;

/**
 * Servlet implementation class ConstructoriController
 */
//@WebServlet("/ConstructoriController")
public class ConstructoriController extends HttpServlet implements Servlet {
	Constructori constructor = new Constructori();
	ConstructoriDaoImpl constructorDaoImpl = new ConstructoriDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, jakarta.servlet.ServletException {
		if (request.getParameter("afiseazaConstructori") != null) {
			List<Constructori> listaConstructori = new ArrayList<Constructori>();
			listaConstructori = constructorDaoImpl.afiseazaConstructori();
			request.setAttribute("listaConstructori", listaConstructori);
			RequestDispatcher rd = request.getRequestDispatcher("Constructori.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, jakarta.servlet.ServletException {

		if (request.getParameter("modificaConstructor") != null) {
			int id1 = Integer.parseInt(request.getParameter("idconstructorEdit"));
			if(!request.getParameter("numeEdit").isEmpty()) {
				String nume = request.getParameter("numeEdit");
				constructorDaoImpl.modificaConstructorNume(id1, nume);
			}
			if(!request.getParameter("prenumeEdit").isEmpty()) {
				String prenume = request.getParameter("prenumeEdit");
				constructorDaoImpl.modificaConstructorPrenume(id1, prenume);
			}
			if(!request.getParameter("salariuEdit").isEmpty()) {
				float salariu;
				try {
					salariu = Float.parseFloat(request.getParameter("salariuEdit"));
				}
				catch (Exception e) { 
					salariu = 0;
		            System.out.println("Eroare! A fost introdus un continut la Salariu care nu este un numar. A fost salvata valoarea 0 "); 
		        } 
				constructorDaoImpl.modificaConstructorSalariu(id1, salariu);
		    } 
				
			
			
			List<Constructori> listaConstructori = new ArrayList<Constructori>();
			listaConstructori = constructorDaoImpl.afiseazaConstructori();
			request.setAttribute("listaConstructori", listaConstructori);
			RequestDispatcher rd = request.getRequestDispatcher("Constructori.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeConstructor") != null) {
			int id2 = Integer.parseInt(request.getParameter("idconstructor"));
			constructor.setIdconstructor(id2);
			constructorDaoImpl.stergeConstructor(constructor);
			List<Constructori> listaConstructori = new ArrayList<Constructori>();
			listaConstructori = constructorDaoImpl.afiseazaConstructori();
			request.setAttribute("listaConstructori", listaConstructori);
			RequestDispatcher rd = request.getRequestDispatcher("Constructori.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("adaugaConstructor") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			float salariu = Float.parseFloat(request.getParameter("salariu"));
			constructor.setNume(nume);
			constructor.setPrenume(prenume);
			constructor.setSalariu(salariu);
			constructorDaoImpl.adaugaConstructori(constructor);
			List<Constructori> listaConstructori = new ArrayList<Constructori>();
			listaConstructori = constructorDaoImpl.afiseazaConstructori();
			request.setAttribute("listaConstructori", listaConstructori);
			RequestDispatcher rd = request.getRequestDispatcher("Constructori.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("afiseazaConstructori") != null) {
			List<Constructori> listaConstructori = new ArrayList<Constructori>();
			listaConstructori = constructorDaoImpl.afiseazaConstructori();
			request.setAttribute("listaConstructori", listaConstructori);
			RequestDispatcher rd = request.getRequestDispatcher("Constructori.jsp");
			rd.forward(request, response);
		}
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
