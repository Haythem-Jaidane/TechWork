<?php

namespace App\Controller;

use App\Entity\Typeprojet;
use App\Form\TypeprojetType;
use App\Repository\TypeprojetRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/typeprojet')]
class TypeprojetController extends AbstractController
{ #[Route('/typeprojet/affich2', name: 'app_typeprojet_index2', methods: ['GET'])]
    public function index2(TypeprojetRepository $typeprojetRepository): Response
    {
        return $this->render('typeprojet/index2.html.twig', [
            'typeprojets' => $typeprojetRepository->findAll(),
            'isConnected'=>True,
        ]);
    }
    #[Route('/', name: 'app_typeprojet_index', methods: ['GET'])]
    public function index(TypeprojetRepository $typeprojetRepository): Response
    {
        return $this->render('typeprojet/index.html.twig', [
            'typeprojets' => $typeprojetRepository->findAll(),
            'isConnected'=>True,
        ]);
    }
/*
    #[Route('/new', name: 'app_typeprojet_new', methods: ['GET', 'POST'])]
    public function new(Request $request, TypeprojetRepository $typeprojetRepository): Response
    {
        $typeprojet = new Typeprojet();
        $form = $this->createForm(TypeprojetType::class, $typeprojet);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $typeprojetRepository->save($typeprojet, true);

            return $this->redirectToRoute('app_typeprojet_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('typeprojet/new.html.twig', [
            'typeprojet' => $typeprojet,
            'form' => $form,
        ]);
    }
*/
#[Route('/new', name: 'app_typeprojet_new',  methods: ['GET', 'POST'])]
public function new(Request $req,TypeprojetRepository $typeprojetRepository): Response
    {
        $typeprojet = new Typeprojet();
        $form = $this->createForm(TypeprojetType::class, $typeprojet);
        $form->handleRequest($req);
    //$entitymanager=$doctrine->getManager();
    if($form->isSubmitted()&& $form->isValid()){
       // $entitymanager->persist($typeprojet);
       // $entitymanager->flush();
       $typeprojetRepository->save($typeprojet,true);
        return $this->redirectToRoute('app_typeprojet_index' , [] ,  Response::HTTP_SEE_OTHER);
    }
    return $this->renderForm('typeprojet/new.html.twig', [
        'typeprojet'=>$typeprojet,

        'form' => $form,
        'isConnected'=>True,
    ]);
    

}
    #[Route('/{idtypeprojet}', name: 'app_typeprojet_show', methods: ['GET'])]
    public function show(Typeprojet $typeprojet): Response
    {
        return $this->render('typeprojet/show.html.twig', [
            'typeprojet' => $typeprojet,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{idtypeprojet}/edit', name: 'app_typeprojet_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Typeprojet $typeprojet, TypeprojetRepository $typeprojetRepository): Response
    {
        $form = $this->createForm(TypeprojetType::class, $typeprojet);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $typeprojetRepository->save($typeprojet, true);

            return $this->redirectToRoute('app_typeprojet_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('typeprojet/edit.html.twig', [
            'typeprojet' => $typeprojet,
            'form' => $form,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{idtypeprojet}', name: 'app_typeprojet_delete', methods: ['POST'])]
    public function delete(Request $request, Typeprojet $typeprojet, TypeprojetRepository $typeprojetRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$typeprojet->getIdtypeprojet(), $request->request->get('_token'))) {
            $typeprojetRepository->remove($typeprojet, true);
        }

        return $this->redirectToRoute('app_typeprojet_index', [], Response::HTTP_SEE_OTHER);
    }
}