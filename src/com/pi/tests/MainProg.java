/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.tests;

import com.pi.entities.Profil;
import com.pi.entities.Publication;
import com.pi.services.ServiceProfil;
import com.pi.services.ServicePublication;


/**
 *
 * @author ASUS
 */
public class MainProg {
     public static void main(String[] args) {
        ServiceProfil sp = new ServiceProfil();
       // System.out.println(sp.getProfilById(12));
        //sp.ajouter(new Profil("21398220", "daly.ghofrane@gmail.com","tunis","Personne dynamique,motivée","français/anglais/arabe","java,web","licence en BI","telecom","oui"));
      //sp.modifier(new Profil(25,"14", "daly.ghofrane@gmail.com","bizerte","Personne dynamique,motivée","français/anglais/arabe","java,web","licence en BI","telecom","oui"));
      //sp.supprimer(new Profil(19));
     // System.out.println(sp.afficher());
      ServicePublication sp1 = new ServicePublication();
      sp1.ajouter(new Publication("gygh","bhbhh",5,6)); 
}

}