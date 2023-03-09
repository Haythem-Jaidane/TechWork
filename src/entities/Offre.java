/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author BOURAOUI
 */
public class Offre  implements Serializable { 
    private int id;
    
    private String titre;
    private String description;
    
    private String post;
    private int salaire; //en TND
    
    private String lieu;

    private String typeContrat;
    private int duree;
    
    private String status; //Disponible, Non Disponible
    
    private String domaineOffre;
    
    private String nomRecruteur;
    private String emailRecruteur;

    
  //  private enum TypeContrat {"contrat de travail à durée indéterminée","Contrat à durée déterminée","Chèque-emploi associatif","Chèque emploi-service universel"}
   // private String[] DomaineOffre = {"Informatique","Assurance","Agriculture","Alimentation","Architecture","Art","Banque","Biologie","Chimie","Design","Finance","Mode"};

    public Offre(int id) {
        this.id = id;
    }

    public Offre(String titre, String description, String post, int salaire, String lieu, String TypeContrat, int duree, String status, String DomaineOffre, String nomRecruteur, String emailRecruteur) {
        this.titre = titre;
        this.description = description;
        this.post = post;
        this.salaire = salaire;
        this.lieu = lieu;
        this.typeContrat = TypeContrat;
        this.duree = duree;
        this.status = status;
        this.domaineOffre = DomaineOffre;
        this.nomRecruteur = nomRecruteur;
        this.emailRecruteur = emailRecruteur;
    } 

    @JsonCreator
 //   public Offre(int id, String titre, String description, String post, int salaire, String lieu, String TypeContrat, int duree, String status, String DomaineOffre, String nomRecruteur, String emailRecruteur) {
    public Offre(@JsonProperty("id") int id,@JsonProperty("titre") String titre, @JsonProperty("description")String description,
            @JsonProperty("post") String post, @JsonProperty("salaire") int salaire, @JsonProperty("lieu") String lieu, 
            @JsonProperty("TypeContrat")String TypeContrat, @JsonProperty("duree")int duree, @JsonProperty("status") String status,
            @JsonProperty("DomaineOffre") String DomaineOffre,@JsonProperty("nomRecruteur") String nomRecruteur,@JsonProperty("emailRecruteur") String emailRecruteur) {
           this.id = id;
        this.titre = titre;
        this.description = description;
        this.post = post;
        this.salaire = salaire;
        this.lieu = lieu;
        this.typeContrat = TypeContrat;
        this.duree = duree;
        this.status = status;
        this.domaineOffre = DomaineOffre;
        this.nomRecruteur = nomRecruteur;
        this.emailRecruteur = emailRecruteur;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
       
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDomaineOffre() {
        return domaineOffre;
    }

    public void setDomaineOffre(String domaineOffre) {
        this.domaineOffre = domaineOffre;
    }

    public String getNomRecruteur() {
        return nomRecruteur;
    }

    public void setNomRecruteur(String nomRecruteur) {
        this.nomRecruteur = nomRecruteur;
    }

    public String getEmailRecruteur() {
        return emailRecruteur;
    }

    public void setEmailRecruteur(String emailRecruteur) {
        this.emailRecruteur = emailRecruteur;
    }

 
 
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return Objects.equals(this.post, other.post);
    }

    
    
    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", post=" + post + ", salaire=" + salaire + ", lieu=" + lieu + ", typeContrat=" + typeContrat + ", duree=" + duree + ", status=" + status + ", DomaineOffre=" + domaineOffre + ", nomRecruteur=" + nomRecruteur + ", emailRecruteur=" + emailRecruteur + '}';
    }

  
    
 
    
}
