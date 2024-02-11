package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import DAOImpl.LucrareDaoImpl;
import DAOImpl.HibernateUtil;
import pojo.Lucrare;
import pojo.Clienti;
import pojo.Constructori;

/**
 * Servlet implementation class LucrareController
 */
public class LucrareController extends HttpServlet implements Servlet {

	Lucrare lucrare = new Lucrare();
	LucrareDaoImpl lucrareDaoImpl = new LucrareDaoImpl();

	protected void doGet(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaLucrare") != null) {
			Integer idclient = java.lang.Integer.parseInt(request.getParameter("idclient"));
			Integer idconstructor = java.lang.Integer.parseInt(request.getParameter("idconstructor"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Clienti client = (Clienti) session.get(Clienti.class, idclient);
			Constructori constructor = (Constructori) session.get(Constructori.class, idconstructor);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date datainceput = null;
			try {
				datainceput = df.parse(request.getParameter("dataInceput"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			float pret = Float.parseFloat(request.getParameter("pret"));
			int durataZile = Integer.parseInt(request.getParameter("durataZile"));

			lucrare.setClienti(client);
			lucrare.setConstructori(constructor);
			lucrare.setDataInceput(datainceput);
			lucrare.setPret(pret);
			lucrare.setDurataZile(durataZile);

			lucrareDaoImpl.adaugaLucrare(lucrare);
			List<Lucrare> listaLucrare = new ArrayList<Lucrare>();
			listaLucrare = lucrareDaoImpl.afiseazaLucrare();
			request.setAttribute("listaLucrare", listaLucrare);
			RequestDispatcher rd = request.getRequestDispatcher("Lucrari.jsp");
			rd.forward(request, response);
	     	}
	   }
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaLucrare") != null) {
			// preluarea parametrilor de interes
			Integer idclient = java.lang.Integer.parseInt(request.getParameter("idclient"));
			Integer idconstructor = java.lang.Integer.parseInt(request.getParameter("idconstructor"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Clienti client = (Clienti) session.get(Clienti.class, idclient);
			Constructori constructor = (Constructori) session.get(Constructori.class, idconstructor);

			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date datainceput = null;
			try {
				datainceput = df.parse(request.getParameter("dataInceput"));
				System.out.println(request.getParameter("dataInceput"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			float pret = Float.parseFloat(request.getParameter("pret"));
			int durataZile = Integer.parseInt(request.getParameter("durataZile"));

			lucrare.setClienti(client);
			lucrare.setConstructori(constructor);
			lucrare.setDataInceput(datainceput);
			lucrare.setPret(pret);
			lucrare.setDurataZile(durataZile);

			lucrareDaoImpl.adaugaLucrare(lucrare);
			List<Lucrare> listaLucrare = new ArrayList<Lucrare>();
			listaLucrare = lucrareDaoImpl.afiseazaLucrare();
			request.setAttribute("listaLucrare", listaLucrare);
			RequestDispatcher rd = request.getRequestDispatcher("Lucrari.jsp");
			rd.forward(request, response);
			
	     	}
	   
		if (request.getParameter("afiseazaLucrare") != null) {
			List<Lucrare> listaLucrare = new ArrayList();
			listaLucrare = lucrareDaoImpl.afiseazaLucrare();
			request.setAttribute("listaLucrare", listaLucrare);
			RequestDispatcher rd = request.getRequestDispatcher("Lucrari.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaLucrare") != null) {
			Integer id1 = Integer.parseInt(request.getParameter("idlucrareEdit"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			if(request.getParameter("idclientEdit")!=null) {
				Integer idclient = java.lang.Integer.parseInt(request.getParameter("idclientEdit"));
				Clienti client = (Clienti) session.get(Clienti.class, idclient);
				lucrareDaoImpl.modificaLucrareClient(id1, client);
				
			}
			if(request.getParameter("idconstructorEdit")!=null) {
				Integer idconstructor = java.lang.Integer.parseInt(request.getParameter("idconstructorEdit"));
				Constructori constructor = (Constructori) session.get(Constructori.class, idconstructor);
				lucrareDaoImpl.modificaLucrareConstructor(id1, constructor);
			}
			if(!request.getParameter("dataInceputEdit").isEmpty()) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dataInceput = null;
				try {
					dataInceput = df.parse(request.getParameter("dataInceputEdit"));
					lucrareDaoImpl.modificaLucrareData(id1, dataInceput);
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("EROARE: NU SE POATE CONVERTI INTR-O DATA!");
				}
			}
			if(!request.getParameter("pretEdit").isEmpty()) {
				float pret=0;
				try {
					pret = Float.parseFloat(request.getParameter("pretEdit"));
				}
				catch(Exception e) {
					System.out.println("Nu se poate converti pretul la un numar real -> " + request.getParameter("pretEdit"));
				}
				lucrareDaoImpl.modificaLucrarePret(id1, pret);
			}
			if(!request.getParameter("durataZileEdit").isEmpty()) {
				int durataZile=0;
				try {
					durataZile = Integer.parseInt(request.getParameter("durataZileEdit"));
				}
				catch(Exception e) {
					System.out.println("Nu se poate converti durata de zile la un numar intreg -> " + request.getParameter("durataZileEdit"));
				}
				lucrareDaoImpl.modificaLucrareDurata(id1, durataZile);
			}
			List<Lucrare> listaLucrare = new ArrayList();
			listaLucrare = lucrareDaoImpl.afiseazaLucrare();
			request.setAttribute("listaLucrare", listaLucrare);
			RequestDispatcher rd = request.getRequestDispatcher("Lucrari.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeLucrare") != null) {
			Integer id2 = Integer.parseInt(request.getParameter("idlucrare"));
			lucrare.setIdlucrare(id2);
			lucrareDaoImpl.stergeLucrare(lucrare);
			List<Lucrare> listaLucrare = new ArrayList();
			listaLucrare = lucrareDaoImpl.afiseazaLucrare();
			request.setAttribute("listaLucrare", listaLucrare);
			RequestDispatcher rd = request.getRequestDispatcher("Lucrari.jsp");
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
