<?php

namespace App\Controller;

use App\Entity\Offre;
use App\Form\OffreType;
use App\Repository\OffreRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Candidature;
use App\Form\CandidatureType;
use App\Repository\CandidatureRepository;
use App\Form\PostulerType;

use App\Entity\CurlServer;

class OffreController extends AbstractController
{
    public function count()
    {   
        $em = $this->getDoctrine()->getManager();
         
        $repoOffres = $em->getRepository(Offre::class);
        
        // 3. Query how many rows are there in the Articles table
        $totalOffres = $repoOffres->createQueryBuilder('a')
            // Filter by parameter  
            // ->where('a.published = 1')
            ->select('count(a.id)')
            ->getQuery()
            ->getSingleScalarResult();
        
        // 4. Return a number as response
        return new Response($totalOffres);
    }


    

    #[Route('dashboard/offre', name: 'app_back_offre_show', methods: ['GET'])]
    public function showBack(OffreRepository $offreRepository): Response
    {
        return $this->render('BackOffice\Components\offre_show.html.twig', [
            'offres' => $offreRepository->findAll(),
        ]);
    }

  
/*

 
    #[Route('/offre', name: 'app_offre_index', methods: ['GET'])]
    public function index(OffreRepository $offreRepository): Response
    {
        return $this->render('offre/index.html.twig', [
            'offres' => $offreRepository->findAll(),
        ]);
    }

*/
 
    #[Route('/offre', name: 'app_offre_index', methods: ['GET'])]
    public function index(OffreRepository $offreRepository): Response
    {
        return $this->render('offre/index.html.twig', [
            'offres' => $offreRepository->findAll(),
        ]);
    }

 

    #[Route('/offre/new', name: 'app_offre_new', methods: ['GET', 'POST'])]
    public function new(Request $request, OffreRepository $offreRepository): Response
    {
        $offre = new Offre();
        $form = $this->createForm(OffreType::class, $offre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $offre->setStatus('Disponible');
            $offreRepository->save($offre, true);

            return $this->redirectToRoute('app_offre_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('offre/new.html.twig', [
            'offre' => $offre,
            'form' => $form,
        ]);
    }

    #[Route('/offre/{id}', name: 'app_offre_show', methods: ['GET'])]
    public function show(Offre $offre): Response
    {
        return $this->render('offre/show.html.twig', [
            'offre' => $offre,
        ]);
    }
/*
    #[Route('/offre/postuler/{id}', name: 'app_offre_show_postuler', methods: ['GET'])]
    public function show_postuler(Offre $offre): Response
    {
        return $this->render('FrontOffice/Components/offrePostuler.html.twig', [
            'offre' => $offre,
        ]);
    }
*/
#[Route('/home/offre/{id}', name: 'app_offre_show_postuler', methods: ['GET', 'POST'])]
public function show_postuler(Offre $offre,Request $request, CandidatureRepository $candidatureRepository): Response
{
    $candidature = new Candidature();
    $form = $this->createForm(PostulerType::class, $candidature);
    $form->handleRequest($request);
    if ($form->isSubmitted() && $form->isValid()) {
        $candidature->setDatepostulation(new \DateTime());
        $candidature->setStatus('Pending');
        $candidature->setOffre($offre);
        $candidatureRepository->save($candidature, true);

        return $this->redirectToRoute('app_home_off', [], Response::HTTP_SEE_OTHER);
    }
    return $this->renderForm('FrontOffice/Components/offrePostuler.html.twig', [
        'offre' => $offre,
        'candidature' => $candidature,
        'form' => $form,
    ]);
}

 

 
    #[Route('/offre_edit/{id}', name: 'app_offre_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Offre $offre, OffreRepository $offreRepository): Response
    {
        $form = $this->createForm(OffreType::class, $offre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
   
            $offreRepository->save($offre, true);

            return $this->redirectToRoute('app_offre_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('offre/edit.html.twig', [
            'offre' => $offre,
            'form' => $form,
        ]);
    }
 
    
    #[Route('/offre/{id}', name: 'app_offre_delete', methods: ['POST'])]
    public function delete(Request $request, Offre $offre, OffreRepository $offreRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$offre->getId(), $request->request->get('_token'))) {
            $offreRepository->remove($offre, true);
        }

        return $this->redirectToRoute('app_offre_index', [], Response::HTTP_SEE_OTHER);
    }


    /**
     * @Route("/stats", name="stats")
     */
    public function statistiques(OffreRepository $categRepo, AnnoncesRepository $annRepo){
        // On va chercher toutes les catégories
        $offre = $categRepo->findAll();

        $categNom = [];
        $categColor = [];
        $categCount = [];

        // On "démonte" les données pour les séparer tel qu'attendu par ChartJS
        foreach($offre as $off){
            $categNom[] = $off->getName();
            $categColor[] = $off->getColor();
            $categCount[] = count($off->getAnnonces());
        }

 

        return $this->render('admin/stats.html.twig', [
            'categNom' => json_encode($categNom),
            'categColor' => json_encode($categColor),
            'categCount' => json_encode($categCount),
   
        ]);
    }


    
 
    #[Route('/offre', name: 'app_offre_record', methods: ['GET'])]
    public function record(OffreRepository $offreRepository): Response
    { 
       
        // Start Server Session
        session_start();
        
        // Display All Errors (For Easier Development)
        ini_set('display_errors', 1);
        ini_set('display_startup_errors', 1);
        error_reporting(E_ALL);
        
        // Include cURL object file
        require '../includes/curl.class.php';
        // Initiate cURL Server bject
        $_cURL = new CurlServer($_SESSION['google_access_tokens']['access_token']);
        
        // Receive the RAW Audio data
        $content = trim(file_get_contents("php://input"));
        
        // Generate parameters for API request
        $parameters = '{
            "config": {
                "encoding": "WEBM_OPUS",
                "languageCode": "en-US",
                "sampleRateHertz": 48000,
                "audioChannelCount": 1,
                "alternativeLanguageCodes": [],
                "speechContexts": [],
                "adaptation": {
                  "phraseSets": [],
                  "phraseSetReferences": [],
                  "customClasses": []
                },
                "enableWordTimeOffsets": true,
                "enableWordConfidence": true,
                "model": "default"
              },
              "audio": {
                "content": "' . base64_encode($content) .'"
              }
          }';
        
        $response = $_cURL->post_request("https://speech.googleapis.com/v1p1beta1/speech:recognize", $parameters);
        
        // Debug
        //echo '<pre>';
        //print_r($response);
        //echo '</pre>';
        
        $async_response = new stdClass();
        $async_response->response_received_data = 'Audio data was received';
        $async_response->response_received_transcript = $response->results[0]->alternatives[0]->transcript;
        $async_response = json_encode($async_response);
        echo $async_response;

}
}