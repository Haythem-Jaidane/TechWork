<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230424081408 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE candidature (id INT AUTO_INCREMENT NOT NULL, offre VARCHAR(255) NOT NULL, recruteur VARCHAR(255) NOT NULL, candidat VARCHAR(255) NOT NULL, status VARCHAR(255) NOT NULL, informations VARCHAR(255) NOT NULL, datepostulation VARCHAR(255) NOT NULL, datemodification VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE chapitre (id_chapitre VARCHAR(255) NOT NULL, id_cours VARCHAR(255) NOT NULL, titre VARCHAR(255) NOT NULL, INDEX IDX_8C62B025134FCDAC (id_cours), PRIMARY KEY(id_chapitre)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE commentaire (id INT AUTO_INCREMENT NOT NULL, utilisateur_id INT NOT NULL, profil_id INT NOT NULL, contenu VARCHAR(255) NOT NULL, note INT NOT NULL, date DATETIME NOT NULL, INDEX IDX_67F068BCFB88E14F (utilisateur_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE contenu (id_contenu VARCHAR(255) NOT NULL, id_chapitre VARCHAR(255) NOT NULL, type VARCHAR(255) NOT NULL, duree INT NOT NULL, lien_contenu VARCHAR(255) NOT NULL, titre VARCHAR(255) NOT NULL, INDEX IDX_89C2003FDCB95CB0 (id_chapitre), PRIMARY KEY(id_contenu)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE cours (id VARCHAR(255) NOT NULL, id_tuteur_id INT NOT NULL, titre VARCHAR(255) NOT NULL, categorie VARCHAR(255) NOT NULL, duree INT NOT NULL, img_url VARCHAR(255) NOT NULL, date_de_lancement DATETIME NOT NULL, INDEX IDX_FDCA8C9C6D9D4FF (id_tuteur_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE fichmedia (idmedia INT AUTO_INCREMENT NOT NULL, id INT NOT NULL, nommedia VARCHAR(255) NOT NULL, urlmedia VARCHAR(255) NOT NULL, typemedia VARCHAR(255) NOT NULL, INDEX IDX_F423DA4EBF396750 (id), PRIMARY KEY(idmedia)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE likepub (id INT AUTO_INCREMENT NOT NULL, id_user INT NOT NULL, id_pub INT NOT NULL, INDEX IDX_B99E03876B3CA4B (id_user), INDEX IDX_B99E0387C4E0D4DF (id_pub), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE offre (id INT AUTO_INCREMENT NOT NULL, titre VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, post VARCHAR(255) NOT NULL, salaire INT NOT NULL, lieu VARCHAR(255) NOT NULL, typecontrat VARCHAR(255) NOT NULL, duree INT NOT NULL, status VARCHAR(255) NOT NULL, domaineoffre VARCHAR(255) NOT NULL, nomrecruteur VARCHAR(255) NOT NULL, emailrecruteur VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE profil (id_Profil INT AUTO_INCREMENT NOT NULL, Nom VARCHAR(255) NOT NULL, Prenom VARCHAR(255) NOT NULL, NumeroTelephone VARCHAR(255) NOT NULL, Email VARCHAR(255) NOT NULL, localisation VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, langues VARCHAR(255) NOT NULL, competences VARCHAR(255) NOT NULL, formation VARCHAR(255) NOT NULL, experiences_professionnelles VARCHAR(255) NOT NULL, latitude VARCHAR(255) NOT NULL, longitude VARCHAR(255) NOT NULL, diplome VARCHAR(255) NOT NULL, PRIMARY KEY(id_Profil)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE progres (id_cours_id VARCHAR(255) NOT NULL, id_utilisateur_id INT NOT NULL, progres_utilisateur INT NOT NULL, note_examen INT NOT NULL, iscomplete TINYINT(1) NOT NULL, INDEX IDX_C8E8FE32E149425 (id_cours_id), INDEX IDX_C8E8FE3C6EE5C49 (id_utilisateur_id), PRIMARY KEY(id_cours_id, id_utilisateur_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE projet (id INT AUTO_INCREMENT NOT NULL, nom VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, domaine VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE publication (id_Pub INT AUTO_INCREMENT NOT NULL, objet VARCHAR(255) NOT NULL, message VARCHAR(255) NOT NULL, id_cours VARCHAR(255) NOT NULL, id_Profil INT NOT NULL, INDEX IDX_AF3C6779C74D024C (id_Profil), PRIMARY KEY(id_Pub)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE typeprojet (idtypeprojet INT AUTO_INCREMENT NOT NULL, id INT NOT NULL, nomtype VARCHAR(255) NOT NULL, descriptiontype VARCHAR(255) NOT NULL, INDEX IDX_D421F7C2BF396750 (id), PRIMARY KEY(idtypeprojet)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE utilisateur (id INT AUTO_INCREMENT NOT NULL, cin VARCHAR(255) NOT NULL, nom VARCHAR(255) NOT NULL, prenom VARCHAR(255) NOT NULL, motdepasse VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, role VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE messenger_messages (id BIGINT AUTO_INCREMENT NOT NULL, body LONGTEXT NOT NULL, headers LONGTEXT NOT NULL, queue_name VARCHAR(190) NOT NULL, created_at DATETIME NOT NULL, available_at DATETIME NOT NULL, delivered_at DATETIME DEFAULT NULL, INDEX IDX_75EA56E0FB7336F0 (queue_name), INDEX IDX_75EA56E0E3BD61CE (available_at), INDEX IDX_75EA56E016BA31DB (delivered_at), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE chapitre ADD CONSTRAINT FK_8C62B025134FCDAC FOREIGN KEY (id_cours) REFERENCES cours (id)');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BCFB88E14F FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id)');
        $this->addSql('ALTER TABLE contenu ADD CONSTRAINT FK_89C2003FDCB95CB0 FOREIGN KEY (id_chapitre) REFERENCES chapitre (id_chapitre)');
        $this->addSql('ALTER TABLE cours ADD CONSTRAINT FK_FDCA8C9C6D9D4FF FOREIGN KEY (id_tuteur_id) REFERENCES utilisateur (id)');
        $this->addSql('ALTER TABLE fichmedia ADD CONSTRAINT FK_F423DA4EBF396750 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT FK_B99E03876B3CA4B FOREIGN KEY (id_user) REFERENCES utilisateur (id)');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT FK_B99E0387C4E0D4DF FOREIGN KEY (id_pub) REFERENCES publication (id_Pub)');
        $this->addSql('ALTER TABLE progres ADD CONSTRAINT FK_C8E8FE32E149425 FOREIGN KEY (id_cours_id) REFERENCES cours (id)');
        $this->addSql('ALTER TABLE progres ADD CONSTRAINT FK_C8E8FE3C6EE5C49 FOREIGN KEY (id_utilisateur_id) REFERENCES utilisateur (id)');
        $this->addSql('ALTER TABLE publication ADD CONSTRAINT FK_AF3C6779C74D024C FOREIGN KEY (id_Profil) REFERENCES profil (id_Profil)');
        $this->addSql('ALTER TABLE typeprojet ADD CONSTRAINT FK_D421F7C2BF396750 FOREIGN KEY (id) REFERENCES projet (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE chapitre DROP FOREIGN KEY FK_8C62B025134FCDAC');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BCFB88E14F');
        $this->addSql('ALTER TABLE contenu DROP FOREIGN KEY FK_89C2003FDCB95CB0');
        $this->addSql('ALTER TABLE cours DROP FOREIGN KEY FK_FDCA8C9C6D9D4FF');
        $this->addSql('ALTER TABLE fichmedia DROP FOREIGN KEY FK_F423DA4EBF396750');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY FK_B99E03876B3CA4B');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY FK_B99E0387C4E0D4DF');
        $this->addSql('ALTER TABLE progres DROP FOREIGN KEY FK_C8E8FE32E149425');
        $this->addSql('ALTER TABLE progres DROP FOREIGN KEY FK_C8E8FE3C6EE5C49');
        $this->addSql('ALTER TABLE publication DROP FOREIGN KEY FK_AF3C6779C74D024C');
        $this->addSql('ALTER TABLE typeprojet DROP FOREIGN KEY FK_D421F7C2BF396750');
        $this->addSql('DROP TABLE candidature');
        $this->addSql('DROP TABLE chapitre');
        $this->addSql('DROP TABLE commentaire');
        $this->addSql('DROP TABLE contenu');
        $this->addSql('DROP TABLE cours');
        $this->addSql('DROP TABLE fichmedia');
        $this->addSql('DROP TABLE likepub');
        $this->addSql('DROP TABLE offre');
        $this->addSql('DROP TABLE profil');
        $this->addSql('DROP TABLE progres');
        $this->addSql('DROP TABLE projet');
        $this->addSql('DROP TABLE publication');
        $this->addSql('DROP TABLE typeprojet');
        $this->addSql('DROP TABLE utilisateur');
        $this->addSql('DROP TABLE messenger_messages');
    }
}
