
TRUNCATE TABLE Note RESTART IDENTITY CASCADE;
TRUNCATE TABLE Parametre RESTART IDENTITY CASCADE;
TRUNCATE TABLE Resolution RESTART IDENTITY CASCADE;
TRUNCATE TABLE Operateur RESTART IDENTITY CASCADE;
TRUNCATE TABLE Correcteur RESTART IDENTITY CASCADE;
TRUNCATE TABLE Matiere RESTART IDENTITY CASCADE;
TRUNCATE TABLE Candidat RESTART IDENTITY CASCADE;


CREATE DATABASE IF NOT EXISTS Fitsarana;
USE Fitsarana;

CREATE TABLE Correcteur (
    id_correcteur SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    telephone VARCHAR(20),
    specialite VARCHAR(100)
);

CREATE TABLE Candidat (
    id_candidat SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE,
    email VARCHAR(150) UNIQUE,
    telephone VARCHAR(20)
);

CREATE TABLE Matiere (
    id_matiere  SERIAL PRIMARY KEY,
    nom_matiere VARCHAR(100) NOT NULL,
    coefficient INT DEFAULT 1
);

CREATE TABLE Note (
    id_note SERIAL PRIMARY KEY,
    
    id_candidat INT NOT NULL,
    id_matiere INT NOT NULL,
    id_correcteur INT NOT NULL,
    
    valeur DECIMAL(5,2) NOT NULL,  -- ex: 15.50
    date_evaluation DATE DEFAULT CURRENT_DATE,
    
    CONSTRAINT fk_note_candidat 
        FOREIGN KEY (id_candidat) 
        REFERENCES Candidat(id_candidat)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_note_matiere 
        FOREIGN KEY (id_matiere) 
        REFERENCES Matiere(id_matiere)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_note_correcteur 
        FOREIGN KEY (id_correcteur) 
        REFERENCES Correcteur(id_correcteur)
        ON DELETE CASCADE
);

CREATE TABLE Operateur (
    id_operateur SERIAL PRIMARY KEY,
    signe VARCHAR(5) NOT NULL UNIQUE
);

CREATE TABLE Resolution (
    id_resolution SERIAL PRIMARY KEY,
    nom_resolution VARCHAR(100) NOT NULL
);

CREATE TABLE Parametre (
    id_parametre SERIAL PRIMARY KEY,
    
    valeur DECIMAL(10,2) NOT NULL,
    
    id_matiere INT NOT NULL,
    id_operateur INT NOT NULL,
    id_resolution INT NOT NULL,

    CONSTRAINT fk_parametre_matiere
        FOREIGN KEY (id_matiere)
        REFERENCES Matiere(id_matiere)
        ON DELETE CASCADE
    
    CONSTRAINT fk_parametre_operateur
        FOREIGN KEY (id_operateur)
        REFERENCES Operateur(id_operateur)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_parametre_resolution
        FOREIGN KEY (id_resolution)
        REFERENCES Resolution(id_resolution)
        ON DELETE CASCADE,
);