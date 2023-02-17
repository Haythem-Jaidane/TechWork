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
public class Profil {
    
    private int id;
    private int tel;
    private String email;
    private String localisation;
    private String description;
    private String langues;
    private String competences;
    private String formation;
    private String experiencesProfessionnelles;
    private boolean diplome;

    public Profil(int id) {
        this.id = id;
    }

    public Profil(int tel, String email, String localisation, String description, String langues, String competences, String formation, String experiencesProfessionnelles, boolean diplome) {
        this.tel = tel;
        this.email = email;
        this.localisation = localisation;
        this.description = description;
        this.langues = langues;
        this.competences = competences;
        this.formation = formation;
        this.experiencesProfessionnelles = experiencesProfessionnelles;
        this.diplome = diplome;
    }


    public Profil(int id, int tel, String email, String localisation, String description,
            String langues, String competences, String formation, String experiencesProfessionnelles, boolean diplome  ) {
        this.id = id;
        this.tel = tel;
        this.email = email;
        this.localisation = localisation;
        this.description = description;
        this.langues = langues;
        this.competences = competences;
        this.formation = formation;
        this.experiencesProfessionnelles = experiencesProfessionnelles;
        this.diplome=diplome;
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getExperiencesProfessionnelles() {
        return experiencesProfessionnelles;
    }

    public void setExperiencesProfessionnelles(String experiencesProfessionnelles) {
        this.experiencesProfessionnelles = experiencesProfessionnelles;
    }

    public boolean getDiplome() {
        return diplome;
    }

    public void setDiplome(boolean diplome) {
        this.diplome = diplome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.tel;
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.localisation);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.langues);
        hash = 17 * hash + Objects.hashCode(this.competences);
        hash = 17 * hash + Objects.hashCode(this.formation);
        hash = 17 * hash + Objects.hashCode(this.experiencesProfessionnelles);
        hash = 17 * hash + (this.diplome ? 1 : 0);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (this.diplome != other.diplome) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.localisation, other.localisation)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.langues, other.langues)) {
            return false;
        }
        if (!Objects.equals(this.competences, other.competences)) {
            return false;
        }
        if (!Objects.equals(this.formation, other.formation)) {
            return false;
        }
        return Objects.equals(this.experiencesProfessionnelles, other.experiencesProfessionnelles);
    }

   
    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", tel=" + tel + ", email=" + email + ", localisation=" + localisation + ", description=" + description + ", langues=" + langues + ", competences=" + competences + ", formation=" + formation + ", experiencesProfessionnelles=" + experiencesProfessionnelles + ", diplome=" + diplome + '}';
    }

}

