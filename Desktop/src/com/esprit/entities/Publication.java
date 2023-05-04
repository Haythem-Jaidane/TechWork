/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Publication {

    private int id_Pub;
    private String objet;
    private String message;
    private String id_cours;
    private int id_Profil;

    public Publication(int id_Pub) {
        this.id_Pub = id_Pub;
    }

    public Publication(String objet, String message, String id_cours, int id_Profil) {
        this.objet = objet;
        this.message = message;
        this.id_cours = id_cours;
        this.id_Profil = id_Profil;
    }

    public Publication(int id_Pub, String objet, String message, String id_cours, int id_Profil) {
        this.id_Pub = id_Pub;
        this.objet = objet;
        this.message = message;
        this.id_cours = id_cours;
        this.id_Profil = id_Profil;
    }

    public int getId_Pub() {
        return id_Pub;
    }

    public void setId_Pub(int id_Pub) {
        this.id_Pub = id_Pub;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId_cours() {
        return id_cours;
    }

    public void setId_cours(String id_cours) {
        this.id_cours = id_cours;
    }

    public int getId_Profil() {
        return id_Profil;
    }

    public void setId_Profil(int id_Profil) {
        this.id_Profil = id_Profil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_Pub;
        hash = 79 * hash + Objects.hashCode(this.objet);
        hash = 79 * hash + Objects.hashCode(this.message);
        hash = 79 * hash + Objects.hashCode(this.id_cours);
        hash = 79 * hash + this.id_Profil;
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
        final Publication other = (Publication) obj;
        if (this.id_Pub != other.id_Pub) {
            return false;
        }
        if (this.id_Profil != other.id_Profil) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.id_cours, other.id_cours);
    }

   

    @Override
    public String toString() {
        return "Publication{" + "id_Pub=" + id_Pub + ", objet=" + objet + ", message=" + message + ", id_cours=" + id_cours + ", id_Profil=" + id_Profil + '}';
    }

}
