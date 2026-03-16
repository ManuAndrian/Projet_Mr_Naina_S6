--------- Donnees -----------------


INSERT INTO Correcteur (nom, prenom, email, telephone, specialite)
VALUES
 ('Correcteur1','Tiana','2002-05-10','andry@test.com','0320000001'),
    ('Correcteur2','Tiana','2002-05-10','andry@test.com','0320000001'),
    ('Correcteur3','Tiana','2002-05-10','andry@test.com','0320000001');


INSERT INTO Candidat (nom, prenom, date_naissance, email, telephone)
VALUES
('Canditat1','Jean','2002-05-10','0340000001','Java'),
('Canditat2','Paul','2002-05-10','0340000002','Java'),
('Canditat2','Marie','2002-05-10','0340000003','Java');


INSERT INTO Matiere (nom_matiere, coefficient)
VALUES
('Programmation Java',2),
('Programmation PHP',2);

INSERT INTO Note (id_candidat,id_matiere,id_correcteur,valeur)
VALUES
(1,1,1,5),
(1,1,2,12),
(1,1,3,17);

INSERT INTO operateur (id_operateur, nom_operateur)
VALUES
(1, '>'),
(2, '<');

INSERT INTO operateur (id_operateur, nom_operateur)
VALUES

(3, '>=');
(4, '<=');


INSERT INTO resolution (id_resolution, nom_resolution)
VALUES
(1, '1'),
(2, '2'),
(3, '3');


INSERT INTO parametre (id_parametre, id_matiere, id_operateur, valeur, id_resolution)
VALUES
(1, 2, 3, 7, 3),   
(2, 2, 2, 12, 1);

INSERT INTO note (id_note, id_candidat, id_matiere,id_correcteur ,valeur)
VALUES
(1, 7, 2,15 ,15),
(2, 7, 2,16, 10),
(3, 7, 2,15 ,12);

(4, 7, 3, 15,9),
(5, 7, 3, 16,8),
(6, 7, 3, 17,11);

(7, 8, 2, 15,10),
(8, 8, 2, 16,10),

(10, 8, 3,15, 13),
(11, 8, 3,16, 11);

/* scenario 1 */


