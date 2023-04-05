<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230331011923 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE candidature CHANGE offre offre VARCHAR(255) NOT NULL, CHANGE recruteur recruteur VARCHAR(255) NOT NULL, CHANGE candidat candidat VARCHAR(255) NOT NULL, CHANGE status status VARCHAR(255) NOT NULL, CHANGE informations informations VARCHAR(255) NOT NULL, CHANGE datePostulation datepostulation VARCHAR(255) NOT NULL, CHANGE dateModification datemodification VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE chapitre DROP FOREIGN KEY chapitre_ibfk_1');
        $this->addSql('ALTER TABLE chapitre CHANGE id_chapitre id_chapitre VARCHAR(255) NOT NULL, CHANGE id_cours id_cours VARCHAR(255) NOT NULL, CHANGE titre titre VARCHAR(255) NOT NULL');
        $this->addSql('DROP INDEX id_cours ON chapitre');
        $this->addSql('CREATE INDEX IDX_8C62B025134FCDAC ON chapitre (id_cours)');
        $this->addSql('ALTER TABLE chapitre ADD CONSTRAINT chapitre_ibfk_1 FOREIGN KEY (id_cours) REFERENCES cours (id)');
        $this->addSql('DROP INDEX IDX_67F068BCB1E7706E ON commentaire');
        $this->addSql('ALTER TABLE commentaire CHANGE utilisateur_id utilisateur_id INT NOT NULL, CHANGE profil_id profil_id INT NOT NULL, CHANGE contenu contenu VARCHAR(255) NOT NULL, CHANGE date date DATETIME NOT NULL');
        $this->addSql('ALTER TABLE contenu DROP FOREIGN KEY fk_chap_cont');
        $this->addSql('ALTER TABLE contenu CHANGE id_contenu id_contenu VARCHAR(255) NOT NULL, CHANGE id_chapitre id_chapitre VARCHAR(255) NOT NULL, CHANGE type type VARCHAR(255) NOT NULL, CHANGE lien_contenu lien_contenu VARCHAR(255) NOT NULL, CHANGE Titre titre VARCHAR(255) NOT NULL');
        $this->addSql('DROP INDEX fk_chap_cont ON contenu');
        $this->addSql('CREATE INDEX IDX_89C2003FDCB95CB0 ON contenu (id_chapitre)');
        $this->addSql('ALTER TABLE contenu ADD CONSTRAINT fk_chap_cont FOREIGN KEY (id_chapitre) REFERENCES chapitre (id_chapitre)');
        $this->addSql('ALTER TABLE cours DROP FOREIGN KEY cours_ibfk_1');
        $this->addSql('DROP INDEX id_tuteur ON cours');
        $this->addSql('ALTER TABLE cours ADD id_tuteur_id INT NOT NULL, DROP id_tuteur, CHANGE id id VARCHAR(255) NOT NULL, CHANGE titre titre VARCHAR(255) NOT NULL, CHANGE categorie categorie VARCHAR(255) NOT NULL, CHANGE duree duree INT NOT NULL, CHANGE date_de_lancement date_de_lancement DATETIME NOT NULL');
        $this->addSql('ALTER TABLE cours ADD CONSTRAINT FK_FDCA8C9C6D9D4FF FOREIGN KEY (id_tuteur_id) REFERENCES utilisateur (id)');
        $this->addSql('CREATE INDEX IDX_FDCA8C9C6D9D4FF ON cours (id_tuteur_id)');
        $this->addSql('ALTER TABLE fichmedia DROP FOREIGN KEY fichmedia_ibfk_1');
        $this->addSql('ALTER TABLE fichmedia CHANGE id id INT NOT NULL, CHANGE nommedia nommedia VARCHAR(255) NOT NULL, CHANGE urlmedia urlmedia VARCHAR(255) NOT NULL, CHANGE typemedia typemedia VARCHAR(255) NOT NULL');
        $this->addSql('DROP INDEX id ON fichmedia');
        $this->addSql('CREATE INDEX IDX_F423DA4EBF396750 ON fichmedia (id)');
        $this->addSql('ALTER TABLE fichmedia ADD CONSTRAINT fichmedia_ibfk_1 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY likepub_ibfk_1');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY fk_lidpub_pub');
        $this->addSql('ALTER TABLE likepub CHANGE id id INT AUTO_INCREMENT NOT NULL, CHANGE id_pub id_pub INT NOT NULL');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT FK_B99E03876B3CA4B FOREIGN KEY (id_user) REFERENCES utilisateur (id)');
        $this->addSql('CREATE INDEX IDX_B99E03876B3CA4B ON likepub (id_user)');
        $this->addSql('DROP INDEX fk_lidpub_pub ON likepub');
        $this->addSql('CREATE INDEX IDX_B99E0387C4E0D4DF ON likepub (id_pub)');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT fk_lidpub_pub FOREIGN KEY (id_pub) REFERENCES publication (id_Pub)');
        $this->addSql('ALTER TABLE offre CHANGE titre titre VARCHAR(255) NOT NULL, CHANGE description description VARCHAR(255) NOT NULL, CHANGE post post VARCHAR(255) NOT NULL, CHANGE lieu lieu VARCHAR(255) NOT NULL, CHANGE typeContrat typecontrat VARCHAR(255) NOT NULL, CHANGE status status VARCHAR(255) NOT NULL, CHANGE domaineOffre domaineoffre VARCHAR(255) NOT NULL, CHANGE nomRecruteur nomrecruteur VARCHAR(255) NOT NULL, CHANGE emailRecruteur emailrecruteur VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE profil ADD NumeroTelephone VARCHAR(255) NOT NULL, ADD Email VARCHAR(255) NOT NULL, DROP Numéro_téléphone, DROP E_mail, CHANGE Nom Nom VARCHAR(255) NOT NULL, CHANGE Prenom Prenom VARCHAR(255) NOT NULL, CHANGE Localisation localisation VARCHAR(255) NOT NULL, CHANGE Description description VARCHAR(255) NOT NULL, CHANGE Langues langues VARCHAR(255) NOT NULL, CHANGE Competences competences VARCHAR(255) NOT NULL, CHANGE Formation formation VARCHAR(255) NOT NULL, CHANGE Experiences_professionnelles experiences_professionnelles VARCHAR(255) NOT NULL, CHANGE latitude latitude VARCHAR(255) NOT NULL, CHANGE longitude longitude VARCHAR(255) NOT NULL, CHANGE Diplome diplome VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE progres DROP FOREIGN KEY fk_prog_cours');
        $this->addSql('ALTER TABLE progres DROP FOREIGN KEY fk_prog_utili');
        $this->addSql('DROP INDEX fk_prog_utili ON progres');
        $this->addSql('DROP INDEX fk_prog_cours ON progres');
        $this->addSql('DROP INDEX `primary` ON progres');
        $this->addSql('ALTER TABLE progres ADD id_cours_id VARCHAR(255) NOT NULL, DROP id_cours, DROP id_utilisateur');
        $this->addSql('ALTER TABLE progres ADD CONSTRAINT FK_C8E8FE32E149425 FOREIGN KEY (id_cours_id) REFERENCES cours (id)');
        $this->addSql('ALTER TABLE progres ADD PRIMARY KEY (id_cours_id)');
        $this->addSql('ALTER TABLE projet CHANGE nom nom VARCHAR(255) NOT NULL, CHANGE description description VARCHAR(255) NOT NULL, CHANGE domaine domaine VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE publication DROP FOREIGN KEY fk_profil_pub');
        $this->addSql('ALTER TABLE publication CHANGE objet objet VARCHAR(255) NOT NULL, CHANGE message message VARCHAR(255) NOT NULL, CHANGE id_cours id_cours VARCHAR(255) NOT NULL, CHANGE id_Profil id_Profil INT NOT NULL');
        $this->addSql('DROP INDEX fk_profil_pub ON publication');
        $this->addSql('CREATE INDEX IDX_AF3C6779C74D024C ON publication (id_Profil)');
        $this->addSql('ALTER TABLE publication ADD CONSTRAINT fk_profil_pub FOREIGN KEY (id_Profil) REFERENCES profil (id_Profil)');
        $this->addSql('ALTER TABLE typeprojet DROP FOREIGN KEY typeprojet_ibfk_1');
        $this->addSql('ALTER TABLE typeprojet CHANGE id id INT NOT NULL, CHANGE nomtype nomtype VARCHAR(255) NOT NULL, CHANGE descriptiontype descriptiontype VARCHAR(255) NOT NULL');
        $this->addSql('DROP INDEX id ON typeprojet');
        $this->addSql('CREATE INDEX IDX_D421F7C2BF396750 ON typeprojet (id)');
        $this->addSql('ALTER TABLE typeprojet ADD CONSTRAINT typeprojet_ibfk_1 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('ALTER TABLE utilisateur CHANGE cin cin VARCHAR(255) NOT NULL, CHANGE nom nom VARCHAR(255) NOT NULL, CHANGE prenom prenom VARCHAR(255) NOT NULL, CHANGE motDePasse motdepasse VARCHAR(255) NOT NULL, CHANGE email email VARCHAR(255) NOT NULL, CHANGE role role VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE candidature CHANGE offre offre LONGTEXT NOT NULL, CHANGE recruteur recruteur VARCHAR(100) NOT NULL, CHANGE candidat candidat VARCHAR(100) NOT NULL, CHANGE status status VARCHAR(100) NOT NULL, CHANGE informations informations VARCHAR(100) NOT NULL, CHANGE datepostulation datePostulation VARCHAR(100) NOT NULL, CHANGE datemodification dateModification VARCHAR(100) NOT NULL');
        $this->addSql('ALTER TABLE chapitre DROP FOREIGN KEY FK_8C62B025134FCDAC');
        $this->addSql('ALTER TABLE chapitre CHANGE id_chapitre id_chapitre VARCHAR(256) NOT NULL, CHANGE id_cours id_cours VARCHAR(256) DEFAULT NULL, CHANGE titre titre VARCHAR(30) NOT NULL');
        $this->addSql('DROP INDEX idx_8c62b025134fcdac ON chapitre');
        $this->addSql('CREATE INDEX id_cours ON chapitre (id_cours)');
        $this->addSql('ALTER TABLE chapitre ADD CONSTRAINT FK_8C62B025134FCDAC FOREIGN KEY (id_cours) REFERENCES cours (id)');
        $this->addSql('ALTER TABLE commentaire CHANGE utilisateur_id utilisateur_id INT DEFAULT NULL, CHANGE profil_id profil_id INT DEFAULT NULL, CHANGE contenu contenu LONGTEXT NOT NULL, CHANGE date date DATETIME DEFAULT CURRENT_TIMESTAMP');
        $this->addSql('CREATE INDEX IDX_67F068BCB1E7706E ON commentaire (profil_id)');
        $this->addSql('ALTER TABLE contenu DROP FOREIGN KEY FK_89C2003FDCB95CB0');
        $this->addSql('ALTER TABLE contenu CHANGE id_contenu id_contenu VARCHAR(256) NOT NULL, CHANGE id_chapitre id_chapitre VARCHAR(256) DEFAULT NULL, CHANGE type type VARCHAR(30) NOT NULL, CHANGE lien_contenu lien_contenu VARCHAR(256) NOT NULL, CHANGE titre Titre VARCHAR(60) NOT NULL');
        $this->addSql('DROP INDEX idx_89c2003fdcb95cb0 ON contenu');
        $this->addSql('CREATE INDEX fk_chap_cont ON contenu (id_chapitre)');
        $this->addSql('ALTER TABLE contenu ADD CONSTRAINT FK_89C2003FDCB95CB0 FOREIGN KEY (id_chapitre) REFERENCES chapitre (id_chapitre)');
        $this->addSql('ALTER TABLE cours DROP FOREIGN KEY FK_FDCA8C9C6D9D4FF');
        $this->addSql('DROP INDEX IDX_FDCA8C9C6D9D4FF ON cours');
        $this->addSql('ALTER TABLE cours ADD id_tuteur INT DEFAULT NULL, DROP id_tuteur_id, CHANGE id id VARCHAR(256) NOT NULL, CHANGE titre titre VARCHAR(30) DEFAULT NULL, CHANGE categorie categorie VARCHAR(30) NOT NULL, CHANGE duree duree INT DEFAULT NULL, CHANGE date_de_lancement date_de_lancement DATE DEFAULT NULL');
        $this->addSql('ALTER TABLE cours ADD CONSTRAINT cours_ibfk_1 FOREIGN KEY (id_tuteur) REFERENCES utilisateur (id)');
        $this->addSql('CREATE INDEX id_tuteur ON cours (id_tuteur)');
        $this->addSql('ALTER TABLE fichmedia DROP FOREIGN KEY FK_F423DA4EBF396750');
        $this->addSql('ALTER TABLE fichmedia CHANGE id id INT DEFAULT NULL, CHANGE nommedia nommedia VARCHAR(50) NOT NULL, CHANGE urlmedia urlmedia VARCHAR(200) NOT NULL, CHANGE typemedia typemedia VARCHAR(50) NOT NULL');
        $this->addSql('DROP INDEX idx_f423da4ebf396750 ON fichmedia');
        $this->addSql('CREATE INDEX id ON fichmedia (id)');
        $this->addSql('ALTER TABLE fichmedia ADD CONSTRAINT FK_F423DA4EBF396750 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY FK_B99E03876B3CA4B');
        $this->addSql('DROP INDEX IDX_B99E03876B3CA4B ON likepub');
        $this->addSql('ALTER TABLE likepub DROP FOREIGN KEY FK_B99E0387C4E0D4DF');
        $this->addSql('ALTER TABLE likepub CHANGE id id INT NOT NULL, CHANGE id_pub id_pub INT DEFAULT NULL');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT likepub_ibfk_1 FOREIGN KEY (id) REFERENCES utilisateur (id)');
        $this->addSql('DROP INDEX idx_b99e0387c4e0d4df ON likepub');
        $this->addSql('CREATE INDEX fk_lidpub_pub ON likepub (id_pub)');
        $this->addSql('ALTER TABLE likepub ADD CONSTRAINT FK_B99E0387C4E0D4DF FOREIGN KEY (id_pub) REFERENCES publication (id_Pub)');
        $this->addSql('ALTER TABLE offre CHANGE titre titre VARCHAR(100) NOT NULL, CHANGE description description VARCHAR(1000) NOT NULL, CHANGE post post VARCHAR(100) NOT NULL, CHANGE lieu lieu VARCHAR(100) NOT NULL, CHANGE typecontrat typeContrat VARCHAR(100) NOT NULL, CHANGE status status VARCHAR(100) NOT NULL, CHANGE domaineoffre domaineOffre VARCHAR(100) NOT NULL, CHANGE nomrecruteur nomRecruteur VARCHAR(100) NOT NULL, CHANGE emailrecruteur emailRecruteur VARCHAR(100) NOT NULL');
        $this->addSql('ALTER TABLE profil ADD Numéro_téléphone TEXT CHARACTER SET utf8 NOT NULL COLLATE `utf8_general_ci`, ADD E_mail TEXT NOT NULL, DROP NumeroTelephone, DROP Email, CHANGE Nom Nom TEXT NOT NULL, CHANGE Prenom Prenom TEXT NOT NULL, CHANGE localisation Localisation TEXT NOT NULL, CHANGE description Description TEXT NOT NULL, CHANGE langues Langues TEXT NOT NULL, CHANGE competences Competences TEXT NOT NULL, CHANGE formation Formation TEXT NOT NULL, CHANGE experiences_professionnelles Experiences_professionnelles TEXT NOT NULL, CHANGE latitude latitude VARCHAR(50) NOT NULL, CHANGE longitude longitude VARCHAR(50) NOT NULL, CHANGE diplome Diplome TEXT NOT NULL');
        $this->addSql('ALTER TABLE progres DROP FOREIGN KEY FK_C8E8FE32E149425');
        $this->addSql('DROP INDEX `PRIMARY` ON progres');
        $this->addSql('ALTER TABLE progres ADD id_cours VARCHAR(256) NOT NULL, ADD id_utilisateur INT NOT NULL, DROP id_cours_id');
        $this->addSql('ALTER TABLE progres ADD CONSTRAINT fk_prog_cours FOREIGN KEY (id_cours) REFERENCES cours (id)');
        $this->addSql('ALTER TABLE progres ADD CONSTRAINT fk_prog_utili FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id)');
        $this->addSql('CREATE INDEX fk_prog_utili ON progres (id_utilisateur)');
        $this->addSql('CREATE INDEX fk_prog_cours ON progres (id_cours)');
        $this->addSql('ALTER TABLE progres ADD PRIMARY KEY (id_cours, id_utilisateur)');
        $this->addSql('ALTER TABLE projet CHANGE nom nom VARCHAR(50) NOT NULL, CHANGE description description VARCHAR(100) NOT NULL, CHANGE domaine domaine VARCHAR(50) NOT NULL');
        $this->addSql('ALTER TABLE publication DROP FOREIGN KEY FK_AF3C6779C74D024C');
        $this->addSql('ALTER TABLE publication CHANGE objet objet TEXT NOT NULL, CHANGE message message TEXT NOT NULL, CHANGE id_cours id_cours TEXT NOT NULL, CHANGE id_Profil id_Profil INT DEFAULT NULL');
        $this->addSql('DROP INDEX idx_af3c6779c74d024c ON publication');
        $this->addSql('CREATE INDEX fk_profil_pub ON publication (id_Profil)');
        $this->addSql('ALTER TABLE publication ADD CONSTRAINT FK_AF3C6779C74D024C FOREIGN KEY (id_Profil) REFERENCES profil (id_Profil)');
        $this->addSql('ALTER TABLE typeprojet DROP FOREIGN KEY FK_D421F7C2BF396750');
        $this->addSql('ALTER TABLE typeprojet CHANGE id id INT DEFAULT NULL, CHANGE nomtype nomtype VARCHAR(50) NOT NULL, CHANGE descriptiontype descriptiontype VARCHAR(200) NOT NULL');
        $this->addSql('DROP INDEX idx_d421f7c2bf396750 ON typeprojet');
        $this->addSql('CREATE INDEX id ON typeprojet (id)');
        $this->addSql('ALTER TABLE typeprojet ADD CONSTRAINT FK_D421F7C2BF396750 FOREIGN KEY (id) REFERENCES projet (id)');
        $this->addSql('ALTER TABLE utilisateur CHANGE cin cin VARCHAR(30) NOT NULL, CHANGE nom nom VARCHAR(30) NOT NULL, CHANGE prenom prenom VARCHAR(30) NOT NULL, CHANGE motdepasse motDePasse VARCHAR(30) NOT NULL, CHANGE email email VARCHAR(30) NOT NULL, CHANGE role role VARCHAR(30) NOT NULL');
    }
}
