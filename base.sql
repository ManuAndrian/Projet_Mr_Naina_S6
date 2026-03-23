
CREATE TABLE Demande (
    id_demande SERIAL INT,
    id_client INT,
    date_demande DATE,
    lieu VARCHAR('100'),
    district VARCHAR('100'),

    foreign key (id_client) references Client(id_client)
);



CREATE TABLE Client(
    id_client SERIAL INT,
    nom VARCHAR('100'),
    contact VARCHAR('100'),
    adresse (VARCHAR('100'))
);


CREATE TABLE TypeDevis(
    id_typeDevis SERIAL INT,
    type VARCHAR('100')
);


CREATE TABLE Devis(
    id_devis SERIAL INT,
    id_typeDevis INT,
    date_devis DATE,
    id_demande INT,
    montantTotal DECIMAL(10,2),
    
    foreign key (id_typeDevis) references TypeDevis(id_typeDevis);
    foreign key (id_demande) references Demande(id_demande)
);


CREATE TABLE DetailsDevis(
    id_detailsDevis SERIAL INT,
    id_devis INT,
    description VARCHAR('255'),
    prixUnitaire DECIMAL(10,2),
    foreign key (id_devis) references Devis(id_devis)
);

CREATE TABLE Statut(
    id_statut SERIAL INT,
    statut VARCHAR('100')
);

CREATE TABLE travaux(
    id_travaux SERIAL INT,
    id_demande INT,
    date_travaux DATE,
    foreign key (id_demande) references Demande(id_demande)
);

CREATE TABLE id_demande_statut(
    id_demande INT,
    id_statut INT,
    date_statut DATE,
    foreign key (id_demande) references Demande(id_demande),
    foreign key (id_statut) references Statut(id_statut)
);