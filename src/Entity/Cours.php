<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CoursRepository;
use \DateTime;


#[ORM\Entity(repositoryClass: CoursRepository::class)]
class Cours
{
    #[ORM\Id]
    #[ORM\Column(name:"id")]
    private ?string $id;

    #[ORM\Column]
    private ?string $titre;

    #[ORM\Column]
    private ?string $categorie;

    #[ORM\Column]
    private ?int $duree;

    #[ORM\Column]
    private ?DateTime $dateDeLancement;

    
    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Utilisateur $idTuteur;



    public function getId(): ?string
    {
        return $this->id;
    }

    public function getTitre(): ?string
    {
        return $this->titre;
    }

    public function setTitre(?string $titre): self
    {
        $this->titre = $titre;

        return $this;
    }

    public function getCategorie(): ?string
    {
        return $this->categorie;
    }

    public function setCategorie(string $categorie): self
    {
        $this->categorie = $categorie;

        return $this;
    }

    public function getDuree(): ?int
    {
        return $this->duree;
    }

    public function setDuree(?int $duree): self
    {
        $this->duree = $duree;

        return $this;
    }

    public function getDateDeLancement(): ?\DateTimeInterface
    {
        return $this->dateDeLancement;
    }

    public function setDateDeLancement(?\DateTimeInterface $dateDeLancement): self
    {
        $this->dateDeLancement = $dateDeLancement;

        return $this;
    }

    public function getIdTuteur(): ?Utilisateur
    {
        return $this->idTuteur;
    }

    public function setIdTuteur(?Utilisateur $idTuteur): self
    {
        $this->idTuteur = $idTuteur;

        return $this;
    }

}
