CREATE TABLE Plantas (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  nomeCientifico VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Planta_Informacoes (
  id INT NOT NULL AUTO_INCREMENT,
  id_planta INT NOT NULL,
  luz_solar FLOAT NOT NULL,
  umidade FLOAT NOT NULL,
  temperatura FLOAT NOT NULL,
  regar TINYINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_planta) REFERENCES Plantas(id)
);