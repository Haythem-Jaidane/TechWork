/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Publication {
    private int id_Pub;
    private String objet;
    private String message;
    private int id_Formation;
    private String image;
    private int id_Candidat;
   
    
    
    
    
    public Publication(int id_Pub) {
        this.id_Pub = id_Pub;
    }

    public Publication(String objet, String message) {
        this.objet = objet;
        this.message = message;
    }

    public Publication(int id_Pub, String objet, String message) {
        this.id_Pub = id_Pub;
        this.objet = objet;
        this.message = message;
    }

   

    public Publication(String objet, String message, int id_Formation, int id_Candidat) {
        this.objet = objet;
        this.message = message;
        this.id_Formation = id_Formation;
        this.id_Candidat = id_Candidat;
    }

    public Publication(int id_Pub, String objet, String message, int id_Formation, int id_Candidat) {
        this.id_Pub = id_Pub;
        this.objet = objet;
        this.message = message;
        this.id_Formation = id_Formation;
        this.id_Candidat = id_Candidat;
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

    public int getId_Formation() {
        return id_Formation;
    }

    public void setId_Formation(int id_Formation) {
        this.id_Formation = id_Formation;
    }

   
    public int getId_Candidat() {
        return id_Candidat;
    }

    public void setId_Candidat(int id_Candidat) {
        this.id_Candidat = id_Candidat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id_Pub;
        hash = 61 * hash + Objects.hashCode(this.objet);
        hash = 61 * hash + Objects.hashCode(this.message);
        hash = 61 * hash + this.id_Formation;
        hash = 61 * hash + this.id_Candidat;
       
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
        if (this.id_Formation != other.id_Formation) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        
        return Objects.equals(this.id_Candidat, other.id_Candidat);
    }

    @Override
    public String toString() {
        return "Publication{" + "id_Pub=" + id_Pub + ", objet=" + objet + ", message=" + message + ", id_Formation=" + id_Formation + ", id_Candidat=" + id_Candidat + '}';
    }

  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
