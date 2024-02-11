/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Constructori;
import DAO.ConstructoriDao;


public class ConstructoriDaoImpl implements ConstructoriDao{

    public void adaugaConstructori(Constructori constructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(constructor);
        transaction.commit();
        session.close();
    }
    public List<Constructori> afiseazaConstructori() {
        List<Constructori> listaConstructori = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createQuery("From Constructori");
        listaConstructori= query.list();
        return listaConstructori;
    }

    @Override
    public void modificaConstructori(int idconstructor, String nume, String prenume, float salariu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Constructori detaliiconstructori = (Constructori) session.load(Constructori.class, idconstructor);
        detaliiconstructori.setNume(nume);
        detaliiconstructori.setPrenume(prenume);
        detaliiconstructori.setSalariu(salariu);
        session.update(detaliiconstructori);
        transaction.commit();
        session.close();
    }
    @Override
    public void modificaConstructorNume(int idconstructor, String nume) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Constructori detaliiconstructori = (Constructori) session.load(Constructori.class, idconstructor);
        detaliiconstructori.setNume(nume);
        session.update(detaliiconstructori);
        transaction.commit();
        session.close();
    }
    
    @Override
    public void modificaConstructorPrenume(int idconstructor, String prenume) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Constructori detaliiconstructori = (Constructori) session.load(Constructori.class, idconstructor);
        detaliiconstructori.setPrenume(prenume);
        session.update(detaliiconstructori);
        transaction.commit();
        session.close();
    }
    @Override
    public void modificaConstructorSalariu(int idconstructor, float salariu) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Constructori detaliiconstructori = (Constructori) session.load(Constructori.class, idconstructor);
        detaliiconstructori.setSalariu(salariu);
        session.update(detaliiconstructori);
        transaction.commit();
        session.close();
    }
    @Override
    public void stergeConstructor(Constructori constructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(constructor);
        transaction.commit();
        session.close();
    }
}
