<?php

namespace App\Controller;

use Spatie\Dropbox\Client;
use App\Entity\Cours;
use App\Entity\Chapitre;
use App\Entity\Contenu;
use App\Entity\Utilisateur;
use App\Entity\Progres;
use App\Repository\CoursRepository;
use App\Form\CoursType;
use App\Form\ChapitreType;
use App\Form\ContenuType;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;



class FormationController extends AbstractController
{

    private bool $isConnected = true;
    private Utilisateur $CurrentUser;


    #[Route('/formation', name: 'app_formation')]
    public function index(): Response
    {
        return $this->render('formation/index.html.twig', [
            'controller_name' => 'FormationController',
        ]);
    }

    #[Route('/ajouterChapitre/{cour}',name:'app_formation_ajouter_Chapitre')]
    public function ajouter($cour,ManagerRegistry $doctrine,Request $request)
    {
            $chapitre_a_ajouté = new Chapitre();
            $repo_Cours = $doctrine->getRepository(Cours::class);
            $repo = $doctrine->getManager();
            $current_cour = $repo_Cours->findOneById($cour);
            $Chapitreform= $this->createForm(ChapitreType::class,$chapitre_a_ajouté);
            $Chapitreform->handleRequest($request);
            if($Chapitreform->isSubmitted()){
                if($Chapitreform->isValid()){
                    $chapitre_a_ajouté->setIdCours($current_cour);
                    $repo->persist($chapitre_a_ajouté);
                    $repo->flush();
                    return $this->redirectToRoute("app_formation_ajouter_Contenu" , [
                        "cour" =>  $current_cour->getId(),
                        "chapitre" => $chapitre_a_ajouté->getId()
                    ]);
                }
            }
            return $this->renderForm('FrontOffice/Components/ajouterCours.html.twig', [
                "isConnected" => $this->isConnected,
                "Cours" => $current_cour,
                "Chpitre_form" => $Chapitreform
            ]);
    }

    #[Route('/ajouterContenu/{cour}/{chapitre}',name:'app_formation_ajouter_Contenu')]
    public function ajouterContenu($cour,$chapitre,ManagerRegistry $doctrine,Request $request){
        $contenu_a_ajouté = new Contenu();
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo = $doctrine->getManager();
        $current_cour = $repo_Cours->findOneById($cour);
        $current_chapitre = $repo_Chapitre->findOneById($chapitre);
        $Contenuform= $this->createForm(ContenuType::class,$contenu_a_ajouté);
        $Contenuform->handleRequest($request);
        if($Contenuform->isSubmitted()){
            if($Contenuform->isValid()){

                $file = $Contenuform->get('lienContenu')->getData();
                $fileMimeType = $file->guessExtension();

                if($fileMimeType == "txt"){
                    $contenu_a_ajouté->setType("text");
                }
                if($fileMimeType == "mp4"){
                    $contenu_a_ajouté->setType("video");
                }

                
                $contenu_a_ajouté->setIdChapitre($current_chapitre);
                $repo->persist($contenu_a_ajouté);
                $repo->flush();
                return $this->redirectToRoute("app_formation_ajouter_Contenu" , [
                    "cour" =>  $current_cour->getId(),
                    "chapitre" => $current_chapitre->getId()
                ]);
            }
        }
        return $this->renderForm('FrontOffice/Components/ajouterContenu.html.twig', [
            "isConnected" => $this->isConnected,
            "Cour" =>  $current_cour,
            "Chapitre" => $current_chapitre,
            "Contenu_form" => $Contenuform
        ]);
    }

    #[Route('/modifierCours/{id}',name:'app_formation_modifier_Cours')]
    public function modifier($id,ManagerRegistry $doctrine,Request $req)
    {
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo_Utilisateur = $doctrine->getRepository(Utilisateur::class);
        $repo_Contenu = $doctrine->getRepository(Contenu::class);
        $cours = $repo_Cours->findOneById($id);
        $file = $req->files->get($cours->getImgUrl());
        $cours->setImgUrl($file);
        $chap = $repo_Chapitre->findByIdCours($id);
        $form=$this->createForm(CoursType::class,$cours);
        $form->handleRequest($req);
        $em=$doctrine->getManager();
        if($form->isSubmitted() && $form->isValid()){
            $cours->setDateDeLancement(new \DateTime('@'.strtotime('now')));
            $utilisateur = $repo_Utilisateur->findOneById(8);
            $cours->setIdTuteur($utilisateur);
            $em->persist($cours);
            $em->flush();
            
            return $this->redirectToRoute('app_formation_afficher_Mes_Cours');
        }
        return $this->renderForm('FrontOffice/Components/modifierCours.html.twig',[
            'Cours_form'=>$form,
            "isConnected" => $this->isConnected,
            "Chap" => $chap,
        ]);
    }

    #[Route('/afficherCours',name:'app_formation_afficher_Cours')]
    public function afficher(ManagerRegistry $doctrine)
    {
        
        $cour_a_ajouté = null;
        return $this->renderForm('FrontOffice/Components/affichageCours.html.twig', [
            'list_cours' => $cour_a_ajouté,
            "isConnected" => $this->isConnected
        ]);
        
        
    }

    #[Route('/afficherTousCours/{id_user}',name:'app_formation_afficher_Cours_Tout')]
    public function afficherTout($id_user,ManagerRegistry $doctrine)
    {
        $repo = $doctrine->getRepository(Cours::class);
        $repo_prog = $doctrine->getRepository(Progres::class);
        $cours = $repo->findByIdNoTuto($id_user);
        $prog = array();
        foreach ($cours as $i) {
            if($repo_prog->findByIdCours($i) == null){
                array_push($prog,0);
            }
            else{
                array_push($prog,$repo_prog->findByIdCours($i)->getProgresUtilisateur());
            }
            
        }
        return $this->render('FrontOffice/Components/affichageTousCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            "prog" => $prog,
        ]);
    }

    #[Route('/afficherCoursCommance',name:'app_formation_afficher_Cours_Commance')]
    public function afficherCommance(ManagerRegistry $doctrine)
    {
        $repo = $doctrine->getRepository(Cours::class);
        $cours = $repo->findAll();
        return $this->render('FrontOffice/Components/affichageCommanceCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
        ]);

        
    }

    #[Route('/afficherCoursTerminer',name:'app_formation_afficher_Cours_Terminer')]
    public function afficherTerminer(ManagerRegistry $doctrine)
    {
        $repo = $doctrine->getRepository(Cours::class);
        $cours = $repo->findAll();
        return $this->render('FrontOffice/Components/affichageTerminerCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
        ]);
    }

    #[Route('/afficherMesCours/{id_user}',name:'app_formation_afficher_Mes_Cours')]
    public function afficherMesCours($id_user,ManagerRegistry $doctrine,Request $req)
    {
        $dropbox = new Client("sl.Bc_uNcEyOHMcaGhKYjaSFzyhJXgQr7U4AqlsEnI-mj0P_XV-g36pwghwxFipa1bxmmjw51jqRfbZg1iWL-KmZR2oC11vyABA4jfBNA-SDo_xfTIonVmh0xamMfK6ispr1nNO5VE");
        $repo = $doctrine->getManager();
        $repo_Utilisateur = $doctrine->getRepository(Utilisateur::class);
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $cours = $repo_Cours->findByIdTuto($id_user);
        $cour_a_ajouté = new Cours();
        $cour_a_ajouté->setDuree(0);
        $form= $this->createForm(CoursType::class,$cour_a_ajouté);
        $form->handleRequest($req);
        if($form->isSubmitted()){
            if($form->isValid()){
                $file = $cour_a_ajouté->getId().".". $form["Img_url"]->getData()->getClientOriginalExtension();
                $form["Img_url"]->getData()->move(
                    $this->getParameter('file_directory'),
                    $file
                );
                $file_path = $this->getParameter('file_directory').'/'.$file;
                $cour_a_ajouté->setDateDeLancement(new \DateTime('@'.strtotime('now')));
                $cour_a_ajouté->setImgUrl("Teckwork/".$cour_a_ajouté->getId().'/'.$file);
                
                $utilisateur = $repo_Utilisateur->findOneById($id_user);
                $cour_a_ajouté->setIdTuteur($utilisateur);
                $dropbox->createFolder("Teckwork/".$cour_a_ajouté->getId());
                $dropbox->upload("Teckwork/".$cour_a_ajouté->getId().'/'.$file,
                                fopen($file_path,'r'));
                var_dump($dropbox->getTemporaryLink("Teckwork/".$cour_a_ajouté->getId().'/'.$file));
                $repo->persist($cour_a_ajouté);
                $repo->flush();
                return $this->redirectToRoute("app_formation_ajouter_Chapitre" , [
                    "cour" =>  $cour_a_ajouté->getId(),
                ]);
            }
            else{
                return $this->renderForm('FrontOffice/Components/affichageMesCours.html.twig', [
                    'list_cours' => $cours,
                    "isConnected" => $this->isConnected,
                    'Cours_form' => $form,
                    "isForm" => true,
                    "DropBox" => $dropbox,
                ]);
            }
        }
        return $this->renderForm('FrontOffice/Components/affichageMesCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            'Cours_form' => $form,
            "isForm" => false,
            "monCour" => $cour_a_ajouté,
            "DropBox" => $dropbox,
        ]);

    }


    
    #[Route('/supprimerCours/{id}',name:'app_formation_supprimer_Cours')]
    public function supprimer($id,ManagerRegistry $doctrine)
    {
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo_Contenu = $doctrine->getRepository(Contenu::class);
        $courSupp = $repo_Cours->findOneById($id);
        $Chapitre = $repo_Chapitre->findByIdCours($courSupp->getId());
        
        foreach($Chapitre as $c){
            $Contenu = $repo_Contenu->findbyIdChapitre($c->getId());
            foreach($Contenu as $co){
                $repo_Contenu->remove($co);
            }
            $repo_Chapitre->remove($c);
        }
        $repo_Cours->remove($courSupp,true);
        return $this->redirectToRoute('app_formation_afficher_Mes_Cours');
    }
}
