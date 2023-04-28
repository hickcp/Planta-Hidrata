CREATE DATABASE planta;

use planta;

CREATE TABLE plantas (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  nome_cientifico VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE planta_informacoes (
  id INT NOT NULL AUTO_INCREMENT,
  id_planta INT NOT NULL,
  luz_solar FLOAT NOT NULL,
  umidade FLOAT NOT NULL,
  temperatura FLOAT NOT NULL,
  regar TINYINT(1) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_planta) REFERENCES plantas(id)
);

insert into plantas(nome, nome_cientifico) values('verinha', 'aloe vera');

insert into planta_informacoes(id_planta, luz_solar, umidade, temperatura, regar)
	values(1, 10.0, 20.0, 30.0, 1);

insert into plantas(nome, nome_cientifico) values('espinhozinho', 'cactus');

insert into planta_informacoes(id_planta, luz_solar, umidade, temperatura, regar)
	values(2, 40.0, 50.0, 60.0, 1);

insert into planta_informacoes(id_planta, luz_solar, umidade, temperatura, regar)
	values(2, 45.0, 55.0, 65.0, 1);