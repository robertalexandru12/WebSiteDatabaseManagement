package pojo;



import java.util.Date;

public class Lucrare  implements java.io.Serializable {

	private Integer idlucrare;
	private Constructori constructori;
	private Clienti clienti;
	private Date datainceput;
	private float pret;
	private int durataZile;

	public Lucrare() {
	}

	public Lucrare(Constructori constructori, Clienti clienti, Date datainceput, float pret, int durataZile) {
		this.constructori = constructori;
		this.clienti = clienti;
		this.datainceput = datainceput;
		this.pret = pret;
		this.durataZile = durataZile;
	}

	public Integer getIdlucrare() {
		return this.idlucrare;
	}

	public void setIdlucrare(Integer idlucrare) {
		this.idlucrare = idlucrare;
	}
	public Constructori getConstructori() {
		return this.constructori;
	}

	public void setConstructori(Constructori constructori) {
		this.constructori = constructori;
	}
	public Clienti getClienti() {
		return this.clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}
	public Date getDataInceput() {
		return this.datainceput;
	}

	public void setDataInceput(Date dataInceput) {
		this.datainceput = dataInceput;
	}
	public float getPret() {
		return this.pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}
	public int getDurataZile() {
		return this.durataZile;
	}

	public void setDurataZile(int durataZile) {
		this.durataZile = durataZile;
	}
}




