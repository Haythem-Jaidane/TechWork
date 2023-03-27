<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230327155212 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE messenger_messages (id BIGINT AUTO_INCREMENT NOT NULL, body LONGTEXT NOT NULL, headers LONGTEXT NOT NULL, queue_name VARCHAR(190) NOT NULL, created_at DATETIME NOT NULL, available_at DATETIME NOT NULL, delivered_at DATETIME DEFAULT NULL, INDEX IDX_75EA56E0FB7336F0 (queue_name), INDEX IDX_75EA56E0E3BD61CE (available_at), INDEX IDX_75EA56E016BA31DB (delivered_at), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE candidature CHANGE offre offre LONGTEXT NOT NULL');
        $this->addSql('ALTER TABLE chapitre CHANGE id_cours id_cours VARCHAR(256) DEFAULT NULL');
        $this->addSql('ALTER TABLE commentaire CHANGE utilisateur_id utilisateur_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE contenu CHANGE id_chapitre id_chapitre VARCHAR(256) DEFAULT NULL');
        $this->addSql('ALTER TABLE fichmedia CHANGE id id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE likepub CHANGE id id INT NOT NULL, CHANGE id_pub id_pub INT DEFAULT NULL');
        $this->addSql('ALTER TABLE profil CHANGE latitude latitude VARCHAR(50) NOT NULL, CHANGE longitude longitude VARCHAR(50) NOT NULL');
        $this->addSql('DROP INDEX `primary` ON progres');
        $this->addSql('ALTER TABLE progres ADD PRIMARY KEY (id_cours, id_utilisateur)');
        $this->addSql('ALTER TABLE publication CHANGE id_Profil id_Profil INT DEFAULT NULL');
        $this->addSql('ALTER TABLE typeprojet CHANGE id id INT DEFAULT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE messenger_messages');
        $this->addSql('ALTER TABLE candidature CHANGE offre offre LONGTEXT NOT NULL COLLATE `utf8mb4_bin`');
        $this->addSql('ALTER TABLE chapitre CHANGE id_cours id_cours VARCHAR(256) NOT NULL');
        $this->addSql('ALTER TABLE commentaire CHANGE utilisateur_id utilisateur_id INT NOT NULL');
        $this->addSql('ALTER TABLE contenu CHANGE id_chapitre id_chapitre VARCHAR(256) NOT NULL');
        $this->addSql('ALTER TABLE fichmedia CHANGE id id INT NOT NULL');
        $this->addSql('ALTER TABLE likepub CHANGE id id INT AUTO_INCREMENT NOT NULL, CHANGE id_pub id_pub INT NOT NULL');
        $this->addSql('ALTER TABLE profil CHANGE latitude latitude VARCHAR(50) DEFAULT \'0\' NOT NULL, CHANGE longitude longitude VARCHAR(50) DEFAULT \'0\' NOT NULL');
        $this->addSql('DROP INDEX `PRIMARY` ON progres');
        $this->addSql('ALTER TABLE progres ADD PRIMARY KEY (id_cours)');
        $this->addSql('ALTER TABLE publication CHANGE id_Profil id_Profil INT NOT NULL');
        $this->addSql('ALTER TABLE typeprojet CHANGE id id INT NOT NULL');
    }
}
