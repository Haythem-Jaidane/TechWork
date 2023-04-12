<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ChapitreRepository;

#[ORM\Entity(repositoryClass: ChapitreRepository::class)]
class Chapitre
{
    #[ORM\Id]
    #[ORM\Column(name:"id_chapitre")]
    private ?string $id;

    #[ORM\Column]
    private $titre;

    #[ORM\ManyToOne(inversedBy: "Cours")]
    #[ORM\JoinColumn(name: "id_cours",referencedColumnName:"id",nullable:false)]
    private ?Cours $id_cours;

    public function getIdChapitre(): ?string
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

    public function getIdCours(): ?Cours
    {
        return $this->id_cours;
    }

    public function setIdCours(?Cours $id_cours): self
    {
        $this->id_cours = $id_cours;

        return $this;
    }


}
