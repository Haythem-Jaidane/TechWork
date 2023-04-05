<?php

namespace App\Controller;

use App\Entity\Profil;
use App\Form\ProfilType;
use App\Repository\ProfilRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/profil')]
class ProfilController extends AbstractController
{
    #[Route('/', name: 'app_profil_index', methods: ['GET'])]
    public function index(ProfilRepository $profilRepository): Response
    {
       
        return $this->render('profil/index.html.twig', [
            'profils' => $profilRepository->findAll(),
            'isConnected' => True,
        ]);
    }

    #[Route('/new', name: 'app_profil_new', methods: ['GET', 'POST'])]
    public function new(Request $request, ProfilRepository $profilRepository): Response
    {
        $profil = new Profil();

        $form = $this->createForm(ProfilType::class, $profil);
        $form->handleRequest($request);
    
        if ($form->isSubmitted() && $form->isValid()) {
          //  $profil->setNuméroTéléphone("55");
            $profilRepository->save($profil, true);

            return $this->redirectToRoute('app_profil_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('profil/new.html.twig', [
            'profil' => $profil,
            'form' => $form,
            'isConnected' => True,
        ]);
    }

    #[Route('/{profil}', name: 'app_profil_show', methods: ['GET'])]
    public function show(Profil $profil): Response
    {
        return $this->render('profil/show.html.twig', [
            'profil' => $profil,
             'isConnected' => True,
        ]);
    }

    #[Route('/{idProfil}/edit', name: 'app_profil_edit', methods: ['GET', 'POST'])]
    public function edit(Profil $idProfil,Request $request, ProfilRepository $profilRepository): Response
    {
        $form = $this->createForm(ProfilType::class, $idProfil);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $profilRepository->save($idProfil, true);

            return $this->redirectToRoute('app_profil_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('profil/edit.html.twig', [
            'profil' => $idProfil,
            'form' => $form,
            'isConnected' => True,
 
        ]);
    }

    #[Route('/{idProfil}', name: 'app_profil_delete', methods: ['POST'])]
    public function delete(Request $request, Profil $idProfil, ProfilRepository $profilRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$idProfil->getIdProfil(), $request->request->get('_token'))) {
            $profilRepository->remove($idProfil, true);
        }

        return $this->redirectToRoute('app_profil_index', [], Response::HTTP_SEE_OTHER);
    }
}
