<?php

namespace App\Repository;

use App\Entity\Cours;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Cours>
 *
 * @method Cours|null find($id, $lockMode = null, $lockVersion = null)
 * @method Cours|null findOneBy(array $criteria, array $orderBy = null)
 * @method Cours[]    findAll()
 * @method Cours[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CoursRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Cours::class);
    }

    public function save(Cours $entity, bool $flush = false): void
    {
        $this->getEntityManager()->persist($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }

    public function remove(Cours $entity, bool $flush = false): void
    {
        $this->getEntityManager()->remove($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }

    public function findByIdTuto($value): array
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.idTuteur = :val')
            ->setParameter('val', $value)
            ->orderBy('c.dateDeLancement', 'ASC')
            ->getQuery()
            ->getResult()
            ;
    }

    public function findByIdNoTuto($value): array
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.idTuteur != :val')
            ->setParameter('val', $value)
            ->orderBy('c.dateDeLancement', 'ASC')
            ->getQuery()
            ->getResult()
            ;
    }

    public function findOneById($value): ?Cours
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.id = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
            ;
    }

    public function rechercheByTitre($value,$user): array
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.titre Like :val and c.idTuteur = :user')
            ->setParameter('val', "%".$value."%")
            ->setParameter('user', $user)
            ->getQuery()
            ->getResult()
        ;
    }

    public function countByDate($value){
        return $this->createQueryBuilder('c')
            ->select("count(c)")
            ->andWhere("c.categorie = :val")
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }

//    /**
//     * @return Cours[] Returns an array of Cours objects
//     */
//    public function findByExampleField($value): array
//    {
//        return $this->createQueryBuilder('c')
//            ->andWhere('c.exampleField = :val')
//            ->setParameter('val', $value)
//            ->orderBy('c.id', 'ASC')
//            ->setMaxResults(10)
//            ->getQuery()
//            ->getResult()
//        ;
//    }

//    public function findOneBySomeField($value): ?Cours
//    {
//        return $this->createQueryBuilder('c')
//            ->andWhere('c.exampleField = :val')
//            ->setParameter('val', $value)
//            ->getQuery()
//            ->getOneOrNullResult()
//        ;
//    }
}
