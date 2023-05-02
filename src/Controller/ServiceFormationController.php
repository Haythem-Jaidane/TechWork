<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
use Symfony\Component\HttpFoundation\JsonResponse;
use App\Entity\Cours;

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
        $repository=$this->getDoctrine()->getRepository(Cours::class);
        $requestString=$request->get("search");
        $api_token=$request->get("api_token");
        $user=$request->get("user");
        $Cours=$repository->rechercheByTitre($requestString,$user);
        return new JsonResponse($Cours);
    }

    #[Route("Formation/api/chart",name:"chart_formation_api")]
    public function chartData()
    {
        $repository=$this->getDoctrine()->getRepository(Cours::class);
        $val = array();
        $Categorie = ['Dev', 'Cloud', 'Reseau', 'Web'];
        foreach($Categorie as $c){
            array_push($val,$repository->countByDate($c)["1"]);
        }
        
        $data = [
            
            'labels' => $Categorie,
            'datasets' => [
                [
                'label' => 'Cours',
                'data' => $val,
                'backgroundColor' => '#f87979'
            ]
        ]
    ];

    return new JsonResponse($data);
}
}
