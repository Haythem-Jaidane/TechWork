<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\ProjectRepository;

class BackController extends AbstractController
{
    #[Route('/dashboard/{getsion}', name: 'app_back_office', methods: ['GET'])]
    public function backOffice($getsion,ProjectRepository $projectRepository): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => $getsion,'projets' => $projectRepository->findAll(),
        ]);
    }

    #[Route('/dashboard', name: 'app_back_office_index')]
    public function backOfficeindex(): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "",
        ]);
    }
   
}
