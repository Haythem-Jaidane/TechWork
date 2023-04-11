<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230329235309 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE publication ADD CONSTRAINT FK_AF3C6779C74D024C FOREIGN KEY (id_Profil) REFERENCES profil (id_Profil)');
        $this->addSql('CREATE INDEX IDX_AF3C6779C74D024C ON publication (id_Profil)');
        $this->addSql('ALTER TABLE typeprojet CHANGE nomtype nomtype VARCHAR(255) NOT NULL, CHANGE descriptiontype descriptiontype VARCHAR(255) NOT NULL, CHANGE id id INT NOT NULL');
        $this->addSql('ALTER TABLE typeprojet ADD CONSTRAINT FK_D421F7C2BF396750 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('CREATE INDEX IDX_D421F7C2BF396750 ON typeprojet (id)');
        $this->addSql('ALTER TABLE utilisateur CHANGE cin cin VARCHAR(255) NOT NULL, CHANGE nom nom VARCHAR(255) NOT NULL, CHANGE prenom prenom VARCHAR(255) NOT NULL, CHANGE motDePasse motdepasse VARCHAR(255) NOT NULL, CHANGE email email VARCHAR(255) NOT NULL, CHANGE role role VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE publication DROP FOREIGN KEY FK_AF3C6779C74D024C');
        $this->addSql('DROP INDEX IDX_AF3C6779C74D024C ON publication');
        $this->addSql('ALTER TABLE typeprojet DROP FOREIGN KEY FK_D421F7C2BF396750');
        $this->addSql('DROP INDEX IDX_D421F7C2BF396750 ON typeprojet');
        $this->addSql('ALTER TABLE typeprojet CHANGE id id INT DEFAULT NULL, CHANGE nomtype nomtype VARCHAR(50) NOT NULL, CHANGE descriptiontype descriptiontype VARCHAR(200) NOT NULL');
        $this->addSql('ALTER TABLE utilisateur CHANGE cin cin VARCHAR(30) NOT NULL, CHANGE nom nom VARCHAR(30) NOT NULL, CHANGE prenom prenom VARCHAR(30) NOT NULL, CHANGE motdepasse motDePasse VARCHAR(30) NOT NULL, CHANGE email email VARCHAR(30) NOT NULL, CHANGE role role VARCHAR(30) NOT NULL');
    }
}
