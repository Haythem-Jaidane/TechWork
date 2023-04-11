<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\LikepubRepository;


#[ORM\Entity(repositoryClass: LikepubRepository::class)]
class Likepub
{
    #[ORM\Id]
    #[ORM\Column(name:"id")]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(name : "id_user",referencedColumnName:"id",nullable:false)]
    private ?Utilisateur $id_user;

    #[ORM\ManyToOne(inversedBy: "Publication")]
    #[ORM\JoinColumn(name : "id_pub",referencedColumnName:"id_Pub",nullable:false)]
    private ?Publication $idPub;

    public function getIdUser(): ?int
    {
        return $this->id;
    }

    public function setIdUser(int $idUser): self
    {
        $this->idUser = $idUser;

        return $this;
    }

    public function getId(): ?Utilisateur
    {
        return $this->id_user	;
    }

    public function setId(?Utilisateur $id): self
    {
        $this->id_user = $id;

        return $this;
    }

    public function getIdPub(): ?Publication
    {
        return $this->idPub;
    }

    public function setIdPub(?Publication $idPub): self
    {
        $this->idPub = $idPub;

        return $this;
    }


}
