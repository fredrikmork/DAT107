-- SQL for en-til-mange-eksemplet gjennomgått i timen fredag 6. april 

DROP SCHEMA IF EXISTS todo_schema CASCADE;
CREATE SCHEMA todo_schema;
SET search_path TO todo_schema;
    
CREATE TABLE Todoliste
(
    ListeId     SERIAL,
    Navn        VARCHAR,
    CONSTRAINT TodolistePN PRIMARY KEY (ListeId)
);

CREATE TABLE Todo
(
    TodoId      SERIAL,
    Tekst       VARCHAR,
    ListeId     INTEGER,
    CONSTRAINT TodoPN PRIMARY KEY (TodoId),
    CONSTRAINT ListeFN FOREIGN KEY (ListeId) REFERENCES Todoliste(ListeId)
);
