package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Lucrare;
import DAO.LucrareDao;
import java.util.Date;
import pojo.Constructori;
import pojo.Clienti;

public class LucrareDaoImpl implements LucrareDao{

    public void adaugaLucrare(Lucrare lucrare) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lucrare);
        transaction.commit();
        session.close();
    }

    public List<Lucrare> afiseazaLucrare() {
        List<Lucrare> listaLucrari = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createQuery("From Lucrare");
        listaLucrari = query.list();
        return listaLucrari;
    }

    public void modificaLucrare(Integer idlucrare, Clienti client, Constructori constructor, Date datainceput, float pret, int durataZile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setClienti(client);
        detaliilucrare.setConstructori(constructor);
        detaliilucrare.setDataInceput(datainceput);
        detaliilucrare.setPret(pret);
        detaliilucrare.setDurataZile(durataZile);
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void modificaLucrareClient(Integer idlucrare, Clienti client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setClienti(client);
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void modificaLucrareConstructor(Integer idlucrare, Constructori constructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setConstructori(constructor);
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void modificaLucrareData(Integer idlucrare, Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setDataInceput(date);;
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void modificaLucrarePret(Integer idlucrare, float pret) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setPret(pret);
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void modificaLucrareDurata(Integer idlucrare, int durataZile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lucrare detaliilucrare;
        detaliilucrare = (Lucrare) session.load(Lucrare.class, idlucrare);
        detaliilucrare.setDurataZile(durataZile);;
        session.update(detaliilucrare);
        transaction.commit();
        session.close();
    }
    public void stergeLucrare(Lucrare lucrare) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(lucrare);
        transaction.commit();
        session.close();
    }
}
