/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gererProfil.entities;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Profil {

    private int id_Profil;
    private String Nom;
    private String Prenom;
    private String Numéro_téléphone;
    private String E_mail;
    private String Localisation;
    private String Description;
    private String Langues;
    private String Competences;
    private String Formation;
    private String Experiences_professionnelles;
    private String Diplome;
    private String latitude;
    private String longitude;

    public Profil(int id_Profil) {
        this.id_Profil = id_Profil;
    }

    public Profil(String Nom, String Prenom, String Numéro_téléphone, String E_mail, String Localisation, String Description, String Langues, String Competences, String Formation, String Experiences_professionnelles, String latitude, String longitude, String Diplome) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Numéro_téléphone = Numéro_téléphone;
        this.E_mail = E_mail;
        this.Localisation = Localisation;
        this.Description = Description;
        this.Langues = Langues;
        this.Competences = Competences;
        this.Formation = Formation;
        this.Experiences_professionnelles = Experiences_professionnelles;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Diplome = Diplome;
    }

    public Profil(int id_Profil, String Nom, String Prenom, String Numéro_téléphone, String E_mail, String Localisation, String Description, String Langues, String Competences, String Formation, String Experiences_professionnelles, String latitude, String longitude, String Diplome) {
        this.id_Profil = id_Profil;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Numéro_téléphone = Numéro_téléphone;
        this.E_mail = E_mail;
        this.Localisation = Localisation;
        this.Description = Description;
        this.Langues = Langues;
        this.Competences = Competences;
        this.Formation = Formation;
        this.Experiences_professionnelles = Experiences_professionnelles;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Diplome = Diplome;
    }

    public int getId_Profil() {
        return id_Profil;
    }

    public void setId_Profil(int id_Profil) {
        this.id_Profil = id_Profil;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNuméro_téléphone() {
        return Numéro_téléphone;
    }

    public void setNuméro_téléphone(String Numéro_téléphone) {
        this.Numéro_téléphone = Numéro_téléphone;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLangues() {
        return Langues;
    }

    public void setLangues(String Langues) {
        this.Langues = Langues;
    }

    public String getCompetences() {
        return Competences;
    }

    public void setCompetences(String Competences) {
        this.Competences = Competences;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String Formation) {
        this.Formation = Formation;
    }

    public String getExperiences_professionnelles() {
        return Experiences_professionnelles;
    }

    public void setExperiences_professionnelles(String Experiences_professionnelles) {
        this.Experiences_professionnelles = Experiences_professionnelles;
    }

    public String getDiplome() {
        return Diplome;
    }

    public void setDiplome(String Diplome) {
        this.Diplome = Diplome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_Profil;
        hash = 89 * hash + Objects.hashCode(this.Nom);
        hash = 89 * hash + Objects.hashCode(this.Prenom);
        hash = 89 * hash + Objects.hashCode(this.Numéro_téléphone);
        hash = 89 * hash + Objects.hashCode(this.E_mail);
        hash = 89 * hash + Objects.hashCode(this.Localisation);
        hash = 89 * hash + Objects.hashCode(this.Description);
        hash = 89 * hash + Objects.hashCode(this.Langues);
        hash = 89 * hash + Objects.hashCode(this.Competences);
        hash = 89 * hash + Objects.hashCode(this.Formation);
        hash = 89 * hash + Objects.hashCode(this.Experiences_professionnelles);
        hash = 89 * hash + Objects.hashCode(this.Diplome);
        hash = 89 * hash + Objects.hashCode(this.latitude);
        hash = 89 * hash + Objects.hashCode(this.longitude);
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
        final Profil other = (Profil) obj;
        if (this.id_Profil != other.id_Profil) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.Numéro_téléphone, other.Numéro_téléphone)) {
            return false;
        }
        if (!Objects.equals(this.E_mail, other.E_mail)) {
            return false;
        }
        if (!Objects.equals(this.Localisation, other.Localisation)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Langues, other.Langues)) {
            return false;
        }
        if (!Objects.equals(this.Competences, other.Competences)) {
            return false;
        }
        if (!Objects.equals(this.Formation, other.Formation)) {
            return false;
        }
        if (!Objects.equals(this.Experiences_professionnelles, other.Experiences_professionnelles)) {
            return false;
        }
        if (!Objects.equals(this.Diplome, other.Diplome)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        return Objects.equals(this.longitude, other.longitude);
    }

    @Override
    public String toString() {
        return "Profil{" + "id_Profil=" + id_Profil + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Num\u00e9ro_t\u00e9l\u00e9phone=" + Numéro_téléphone + ", E_mail=" + E_mail + ", Localisation=" + Localisation + ", Description=" + Description + ", Langues=" + Langues + ", Competences=" + Competences + ", Formation=" + Formation + ", Experiences_professionnelles=" + Experiences_professionnelles  + ", latitude=" + latitude + ", longitude=" + longitude + ", Diplome=" + Diplome + '}';
    }

   

   

    

}
