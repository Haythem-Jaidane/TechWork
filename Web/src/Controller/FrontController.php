<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Profil;
use App\Entity\Utilisateur;
use App\Form\ProfilType;
use App\Repository\ProfilRepository;
use App\Repository\ProjectRepository;
use App\Repository\UtilisateurRepository;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\Offre;
use App\Form\OffreType; 
use App\Repository\OffreRepository;
use App\Repository\CandidatureRepository;
use App\Repository\ContratRepository;
use App\Repository\DomaineRepository;
use Symfony\Component\Security\Core\Security;


class FrontController extends AbstractController
{

    private bool $connection;
    private $security;
    private Utilisateur $CurrentUser;

    public function __construct(Security $security,UtilisateurRepository $UtilisateurManager)
    {
        $this->security = $security;
        $user = $this->security->getUser();

        if ($user) {
            $this->connection = true;
            $this->CurrentUser = $UtilisateurManager->findOneById($user->getId());
        } else {
            $this->connection = false;
        }
    }

    #[Route('/', name: 'app_home')]
    public function index(): Response
    {
       

        $section = '';

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => $this->connection, 
        ]);
    }

    /*#[Route('/home/{section}', name: 'app_home_other')]
    public function other($section): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }*/

    #[Route('/home', name: 'app_home_connected')]
    public function session($section = 'default-section')
    {
        return $this->redirectToRoute("app_formation_token_Cours");
    }

    #[Route('/home_user', name: 'app_home_connected_user')]
    public function user_home($section = 'default-section')
    {
        return $this->render('FrontOffice/Components/homeNewSession.html.twig', [
            "section" => $section,
            "isConnected" => $this->connection,
        ]);
    }
 
 
    #[Route('/home/offre_', name: 'app_home_off', methods: ['GET'])]
    public function off(OffreRepository $o,CandidatureRepository $c,CandidatureRepository $cp,CandidatureRepository $cr,CandidatureRepository $ca): Response
    {
        return $this->render('FrontOffice/Components/offreRedirect.html.twig');
    } 


/*
    #[Route('/home_offre_', name: 'app_home_off', methods: ['GET'])]
    public function off(OffreRepository $o,CandidatureRepository $c,CandidatureRepository $cp,CandidatureRepository $cr,CandidatureRepository $ca): Response
    {
       // OffreRepository $o;
      //  $o = new OffreRepository; 
        $offres= $o->findAll();
        $candidatures= $c->findAll();
        $candidaturesPending=$cp->findByStatus('Pending'); 
        $candidaturesAccepted=$ca->findByStatus('Acceptée'); 
        $candidaturesRejected=$cr->findByStatus('Rejetée'); 
        return $this->render('FrontOffice/Components/offreView.html.twig',[
       
            "isConnected" => true,                              
            'offres' => $o->findAll(),
            'candidatures' => $c->findAll(),
            'candidaturesPending' =>$cp->findByStatus('Pending'),
            'candidaturesAccepted' =>$ca->findByStatus('Acceptée'),
            'candidaturesRejected' =>$cr->findByStatus('Rejectée'),
        ]);

    }*/
    #[Route('/home/{section}', name: 'app_home_other', methods: ['GET'])]
    public function other($section,ProjectRepository $projectRepository,OffreRepository $o,CandidatureRepository $c,CandidatureRepository $cp,CandidatureRepository $cr,CandidatureRepository $ca,ContratRepository $con,DomaineRepository $dom): Response
    {
       // OffreRepository $o;
      //  $o = new OffreRepository; 
        $offres= $o->findAll();
        $candidatures= $c->findAll();
        $contrats= $con->findAll();
        $domaines= $dom->findAll();
        $candidaturesPending=$cp->findByStatus('Pending',$this->CurrentUser); 
        $candidaturesAccepted=$ca->findByStatus('Acceptée',$this->CurrentUser); 
        $candidaturesRejected=$cr->findByStatus('Rejetée',$this->CurrentUser);
        //var_dump($o->getOfferToPostule()[0]->getTitre());
        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true,                              
            'offres' => $o->findAll(),
            'mesOffres' => $o->findByrecruteur($this->CurrentUser),
            'contrats' => $con->findAll(),
            'domaines' => $dom->findAll(),
            'candidatures' => $c->findAll(),
            //'candidaturesAPostuler' => $c->findBy(),
            'candidaturesPending' =>$cp->findByStatus('Pending',$this->CurrentUser),
            'candidaturesAccepted' =>$ca->findByStatus('Acceptée',$this->CurrentUser),
            'candidaturesRejected' =>$cr->findByStatus('Rejetée',$this->CurrentUser),
            "section" => $section,'projets' => $projectRepository->findAll(),
            "isConnected" => $this->connection,
            "user" => $this->CurrentUser,
        ]);
    }


    
    #[Route('/home/{profil}/profil_', name: 'app_home_offf', methods: ['GET'])]
    public function off_(Profil $profil,Request $request, ProfilRepository $profilRepository): Response
    {
        return $this->render('FrontOffice/Components/ProfilRedirect.html.twig', [
            'profile' => $profil,
 
        ]);
    }
    

    /*
    #[Route('/home/{section}', name: 'app_home_other')]
    public function other_($section,ProjectRepository $projectRepository): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,'projets' => $projectRepository->findAll(),
            "isConnected" => true, 
        ]);
    } */


  

    


    /*
    #[Route('/home/offre', name: 'app_offre_index', methods: ['GET'])]
    public function show(OffreRepository $offreRepository): Response
    {
        return $this->render('FrontOffice/home.html.twig', [
            'offres' => $offreRepository->findAll(),
        ]);
    }*/

    
}