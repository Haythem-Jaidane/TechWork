<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\ProfilRepository;

class BackController extends AbstractController
{
    #[Route('/dashboard/{getsion}', name: 'app_back_office', methods: ['GET'])]
    public function backOffice($getsion,ProfilRepository $profilRepository): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => $getsion,'profils' => $profilRepository->findAll(),
            
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

    #[Route('/dashboard', name: 'app_back_office_index')]
    public function backOfficeindex(): Response
    {
        return $this->render('BackOffice/back.html.twig',[
            "getsion" => "",
        ]);
    }
}
