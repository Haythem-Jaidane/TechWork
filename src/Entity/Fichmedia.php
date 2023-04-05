<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\FichmediaRepository;


#[ORM\Entity(repositoryClass: FichmediaRepository::class)]
class Fichmedia
{

    #[ORM\Id]
    #[ORM\Column(name:"idmedia")]
    #[ORM\GeneratedValue]
    private ?int $idmedia;

    #[ORM\Column]
    private ?string $nommedia;

    #[ORM\Column]
    private ?string $urlmedia;

    #[ORM\Column]
    private ?string $typemedia;

    #[ORM\ManyToOne(inversedBy: "Projet")]
    #[ORM\JoinColumn(name: "id",referencedColumnName:"id",nullable:false)]
    private ?Projet $id;

    public function getIdmedia(): ?int
    {
        return $this->idmedia;
    }

    public function getNommedia(): ?string
    {
        return $this->nommedia;
    }

    public function setNommedia(string $nommedia): self
    {
        $this->nommedia = $nommedia;

        return $this;
    }

    public function getUrlmedia(): ?string
    {
        return $this->urlmedia;
    }

    public function setUrlmedia(string $urlmedia): self
    {
        $this->urlmedia = $urlmedia;

        return $this;
    }

    public function getTypemedia(): ?string
    {
        return $this->typemedia;
    }

    public function setTypemedia(string $typemedia): self
    {
        $this->typemedia = $typemedia;

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
