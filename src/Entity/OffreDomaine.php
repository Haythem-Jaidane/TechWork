<?php

namespace App\Entity;

use App\Repository\OffreDomaineRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: OffreDomaineRepository::class)]
class OffreDomaine
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;
 
    #[ORM\ManyToMany(targetEntity: Offre::class)]
    private Collection $offre;

    #[ORM\ManyToMany(targetEntity: Domaine::class)]
    private Collection $domaine;

    public function __construct()
    {
        $this->offre = new ArrayCollection();
        $this->domaine = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * @return Collection<int, Offre>
     */
    public function getOffre(): Collection
    {
        return $this->offre;
    }

    public function addOffre(Offre $offre): self
    {
        if (!$this->offre->contains($offre)) {
            $this->offre->add($offre);
        }

        return $this;
    }

    public function removeOffre(Offre $offre): self
    {
        $this->offre->removeElement($offre);

        return $this;
    }

    /**
     * @return Collection<int, Domaine>
     */
    public function getDomaine(): Collection
    {
        return $this->domaine;
    }

    public function addDomaine(Domaine $domaine): self
    {
        if (!$this->domaine->contains($domaine)) {
            $this->domaine->add($domaine);
        }

        return $this;
    }

    public function removeDomaine(Domaine $domaine): self
    {
        $this->domaine->removeElement($domaine);

        return $this;
    }
}
