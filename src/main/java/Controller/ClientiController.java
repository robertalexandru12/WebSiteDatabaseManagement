package Controller;



import DAOImpl.ClientiDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Clienti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;



/**
 * Servlet implementation class ClientiController
 */
@WebServlet("/ClientiController")
public class ClientiController extends HttpServlet implements Servlet {

	Clienti client = new Clienti();
	ClientiDaoImpl clientDaoImpl = new ClientiDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Clienti> listaClienti = new ArrayList<Clienti>();
		listaClienti = clientDaoImpl.afiseazaClienti();
		request.setAttribute("listaClienti", listaClienti);
		RequestDispatcher rd = request.getRequestDispatcher("Clienti.jsp");
		rd.forward(request, response); return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaClienti") != null) {
			List<Clienti> listaClienti = new ArrayList<Clienti>();
			listaClienti = clientDaoImpl.afiseazaClienti();
			request.setAttribute("listaClienti", listaClienti);
			RequestDispatcher rd = request.getRequestDispatcher("Clienti.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("modificaClient") != null) {
			int id1 = Integer.parseInt(request.getParameter("idclientEdit"));
			if(!request.getParameter("numeEdit").isEmpty()) {			
				String nume = request.getParameter("numeEdit");
				clientDaoImpl.modificaClientNume(id1, nume);
			}
			if(!request.getParameter("prenumeEdit").isEmpty()){
				String prenume = request.getParameter("prenumeEdit");
				clientDaoImpl.modificaClientPrenume(id1, prenume);
			}
			if(!request.getParameter("adresaEdit").isEmpty())
			{
				String adresa = request.getParameter("adresaEdit");
				clientDaoImpl.modificaClientAdresa(id1, adresa);
			}
			if(!request.getParameter("bugetEdit").isEmpty()) {
				float buget;
				try {
					buget = Float.parseFloat(request.getParameter("bugetEdit"));
				}
				catch (Exception e) { 
					buget = 0;
		            System.out.println("Eroare! A fost introdus un continut la Salariu care nu este un numar. A fost salvata valoarea 0 "); 
		        }
				clientDaoImpl.modificaClientBuget(id1, buget);
			}
			List<Clienti> listaClienti = new ArrayList<Clienti>();
			listaClienti = clientDaoImpl.afiseazaClienti();
			request.setAttribute("listaClienti", listaClienti);
			RequestDispatcher rd = request.getRequestDispatcher("Clienti.jsp");
			rd.forward(request, response);

		}
		if (request.getParameter("stergeClient") != null) {
			int id2 = Integer.parseInt(request.getParameter("idclient"));
			client.setIdclient(id2);
			clientDaoImpl.stergeClient(client);
			List<Clienti> listaClienti = new ArrayList<Clienti>();
			listaClienti = clientDaoImpl.afiseazaClienti();
			request.setAttribute("listaClienti", listaClienti);
			RequestDispatcher rd = request.getRequestDispatcher("Clienti.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("adaugaClient") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String adresa = request.getParameter("adresa");
			float buget = Float.parseFloat(request.getParameter("buget"));
			client.setNume(nume);
			client.setPrenume(prenume);
			client.setAdresa(adresa);
			client.setBuget(buget);
			clientDaoImpl.adaugaClienti(client);
			List<Clienti> listaClienti = new ArrayList<Clienti>();
			listaClienti = clientDaoImpl.afiseazaClienti();
			request.setAttribute("listaClienti", listaClienti);
			RequestDispatcher rd = request.getRequestDispatcher("Clienti.jsp");
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
