package DAO;

import java.util.List;
import pojo.Constructori;

public interface ConstructoriDao {
    public void adaugaConstructori (Constructori constructori);
    public List<Constructori> afiseazaConstructori();
    public void modificaConstructori (int idconstructor, String nume, String prenume, float salariu);
    public void modificaConstructorNume(int idconstructor, String nume);
    public void modificaConstructorPrenume(int idconstructor, String prenume);
    public void modificaConstructorSalariu(int idconstructor, float salariu);
    public void stergeConstructor (Constructori constructor);
}