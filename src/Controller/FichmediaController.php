<?php

namespace App\Controller;

use App\Entity\Fichmedia;
use App\Form\FichmediaType;
use App\Repository\FichmediaRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
/*Use Symfony instead;
Use symfony/mailer instead;
Use symfony/mailer instead;*/
#[Route('/fichmedia')]
class FichmediaController extends AbstractController
{
    #[Route('/', name: 'app_fichmedia_index', methods: ['GET'])]
    public function index(FichmediaRepository $fichmediaRepository): Response
    {
        return $this->render('fichmedia/index.html.twig', [
            'fichmedia' => $fichmediaRepository->findAll(),
            'isConnected'=>True,
        ]);
    }
    
    #[Route('/fichmedia/affich2', name: 'app_fichmedia_index2', methods: ['GET'])]
    public function index2(FichmediaRepository $fichmediaRepository): Response
    {
        return $this->render('fichmedia/index2.html.twig', [
            'fichmedia' => $fichmediaRepository->findAll(),
            'isConnected'=>True,
        ]);
    }

    #[Route('/new', name: 'app_fichmedia_new', methods: ['GET', 'POST'])]
    public function new(Request $request, FichmediaRepository $fichmediaRepository): Response
    {
        $fichmedia = new Fichmedia();
        $form = $this->createForm(FichmediaType::class, $fichmedia);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $fichmediaRepository->save($fichmedia, true);

            return $this->redirectToRoute('app_fichmedia_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('fichmedia/new.html.twig', [
            'fichmedia' => $fichmedia,
            'form' => $form,
            'isConnected'=>True,

        ]);
    }

    #[Route('/{idmedia}', name: 'app_fichmedia_show', methods: ['GET'])]
    public function show(Fichmedia $fichmedia): Response
    {
        return $this->render('fichmedia/show.html.twig', [
            'fichmedia' => $fichmedia,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{idmedia}/edit', name: 'app_fichmedia_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Fichmedia $fichmedia, FichmediaRepository $fichmediaRepository): Response
    {
        $form = $this->createForm(FichmediaType::class, $fichmedia);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $fichmediaRepository->save($fichmedia, true);

            return $this->redirectToRoute('app_fichmedia_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('fichmedia/edit.html.twig', [
            'fichmedia' => $fichmedia,
            'form' => $form,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{idmedia}', name: 'app_fichmedia_delete', methods: ['POST'])]
    public function delete(Request $request, Fichmedia $fichmedia, FichmediaRepository $fichmediaRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$fichmedia->getIdmedia(), $request->request->get('_token'))) {
            $fichmediaRepository->remove($fichmedia, true);
        }

        return $this->redirectToRoute('app_fichmedia_index', [], Response::HTTP_SEE_OTHER);
    }
}
