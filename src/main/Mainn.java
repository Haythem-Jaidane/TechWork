/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import entities.Offre;
import services.ServiceOffre;

/**
 *
 * @author BOURAOUI
 */
public class Mainn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
          
          
        ServiceOffre so = new ServiceOffre();
 
        so.ajouter(new Offre("Marketing Manager pour une société", "Strategie de marketing et creation d'une identité pour l'entreprise", "Head of Marketing", 1200, "Tunis", "CDD: Contrat à durée déterminée", 12, "Disponible","Marketing","Proxym","Proxym@gmail.com"));
        so.ajouter(new Offre("Data Analysis for a dashboard creation", "Analyser les données des clients", "Data Analyst", 2000, "Sousse", "CDI: Contrat de travail à durée indéterminée", 0, "Disponible","Data Analysis","Proxym","Proxym@gmail.com"));
        so.ajouter(new Offre("Web Application for a bank", "Créer une applciation mobile pour une banque", "Mobile Developer", 300, "Tunis", "CDD: Contrat à durée déterminée", 36, "Disponible","Developpement Web","Proxym","Proxym@gmail.com"));
        //so.modifier(new Offre(2, "titre", "description", "post", 1200, "lieu", "typeContrat", 2, "status","domaineOffre","nomRecruteur","emailRecruteur@test.com"));
     	//  so.supprimer(new Offre(3));
    }
    
}
