<?php

namespace App\Controller;
use App\Form\SearchProjetType;
use App\Entity\Projet;
use App\Form\ProjetType;
use App\Repository\ProjectRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/projet')]
class ProjetController extends AbstractController
{
    
    #[Route('/', name: 'app_projet_index', methods: ['GET'])]
    public function index(ProjectRepository $projectRepository): Response
    {
        return $this->render('projet/index.html.twig', [
            'projets' => $projectRepository->findAll(),
            "isConnected" => true, 
        ]);
    }
   
    #[Route('/search', name: 'app_projet_search', methods: ['GET', 'POST'])]
    public function search(Request $req): Response
    {
        $form= $this->createForm(SearchProjetType::class );
        $form->handleRequest($req);
        $projets=[];
        if($form->isSubmitted()){
            $nom = $form->getData()['nom'];
           // $projets = $projectRepository->findByName($form->getData('search'));
           $entityManager = $this->getDoctrine()->getManager();
           $projectRepository = $entityManager->getRepository(Project::class);
           $projets = $projectRepository->findByName([
            'name'=> $nom,
        ]);
        return $this->render('projet/search.html.twig', [
            
            'form'=>$form->createView(),
            'projets'=>$projets,
            ]);
        }
        return $this->render('projet/search.html.twig', [
            
            'form'=>$form->createView(),
            'projets'=>$projets,
            ]);
       
    }


    #[Route('/new', name: 'app_projet_new', methods: ['GET', 'POST'])]
    public function new(Request $request, ProjectRepository $projectRepository): Response
    {
        $projet = new Projet();
        $form = $this->createForm(ProjetType::class, $projet);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $projectRepository->save($projet, true);

            return $this->redirectToRoute('app_projet_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('projet/new.html.twig', [
            'projet' => $projet,
            'form' => $form,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{id}', name: 'app_projet_show', methods: ['GET'])]
    public function show(Projet $projet): Response
    {
        return $this->render('projet/show.html.twig', [
            'projet' => $projet,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_projet_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Projet $projet, ProjectRepository $projectRepository): Response
    {
        $form = $this->createForm(ProjetType::class, $projet);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $projectRepository->save($projet, true);

            return $this->redirectToRoute('app_projet_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('projet/edit.html.twig', [
            'projet' => $projet,
            'form' => $form,
            'isConnected'=>True,
        ]);
    }

    #[Route('/{id}', name: 'app_projet_delete', methods: ['POST'])]
    public function delete(Request $request, Projet $projet, ProjectRepository $projectRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$projet->getId(), $request->request->get('_token'))) {
            $projectRepository->remove($projet, true);
        }

        return $this->redirectToRoute('app_projet_index', [], Response::HTTP_SEE_OTHER);
    }
}
