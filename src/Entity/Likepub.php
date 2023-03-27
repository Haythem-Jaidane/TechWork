<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\LikepubRepository;


#[ORM\Entity(repositoryClass: LikepubRepository::class)]
class Likepub
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $idUser;

    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Utilisateur $id;

    #[ORM\ManyToOne(inversedBy: "Publication")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Publication $idPub;

    public function getIdUser(): ?int
    {
        return $this->idUser;
    }

    public function setIdUser(int $idUser): self
    {
        $this->idUser = $idUser;

        return $this;
    }

    public function getId(): ?Utilisateur
    {
        return $this->id;
    }

    public function setId(?Utilisateur $id): self
    {
        $this->id = $id;

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
