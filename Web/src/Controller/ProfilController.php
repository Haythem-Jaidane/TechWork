<?php

namespace App\Controller;

use App\Entity\Profil;
use App\Entity\Utilisateur;
use App\Form\ProfilType;
use App\Repository\ProfilRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Twig\Extension\StringLoaderExtension ;
use Dompdf\Dompdf;
use Dompdf\Options;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Security\Core\Security;


#[Route('/profil')]
class ProfilController extends AbstractController
{
    private bool $isConnected;
    private Profil $CurrentUser;
    private $security;

    public function __construct(Security $security,ProfilRepository $ProfilManager)
    {
        $this->security = $security;
        $user = $this->security->getUser();

        if ($user) {
            $this->isConnected = true;
            $this->CurrentUser = $ProfilManager->findOneById($user->getId());
        } else {
            $this->isConnected = false;
        }
    }

    #[Route('/', name: 'app_profil_index', methods: ['GET'])]
    public function index(ProfilRepository $profilRepository): Response
    {
 

        return $this->render('profil/index.html.twig', [
            'profils' => $profilRepository->findAll(),
            'isConnected' => $this->isConnected,
        ]);
    }
    #[Route('/pdf', name: 'PDF_profil', methods: ['GET'])]
    public function pdf(EntityManagerInterface $entityManager)
    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Open Sans');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);

        // Retrieve the HTML generated in our twig file
        $profil = $entityManager->getRepository(Profil::class)->find($this->CurrentUser);
        $html = $this->renderView('profil/pdf.html.twig', [
            'profil' => $profil,
        ]);

        // Add header HTML to $html variable
        $headerHtml = '<h1 style="text-align: center; color: #b0f2b6;">Bienvenue chez techwork </h1>';
        $html = $headerHtml . $html;

        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (inline view)
        // Send the PDF to the browser
        $response = new Response($dompdf->output(), 200, [
            'Content-Type' => 'application/pdf',
            'Content-Disposition' => 'attachment; filename="profil.pdf"',
        ]);

        return $response;
    }
    #[Route('/dashboard_show_profile', name: 'app_profil_indexe', methods: ['GET'])]
    public function indexx(ProfilRepository $profilRepository): Response
    {
       
        return $this->render('profil/profileViewBack.html.twig', [
            'profils' => $profilRepository->findAll(),
            'isConnected' => $this->isConnected,
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
            return $this->redirectToRoute('app_home_offf', ['profil' => $profil->getIdProfil()], Response::HTTP_SEE_OTHER);
           // return $this->redirectToRoute('app_profil_msg', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('profil/new.html.twig', [
            'profil' => $profil,
            'form' => $form,
            'isConnected' => $this->isConnected,
        ]);
    }


 

    #[Route('/show', name: 'app_profil_show', methods: ['GET'])]
    public function show(): Response
    {
        return $this->render('profil/show.html.twig', [
            'profil' => $this->CurrentUser,
             'isConnected' => $this->isConnected,
        ]);
    }



/**
 * @Route("/qr-code")
 */
public function qrCode(): Response
{
    $renderer = new Png();
    $renderer->setWidth(250);
    $renderer->setHeight(250);

    $writer = new Writer($renderer);
    $qrCode = new QrCode('Your text goes here');

    $response = new Response();
    $response->headers->set('Content-Type', 'image/png');
    $response->setContent($writer->write($qrCode));

    return $response;
}


    #[Route('/edit', name: 'app_profil_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, ProfilRepository $profilRepository): Response
    {
        $form = $this->createForm(ProfilType::class, $this->CurrentUser);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $profilRepository->save($this->CurrentUser, true);

            return $this->redirectToRoute('app_profil_show',['profil' => $this->CurrentUser->getIdProfil()], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('profil/edit.html.twig', [
            'profil' => $this->CurrentUser,
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
