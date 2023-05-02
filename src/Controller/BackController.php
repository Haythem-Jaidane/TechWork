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
    /*
#[Route('/admin/projets/{id}/noter', name: 'app_admin_noter_projet')]
public function noterProjet(Request $request, Project $project): Response
{
    // Vérifier que l'utilisateur a le rôle d'admin
    $this->denyAccessUnlessGranted('ROLE_ADMIN');

    // Récupérer les soumissions pour ce projet
    $submissions = $project->getSubmissions();

    // Créer un formulaire pour noter chaque soumission
    $formBuilder = $this->createFormBuilder();
    foreach ($submissions as $submission) {
        $formBuilder->add('note_'.$submission->getId(), IntegerType::class, [
            'label' => $submission->getCandidate()->getFullName(),
            'attr' => [
                'min' => 0,
                'max' => 20,
            ],
            'data' => $submission->getNote(),
            'required' => false,
        ]);
    }
    $form = $formBuilder->getForm();

    // Traiter le formulaire
    $form->handleRequest($request);
    if ($form->isSubmitted() && $form->isValid()) {
        $em = $this->getDoctrine()->getManager();
        foreach ($submissions as $submission) {
            $note = $form->get('note_'.$submission->getId())->getData();
            $submission->setNote($note);
            $em->persist($submission);
        }
        $em->flush();
        $this->addFlash('success', 'Les notes ont été enregistrées avec succès.');
        return $this->redirectToRoute('app_admin_dashboard');
    }

    // Afficher le formulaire de notation
    return $this->render('admin/projet/noter.html.twig', [
        'project' => $project,
        'form' => $form->createView(),
    ]);
}

    */



   
}
