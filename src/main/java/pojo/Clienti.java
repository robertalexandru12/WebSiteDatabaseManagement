package pojo;


import java.util.HashSet;
import java.util.Set;

public class Clienti  implements java.io.Serializable {

	private Integer idclient;
	private String nume;
	private String prenume;
	private String adresa;
	private float buget;
	private Set lucrari = new HashSet(0);

	public Clienti() {
	}

	public Clienti(String nume, String prenume, String adresa, Set lucrari, float buget) {
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.lucrari = lucrari;
		this.buget = buget;
	}
	public float getBuget() {
		return this.buget;
	}
	public void setBuget(float buget) {
		this.buget = buget;
	}
	public Integer getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}
	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set getLucrari() {
		return this.lucrari;
	}

	public void setLucrari(Set lucrari) {
		this.lucrari = lucrari;
	}
}




