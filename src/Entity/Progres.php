<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ProgresRepository;

#[ORM\Entity(repositoryClass: ProgresRepository::class)]
class Progres
{
    #[ORM\Column]
    private ?int $progresUtilisateur;

    #[ORM\Column]
    private ?int $noteExamen;

    #[ORM\Column]
    private ?bool $iscomplete;

    #[ORM\ManyToOne(inversedBy: "Profil")]
    #[ORM\JoinColumn(nullable:false)]
    #[ORM\Id]
    private ?Cours $idCours;

    
    #[ORM\OneToMany(mappedBy: "Utilisateur",targetEntity:Utilisateur::class)]
    #[ORM\Id]
    private ?Utilisateur $idUtilisateur;

    public function getProgresUtilisateur(): ?int
    {
        return $this->progresUtilisateur;
    }

    public function setProgresUtilisateur(int $progresUtilisateur): self
    {
        $this->progresUtilisateur = $progresUtilisateur;

        return $this;
    }

    public function getNoteExamen(): ?int
    {
        return $this->noteExamen;
    }

    public function setNoteExamen(int $noteExamen): self
    {
        $this->noteExamen = $noteExamen;

        return $this;
    }

    public function isIscomplete(): ?bool
    {
        return $this->iscomplete;
    }

    public function setIscomplete(bool $iscomplete): self
    {
        $this->iscomplete = $iscomplete;

        return $this;
    }

    public function getIdCours(): ?Cours
    {
        return $this->idCours;
    }

    public function setidCours(Cours $idCours): self
    {
        $this->idCours = $idCours;

        return $this;
    }

    public function getId(): ?Utilisateur
    {
        return $this->idUtilisateur;
    }

    public function setId(Utilisateur $idUtilisateur): self
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }

    public function getIdUtilisateur(): ?string
    {
        return $this->idUtilisateur;
    }


}