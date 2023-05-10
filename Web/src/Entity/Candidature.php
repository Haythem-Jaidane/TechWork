<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CandidatureRepository;
use App\Entity\Offre;

#[ORM\Entity(repositoryClass: CandidatureRepository::class)]
class Candidature
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\ManyToOne(inversedBy: 'candidatures')]
    #[ORM\JoinColumn(nullable: false)]
    private ?Offre $offre = null;
 
    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    private ?Utilisateur $candidat = null;

    #[ORM\Column]
    private ?string $status;

    #[ORM\Column]
    private ?string $details=" ";

    #[ORM\Column(type: Types::DATETIME_MUTABLE, nullable: true)]
    private ?\DateTimeInterface $datepostulation = null;

    #[ORM\Column(type: Types::DATETIME_MUTABLE, nullable: true)]
    private ?\DateTimeInterface $datemodification = null;

    
    private $mail;

    public function getmail(): ?string
    {
        return $this->mail;
    }

    public function setmail(?string $mail): self
    {
        $this->mail = $mail;

        return $this;
    }


    public function getId(): ?int
    {
        return $this->id;
    }



    public function getRecruteur(): ?string
    {
        return $this->recruteur;
    }

    public function setRecruteur(string $recruteur): self
    {
        $this->recruteur = $recruteur;

        return $this;
    }

 

    public function getStatus(): ?string
    {
        return $this->status;
    }

    public function setStatus(string $status): self
    {
        $this->status = $status;

        return $this;
    }

    public function getInformations(): ?string
    {
        return $this->informations;
    }

    public function setInformations(string $informations): self
    {
        $this->informations = $informations;
    }
    
    public function getDetails(): ?string
    {
        return $this->details;
    }

    public function setDetails(string $details): self
    {
        $this->details = $details;

        return $this;
    }

    public function getDatepostulation(): ?\DateTimeInterface
    {
        return $this->datepostulation;
    }

    public function setDatepostulation(?\DateTimeInterface $datepostulation): self
    {
        $this->datepostulation = $datepostulation;

        return $this;
    }

    public function getDatemodification(): ?\DateTimeInterface
    {
        return $this->datemodification;
    }

    public function setDatemodification(?\DateTimeInterface $datemodification): self
    {
        $this->datemodification = $datemodification;

        return $this;
    }

    public function getOffre(): ?Offre
    {
        return $this->offre;
    }

    public function setOffre(?Offre $offre): self
    {
        $this->offre = $offre;

        return $this;
    }

    public function getCandidat(): ?Utilisateur
    {
        return $this->candidat;
    }

    public function setCandidat(?Utilisateur $candidat): self
    {
        $this->candidat = $candidat;

        return $this;
    }

    
        public function __toString()
        {
            return(string)$this->getId();
        }

}
