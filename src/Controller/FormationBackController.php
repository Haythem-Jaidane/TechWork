<?php

namespace App\Controller;

use App\Entity\Cours;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Doctrine\Persistence\ManagerRegistry;
use App\Repository\CoursRepository;

class FormationBackController extends AbstractController
{
    #[Route('/formation/back', name: 'app_formation_back')]
    public function index(): Response
    {
        return $this->render('formation_back/index.html.twig', [
            'controller_name' => 'FormationBackController',
        ]);
    }

    #[Route('/admin/afficherFormation', name: 'app_formation_back_afficher')]
    public function afficher(ManagerRegistry $doctrine): Response
    {
        $repo = $doctrine->getRepository(Cours::class);
        $cours = $repo->findAll();
        return $this->render('BackOffice/Components/afficherCours.html.twig', [
            'Cours' => $cours,
            'getsion' => "formation"
        ]);
    }

    #[Route('/admin/SupprimerFormation/{id}', name: 'app_formation_back_bannir')]
    public function bannir($id,CoursRepository $repo): Response
    {
        $courSupp = $repo->find($id);
        $repo->remove($courSupp,true);
        return $this->redirectToRoute('app_formation_back_afficher');
    }
}
