package model;

public class Enseignant {
	private int id;
	private String numero_enseignant;
	private String nom;
	private String prenom;
	private String grade;
	private String id_user;
	public Enseignant() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero_enseignant() {
		return numero_enseignant;
	}
	public void setNumero_enseignant(String numero_enseignant) {
		this.numero_enseignant = numero_enseignant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	
	

}
