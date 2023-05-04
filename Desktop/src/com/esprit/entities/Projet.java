/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author abdel
 */
public class Projet {

    
    
    private int id;
    private String nom;
    private String description;
    private String domaine;
   // private int idtypeprojet ;

    public Projet(int id) {
        this.id = id;
    }

    public Projet(String nom, String description, String domaine) {
        this.nom = nom;
        this.description = description;
        this.domaine = domaine;
    }

    public Projet(int id, String nom, String description, String domaine) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.domaine = domaine;
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDecription(String description) {
        this.description = description;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

   

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.nom);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + Objects.hashCode(this.domaine);
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
        final Projet other = (Projet) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.domaine, other.domaine);
    }


   /* @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", domaine=" + domaine + '}';
    }
*/

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", domaine=" + domaine + '}';
    }
  

    
}
