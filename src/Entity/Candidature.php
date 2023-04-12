<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CandidatureRepository;

#[ORM\Entity(repositoryClass: CandidatureRepository::class)]
class Candidature
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\Column]
    private ?string $offre;

    #[ORM\Column]
    private ?string $recruteur;

    #[ORM\Column]
    private ?string $candidat;

    #[ORM\Column]
    private ?string $status;

    #[ORM\Column]
    private ?string $informations;

    #[ORM\Column]
    private ?string $datepostulation;

    #[ORM\Column]
    private ?string $datemodification;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getOffre(): ?string
    {
        return $this->offre;
    }

    public function setOffre(string $offre): self
    {
        $this->offre = $offre;

        return $this;
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

    public function getCandidat(): ?string
    {
        return $this->candidat;
    }

    public function setCandidat(string $candidat): self
    {
        $this->candidat = $candidat;

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

        return $this;
    }

    public function getDatepostulation(): ?string
    {
        return $this->datepostulation;
    }

    public function setDatepostulation(string $datepostulation): self
    {
        $this->datepostulation = $datepostulation;

        return $this;
    }

    public function getDatemodification(): ?string
    {
        return $this->datemodification;
    }

    public function setDatemodification(string $datemodification): self
    {
        $this->datemodification = $datemodification;

        return $this;
    }


}
