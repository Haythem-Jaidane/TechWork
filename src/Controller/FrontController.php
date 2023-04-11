<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\ProjectRepository;

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

    #[Route('/home/{section}', name: 'app_home_other', methods: ['GET'])]
    public function other($section,ProjectRepository $projectRepository): Response
    {

        return $this->render('FrontOffice/home.html.twig',[
            "section" => $section,'projets' => $projectRepository->findAll(),
            "isConnected" => true, 
        ]);
    } 


  

    
}