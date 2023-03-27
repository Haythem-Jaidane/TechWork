<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ChapitreRepository;

#[ORM\Entity(repositoryClass: ChapitreRepository::class)]
class Chapitre
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?string $idChapitre;

    #[ORM\Column]
    private $titre;

    #[ORM\ManyToOne(inversedBy: "Cours")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Cours $idCours;

    public function getIdChapitre(): ?string
    {
        return $this->idChapitre;
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

    public function getIdCours(): ?Cours
    {
        return $this->idCours;
    }

    public function setIdCours(?Cours $idCours): self
    {
        $this->idCours = $idCours;

        return $this;
    }


}
