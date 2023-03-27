<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\TypeprojetRepository;

#[ORM\Entity(repositoryClass: TypeprojetRepository::class)]
class Typeprojet
{
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $idtypeprojet;

    #[ORM\Column]
    private ?string $nomtype;

    #[ORM\Column]
    private ?string $descriptiontype;

    #[ORM\ManyToOne(inversedBy: "Projet")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Projet $id;

    public function getIdtypeprojet(): ?int
    {
        return $this->idtypeprojet;
    }

    public function getNomtype(): ?string
    {
        return $this->nomtype;
    }

    public function setNomtype(string $nomtype): self
    {
        $this->nomtype = $nomtype;

        return $this;
    }

    public function getDescriptiontype(): ?string
    {
        return $this->descriptiontype;
    }

    public function setDescriptiontype(string $descriptiontype): self
    {
        $this->descriptiontype = $descriptiontype;

        return $this;
    }

    public function getId(): ?Projet
    {
        return $this->id;
    }

    public function setId(?Projet $id): self
    {
        $this->id = $id;

        return $this;
    }


}
