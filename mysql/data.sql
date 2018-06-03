DROP SCHEMA IF EXISTS JavaSeniorJonatasRodrigues_db;

CREATE SCHEMA IF NOT EXISTS JavaSeniorJonatasRodrigues_db;
USE JavaSeniorJonatasRodrigues_db;

CREATE TABLE setor(
set_id int not null AUTO_INCREMENT,
set_descricao VARCHAR(255) NOT NULL,
constraint pk_setor PRIMARY KEY (set_id));

CREATE TABLE colaborador(
col_id int NOT NULL AUTO_INCREMENT,
set_id int NOT NULL,
col_nome VARCHAR(100) NOT NULL,
col_cpf VARCHAR(20) NULL,
col_telefone VARCHAR(20) NULL,
col_email VARCHAR(80) NULL,
constraint pk_colaborador PRIMARY KEY (col_id),
constraint fk_setor FOREIGN KEY (set_id) REFERENCES setor(set_id));

insert into setor(set_id,set_descricao) values (1,"Setor A");
insert into setor(set_id,set_descricao) values (2,"Setor B");
insert into setor(set_id,set_descricao) values (3,"Setor C");

COMMIT;
