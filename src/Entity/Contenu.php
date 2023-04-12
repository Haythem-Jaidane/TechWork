<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\ContenuRepository;
use Symfony\Component\Validator\Constraints as Assert;
use Ramsey\Uuid\Uuid;

#[ORM\Entity(repositoryClass: ContenuRepository::class)]
class Contenu
{
    #[ORM\Id]
    #[ORM\Column(name:"id_contenu")]
    private ?string $id;

    #[ORM\Column]
    private ?string $type;

    #[ORM\Column]
    #[Assert\NotBlank(message:"verifié la durée entré")]
    #[Assert\Positive(message:"la durée doit etre positive")]
    private ?int $duree;

    #[ORM\Column]
    #[Assert\NotBlank(message:"enter un fichier")]
    #[Assert\File(mimeTypes : ['text/plain','video/mp4',],mimeTypesMessage : 'enter une image valide')]
    private ?string $lienContenu;

    #[ORM\Column]
    #[Assert\NotBlank(message:"verifié le titre entré")]
    private ?string $titre;

    #[ORM\ManyToOne(inversedBy: "Chapitre")]
    #[ORM\JoinColumn(name : "id_chapitre",referencedColumnName:"id_chapitre",nullable:false)]
    private ?Chapitre $id_chapitre;

    public function __construct(){
        $this->id = Uuid::uuid4()->toString();
    }

    public function getId(): ?string
    {
        return $this->id;
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
        return $this->id_chapitre;
    }

    public function setIdChapitre(?Chapitre $idChapitre): self
    {
        $this->id_chapitre = $idChapitre;

        return $this;
    }


}
