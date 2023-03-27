<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class homeController extends AbstractController
{

    #[Route('/', name: 'app_home')]
    public function index(): Response
    {

        $section = '';

        return $this->render('home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }

    #[Route('/{section}', name: 'app_home_other')]
    public function other($section): Response
    {

        return $this->render('home.html.twig',[
            "section" => $section,
            "isConnected" => true, 
        ]);
    }

    #[Route('/dashboard/admin', name: 'app_back_office')]
    public function backOffice(): Response
    {
        return $this->render('back.html.twig');
    }
}