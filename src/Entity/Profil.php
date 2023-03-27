<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\ProfilRepository;

#[ORM\Entity(repositoryClass: ProfilRepository::class)]
class Profil
{
    
    #[ORM\Id]
    #[ORM\Column]
    #[ORM\GeneratedValue]
    private ?int $idProfil;

    #[ORM\Column]
    private ?string $nom;

    #[ORM\Column]
    private ?string $prenom;

    #[ORM\Column]
    private  ?string $numéroTéléphone;

    #[ORM\Column]
    private ?string $eMail;

    #[ORM\Column]
    private ?string $localisation;

    #[ORM\Column]
    private ?string $description;

    #[ORM\Column]
    private ?string $langues;

    #[ORM\Column]
    private ?string $competences;

    #[ORM\Column]
    private ?string $formation;

    #[ORM\Column]
    private ?string $experiencesProfessionnelles;

    #[ORM\Column]
    private ?string $latitude = '0';

    #[ORM\Column]
    private ?string $longitude = '0';

    #[ORM\Column]
    private ?string $diplome;

    public function getIdProfil(): ?int
    {
        return $this->idProfil;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getNuméroTéléphone(): ?string
    {
        return $this->numéroTéléphone;
    }

    public function setNuméroTéléphone(string $numéroTéléphone): self
    {
        $this->numéroTéléphone = $numéroTéléphone;

        return $this;
    }

    public function getEMail(): ?string
    {
        return $this->eMail;
    }

    public function setEMail(string $eMail): self
    {
        $this->eMail = $eMail;

        return $this;
    }

    public function getLocalisation(): ?string
    {
        return $this->localisation;
    }

    public function setLocalisation(string $localisation): self
    {
        $this->localisation = $localisation;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getLangues(): ?string
    {
        return $this->langues;
    }

    public function setLangues(string $langues): self
    {
        $this->langues = $langues;

        return $this;
    }

    public function getCompetences(): ?string
    {
        return $this->competences;
    }

    public function setCompetences(string $competences): self
    {
        $this->competences = $competences;

        return $this;
    }

    public function getFormation(): ?string
    {
        return $this->formation;
    }

    public function setFormation(string $formation): self
    {
        $this->formation = $formation;

        return $this;
    }

    public function getExperiencesProfessionnelles(): ?string
    {
        return $this->experiencesProfessionnelles;
    }

    public function setExperiencesProfessionnelles(string $experiencesProfessionnelles): self
    {
        $this->experiencesProfessionnelles = $experiencesProfessionnelles;

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
        return $this->diplome;
    }

    public function setDiplome(string $diplome): self
    {
        $this->diplome = $diplome;

        return $this;
    }


}
