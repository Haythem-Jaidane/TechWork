/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.entities;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Historique {
    private int id;
    private int id_Profil;
    private int id_Recruteur;
    private int id_Offre;
    private Boolean resultat;

    public Historique(int id) {
        this.id = id;
    }

    public Historique(int id_Profil, int id_Recruteur, int id_Offre, Boolean resultat) {
        this.id_Profil = id_Profil;
        this.id_Recruteur = id_Recruteur;
        this.id_Offre = id_Offre;
        this.resultat = resultat;
    }

    public Historique(int id, int id_Profil, int id_Recruteur, int id_Offre, Boolean resultat) {
        this.id = id;
        this.id_Profil = id_Profil;
        this.id_Recruteur = id_Recruteur;
        this.id_Offre = id_Offre;
        this.resultat = resultat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Profil() {
        return id_Profil;
    }

    public void setId_Profil(int id_Profil) {
        this.id_Profil = id_Profil;
    }

    public int getId_Recruteur() {
        return id_Recruteur;
    }

    public void setId_Recruteur(int id_Recruteur) {
        this.id_Recruteur = id_Recruteur;
    }

    public int getId_Offre() {
        return id_Offre;
    }

    public void setId_Offre(int id_Offre) {
        this.id_Offre = id_Offre;
    }

    public Boolean getResultat() {
        return resultat;
    }

    public void setResultat(Boolean resultat) {
        this.resultat = resultat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.id_Profil;
        hash = 67 * hash + this.id_Recruteur;
        hash = 67 * hash + this.id_Offre;
        hash = 67 * hash + Objects.hashCode(this.resultat);
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
        final Historique other = (Historique) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_Profil != other.id_Profil) {
            return false;
        }
        if (this.id_Recruteur != other.id_Recruteur) {
            return false;
        }
        if (this.id_Offre != other.id_Offre) {
            return false;
        }
        return Objects.equals(this.resultat, other.resultat);
    }

    @Override
    public String toString() {
        return "Historique{" + "id=" + id + ", id_Profil=" + id_Profil + ", id_Recruteur=" + id_Recruteur + ", id_Offre=" + id_Offre + ", resultat=" + resultat + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
