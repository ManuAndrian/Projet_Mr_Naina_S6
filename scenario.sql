
--------------------DONNEE DE TEST UN A UN (OK)--------------------------------------------
--Une seule reservation nbr_place >= nbr_passager  , on prend le minimum de trajet (OK)
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Zero','Zero', 7 ,'2026-01-12 06:00:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Un','Un', 4 ,'2026-01-12 09:10:00',3);
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(8,1),--id 1
(5,2),--id 2
(8,1); -- id  3
INSERT INTO Utilisation_voiture(id_voiture , id_reservation , heure_depart,heure_redisponibilite,duree_minutes,km_parcourue) VALUES
(3,1,'2026-01-12 06:00:00','2026-01-12 08:00:00',111,37);

--Une seule reservation nbr_place >= nbr_passager  , on prend le minimum de trajet si egale on prend le carburant qui est gasoil(OK)
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Un','Un', 7 ,'2026-01-12 09:10:00',3);
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(8,1),--id 1
(5,2),--id 2
(8,2); -- id 3

--Une seule reservation nbr_place >= nbr_passager  , on prend le minimum de trajet si egale on prend le carburant qui est gasoil si egale on prend le nbr_place min(OK)
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Un','Un', 7 ,'2026-01-12 09:10:00',3);

INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(9,1),--id 1
(5,2),--id 2
(8,1); -- id 3

---AVEC TA -----
---Total des passagers , atonona ao anaty voiture anankiray---------
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(12,1); -- id 1
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(12,2); -- id 2
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Un','Un', 7 ,'2026-01-12 08:00:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Deux','Deux', 5 ,'2026-01-12 08:25:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Trois','Trois', 7 ,'2026-01-12 08:31:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Trois','Trois', 5 ,'2026-01-12 08:35:00',2);

---Total des passagers , tsy atonona ao anaty voiture anankiray---------
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(14,1); -- id 1
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(12,2); -- id 2
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Un','Un', 11 ,'2026-01-12 08:00:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Deux','Deux', 3 ,'2026-01-12 08:25:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Trois','Trois', 8 ,'2026-01-12 08:15:00',3);




--------------------------DONNEE DE TEST AUJOURD'HUI(OK)-----------------------------
----------CAS 1 (OK)
INSERT INTO Voiture(nbr_place , id_carburant) VALUES
(10,1), -- id 1
(10,1), -- id 2
(10,1); -- id 3
INSERT INTO Parametre (vitesse_moyenne, temps_attente)
VALUES (50,30);
INSERT INTO Hotel (nom, lieu) VALUES
('H0', 'H0'),
('H1', 'H1'),
('H2', 'H2'),
('H3', 'H3');
INSERT INTO Distance (from_id_hotel,to_id_hotel,distance) VALUES
(1,2,90),
(1,3,65), 
(1,4,45),
(2,3,10),
(3,4,5),            
(4,2,20);

INSERT INTO Reservation(nom, prenom, nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 1','Client 1', 8,'2026-02-16 10:00:00', 2),
('Client 2','Client 2', 8,'2026-02-16 10:30:00', 3);


----------CAS 2 (OK)
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(12,1),--id 1
(6,1),--id 2
(24,1); -- id 3
INSERT INTO Parametre (vitesse_moyenne, temps_attente)
VALUES (50,30);
INSERT INTO Hotel (nom, lieu) VALUES
('H0', 'H0'),
('H1', 'H1'),
('H2', 'H2'),
('H3', 'H3');
INSERT INTO Distance (from_id_hotel,to_id_hotel,distance) VALUES
(1,2,90),
(1,3,65),
(1,4,45),
(2,3,10),
(3,4,5),
(4,2,20);

INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 4 ','Client 4 ', 20,'2026-02-17 9:05:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 1 ','Client 1 ', 2,'2026-02-17 10:10:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 2 ','Client 2 ', 4 ,'2026-02-17 10:20:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 3 ','Client 3 ', 8 ,'2026-02-17 10:30:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 5 ','Client 5 ', 30 ,'2026-02-18 8:00:00',2);

--xxxxxxxxxxxxxxxx A VERIFIER
---misy tsy mety kely ilay filtre par date-----------



----------CAS 3
INSERT INTO Voiture(nbr_place , id_carburant)VALUES
(40,1),
(40,2),
(24,1),
(24,2); 
INSERT INTO Parametre (vitesse_moyenne, temps_attente)
VALUES (50,30);
INSERT INTO Hotel (nom, lieu) VALUES
('H0', 'H0'),
('H1', 'H1'),
('H2', 'H2'),
('H3', 'H3');
INSERT INTO Distance (from_id_hotel,to_id_hotel,distance) VALUES
(1,2,90),
(1,3,65),
(1,4,45),
(2,3,10),
(3,4,5),
(4,2,20);

INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client1 ','Jena ', 30 ,'2026-02-17 9:05:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 2 ','Mario ', 32 ,'2026-02-17 10:00:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 3 ','Manohisoa ', 20 ,'2026-02-17 11:00:00',4);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 4 ','Fenitra ', 14,'2026-02-17 11:05:00',2);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 5 ','Manu ', 6 ,'2026-02-17 11:10:00',3);
INSERT INTO Reservation(nom , prenom , nbr_passager, date_et_heure_arrive, id_hotel) VALUES
('Client 6 ','Jessy ', 4 ,'2026-02-17 11:05:00',4);



