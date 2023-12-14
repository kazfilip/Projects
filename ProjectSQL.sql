CREATE TABLE Diabelski_Owoc (
    ID integer  NOT NULL,
    Nazwa char(15)  NOT NULL,
    CONSTRAINT Diabelski_Owoc_pk PRIMARY KEY (ID)
) ;


CREATE TABLE Imperator_Morz (
    ID integer  NOT NULL,
    Pirat_ID integer  NOT NULL,
    Bron char(20)  NOT NULL,
    CONSTRAINT Imperator_Morz_pk PRIMARY KEY (ID)
) ;


CREATE TABLE Konflikt_Piratow (
    ID integer  NOT NULL,
    Pirat_ID integer  NOT NULL,
    Pirat_2_ID integer  NOT NULL,
    CONSTRAINT Konflikt_Piratow_pk PRIMARY KEY (ID)
) ;


CREATE TABLE Konflikt_Zalog (
    ID integer  NOT NULL,
    Zaloga_ID integer  NOT NULL,
    Zaloga_2_ID integer  NOT NULL,
    CONSTRAINT Konflikt_Zalog_pk PRIMARY KEY (ID)
) ;

CREATE TABLE Krol_Piratow (
    ID integer  NOT NULL,
    Pirat_ID integer  NOT NULL,
    Data_Odnalezienia_Skarbu date  NOT NULL,
    CONSTRAINT Krol_Piratow_pk PRIMARY KEY (ID)
) ;

CREATE TABLE Pirat (
    ID integer  NOT NULL,
    Imie char(20)  NOT NULL,
    Nazwisko char(20)  NOT NULL,
    Data_smierci date  NULL,
    Diabelski_Owoc_ID integer  NULL,
    Zaloga_ID integer  NULL ,
    CONSTRAINT Pirat_pk PRIMARY KEY (ID)
) ;


CREATE TABLE Statek (
    ID integer  NOT NULL,
    Nazwa char(20)  NOT NULL,
    Zaloga_ID integer  NOT NULL,
    Size integer NOT NULL ,
    CONSTRAINT Statek_pk PRIMARY KEY (ID)
) ;

CREATE TABLE Wladcy_Morz (
    ID integer  NOT NULL,
    Pirat_ID integer  NOT NULL,
    CONSTRAINT Wladcy_Morz_pk PRIMARY KEY (ID)
) ;

CREATE TABLE Zaloga (
    ID integer  NOT NULL,
    Nazwa char(30)  NOT NULL,
    CONSTRAINT Zaloga_pk PRIMARY KEY (ID)
) ;

ALTER TABLE Imperator_Morz ADD CONSTRAINT Imperator_Morz_Pirat
    FOREIGN KEY (Pirat_ID)
    REFERENCES Pirat (ID);

ALTER TABLE Konflikt_Piratow ADD CONSTRAINT Konflikt_Pirat_1
    FOREIGN KEY (Pirat_ID)
    REFERENCES Pirat (ID);

ALTER TABLE Konflikt_Piratow ADD CONSTRAINT Konflikt_Pirat_2
    FOREIGN KEY (Pirat_2_ID)
    REFERENCES Pirat (ID);
ALTER TABLE Konflikt_Zalog ADD CONSTRAINT Konflikt_Zaloga_1
    FOREIGN KEY (Zaloga_ID)
    REFERENCES Zaloga (ID);

ALTER TABLE Konflikt_Zalog ADD CONSTRAINT Konflikt_Zaloga_2
    FOREIGN KEY (Zaloga_2_ID)
    REFERENCES Zaloga (ID);

ALTER TABLE Krol_Piratow ADD CONSTRAINT Krol_Piratow_Pirat
    FOREIGN KEY (Pirat_ID)
    REFERENCES Pirat (ID);

ALTER TABLE Pirat ADD CONSTRAINT Pirat_Diabelski_Owoc
    FOREIGN KEY (Diabelski_Owoc_ID)
    REFERENCES Diabelski_Owoc (ID);

ALTER TABLE Pirat ADD CONSTRAINT Pirat_Zaloga
    FOREIGN KEY (Zaloga_ID)
    REFERENCES Zaloga (ID);

ALTER TABLE Statek ADD CONSTRAINT Statek_Zaloga
    FOREIGN KEY (Zaloga_ID)
    REFERENCES Zaloga (ID);

ALTER TABLE Wladcy_Morz ADD CONSTRAINT Wladcy_Morz_Pirat
    FOREIGN KEY (Pirat_ID)
    REFERENCES Pirat (ID);




INSERT INTO ZALOGA(ID, Nazwa)
VALUES (1,'Zaloga Slomkowego Kapelusza');
INSERT INTO ZALOGA(ID, Nazwa)
VALUES (2,'Piraci Bestii');
INSERT INTO ZALOGA(id, nazwa)
VALUES (3,'Zaloga Big Mom');
INSERT INTO ZALOGA(id, nazwa)
VALUES (4,'Piraci Rogera');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES (1,'Gum-Gum-Owoc');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES (2,'Dusz-Dusz-Owoc');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES (3,'Ryb-Ryb-Owoc');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES (4,'ludz-ludziowoc');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES (5,'kwiat-kwiatowoc');
INSERT INTO Diabelski_Owoc(id, nazwa)
VALUES(6,'Oz-ozywowoc');
INSERT INTO Pirat (ID, Imie, Nazwisko, Data_smierci, Diabelski_Owoc_ID, Zaloga_ID)
VALUES (1,'Luffy','Monkey D.',null,1,1);
INSERT INTO Pirat (ID, Imie, Nazwisko, Data_smierci, Diabelski_Owoc_ID, Zaloga_ID)
VALUES (2,'Zoro','Roronoa',null,null,1);
INSERT INTO Pirat (ID, Imie, Nazwisko, Data_smierci, Diabelski_Owoc_ID, Zaloga_ID)
VALUES (3,'Nami',' ',null,null,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (4,'Kaidou',' ',null,3,2);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (5,'Charlotte','Linlin',null,2,3);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (6,'Roger','Gol D.',to_date('1011-11-03','yyyy-mm-dd'),null,4);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (7,'Dracule','Mihawk',null,null,null);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (8,'Usopp',' ',null,null,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (9,'Sanji','Vinsmoke',null,null,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (10,'Chopper','Tony Tony',null,4,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (11,'Robin','Nico',null,5,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (12,'Franky',' ',null,null,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (13,'Brook',' ',to_date('987-12-17','yyyy-mm-dd'),6,1);
INSERT INTO PIRAT(id, imie, nazwisko, data_smierci, diabelski_owoc_id, zaloga_id)
VALUES (14,'Jinbe',' ',null,null,1);


INSERT INTO KROL_PIRATOW(id, pirat_id, data_odnalezienia_skarbu)
VALUES (1,6,to_date('1009-08-24','yyyy-mm-dd'));

SELECT *
FROM Pirat;

SELECT *
FROM KROL_PIRATOW;

INSERT INTO IMPERATOR_MORZ(id, pirat_id, bron)
VALUES(1,4,'Hassaikai');
INSERT INTO IMPERATOR_MORZ(id, pirat_id, bron)
VALUES (2,5,'Napoleon');

INSERT INTO KONFLIKT_PIRATOW(id, pirat_id, pirat_2_id)
VALUES (1,1,5);



INSERT INTO STATEK(id, nazwa, zaloga_id, size)
VALUES (1,'Sunny',1, 30);


INSERT INTO STATEK(id, nazwa, zaloga_id, size)
VALUES (2,'Queen Mama Chanter',3, 400);

INSERT INTO Statek(id, nazwa, zaloga_id, size)
VALUES (3,'Mammoth',2,50);

INSERT INTO Statek(id, nazwa, zaloga_id, size)
VALUES (4,'Queens Ship',2,50);

INSERT INTO Statek(id, nazwa, zaloga_id, size)
VALUES (5,'Scratcham Apoos Ship',2,200);

INSERT INTO Statek(id, nazwa, zaloga_id, size)
VALUES (6,'Oro Jackson',4,150);


INSERT INTO WLADCY_MORZ(id, pirat_id)
VALUES (1,7) ;

INSERT INTO KONFLIKT_ZALOG(id, zaloga_id, zaloga_2_id)
VALUES (1,1,2);

SELECT *
FROM Pirat;

SELECT Imie
FROM Pirat;

SELECT *
FROM ZALOGA;

SELECT ID
FROM DIABELSKI_OWOC
WHERE ID = 1;
--------------------------------------------Projekt 3
-----zad1
SELECT *
FROM Pirat p1
JOIN Statek S on p1.Zaloga_ID = S.Zaloga_ID
WHERE p1.ID = 1;

SELECT *
FROM Pirat p1
JOIN Diabelski_Owoc DO on DO.ID = p1.Diabelski_Owoc_ID
WHERE DO.ID > 3;

-----zad2
SELECT COUNT (*)
FROM Pirat
WHERE Pirat.Zaloga_ID = 1;

SELECT (MAX(Size))
FROM Statek;

-----zad3
SELECT *
FROM Pirat
WHERE Pirat.Zaloga_ID = (SELECT MIN(Pirat.Zaloga_ID)
                         FROM Pirat);
-----zad4
SELECT Diabelski_Owoc_ID,Imie
FROM Pirat
WHERE EXISTS(
    SELECT ID,Nazwa
    FROM Diabelski_Owoc
    WHERE Pirat.Diabelski_Owoc_ID = Diabelski_Owoc.ID
);












