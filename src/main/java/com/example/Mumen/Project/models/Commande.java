package com.example.Mumen.Project.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "trappe")
	private String trappe;
	
	@Column(name = "typeProtection")
	private String typeProtection;
	
	@Column(name = "prixProtection")
	private double prixProtection;
	
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "modele")
	private String modele;
	
	@Column(name = "immatriculation")
	private String immatriculation;
	
	@Column(name = "DatePreimma")
	private Date DatePreimma;
	
	@Column(name = "toit")
	private String toit;
	
	@Column(name = "etiquette")
	private String etiquette;
	
	@Column(name = "photoCarteGrise")
	private String photoCarteGrise;
	
	@Column(name = "photoVoiture")
	private String photoVoiture;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrappe() {
		return trappe;
	}

	public void setTrappe(String trappe) {
		this.trappe = trappe;
	}

	public String getTypeProtection() {
		return typeProtection;
	}

	public void setTypeProtection(String typeProtection) {
		this.typeProtection = typeProtection;
	}

	public double getPrixProtection() {
		return prixProtection;
	}

	public void setPrixProtection(double prixProtection) {
		this.prixProtection = prixProtection;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDatePreimma() {
		return DatePreimma;
	}

	public void setDatePreimma(Date datePreimma) {
		DatePreimma = datePreimma;
	}

	public String getToit() {
		return toit;
	}

	public void setToit(String toit) {
		this.toit = toit;
	}

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public String getPhotoCarteGrise() {
		return photoCarteGrise;
	}

	public void setPhotoCarteGrise(String photoCarteGrise) {
		this.photoCarteGrise = photoCarteGrise;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPhotoVoiture() {
		return photoVoiture;
	}

	public void setPhotoVoiture(String photoVoiture) {
		this.photoVoiture = photoVoiture;
	}
	
	


}
