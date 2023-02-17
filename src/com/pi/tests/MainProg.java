/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.tests;

import com.pi.entities.Profil;
import com.pi.services.ServiceProfil;
import com.pi.entities.Historique;
import com.pi.services.ServiceHistorique;

/**
 *
 * @author ASUS
 */
public class MainProg {
     public static void main(String[] args) {
        ServiceProfil sp = new ServiceProfil();
        //sp.ajouter(new Profil(54398225, "daly.ghofrane@gmail.com","bizerte","Personne dynamique,motivée","français/anglais/arabe","java,web","licence en BI","telecom",false));
        //sp.modifier(new Profil(4,25398225, "daly.ghofrane@gmail.com","tunis","Personne dynamique,motivée","français/anglais/arabe","java,web","licence en BI","telecom",true));
        ServiceHistorique sp1 = new ServiceHistorique();
        sp1.ajouter(new Historique(14,5,6,true));
}

}