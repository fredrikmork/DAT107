-- SQL for en-til-mange-eksemplet gjennomgått i timen tirsdag 3. april 

DROP SCHEMA IF EXISTS forelesning3 CASCADE;
CREATE SCHEMA forelesning3;
SET search_path TO forelesning3;
    
CREATE TABLE En
(
    CONSTRAINT ??? PRIMARY KEY (???)
);

CREATE TABLE Mange
(
    CONSTRAINT ??? PRIMARY KEY (???),
    CONSTRAINT ??? UNIQUE (???, ???, ???, ???),
    CONSTRAINT ??? FOREIGN KEY (???) REFERENCES ???(???)
);


INSERT INTO
  En(???, ???, ???)
VALUES
    (...),
    (...),
    (...);
    
INSERT INTO
  Mange(???, ???, ???)
VALUES
    (...),
    (...),
    (...);
    

