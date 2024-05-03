DROP DATABASE IF EXISTS bibliotheque;
CREATE DATABASE IF NOT EXISTS bibliotheque;
use bibliotheque;
DROP TABLE IF EXISTS  users ;
DROP TABLE IF EXISTS membres ;
DROP TABLE IF EXISTS emprunts;
DROP TABLE IF EXISTS livres;

create table if not exists users(
	user_id int auto_increment,
    username varchar(30),
    passwd varchar(30),
    email varchar(30),
    role varchar(20) DEFAULT "user",
    primary key (user_id)
    
);
create table if not exists membres(
	  mem_id int auto_increment,
      nom_mem varchar(30),
      adresse_mem varchar(45),
      telephone_mem int ,
      primary key(mem_id)
);
create table if not exists livres(
       livre_id int auto_increment,
       titre varchar(40),
       auteur varchar(40),
	   editeur varchar(40),
	   année_de_publication date,
	   primary key(livre_id)
);

create table if not exists emprunts(
	livre_id int,
    mem_id int,
    date_retour date,
    date_emprunt date,
    statut varchar(30) check (statut in('en cours','en retard','terminé')),
   FOREIGN KEY (livre_id) REFERENCES livres(livre_id),
   FOREIGN KEY (mem_id) REFERENCES membres (mem_id)
);

insert into membres (nom_mem,adresse_mem,telephone_mem) values ("hassan"," rabat","063222657"),("yassin","douar ait said","063454357");
insert into emprunts (livre_idm,mem_id,date_retour,date_emprunt,statut) values (12,1,'2024-05-02','2024-05-02',"terminé");

insert into users (username,passwd,email,role) values ("admin","admin","admin@gmail.com","admin");
insert into users (username,passwd,email) values ("user1","user1","user1@gmail.com");

select * from livres;
select * from membres;
select * from emprunts ;
select * from users ;




-- select membres.nom_mem ,count(membres.mem_id) As nombreTotal
-- from emprunts inner join membres
-- on emprunts.mem_id=membres.mem_id
-- group by membres.mem_id ; 

-- select livres.titre, count(livres.livre_id)
-- from livres inner join emprunts
-- on livres.livre_id=emprunts.livre_id
-- group by livres.livre_id ;


