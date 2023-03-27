<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ContenuRepository;

#[ORM\Entity(repositoryClass: ContenuRepository::class)]
class Contenu
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?string $idContenu;

    #[ORM\Column]
    private ?string $type;

    #[ORM\Column]
    private ?int $duree;

    #[ORM\Column]
    private ?string $lienContenu;

    #[ORM\Column]
    private ?string $titre;

    
    #[ORM\ManyToOne(inversedBy: "Chapitre")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Chapitre $idChapitre;

    public function getIdContenu(): ?string
    {
        return $this->idContenu;
    }

    public function getType(): ?string
    {
        return $this->type;
    }

    public function setType(string $type): self
    {
        $this->type = $type;

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

    public function getLienContenu(): ?string
    {
        return $this->lienContenu;
    }

    public function setLienContenu(string $lienContenu): self
    {
        $this->lienContenu = $lienContenu;

        return $this;
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

    public function getIdChapitre(): ?Chapitre
    {
        return $this->idChapitre;
    }

    public function setIdChapitre(?Chapitre $idChapitre): self
    {
        $this->idChapitre = $idChapitre;

        return $this;
    }


}
