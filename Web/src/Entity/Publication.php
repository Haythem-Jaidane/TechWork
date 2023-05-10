<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\PublicationRepository;


#[ORM\Entity(repositoryClass: PublicationRepository::class)]
class Publication
{
    
    #[ORM\Id]
    #[ORM\Column(name:"id_Pub")]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\Column]
    private ?string $objet;

    #[ORM\Column]
    private ?string $message;

    #[ORM\Column]
    private ?string $idCours=" ";

    #[ORM\ManyToOne(inversedBy: "Profil")]
    #[ORM\JoinColumn(name:"id_Profil",referencedColumnName:"id_Profil",nullable:false)]
    private ?Profil $id_Profil; 

    public function getIdPub(): ?int
    {
        return $this->id;
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
        return $this->id_Profil;
    }

    public function setIdProfil(?Profil $idProfil): self
    {
        $this->id_Profil = $idProfil;

        return $this;
    }


}
