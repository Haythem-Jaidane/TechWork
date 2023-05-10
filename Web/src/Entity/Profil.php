<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\ProfilRepository;
use Symfony\Component\Validator\Constraints as Assert;
#[ORM\Entity(repositoryClass: ProfilRepository::class)]
class Profil
{
    
    #[ORM\Id]
    #[ORM\OneToOne(targetEntity:"Utilisateur")]
    #[ORM\JoinColumn(name:"id_Profil", referencedColumnName:"id")]
    private ?Utilisateur $id;

    
    #[Assert\NotBlank(message:"nom is required")]
    #[ORM\Column(name:"Nom")]
    private ?string $Nom=" ";

    #[ORM\Column(name:"Prenom")]
    private ?string $Prenom=" ";

    #[ORM\Column(name:"NumeroTelephone")]
    private  ?string $NumeroTelephone=" ";

    #[ORM\Column(name:"Email")]
    private ?string $Email=" ";

    #[ORM\Column(name:"Localisation")]
    private ?string $Localisation=" ";

    #[ORM\Column(name:"Description")]
    private ?string $Description=" ";

    #[ORM\Column(name:"Langues")]
    private ?string $Langues=" ";

    #[ORM\Column(name:"Competences")]
    private ?string $Competences=" ";

    #[ORM\Column(name:"Formation")]
    private ?string $Formation=" ";

    #[ORM\Column(name:"ExperiencesProfessionnelles")]
    private ?string $ExperiencesProfessionnelles=" ";

    #[ORM\Column]
    private ?string $latitude=" ";

    #[ORM\Column]
    private ?string $longitude=" ";

    #[ORM\Column(name:"Diplome")]
    private ?string $Diplome=" ";

    /*public __construct(int $id,string $Nom,string $Prenom,string $NumeroTelephone,string $Email,string $Localisation,string $Description,string $Langues,string $Competences,string $Formation,?string $ExperiencesProfessionnelles,string $latitude,string $longitude,string $Diplome){
        
    }*/

    public function getIdProfil(): ?Utilisateur
    {
        return $this->id;
    }

    public function setIdProfil(Utilisateur $id): self
    {
        $this->id = $id;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->Nom;
    }

    public function setNom(string $nom): self
    {
        $this->Nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->Prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->Prenom = $prenom;

        return $this;
    }

    public function getNumeroTelephone(): ?string
    {
        return $this->NumeroTelephone;
    }

    public function setNumeroTelephone(string $numeroTelephone): self
    {
        $this->NumeroTelephone = $numeroTelephone;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->Email;
    }

    public function setEMail(string $email): self
    {
        $this->Email = $email;

        return $this;
    }

    public function getLocalisation(): ?string
    {
        return $this->Localisation;
    }

    public function setLocalisation(string $localisation): self
    {
        $this->Localisation = $localisation;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->Description;
    }

    public function setDescription(string $description): self
    {
        $this->Description = $description;

        return $this;
    }

    public function getLangues(): ?string
    {
        return $this->Langues;
    }

    public function setLangues(string $langues): self
    {
        $this->Langues = $langues;

        return $this;
    }

    public function getCompetences(): ?string
    {
        return $this->Competences;
    }

    public function setCompetences(string $competences): self
    {
        $this->Competences = $competences;

        return $this;
    }

    public function getFormation(): ?string
    {
        return $this->Formation;
    }

    public function setFormation(string $formation): self
    {
        $this->Formation = $formation;

        return $this;
    }

    public function getExperiencesProfessionnelles(): ?string
    {
        return $this->ExperiencesProfessionnelles;
    }

    public function setExperiencesProfessionnelles(string $experiencesProfessionnelles): self
    {
        $this->ExperiencesProfessionnelles = $experiencesProfessionnelles;

        return $this;
    }

    public function getLatitude(): ?string
    {
        return $this->latitude;
    }

    public function setLatitude(string $latitude): self
    {
        $this->latitude = $latitude;

        return $this;
    }

    public function getLongitude(): ?string
    {
        return $this->longitude;
    }

    public function setLongitude(string $longitude): self
    {
        $this->longitude = $longitude;

        return $this;
    }

    public function getDiplome(): ?string
    {
        return $this->Diplome;
    }

    public function setDiplome(string $diplome): self
    {
        $this->Diplome = $diplome;

        return $this;
    }


}
