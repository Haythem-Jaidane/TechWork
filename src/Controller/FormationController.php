<?php

namespace App\Controller;

use Spatie\Dropbox\Client;
use Spatie\Dropbox\Exceptions\BadRequest;
use Spatie\Dropbox\TokenProvider;
use App\Entity\Cours;
use App\Entity\Chapitre;
use App\Entity\Contenu;
use App\Entity\Utilisateur;
use App\Entity\Progres;
use App\Form\CoursType;
use App\Form\ChapitreType;
use App\Form\ContenuType;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use Symfony\Contracts\HttpClient\HttpClientInterface;
use Symfony\Component\HttpFoundation\Session\SessionInterface;

use function Ramsey\Uuid\v1;




class FormationController extends AbstractController
{

    

    private bool $isConnected = true;
    private Utilisateur $CurrentUser;
    private $token;


    public function __construct(SessionInterface $session)
    {
        $this->token = $session->get('token');
    }


    #[Route('/formation', name: 'app_formation')]
    public function index(): Response
    {
        return $this->render('formation/index.html.twig', [
            'controller_name' => 'FormationController',
        ]);
    }

    #[Route('/ajouterChapitre/{cour}',name:'app_formation_ajouter_Chapitre')]
    public function ajouter(SessionInterface $session,$cour,ManagerRegistry $doctrine,Request $request)
    {
        $this->token = $session->get('token');

        $dropbox = new Client($this->token);
            $chapitre_a_ajouté = new Chapitre();
            $repo_Cours = $doctrine->getRepository(Cours::class);
            $repo = $doctrine->getManager();
            $current_cour = $repo_Cours->findOneById($cour);
            $Chapitreform= $this->createForm(ChapitreType::class,$chapitre_a_ajouté);
            $Chapitreform->handleRequest($request);
            if($Chapitreform->isSubmitted()){
                if($Chapitreform->isValid()){
                    $chapitre_a_ajouté->setIdCours($current_cour);
                    $dropbox->createFolder("Teckwork/".$cour."/".$chapitre_a_ajouté->getId());
                    $repo->persist($chapitre_a_ajouté);
                    $repo->flush();
                    return $this->redirectToRoute("app_formation_ajouter_Contenu" , [
                        "cour" =>  $current_cour->getId(),
                        "chapitre" => $chapitre_a_ajouté->getId()
                    ]);
                }
            }
            return $this->renderForm('FrontOffice/Components/ajouterCours.html.twig', [
                "isConnected" => $this->isConnected,
                "Cours" => $current_cour,
                "Chpitre_form" => $Chapitreform
            ]);
    }

    #[Route('/ajouterContenu/{cour}/{chapitre}',name:'app_formation_ajouter_Contenu')]
    public function ajouterContenu(SessionInterface $session,$cour,$chapitre,ManagerRegistry $doctrine,Request $request){
        $this->token = $session->get('token');

        $dropbox = new Client($this->token);
        $contenu_a_ajouté = new Contenu();
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo = $doctrine->getManager();
        $current_cour = $repo_Cours->findOneById($cour);
        $current_chapitre = $repo_Chapitre->findOneById($chapitre);
        $Contenuform= $this->createForm(ContenuType::class,$contenu_a_ajouté);
        $Contenuform->handleRequest($request);
        if($Contenuform->isSubmitted()){
            if($Contenuform->isValid()){

                $cours = $repo_Cours->findOneById($cour);
                $cours->setDuree($cours->getDuree()+$contenu_a_ajouté->getDuree());

                $file = $Contenuform->get('lienContenu')->getData();
                $fileMimeType = $file->guessExtension();

                $file = $contenu_a_ajouté->getId().".". $Contenuform["lienContenu"]->getData()->getClientOriginalExtension();
                $Contenuform["lienContenu"]->getData()->move(
                    $this->getParameter('file_directory'),
                    $file
                );
                $file_path = $this->getParameter('file_directory').'/'.$file;
                $contenu_a_ajouté->setLienContenu("Teckwork/".$cour.'/'.$chapitre.'/'.$file);
                
                $dropbox->upload("Teckwork/".$cour.'/'.$chapitre.'/'.$file,
                                fopen($file_path,'r'));

                if($fileMimeType == "txt"){
                    $contenu_a_ajouté->setType("text");
                }
                if($fileMimeType == "mp4"){
                    $contenu_a_ajouté->setType("video");
                }

                
                $contenu_a_ajouté->setIdChapitre($current_chapitre);


                $repo->persist($cours);
                $repo->persist($contenu_a_ajouté);
                $repo->flush();
                return $this->redirectToRoute("app_formation_ajouter_Contenu" , [
                    "cour" =>  $current_cour->getId(),
                    "chapitre" => $current_chapitre->getId()
                ]);
            }
        }
        return $this->renderForm('FrontOffice/Components/ajouterContenu.html.twig', [
            "isConnected" => $this->isConnected,
            "Cour" =>  $current_cour,
            "Chapitre" => $current_chapitre,
            "Contenu_form" => $Contenuform
        ]);
    }

    #[Route('/modifierCours/{id}',name:'app_formation_modifier_Cours')]
    public function modifier($id,ManagerRegistry $doctrine,Request $req)
    {
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo_Utilisateur = $doctrine->getRepository(Utilisateur::class);
        $cours = $repo_Cours->findOneById($id);
        $file = $req->files->get($cours->getImgUrl());
        $cours->setImgUrl($file);
        $chap = $repo_Chapitre->findByIdCours($id);
        $form=$this->createForm(CoursType::class,$cours);
        $form->handleRequest($req);
        $em=$doctrine->getManager();
        if($form->isSubmitted() && $form->isValid()){
            $cours->setDateDeLancement(new \DateTime('@'.strtotime('now')));
            $utilisateur = $repo_Utilisateur->findOneById(8);
            $cours->setIdTuteur($utilisateur);
            $em->persist($cours);
            $em->flush();
            
            return $this->redirectToRoute('app_formation_afficher_Mes_Cours');
        }
        return $this->renderForm('FrontOffice/Components/modifierCours.html.twig',[
            'Cours_form'=>$form,
            "isConnected" => $this->isConnected,
            "Chap" => $chap,
        ]);
    }

    #[Route('/afficherCours/{id_user}',name:'app_formation_afficher_Cours')]
    public function afficher($id_user,SessionInterface $session,Request $request,ManagerRegistry $doctrine)
    {
        $this->token = $session->get('token');

        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }
        $repo_progres = $doctrine->getRepository(Progres::class);
        $repo_Cours = $doctrine->getRepository(Cours::class);
        
        $cours_entre = $repo_progres->findByIdUtilisateur($id_user);
        $cour_entre_ = array();
        foreach($cours_entre as $i){
            array_push($cour_entre_,$repo_Cours->findOneById($i->getIdCours()));
        }
        $cours = $repo_Cours->findByIdNoTuto($id_user);
        $cours_a_recommande = array();
        foreach($cours as $i){
            $a = 1;
            foreach($cours_entre as $j){
                if($i->getId()== $j->getIdCours()->getId()){
                    $a=0;
                    break;
                }
            }
            if($a){
                array_push($cours_a_recommande,$i);
            }
        }
        
        
        $distances = array();
        foreach($cours_a_recommande as $i){
            
            $distance_ = 0;
            foreach($cour_entre_ as $j){
                $distance = 0;
                if($i->getCategorie() == $j->getCategorie()){
                    $distance = 0;
                }
                else{
                    $distance = 100;
                }
                $distance = $distance + (abs($i->getDuree() - $j->getDuree()));

                $distance_ = $distance_ + $distance;
            }

            array_push($distances ,array($distance_, $i));
        }
        
        for($I = count($distances) - 2;$I >= 0; $I--) {
            for($J = 0; $J <= $I; $J++) {
             if($distances[$J + 1][0] < $distances[$J][0]) {
              $t = $distances[$J + 1];
              $distances[$J + 1] = $distances[$J];
              $distances[$J] = $t;

             }
            }
           }

        /*foreach($distances as $d) {
            echo "|".$d[0].",".$d[1]->getTitre();
            echo "|";
        }*/

        $cour_a_ajouté =array();

        $i=0;

        foreach($distances as $d) {
            if($i<3){
                array_push($cour_a_ajouté,$d[1]);
            }
            else{
                break;
            }
            $i++;
        }


        return $this->renderForm('FrontOffice/Components/affichageCours.html.twig', [
            'list_cours' => $cour_a_ajouté,
            "isConnected" => $this->isConnected,
            "DropBox" => $dropbox,
            "iduser" => $id_user,
        ]);

       

        
        
    }

    #[Route("/autorization")]
    public function autorization_token(SessionInterface $session,Request $request,HttpClientInterface $httpClient){
        $authUrl = 'https://api.dropboxapi.com/oauth2/token';
        $clientId = 't186ceszuy8at19';
        $clientSecret = 'zuy61of02l5ohcb';
        $redirectUri = 'http://localhost:8000/autorization';

        $code = $request->query->get('code');

        $response = $httpClient->request('POST', $authUrl, [
            'headers' => [
                'Content-Type' => 'application/x-www-form-urlencoded',
            ],
            'body' => [
                'code' => $code,
                'grant_type' => 'authorization_code',
                'client_id' => $clientId,
                'client_secret' => $clientSecret,
                'redirect_uri' => $redirectUri,
                //"refresh_token " => "offline"
            ],
        ]);

        $data = json_decode($response->getContent(), true);

        $accessToken = $data['access_token'];

        $session->set("token",$accessToken);

        $url = 'http://localhost:8000/afficherCours/8';

        return $this->redirect($url);
    }

    #[Route('/token',name:'app_formation_token_Cours')]
    public function myTokenProvider()/*: TokenProvider*/
    {

        $authUrl = 'https://www.dropbox.com/oauth2/authorize';
        $clientId = 't186ceszuy8at19';
        $redirectUri = 'http://localhost:8000/autorization';

        $params = [
            'client_id' => $clientId,
            'response_type' => 'code',
            'redirect_uri' => $redirectUri,
            "token_access_type" => "offline" ,
        ];

        $url = $authUrl . '?' . http_build_query($params);

        return $this->redirect($url);

    }

    #[Route('/afficherTousCours/{id_user}',name:'app_formation_afficher_Cours_Tout')]
    public function afficherTout($id_user,SessionInterface $session,Request $request,ManagerRegistry $doctrine)
    {

        $this->token = $session->get('token');
    
        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }
        $repo = $doctrine->getRepository(Cours::class);
        $repo_prog = $doctrine->getRepository(Progres::class);


        $cours_entre = $repo_prog->findByIdUtilisateur($id_user);
        $cour_entre_ = array();
        foreach($cours_entre as $i){
            array_push($cour_entre_,$repo->findOneById($i->getIdCours()));
        }
        $cours_ = $repo->findByIdNoTuto($id_user);
        $cours= array();

        
        foreach($cours_ as $i){
            $a = 1;
            foreach($cours_entre as $j){
                if($i->getId() == $j->getIdCours()->getId()){
                    $a=0;
                    break;
                }
            }
            if($a){
                array_push($cours,$i);
            }

            
        }

        $prog = array();
        foreach ($cours as $i) {
            if($repo_prog->findOneByIdCours($i) == null){
                array_push($prog,0);
            }
            else{
                array_push($prog,$repo_prog->findOneByIdCours($i)->getProgresUtilisateur());
            }
            
        }

        return $this->render('FrontOffice/Components/affichageTousCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            "prog" => $prog,
            "DropBox" => $dropbox,
            "iduser" => $id_user,
        ]);

    }

    #[Route('/afficherCoursCommance/{id_user}',name:'app_formation_afficher_Cours_Commance')]
    public function afficherCommance($id_user,SessionInterface $session,ManagerRegistry $doctrine)
    {

        $this->token = $session->get('token');

        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }
        $repo = $doctrine->getRepository(Cours::class);
        $repo_prog = $doctrine->getRepository(Progres::class);
        $user_array = $repo_prog->findByidUtilisateur($id_user);
        //var_dump($user_array);
        $user_array2 = array();
        $prog = array();
        foreach($user_array as $i){
            array_push($user_array2,$i->getIdCours()->getId());
            array_push($prog,$i->getProgresUtilisateur());
        }
        print_r($user_array2);
        $cours = array();
        
        foreach($user_array2 as $i){
            //var_dump($i);
            array_push($cours,$repo->findOneById($i));
        }
        //print_r($cours);
        return $this->render('FrontOffice/Components/affichageCommanceCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            "prog" => $prog,
            "DropBox" => $dropbox,
            "iduser" => $id_user,
        ]);

        
    }

    #[Route('/afficherCoursTerminer/{id_user}',name:'app_formation_afficher_Cours_Terminer')]
    public function afficherTerminer($id_user,SessionInterface $session,ManagerRegistry $doctrine)
    {

        $this->token = $session->get('token');
        
        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }
        $repo = $doctrine->getRepository(Cours::class);
        $repo_prog = $doctrine->getRepository(Progres::class);
        $user_array = $repo_prog->findFinshedCoursByIdUtilisateur($id_user);
        $user_array2 = array();
        $prog = array();
        foreach($user_array as $i){
            array_push($user_array2,$i->getIdCours()->getId());
            array_push($prog,$i->getProgresUtilisateur());
        }
        print_r($user_array2);
        $cours = array();
        
        foreach($user_array2 as $i){
            //var_dump($i);
            array_push($cours,$repo->findOneById($i));
        }
        return $this->render('FrontOffice/Components/affichageTerminerCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            "iduser" => $id_user,
        ]);
    }

    #[Route('/afficherMesCours/{id_user}',name:'app_formation_afficher_Mes_Cours')]
    public function afficherMesCours($id_user,SessionInterface $session,ManagerRegistry $doctrine,Request $req)
    {
        $this->token = $session->get('token');

        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }
        $repo = $doctrine->getManager();
        $repo_Utilisateur = $doctrine->getRepository(Utilisateur::class);
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $cours = $repo_Cours->findByIdTuto($id_user);
        $cour_a_ajouté = new Cours();
        $cour_a_ajouté->setDuree(0);
        $form= $this->createForm(CoursType::class,$cour_a_ajouté);
        $form->handleRequest($req);
        if($form->isSubmitted()){
            if($form->isValid()){
                $file = $cour_a_ajouté->getId().".". $form["Img_url"]->getData()->getClientOriginalExtension();
                $form["Img_url"]->getData()->move(
                    $this->getParameter('file_directory'),
                    $file
                );
                $file_path = $this->getParameter('file_directory').'/'.$file;
                $cour_a_ajouté->setDateDeLancement(new \DateTime('@'.strtotime('now')));
                $cour_a_ajouté->setImgUrl("Teckwork/".$cour_a_ajouté->getId().'/'.$file);
                
                $utilisateur = $repo_Utilisateur->findOneById($id_user);
                $cour_a_ajouté->setIdTuteur($utilisateur);
                $dropbox->createFolder("Teckwork/".$cour_a_ajouté->getId());
                $dropbox->upload("Teckwork/".$cour_a_ajouté->getId().'/'.$file,
                                fopen($file_path,'r'));
                $repo->persist($cour_a_ajouté);
                $repo->flush();
                return $this->redirectToRoute("app_formation_ajouter_Chapitre" , [
                    "cour" =>  $cour_a_ajouté->getId(),
                ]);
            }
            else{
                return $this->renderForm('FrontOffice/Components/affichageMesCours.html.twig', [
                    'list_cours' => $cours,
                    "isConnected" => $this->isConnected,
                    'Cours_form' => $form,
                    "isForm" => true,
                    "DropBox" => $dropbox,
                    "iduser" => $id_user,
                ]);
            }
        }
        return $this->renderForm('FrontOffice/Components/affichageMesCours.html.twig', [
            'list_cours' => $cours,
            "isConnected" => $this->isConnected,
            'Cours_form' => $form,
            "isForm" => false,
            "monCour" => $cour_a_ajouté,
            "DropBox" => $dropbox,
            "iduser" => $id_user,
        ]);

    }


    
    #[Route('/supprimerCours/{id}',name:'app_formation_supprimer_Cours')]
    public function supprimer($id,ManagerRegistry $doctrine)
    {
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Chapitre = $doctrine->getRepository(Chapitre::class);
        $repo_Contenu = $doctrine->getRepository(Contenu::class);
        $courSupp = $repo_Cours->findOneById($id);
        $Chapitre = $repo_Chapitre->findByIdCours($courSupp->getId());
        
        foreach($Chapitre as $c){
            $Contenu = $repo_Contenu->findbyIdChapitre($c->getId());
            foreach($Contenu as $co){
                $repo_Contenu->remove($co);
            }
            $repo_Chapitre->remove($c);
        }
        $repo_Cours->remove($courSupp,true);
        return $this->redirectToRoute('app_formation_afficher_Mes_Cours');
    }

    #[Route("CommancerCour/{id_cours}/{id_user}",name:"CommancerCour")]
    public function commancer($id_cours,SessionInterface $session,$id_user,ManagerRegistry $doctrine,HttpClientInterface $httpClient){

        $this->token = $session->get('token');

        try {
            $dropbox = new Client($this->token);
        } catch (BadRequest $e) {
            echo 'Error: ' . $e->getMessage();
        }

        $repo = $doctrine->getManager();
        $repo_Cours = $doctrine->getRepository(Cours::class);
        $repo_Utilisateur = $doctrine->getRepository(Utilisateur::class);
        $repo_chapitre = $doctrine->getRepository(Chapitre::class);
        $repo_contenu = $doctrine->getRepository(Contenu::class);
        $cours = $repo_Cours->findOneById($id_cours);
        $user = $repo_Utilisateur->findOneById($id_user);
        $chapitres = $repo_chapitre->findByIdCours($id_cours);
        $pro = new Progres();
        $pro->setId($user);
        $pro->setidCours($cours);
        $pro->setNoteExamen(0);
        $pro->setProgresUtilisateur(0);
        $pro->setIscomplete(False);
        $repo->persist($pro);
        $repo->flush();
        return $this->renderForm('FrontOffice/Components/commancerCours.html.twig', [
            'chapiters' => $chapitres,
            "isConnected" => $this->isConnected,
            "contenu" => $repo_contenu,
            "DropBox" => $dropbox,
            "httpClient" => $httpClient,
        ]);
    }
}

   