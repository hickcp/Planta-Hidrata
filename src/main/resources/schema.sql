CREATE TABLE plantas (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  nome_cientifico varchar(255) NOT NULL,
  PRIMARY KEY (id)
);



CREATE TABLE planta_informacoes (
  id int NOT NULL AUTO_INCREMENT,
  id_planta int NOT NULL,
  luz_solar float NOT NULL,
  umidade float NOT NULL,
  temperatura float NOT NULL,
  regar BOOLEAN DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_planta FOREIGN KEY (id_planta) REFERENCES plantas (id)
);

