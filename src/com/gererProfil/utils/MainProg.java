/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gererProfil.utils;

import com.gererProfil.entities.Profil;
import com.gererProfil.entities.Publication;
import com.gererProfil.services.ServiceProfil;
import com.gererProfil.services.ServicePublication;

/**
 *
 * @author ASUS
 */
public class MainProg {
     public static void main(String[] args) {
       ServiceProfil sp = new ServiceProfil();
       // System.out.println(sp.getProfilById(12));
        sp.ajouter(new Profil("manar","boukhris","99874256", "manar.boukhris@gmail.com","sousse","Personne dynamique,motivée","français/anglais/arabe","iot","licence en iot","tech","35.82468","10.63473","oui"));
      //sp.modifier(new Profil(25,"14", "daly.ghofrane@gmail.com","bizerte","Personne dynamique,motivée","français/anglais/arabe","java,web","licence en BI","telecom","oui",));
      //sp.supprimer(new Profil(19));
     // System.out.println(sp.afficher());
      ServicePublication sp1 = new ServicePublication();
     // sp1.ajouter(new Publication("gygh","bhbhh","7",8)); 
       //  System.out.println( sp1.getPublicationByname(37));
}
}
