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
public class FichMedia {
    private int idmedia;
    private String nommedia;
    private String urlmedia;
    private String typemedia ;
    private int id;

    public FichMedia(int idmedia, String nommedia, String urlmedia, String typemedia, int id) {
        this.idmedia = idmedia;
        this.nommedia = nommedia;
        this.urlmedia = urlmedia;
        this.typemedia = typemedia;
        this.id = id;
    }

    public FichMedia(String nommedia, String urlmedia, String typemedia) {
        this.nommedia = nommedia;
        this.urlmedia = urlmedia;
        this.typemedia = typemedia;
    }

    public FichMedia(int idmedia) {
        this.idmedia = idmedia;
    }

    public FichMedia(String nommedia, String urlmedia, String typemedia, int id) {
        this.nommedia = nommedia;
        this.urlmedia = urlmedia;
        this.typemedia = typemedia;
        this.id = id;
    }

    public int getIdmedia() {
        return idmedia;
    }

    public void setIdmedia(int idmedia) {
        this.idmedia = idmedia;
    }

    public String getNommedia() {
        return nommedia;
    }

    public void setNommedia(String nommedia) {
        this.nommedia = nommedia;
    }

    public String getUrlmedia() {
        return urlmedia;
    }

    public void setUrlmedia(String urlmedia) {
        this.urlmedia = urlmedia;
    }

    public String getTypemedia() {
        return typemedia;
    }

    public void setTypemedia(String typemedia) {
        this.typemedia = typemedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idmedia;
        hash = 23 * hash + Objects.hashCode(this.nommedia);
        hash = 23 * hash + Objects.hashCode(this.urlmedia);
        hash = 23 * hash + Objects.hashCode(this.typemedia);
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final FichMedia other = (FichMedia) obj;
        if (this.idmedia != other.idmedia) {
            return false;
        }
        if (!Objects.equals(this.nommedia, other.nommedia)) {
            return false;
        }
        if (!Objects.equals(this.urlmedia, other.urlmedia)) {
            return false;
        }
        if (!Objects.equals(this.typemedia, other.typemedia)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "FichMedia{" + "idmedia=" + idmedia + ", nommedia=" + nommedia + ", urlmedia=" + urlmedia + ", typemedia=" + typemedia + ", id=" + id + '}';
    }
    
   
}
