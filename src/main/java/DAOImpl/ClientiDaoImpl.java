/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojo.Clienti;
import DAO.ClientiDao;


public class ClientiDaoImpl implements ClientiDao{

    public void adaugaClienti(Clienti client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public List<Clienti> afiseazaClienti() {
        List<Clienti> listaClienti = new ArrayList<Clienti>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Clienti> query = session.createQuery("From Clienti", Clienti.class);
        listaClienti = query.list();
        return listaClienti;
    }

    public void modificaClienti(int idclient, String nume, String prenume, String adresa, float buget) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clienti detaliiclienti = (Clienti) session.load(Clienti.class, idclient);
        detaliiclienti.setNume(nume);
        detaliiclienti.setPrenume(prenume);
        detaliiclienti.setAdresa(adresa);
        detaliiclienti.setBuget(buget);
        session.update(detaliiclienti);
        transaction.commit();
        session.close();
    }
    public void modificaClientNume(int idclient, String nume) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clienti detaliiclienti = (Clienti) session.load(Clienti.class, idclient);
        detaliiclienti.setNume(nume);
        session.update(detaliiclienti);
        transaction.commit();
        session.close();
    }
    public void modificaClientPrenume(int idclient ,String prenume) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clienti detaliiclienti = (Clienti) session.load(Clienti.class, idclient);
        detaliiclienti.setPrenume(prenume);
        session.update(detaliiclienti);
        transaction.commit();
        session.close();
    }
    public void modificaClientAdresa(int idclient, String adresa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clienti detaliiclienti = (Clienti) session.load(Clienti.class, idclient);
        detaliiclienti.setAdresa(adresa);
        session.update(detaliiclienti);
        transaction.commit();
        session.close();
    }
    public void modificaClientBuget(int idclient, float buget) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clienti detaliiclienti = (Clienti) session.load(Clienti.class, idclient);
        detaliiclienti.setBuget(buget);
        session.update(detaliiclienti);
        transaction.commit();
        session.close();
    }
    public void stergeClient(Clienti client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }
}
