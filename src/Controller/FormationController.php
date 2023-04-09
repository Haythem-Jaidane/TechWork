<?php

namespace App\Controller;

use App\Entity\Cours;
use App\Repository\CoursRepository;
use App\Form\CoursType;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


class FormationController extends AbstractController
{
    #[Route('/formation', name: 'app_formation')]
    public function index(): Response
    {
        return $this->render('formation/index.html.twig', [
            'controller_name' => 'FormationController',
        ]);
    }

    #[Route('/ajouterCours',name:'app_formation_ajouter_Cours')]
    public function ajouter(ManagerRegistry $doctrine)
    {
        
    }

    #[Route('/modifierCours',name:'app_formation_modifier_Cours')]
    public function modifier(ManagerRegistry $doctrine)
    {
        
    }

    #[Route('/afficherCours',name:'app_formation_afficher_Cours')]
    public function afficher(ManagerRegistry $doctrine)
    {
        $repo = $doctrine->getRepository(Cours::class);
        $cours = $repo->findAll();
        $cour_a_ajouté = new Cours();
        $form= $this->createForm(CoursType::class,$cour_a_ajouté);
        return $this->renderForm('FrontOffice/Components/affichageCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => true,
            'Cours_form' => $form
        ]);
    }
    
    #[Route('/supprimerCours/{id}',name:'app_formation_supprimer_Cours')]
    public function supprimer($id,CoursRepository $repo)
    {
        $courSupp = $repo->find($id);
        $repo->remove($courSupp,true);
        return $this->redirectToRoute('app_formation_afficher_Cours');
    }
}
