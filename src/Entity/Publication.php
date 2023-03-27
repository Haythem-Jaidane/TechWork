<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\PublicationRepository;


#[ORM\Entity(repositoryClass: PublicationRepository::class)]
class Publication
{
    
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $idPub;

    #[ORM\Column]
    private ?string $objet;

    #[ORM\Column]
    private ?string $message;

    #[ORM\Column]
    private ?string $idCours;

    #[ORM\ManyToOne(inversedBy: "Profil")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Profil $idProfil;

    public function getIdPub(): ?int
    {
        return $this->idPub;
    }

    public function getObjet(): ?string
    {
        return $this->objet;
    }

    public function setObjet(string $objet): self
    {
        $this->objet = $objet;

        return $this;
    }

    public function getMessage(): ?string
    {
        return $this->message;
    }

    public function setMessage(string $message): self
    {
        $this->message = $message;

        return $this;
    }

    public function getIdCours(): ?string
    {
        return $this->idCours;
    }

    public function setIdCours(string $idCours): self
    {
        $this->idCours = $idCours;

        return $this;
    }

    public function getIdProfil(): ?Profil
    {
        return $this->idProfil;
    }

    public function setIdProfil(?Profil $idProfil): self
    {
        $this->idProfil = $idProfil;

        return $this;
    }


}
