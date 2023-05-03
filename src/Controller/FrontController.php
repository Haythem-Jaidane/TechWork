<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Profil;
use App\Form\ProfilType;
use App\Repository\ProfilRepository;
use App\Repository\ProjectRepository;
use Symfony\Component\HttpFoundation\Request; 

class FrontController extends AbstractController
{

    #[Route('/', name: 'app_home')]
    public function index(): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => "",
            "isConnected" => true, 
        ]);
    }

    #[Route('/home/{section}', name: 'app_home_other')]
    public function other($section): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }

    #[Route('/home', name: 'app_home_connected')]
    public function session($section = 'default-section')
    {
        return $this->redirectToRoute("app_formation_token_Cours");
        /*return $this->render('FrontOffice/Components/homeNewSession.html.twig', [
            "section" => $section,
            "isConnected" => true, 
        ]);*/
    }

    #[Route('/home_user', name: 'app_home_connected_user')]
    public function user_home($section = 'default-section')
    {
        return $this->render('FrontOffice/Components/homeNewSession.html.twig', [
            "section" => $section,
            "isConnected" => true, 
        ]);
    }


    
    #[Route('/home/{profil}/profil_', name: 'app_home_off', methods: ['GET'])]
    public function off(Profil $profil,Request $request, ProfilRepository $profilRepository): Response
    {
        return $this->render('FrontOffice/Components/ProfilRedirect.html.twig', [
            'profile' => $profil,
 
        ]);
    }
    

    
    #[Route('/home/{section}', name: 'app_home_other')]
    public function other_($section,ProjectRepository $projectRepository): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,'projets' => $projectRepository->findAll(),
            "isConnected" => true, 
        ]);
    } 


  

    
}