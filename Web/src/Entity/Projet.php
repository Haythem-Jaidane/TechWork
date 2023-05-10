<?php

namespace App\Entity;

use Doctrine\ORM\Exception\RepositoryException;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\ProjectRepository;


#[ORM\Entity(repositoryClass: ProjectRepository::class)]
class Projet
{


    #[ORM\Id]
    #[ORM\Column(name:"id")]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\Column]
    private ?string $nom;

    #[ORM\Column]
    private ?string $description;

    #[ORM\Column]
    private ?string $domaine;

    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Utilisateur $idUtilisateur;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

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

    public function getDomaine(): ?string
    {
        return $this->domaine;
    }

    public function setDomaine(string $domaine): self
    {
        $this->domaine = $domaine;

        return $this;
    }

    public function getIdUtilisateur(): ?Utilisateur
    {
        return $this->$idUtilisateur;
    }

    public function setIdUtilisateur(Utilisateur $idUtilisateur): self
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }

}
