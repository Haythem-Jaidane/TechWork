<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\OffreRepository;

#[ORM\Entity(repositoryClass: OffreRepository::class)]
class Offre
{
    
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\Column]
    private ?string $titre;

    #[ORM\Column]
    private ?string $description;

    #[ORM\Column]
    private ?string $post;

    #[ORM\Column]
    private ?int $salaire;

    #[ORM\Column]
    private ?string $lieu;

    #[ORM\Column]
    private ?string $typecontrat;

    #[ORM\Column]
    private ?int $duree;

    #[ORM\Column]
    private ?string $status;

    #[ORM\Column]
    private ?string $domaineoffre;

    #[ORM\Column]
    private ?string $nomrecruteur;

    #[ORM\Column]
    private ?string $emailrecruteur;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitre(): ?string
    {
        return $this->titre;
    }

    public function setTitre(string $titre): self
    {
        $this->titre = $titre;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getPost(): ?string
    {
        return $this->post;
    }

    public function setPost(string $post): self
    {
        $this->post = $post;

        return $this;
    }

    public function getSalaire(): ?int
    {
        return $this->salaire;
    }

    public function setSalaire(int $salaire): self
    {
        $this->salaire = $salaire;

        return $this;
    }

    public function getLieu(): ?string
    {
        return $this->lieu;
    }

    public function setLieu(string $lieu): self
    {
        $this->lieu = $lieu;

        return $this;
    }

    public function getTypecontrat(): ?string
    {
        return $this->typecontrat;
    }

    public function setTypecontrat(string $typecontrat): self
    {
        $this->typecontrat = $typecontrat;

        return $this;
    }

    public function getDuree(): ?int
    {
        return $this->duree;
    }

    public function setDuree(int $duree): self
    {
        $this->duree = $duree;

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

    public function getDomaineoffre(): ?string
    {
        return $this->domaineoffre;
    }

    public function setDomaineoffre(string $domaineoffre): self
    {
        $this->domaineoffre = $domaineoffre;

        return $this;
    }

    public function getNomrecruteur(): ?string
    {
        return $this->nomrecruteur;
    }

    public function setNomrecruteur(string $nomrecruteur): self
    {
        $this->nomrecruteur = $nomrecruteur;

        return $this;
    }

    public function getEmailrecruteur(): ?string
    {
        return $this->emailrecruteur;
    }

    public function setEmailrecruteur(string $emailrecruteur): self
    {
        $this->emailrecruteur = $emailrecruteur;

        return $this;
    }


}
