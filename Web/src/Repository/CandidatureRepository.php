<?php

namespace App\Repository;

use App\Entity\Candidature;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Twilio\Rest\Client;

/**
 * @extends ServiceEntityRepository<Candidature>
 *
 * @method Candidature|null find($id, $lockMode = null, $lockVersion = null)
 * @method Candidature|null findOneBy(array $criteria, array $orderBy = null)
 * @method Candidature[]    findAll()
 * @method Candidature[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CandidatureRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Candidature::class);
    }

    public  function sms(){
        // Your Account SID and Auth Token from twilio.com/console
                $sid = 'ACed59c2efc292602af3f856aad90c6bb6';
                $auth_token = 'f4fc9826d7cb10067d6450dad8321172';
        // In production, these should be environment variables. E.g.:
        // $auth_token = $_ENV["TWILIO_AUTH_TOKEN"]
        // A Twilio number you own with SMS capabilities
                $twilio_number = "+12762849300";
        
                $client = new Client($sid, $auth_token);
                $client->messages->create(
                // the number you'd like to send the message to
                    '+21650742776',
                    [
                        // A Twilio phone number you purchased at twilio.com/console
                        'from' => '+13204164063',
                        // the body of the text message you'd like to send
                        'body' => 'votre candidature à été mise à jour!'
                    ]
                );
            }

    public function save(Candidature $entity, bool $flush = false): void
    {
        $this->getEntityManager()->persist($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }

    public function remove(Candidature $entity, bool $flush = false): void
    {
        $this->getEntityManager()->remove($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }


     /**
      * @return Candidature[] Returns an array of Candidature objects
      */
     public function findByStatus($value,$id): array
     {
         return $this->createQueryBuilder('c')
             ->andWhere('c.status = :val and c.candidat = :id')
             ->setParameter('val', $value)
             ->setParameter('id', $id)
             ->orderBy('c.id', 'ASC')
             ->setMaxResults(10)
             ->getQuery()
             ->getResult()
         ;
     }

     public function countByDate(){
          $query = $this->createQueryBuilder('a')
              ->select('SUBSTRING(a.datepostulation, 1, 10) as datePostulation, COUNT(a) as count')
              ->groupBy('datePostulation')
           ;
          return $query->getQuery()->getResult(); 
    }

//    /**
//     * @return Candidature[] Returns an array of Candidature objects
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

//    public function findOneBySomeField($value): ?Candidature
//    {
//        return $this->createQueryBuilder('c')
//            ->andWhere('c.exampleField = :val')
//            ->setParameter('val', $value)
//            ->getQuery()
//            ->getOneOrNullResult()
//        ;
//    }
}
