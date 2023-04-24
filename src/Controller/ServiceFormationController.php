<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;

class ServiceFormationController extends AbstractController
{
    #[Route('/service/formation', name: 'app_service_formation')]
    public function index(): Response
    {
        return $this->render('service_formation/index.html.twig', [
            'controller_name' => 'ServiceFormationController',]);
        
    }


    #[Route("Formation/api/recherche",name:"recherche_formation_api",methods:["POST"])]
    public function rechercheCourApi(Request $request,NormalizerInterface $Normalizer){
        $repository=$this->getDoctrine()->getRepository(Student::class);
        $requestString=$request->get("search");
        $api_token=$request->get("api_token");
        $Cours=$repository->rechercheByTitre($requestString);
        $jsonContent=$Normalizer->normalize($Cours,"json",["groups","cours"]);
        $retour=json_encode($jsonContent);
        return new Response($retour);
    } 
}
