package pojo;


import java.util.HashSet;
import java.util.Set;

public class Constructori  implements java.io.Serializable {


	private Integer idconstructor;
	private String nume;
	private String prenume;
	private float salariu;
	private Set lucrari = new HashSet(0);

	public Constructori() {
	}

	public Constructori(String nume, String prenume, float salariu, Set lucrari) {
		this.nume = nume;
		this.prenume = prenume;
		this.salariu = salariu;
		this.lucrari = lucrari;
	}

	public Integer getIdconstructor() {
		return this.idconstructor;
	}

	public void setIdconstructor(Integer idconstructor) {
		this.idconstructor = idconstructor;
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
	public float getSalariu() {
		return this.salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}
	public Set getLucrari() {
		return this.lucrari;
	}

	public void setLucrari(Set lucrari) {
		this.lucrari = lucrari;
	}
}




