<?php

namespace App\Entity;

use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CoursRepository;
use \DateTime;
use Ramsey\Uuid\Uuid;



#[ORM\Entity(repositoryClass: CoursRepository::class)]
class Cours
{
    #[ORM\Id]
    #[ORM\Column(name:"id")]
    private ?string $id;

    
    #[ORM\Column]
    #[Assert\NotBlank(message:"verifié le titre entré")]
    private ?string $titre;

    #[ORM\Column]
    #[Assert\NotBlank(message:"verifié la Categorie entré")]
    private ?string $categorie;

    #[ORM\Column]
    private ?int $duree;

    #[ORM\Column]
    #[Assert\NotBlank(message:"enter un fichier")]
    #[Assert\File(mimeTypes : ['image/*',],mimeTypesMessage : 'enter une image valide')]
    private ?String $Img_url;

    #[ORM\Column]
    private ?DateTime $dateDeLancement;

    
    #[ORM\ManyToOne(inversedBy: "Utilisateur")]
    #[ORM\JoinColumn(nullable:false)]
    private ?Utilisateur $idTuteur;

    public function __construct(){
        $this->id = Uuid::uuid4()->toString();
    }

    public function setId(?string $id): ?self
    {
        $this->id = $id;

        return $this;
    }

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

    public function getImgUrl(): ?String
    {
        return $this->Img_url;
    }

    public function setImgUrl(?String $Img_url): self
    {
        $this->Img_url = $Img_url;

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
