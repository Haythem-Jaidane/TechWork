<?php

namespace App\Controller;

use App\Entity\Publication;
use App\Form\PublicationType;
use App\Repository\PublicationRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Endroid\QrCode\QrCode;
use Knp\Component\Pager\PaginatorInterface;
use Doctrine\ORM\EntityManagerInterface;

//#[Route('/publication')]
class PublicationController extends AbstractController
{
    #[Route('/publication/{id_Profil}', name: 'app_publication_index', methods: ['GET'])]
    public function index($id_Profil,Request $request,PublicationRepository $publicationRepository,PaginatorInterface $paginator,EntityManagerInterface $entityManager): Response
    {
        $qrCode = new QrCode('https://www.example.com');
        $publications = $entityManager->getRepository(Publication::class)->findByIdProfil($id_Profil);
            $publications = $paginator->paginate(
                $publications,
                $request->query->getInt(key:'page',default:1),
                limit:3
            );
        return $this->render('FrontOffice/Components/profileView.html.twig', [
            'publications' => $publications,

            'isConnected' => True, 'qrCode' => $qrCode,

        ]);
    }

    #[Route('/publicaation/new', name: 'app_publication_new', methods: ['GET', 'POST'])]
    public function new(Request $request, PublicationRepository $publicationRepository): Response
    {
        $publication = new Publication();
        $form = $this->createForm(PublicationType::class, $publication);
        $form->handleRequest($request);

        
        if ($form->isSubmitted() && $form->isValid()) {
            
            $publicationRepository->save($publication, true);
          //  $publicationRepository->sms();

            return $this->redirectToRoute('app_publication_index', ['id_Profil' => $publication->getIdProfil()->getIdProfil()], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('publication/new.html.twig', [
            'publication' => $publication,
            'form' => $form,
            'isConnected' => True,
           
        ]);
    }

    #[Route('/publication/show/{id}', name: 'app_publication_show', methods: ['GET'])]
    public function show(Publication $publication): Response
    {
        return $this->render('publication/show.html.twig', [
            'publication' => $publication,
            'isConnected' => True,
        ]);
    }

    #[Route('/publication/{id}/edit', name: 'app_publication_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Publication $publication, PublicationRepository $publicationRepository): Response
    {
        $form = $this->createForm(PublicationType::class, $publication);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $publicationRepository->save($publication, true);

            return $this->redirectToRoute('app_publication_index', ['id_Profil' => $publication->getIdProfil()->getIdProfil()], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('publication/edit.html.twig', [
            'publication' => $publication,
            'profil'=> $publication->getIdProfil()->getIdProfil(),
            'form' => $form,
            'isConnected' => True,
        ]);
    }

    #[Route('/publication/{id}', name: 'app_publication_delete', methods: ['POST'])]
    public function delete(Request $request, Publication $publication, PublicationRepository $publicationRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$publication->getIdPub(), $request->request->get('_token'))) {
            $publicationRepository->remove($publication, true);
        }

        return $this->redirectToRoute('app_publication_index', ['id_Profil' => $publication->getIdProfil()->getIdProfil()], Response::HTTP_SEE_OTHER);
    }
}
