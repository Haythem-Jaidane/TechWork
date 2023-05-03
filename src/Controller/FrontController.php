<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Profil;
use App\Form\ProfilType;
use App\Repository\ProfilRepository;
use Symfony\Component\HttpFoundation\Request; 

class FrontController extends AbstractController
{

    #[Route('/', name: 'app_home')]
    public function index(): Response
    {

        $section = '';

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }

    #[Route('/dashboard/{getsion}', name: 'app_back_office')]
    public function backOffice($getsion): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => $getsion,
        ]);
    }

    #[Route('/dashboard', name: 'app_back_office_index')]
    public function backOfficeindex(): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "",
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
    public function other($section): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }
}