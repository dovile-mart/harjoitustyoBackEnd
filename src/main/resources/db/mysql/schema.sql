SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS postinumero; 
DROP TABLE IF EXISTS asiakas; 
DROP TABLE IF EXISTS tyontekija; 
DROP TABLE IF EXISTS huone; 
DROP TABLE IF EXISTS huonevaraus; 
DROP TABLE IF EXISTS varaus;
DROP TABLE IF EXISTS app_user;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE postinumero 
(id BIGINT AUTO_INCREMENT,
postinumero VARCHAR(5) , 
postitoimipaikka VARCHAR(50) ,
PRIMARY KEY (id)
);


INSERT INTO postinumero (postinumero, postitoimipaikka) 
VALUES 
('06100', 'Porvoo'),
('06500', 'Porvoo'),
('05500', 'Helsinki'),
('02300', 'Tampere');



CREATE TABLE asiakas
(asiakas_id BIGINT AUTO_INCREMENT,
etunimi VARCHAR(50)  ,
sukunimi VARCHAR(50)  ,
sposti VARCHAR(150)  ,
puhelin VARCHAR(20)  ,
katuosoite VARCHAR(200)  ,
id BIGINT,
PRIMARY KEY (asiakas_id),
FOREIGN KEY (id) REFERENCES postinumero(id)
);

INSERT INTO asiakas (etunimi, sukunimi, sposti, puhelin, katuosoite, id)
VALUES 
('Matti', 'Meikäläinen', 'matti@mail.com', '019-123456', 'Pilvikuja 2', 2),
('Joona', 'Seppälä', 'joona@mail.com', '050-123456', 'Pilvitie 13', 1),
('Katri', 'Seppälä', 'katri@mail.com', '050-123666', 'Pilvitie 13', 1);

CREATE TABLE tyontekija
(tyontekija_id BIGINT AUTO_INCREMENT,
etunimi VARCHAR(50)  ,
sukunimi VARCHAR(50)  ,
sposti VARCHAR(150)  ,
puhelin VARCHAR(20)  ,
katuosoite VARCHAR(200)  ,
id BIGINT,
PRIMARY KEY (tyontekija_id),
FOREIGN KEY (id) REFERENCES postinumero(id)
);

INSERT INTO tyontekija (etunimi, sukunimi, sposti, puhelin, katuosoite, id)
VALUES 
('Seppo', 'Seppolainen', 'seppo@mail.com', '019-1111111', 'Pilvikatu 42', 2),
('Katri', 'Kekkilä', 'katri@mail.com', '040-1222233', 'Hiihtäjäntie 3', 1),
('Antti', 'Opiskelija', 'antti@mail.com', '040-000000', 'Opiskelijakatu 15-5', 3);
		

CREATE TABLE huone
(id BIGINT NOT NULL AUTO_INCREMENT,
huone_nro VARCHAR(3) NOT NULL,
huone_kuvaus VARCHAR(500) NOT NULL,
hinta INT NOT NULL,
onko_vapaa BOOLEAN NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO huone (huone_nro, huone_kuvaus, hinta, onko_vapaa)
VALUES 
('101', 'Huoneen 101 kuvaus', 90, TRUE),
('102', 'Huoneen 102 kuvaus', 110, TRUE),
('103', 'Huoneen 103 kuvaus', 95, TRUE);


CREATE TABLE varaus
(varaus_id BIGINT NOT NULL AUTO_INCREMENT,
asiakas_id BIGINT NOT NULL,
tyontekija_id BIGINT NOT NULL,
varaus_pvm DATETIME NOT NULL,
lisatietoja VARCHAR(200),
hinta INT NOT NULL,
maksettu BOOLEAN NOT NULL,
PRIMARY KEY (varaus_id),
FOREIGN KEY (asiakas_id) REFERENCES asiakas(asiakas_id),
FOREIGN KEY (tyontekija_id) REFERENCES tyontekija(tyontekija_id)
);

INSERT INTO varaus (asiakas_id, tyontekija_id, varaus_pvm, lisatietoja, hinta, maksettu)
VALUES 
(1, 1, '2023-1-26', 'Lisätiedot varauksesta', 120, FALSE),
(2, 2, '2023-1-24', 'Lisätiedot varauksesta', 150, FALSE);



CREATE TABLE huonevaraus
(huonevaraus_id BIGINT NOT NULL AUTO_INCREMENT,
varaus_id BIGINT NOT NULL,
id BIGINT NOT NULL,
tulo_pvm DATETIME NOT NULL,
lahto_pvm DATETIME NOT NULL,
hlo_maara INT NOT NULL,
lisatietoja VARCHAR(200),
hinta INT NOT NULL,
maksettu BOOLEAN NOT NULL,
PRIMARY KEY (huonevaraus_id),
FOREIGN KEY (varaus_id) REFERENCES varaus(varaus_id),
FOREIGN KEY (id) REFERENCES huone(id));

INSERT INTO huonevaraus (varaus_id, id, tulo_pvm, lahto_pvm, hlo_maara, lisatietoja, hinta, maksettu)
VALUES 
(1,1,'2023-1-23','2023-1-24', 2, 'Lisätiedot huoneen 101 huonevarauksesta',	120, FALSE),
(2,3,'2023-1-23','2023-1-25', 1, 'Lisätiedot huoneen 103 huonevarauksesta', 90, TRUE),
(2,2,'2023-1-23','2023-1-25', 2, 'Lisätiedot huoneen 101 huonevarauksesta', 130, FALSE);



CREATE TABLE app_user
(id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
role VARCHAR(250) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO app_user (username, password, role) 
VALUES ('user', '$2a$10$mR2WmGjLXN3t6v.cjNWY8upoHecRvcGjmq7slGq.9wwY83BD3yJkK', 'USER'), 
('admin', '$2a$10$jzx/BIs9sqsRfAaJOeGWeuqFbH/GG4Uxuz82ysgG5gn0ygew53GuW', 'ADMIN');

CREATE TABLE asiakas_varaukset
(asiakas_id BIGINT,
varaus_id BIGINT,
FOREIGN KEY (asiakas_id) REFERENCES asiakas(asiakas_id),
FOREIGN KEY (varaus_id) REFERENCES varaus(varaus_id));

INSERT INTO asiakas_varaukset(asiakas_id, varaus_id) VALUES (1,1),(2,2);

SELECT * FROM asiakas_varaukset;
SELECT * FROM postinumero; 
SELECT * FROM asiakas; 
SELECT * FROM tyontekija; 
SELECT * FROM huone; 
SELECT * FROM huonevaraus; 
SELECT * FROM varaus;
SELECT * FROM app_user;