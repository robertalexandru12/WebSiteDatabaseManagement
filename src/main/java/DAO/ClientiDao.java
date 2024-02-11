package DAO;

import java.util.List;
import pojo.Clienti;

public interface ClientiDao {
    public void adaugaClienti (Clienti clienti);
    public List<Clienti> afiseazaClienti();
    public void modificaClienti (int idclient, String nume, String prenume, String adresa, float buget);
    public void modificaClientNume(int idclient, String nume);
    public void modificaClientPrenume(int idclient, String prenume);
    public void modificaClientAdresa(int idclient, String adresa);
    public void modificaClientBuget(int idclient, float buget);
    public void stergeClient (Clienti client);
}

