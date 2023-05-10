<?php

namespace App\Controller;
use App\Form\SearchProjetType;
use App\Entity\Projet;
use App\Entity\Utilisateur;
use App\Form\ProjetType;
use App\Repository\ProjectRepository;
use App\Repository\UtilisateurRepository;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use TCPDF;
use Dompdf\Dompdf;
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use App\Mailer\ProjectMailer;
use Symfony\Component\HttpFoundation\JsonResponse;
use Twilio\Rest\Client;
use Symfony\Component\Security\Core\Security;


//use Nexmo\Client as NexmoClient;
//use NexmoBundle;
//use Nexmo\Client;
//use Symfony\Component\HttpClient\Psr18Client;
//use Nyholm\Psr7\Factory\Psr17Factory;
//use Vonage\Client;
//use Vonage\Client\Credentials\Basic;



/*$basic  = new Basic('e21b491d', 'ishCYmv2eWOL36nL');
$credentials = $basic;

$client = new Client($credentials);*/


#[Route('/projet')]
class ProjetController extends AbstractController
{
private $from = 'techwork414@gmail.com';
private bool $connection;
    private $security;
    private Utilisateur $CurrentUser;

    public function __construct(Security $security,UtilisateurRepository $UtilisateurManager)
    {
        $this->security = $security;
        $user = $this->security->getUser();

        if ($user) {
            $this->connection = true;
            $this->CurrentUser = $UtilisateurManager->findOneById($user->getId());
        } else {
            $this->connection = false;
        }
    }
    #[Route('/', name: 'app_projet_index', methods: ['GET'])]
    public function index(ProjectRepository $projectRepository,Request $request, PaginatorInterface $paginator): Response
    {
        $pagination = $paginator->paginate($projectRepository->findAll(), $request->query->getInt('page', 1), 4);
        return $this->render('projet/index.html.twig', [
            'projets' => $pagination,
            "isConnected" => true, 
        ]);
    
        
    }
    #[Route('/gen', name: 'app_genprojet_index')]
    public function generateProjectsPdf(): Response
    {
        // Récupérer l'EntityManager de Doctrine
$entityManager = $this->getDoctrine()->getManager();

// Récupérer le Repository de l'entité Project
$projectRepository = $entityManager->getRepository(Projet::class);

// Récupérer la liste des projets à partir du Repository
$projets = $projectRepository->findAll();
        // Initialisez la bibliothèque TCPDF
        $pdf = new TCPDF('P', 'mm', 'A4', true, 'UTF-8', false);

        // Définissez les informations du document PDF
        $pdf->SetCreator('Mon application Symfony');
        $pdf->SetAuthor('Moi');
        $pdf->SetTitle('Liste de projets');
        $pdf->SetSubject('Liste de projets');
    // Ajouter un en-tête personnalisé
$pdf->SetHeaderData(0, 0, 'Mon application Symfony', 'Liste de projets', array(0, 0, 0), array(255, 255, 255));

// Ajouter un pied de page avec le numéro de page
$pdf->SetFooterData(0, 0, 'Page '.$pdf->getAliasNumPage().'/'.$pdf->getAliasNbPages(), '', array(0, 0, 0), array(255, 255, 255));

// Ajouter une bordure autour de chaque cellule
$pdf->SetLineWidth(0.1);
//foreach ($projets as $projet) {
   // $pdf->Cell(0, 10, $projet->getNom(), 'B', 1);
//}

        // Ajoutez une page au document PDF
       $pdf->AddPage();
    
        // Définissez la police et la taille de la police
      $pdf->SetFont('helvetica', '', 12);
    
        // Bouclez sur votre liste de projets et ajoutez-les au document PDF
    foreach ($projets as $projet) {
        $pdf->Cell(0, 10, $projet->getNom(), 0, 1);
     }
    
        // Générez le fichier PDF et renvoyez-le en réponse
        return new Response($pdf->Output('projets.pdf', 'D'));


        

    }
   
    #[Route('/search', name: 'app_projet_search', methods: ['GET', 'POST'])]
    public function search(Request $req): Response
    {
        $form= $this->createForm(SearchProjetType::class );
        $form->handleRequest($req);
        $projets=[];
        if($form->isSubmitted()){
            $nom = $form->getData()['search'];
           // $projets = $projectRepository->findByName($form->getData('search'));
           $entityManager = $this->getDoctrine()->getManager();
           $projectRepository = $entityManager->getRepository(Projet::class);
           $projets = $projectRepository->findByName([
            'search'=> $nom,  ]);
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
public function new(Request $request, ProjectRepository $projectRepository, MailerInterface $mailer): Response
{
    $projet = new Projet();
    $form = $this->createForm(ProjetType::class, $projet);
    $form->handleRequest($request);

    if ($form->isSubmitted() && $form->isValid()) {
        $projet->setidUtilisateur($this->CurrentUser);
        $projectRepository->save($projet, true);
        $nom = $projet->getNom();
        
        // send email
        /*$email = (new Email())
            ->from('techwork414@gmail.com')
            ->to('manarboukhris8@gmail.com')
            ->subject('New Project Created')
            ->html(sprintf('Voici les informations de la base de données : "%s".', $nom));
    
        $mailer->send($email);*/
       /* 
        // send SMS
        $sid = 'AC5f382709f0dc165bba6e84ceb95dc455';
        $token = '0df8489b47f3cb82c43a0d02d0a5a5b8';
        $client = new \Twilio\Rest\Client($sid, $token);

        $message = $client->messages->create(
            '+21695643106',
            [
                'from' => '+16206598267',
                'body' => sprintf('Un nouveau projet a été créé dans votre portfolio sous le nom : "%s"!', $nom)
            ]
        );
        
        // add flash message
        $this->addFlash('success', 'Le projet a été ajouté avec succès!');
*/
        return $this->redirectToRoute('app_projet_index', [], Response::HTTP_SEE_OTHER);
    }

    return $this->renderForm('projet/new.html.twig', [
        'projet' => $projet,
        'form' => $form,
        'isConnected' => true,
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

#[Route('/searchh', name: 'searchh_projet', methods: ['GET'])]
public function searchProjet(Request $request): JsonResponse
{
    // Get the search query from the request
    $searchQuery = $request->query->get('query');

    // Query the database to find projects matching the search query
    $entityManager = $this->getDoctrine()->getManager();
    $projetRepository = $entityManager->getRepository(Projet::class);
    $projets = $projetRepository->createQueryBuilder('p')
        ->where('LOWER(p.nom) LIKE :query OR LOWER(p.description) LIKE :query')
        ->setParameter('query', '%' . strtolower($searchQuery) . '%')
        ->getQuery()
        ->getResult();

    // Transform the project data into an array of objects for JSON serialization
    $results = [];
    foreach ($projets as $projet) {
        $results[] = [
            'nom' => $projet->getNom(),
            'description' => $projet->getDescription()
        ];
    }

    // Return the search results as a JSON response
    return new JsonResponse($results);
}



    #[Route('/{id}', name: 'app_projet_delete', methods: ['POST'])]
    public function delete(Request $request, Projet $projet, ProjectRepository $projectRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$projet->getId(), $request->request->get('_token'))) {
            $projectRepository->remove($projet, true);
        }

        return $this->redirectToRoute('app_projet_index', [], Response::HTTP_SEE_OTHER);
    }




    #[Route("/stats", name:"app_stats")]
public function stats(): Response
{
    // Récupérer le nombre de projets par domaine
    
    $projectRepository = $this->getDoctrine()->getRepository(Projet::class);
    
    $nbProjetInfo = $projectRepository->countByDomaine("Info");
    
    $nbProjetAgriculture = $projectRepository->countByDomaine("Agriculture");
    
    $nbProjetIOT = $projectRepository->countByDomaine("IOT");
    

    // Créer un tableau avec les données
    $data = [
        "labels" => ["Info", "Agriculture", "IOT"],
        "datasets" => [
            [
                "label" => "Nombre de projets par domaine",
                "backgroundColor" => ["#3e95cd", "#8e5ea2", "#3cba9f"],
                "data" => [$nbProjetInfo, $nbProjetAgriculture, $nbProjetIOT]
            ]
        ]
    ];

    // Convertir le tableau en JSON
    $jsonData = json_encode($data);

    return $this->render('projet/stat.html.twig', [
        'jsonData' => $jsonData,
    ]);
}

}
