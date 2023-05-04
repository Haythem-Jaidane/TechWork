<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CommentaireRepository;
use \DateTime;

#[ORM\Entity(repositoryClass: CommentaireRepository::class)]
class Commentaire
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $id;

    #[ORM\Column]
    private ?int $profilId;

    #[ORM\Column]
    private $contenu;

    #[ORM\Column]
    private ?int $note;

    #[ORM\Column]
    private ?DateTime $date;

    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Utilisateur $utilisateur;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getProfilId(): ?int
    {
        return $this->profilId;
    }

    public function setProfilId(?int $profilId): self
    {
        $this->profilId = $profilId;

        return $this;
    }

    public function getContenu(): ?string
    {
        return $this->contenu;
    }

    public function setContenu(string $contenu): self
    {
        $this->contenu = $contenu;

        return $this;
    }

    public function getDate(): ?DateTime
    {
        return $this->date;
    }

    public function setDate(?DateTime $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getNote(): ?int
    {
        return $this->note;
    }

    public function setNote(int $note): self
    {
        $this->note = $note;

        return $this;
    }

    public function getUtilisateur(): ?Utilisateur
    {
        return $this->utilisateur;
    }

    public function setUtilisateur(?Utilisateur $utilisateur): self
    {
        $this->utilisateur = $utilisateur;

        return $this;
    }


}
