<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

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

    #[Route('/home/{section}', name: 'app_home_other')]
    public function other($section): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }
  

    #[Route('/home', name: 'app_home_connected')]
    public function session($section = 'default-section'): Response
    {
        return $this->render('FrontOffice/Components/homeNewSession.html.twig', [
            "section" => $section,
            "isConnected" => true, 
        ]);
    }
}