/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author BOURAOUI
 */
public class Candidature {
    private int id;
    private Offre offre;
    private String recruteur;
    private String candidat;
    private String status; //Acceptée, Rejetée, Annulée
    private String informations; // Why rejetée/ why acceptée
    private String datePostulation;
    private String dateModification;

    public Candidature(int id) {
        this.id = id;
    }
    public Candidature(int id,  String status  ) {
            this.id = id;
    
        this.status = status; 
    }
    public Candidature(Offre offre, String recruteur, String candidat, String status, String informations, String datePostulation, String dateModification) {
        this.offre = offre;
        this.recruteur = recruteur;
        this.candidat = candidat;
        this.status = status;
        this.informations = informations;
        this.datePostulation = datePostulation;
        this.dateModification = dateModification;
    }

    public Candidature(int id, Offre offre, String recruteur, String candidat, String status, String informations, String datePostulation, String dateModification) {
        this.id = id;
        this.offre = offre;
        this.recruteur = recruteur;
        this.candidat = candidat;
        this.status = status;
        this.informations = informations;
        this.datePostulation = datePostulation;
        this.dateModification = dateModification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

 

    public String getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public String getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(String datePostulation) {
        this.datePostulation = datePostulation;
    }

    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
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
        final Candidature other = (Candidature) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.offre != other.offre) {
            return false;
        }
        if (!Objects.equals(this.recruteur, other.recruteur)) {
            return false;
        }
        if (!Objects.equals(this.candidat, other.candidat)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.informations, other.informations)) {
            return false;
        }
        if (!Objects.equals(this.datePostulation, other.datePostulation)) {
            return false;
        }
        return Objects.equals(this.dateModification, other.dateModification);
    }

 

    @Override
    public String toString() {
        return "Candidature{" + "id=" + id + ", offre=" + offre + ", recruteur=" + recruteur + ", candidat=" + candidat + ", status=" + status + ", informations=" + informations + ", datePostulation=" + datePostulation + ", dateModification=" + dateModification + '}';
    }
    
 
    
    
}
