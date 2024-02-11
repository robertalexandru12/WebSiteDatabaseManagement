package DAO;

import java.util.List;
import pojo.Lucrare;
import java.util.Date;
import pojo.Clienti;
import pojo.Constructori;

public interface LucrareDao {
    public void adaugaLucrare(Lucrare lucrare);
    public List<Lucrare> afiseazaLucrare();
    public void modificaLucrare (Integer idlucrare, Clienti client, Constructori constructor, Date datainceput, float pret, int durataZile);
    public void modificaLucrareClient(Integer idlucrare, Clienti client);
    public void modificaLucrareConstructor(Integer idlucrare, Constructori constructor);
    public void modificaLucrareData(Integer idlucrare, Date date);
    public void modificaLucrarePret(Integer idlucrare, float pret);
    public void modificaLucrareDurata(Integer idlucrare, int durataZile);
    public void stergeLucrare (Lucrare lucrare);
}