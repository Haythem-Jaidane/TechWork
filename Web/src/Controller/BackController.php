<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\ProjectRepository;
use App\Repository\ProfilRepository;
use App\Repository\OffreRepository;
use App\Repository\CandidatureRepository;
use App\Repository\UtilisateurRepository;
use App\Entity\Offre;
use App\Entity\Candidature;
use App\Entity\Domaine;
use App\Entity\Contrat;

class BackController extends AbstractController
{
    #[Route('/dashboard/portfolio', name: 'app_back_office_portfolio', methods: ['GET'])]
    public function backOffice(ProjectRepository $projectRepository): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "portfolio",'projets' => $projectRepository->findAll(),
        ]);
    }

    #[Route('/dashboard/profile', name: 'app_back_office_profile', methods: ['GET'])]
    public function backOffic(ProfilRepository $profilRepository,ProjectRepository $projectRepository): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "profile",'profils' => $profilRepository->findAll(),'projets ' => $projectRepository->findAll(),
            
        ]);
    }

    #[Route('/dashboard/utilisateur', name: 'app_back_office_utilisateur', methods: ['GET'])]
    public function backOfficeUser(ProfilRepository $profilRepository,UtilisateurRepository $userRepo): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "utilisateur",'utilisateurs' => $userRepo->findAll(),
            
        ]);
    }
/*
    #[Route('/profile_', name: 'app_back_office', methods: ['GET'])]
    public function backOfficee(ProfilRepository $profilRepository): Response
    {
        return $this->render('BackOffice/Components/portfolio.html.twig',[
             'profils' => $profilRepository->findAll(),
            
        ]);
    }*/



    #[Route('/dashboard/offre', name: 'app_back_office_offre')]
    public function backOffice_(ProfilRepository $profilRepository,ProjectRepository $projectRepository,OffreRepository $offreRepository,CandidatureRepository $candidatureRepository): Response
    {
        $em = $this->getDoctrine()->getManager();
        $countt = $em->getRepository(Offre::class)->createQueryBuilder('o')
            ->select('COUNT(o)')
            ->getQuery()
            ->getSingleScalarResult();
        
        
        $em = $this->getDoctrine()->getManager();
        $countt2 = $em->getRepository(Candidature::class)->createQueryBuilder('o')
            ->select('COUNT(o)')
            ->getQuery()
            ->getSingleScalarResult();

        $em = $this->getDoctrine()->getManager();
        $countt4 = $em->getRepository(Domaine::class)->createQueryBuilder('o')
            ->select('COUNT(o)')
            ->getQuery()
            ->getSingleScalarResult();


        $em = $this->getDoctrine()->getManager();
        $countt3 = $em->getRepository(Contrat::class)->createQueryBuilder('o')
            ->select('COUNT(o)')
            ->getQuery()
            ->getSingleScalarResult();

        // On va chercher toutes les catégories
        $offre = $offreRepository->findAll();
        //OFFRE par candidature
        $categColor  = [];
        $categNomOff = [];
        $categCountOff = [];
        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($offre as $off){
            $categNomOff[] = $off->getTitre();
            $categCountOff[] = count($off->getCandidatures());
 
        }


        // On va chercher le nombre de candidatures par date
        $bysmth = $candidatureRepository->countByDate();

        $dates = [];
        $candidaturesCount = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($bysmth as $can){
            $dates[] = $can['datePostulation'];
            $candidaturesCount[] = $can['count'];
        }


        // On va chercher le nombre d'offres par domaine
        $cby = $offreRepository->countByDomaine();

        $smth = [];
        $cbyCount = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($cby as $ind){
            $smth[] = $ind['cbysmth'];
            $cbyCount[] = $ind['count'];
        }


        // On va chercher le nombre d'offres par domaine
        $cby2 = $offreRepository->countByContrat();

        $smth2 = [];
        $cbyCount2 = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($cby2 as $ind2){
            $smth2[] = $ind2['cbysmth2'];
            $cbyCount2[] = $ind2['count'];
        }

/*
        $ales = $candidatureRepository->countByDate();

        $dates = [];
        $candidaturesCount = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($bysmth as $can){
            $dates[] = $can['dateAnnonces'];
            $candidaturesCount[] = $can['count'];
        }



*/
        // On va chercher toutes les catégories
        $offre = $offreRepository->findAll();
        //OFFRE par CONTRAT 
        $categNomOff3 = []; 
        $categCountOff3 = [];
        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($offre as $off3){
            $categNomOff3[] = $off3->getContrat()->getNom();
            $categCountOff3[] = count($off3->getCandidatures());
        }

        //CANDIDATURE
        /*
        $findall = $candidatureRepository->findAll();
        $categNomCan = [];
        $categColorCan = [];
        $categCountCan = [];
        
        foreach($findall as $j){
            $categNomCan[] = $j->getCandidat();
       //      $categCountCan[] = count($j->getCandidat());
            $categColorCan[] = "red";

        }*/





 

        return $this->render('BackOffice/back.html.twig', [
            "getsion" => "offre",

            'countt' => $countt,
            'countt2' => $countt2,
            'countt3' => $countt3,
            'countt4' => $countt4,

            'categColor' => json_encode($categColor),

            'categNomOff' => json_encode($categNomOff),
            'categCountOff' => json_encode($categCountOff),

            'dates' => json_encode($dates),
            'candidaturesCount' => json_encode($candidaturesCount),

            'smth' => json_encode($smth),
            'cbyCount' => json_encode($cbyCount),

            'smth2' => json_encode($smth2),
            'cbyCount2' => json_encode($cbyCount2),

        //    'categNomOff2' => json_encode($categNomOff2), 
          //  'categCountOff2' => json_encode($categCountOff2),

      /*      'categNomOff3' => json_encode($categNomOff3), 
            'categCountOff3' => json_encode($categCountOff3),*/
            "getsion" => "offre",
            'profils' => $profilRepository->findAll(),
            'projets ' => $projectRepository->findAll(),
           

        ]);
    }
    
    
    
    
    
    
    
    
    
    /*
    #[Route('/dashboard/{getsion}', name: 'app_back_office')]
    public function backOffice($getsion): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => $getsion,
        ]);
    } */



    /*
    #[Route('/dashboard/{getsion}', name: 'app_back_office', methods: ['GET'])]
    public function backOffice($getsion,OffreRepository $offreRepository): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => $getsion, 'offres' => $offreRepository->findAll(),
        ]);
    }
*/
    #[Route('/dashboard', name: 'app_back_office_index')]
    public function backOfficeindex(): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "",
        ]);
    }
    /*
#[Route('/admin/projets/{id}/noter', name: 'app_admin_noter_projet')]
public function noterProjet(Request $request, Project $project): Response
{
    // Vérifier que l'utilisateur a le rôle d'admin
    $this->denyAccessUnlessGranted('ROLE_ADMIN');

    // Récupérer les soumissions pour ce projet
    $submissions = $project->getSubmissions();

    // Créer un formulaire pour noter chaque soumission
    $formBuilder = $this->createFormBuilder();
    foreach ($submissions as $submission) {
        $formBuilder->add('note_'.$submission->getId(), IntegerType::class, [
            'label' => $submission->getCandidate()->getFullName(),
            'attr' => [
                'min' => 0,
                'max' => 20,
            ],
            'data' => $submission->getNote(),
            'required' => false,
        ]);
    }
    $form = $formBuilder->getForm();

    // Traiter le formulaire
    $form->handleRequest($request);
    if ($form->isSubmitted() && $form->isValid()) {
        $em = $this->getDoctrine()->getManager();
        foreach ($submissions as $submission) {
            $note = $form->get('note_'.$submission->getId())->getData();
            $submission->setNote($note);
            $em->persist($submission);
        }
        $em->flush();
        $this->addFlash('success', 'Les notes ont été enregistrées avec succès.');
        return $this->redirectToRoute('app_admin_dashboard');
    }

    // Afficher le formulaire de notation
    return $this->render('admin/projet/noter.html.twig', [
        'project' => $project,
        'form' => $form->createView(),
    ]);
}

    */



   
}
