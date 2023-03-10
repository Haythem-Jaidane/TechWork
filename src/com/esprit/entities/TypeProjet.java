/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author asus
 */
public class TypeProjet {
    private int idtypeprojet;
    private String nomtype;
    private String descriptiontype;
    private int id;

    public TypeProjet(int idtypeprojet, String nomtype, String descriptiontype, int id) {
        this.idtypeprojet = idtypeprojet;
        this.nomtype = nomtype;
        this.descriptiontype = descriptiontype;
        this.id = id;
    }
    

    public TypeProjet(int idtypeprojet) {
        this.idtypeprojet = idtypeprojet;
    }

    public TypeProjet(String nomtype, String descriptiontype, int id) {
        this.nomtype = nomtype;
        this.descriptiontype = descriptiontype;
        this.id = id;
    }

    public TypeProjet() {
    }

   

    public int getIdtypeprojet() {
        return idtypeprojet;
    }

    public void setIdtypeprojet(int idtypeprojet) {
        this.idtypeprojet = idtypeprojet;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public String getDescriptiontype() {
        return descriptiontype;
    }

    public void setDescriptiontype(String descriptiontype) {
        this.descriptiontype = descriptiontype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idtypeprojet;
        hash = 67 * hash + Objects.hashCode(this.nomtype);
        hash = 67 * hash + Objects.hashCode(this.descriptiontype);
        hash = 67 * hash + this.id;
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
        final TypeProjet other = (TypeProjet) obj;
        if (this.idtypeprojet != other.idtypeprojet) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomtype, other.nomtype)) {
            return false;
        }
        return Objects.equals(this.descriptiontype, other.descriptiontype);
    }

    @Override
    public String toString() {
        return "TypeProjet{" + "idtypeprojet=" + idtypeprojet + ", nomtype=" + nomtype + ", descriptiontype=" + descriptiontype + ", id=" + id + '}';
    }

    

   

   
    
}
