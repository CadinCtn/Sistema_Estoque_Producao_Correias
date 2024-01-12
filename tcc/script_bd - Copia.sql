CREATE DATABASE bd_linkagro;
USE bd_linkagro;

CREATE TABLE usuarios (
  id int NOT NULL AUTO_INCREMENT,
  login varchar(50) NOT NULL,
  senha varchar(15) NOT NULL,
  permissao varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
); 

CREATE TABLE produtos (
  produto varchar(50) NOT NULL,
  cor_produto varchar(50) not null,
  PRIMARY KEY (produto)
); 


CREATE TABLE estoque (
  id int NOT NULL AUTO_INCREMENT,
  categoria varchar(50) NOT NULL,
  lonas int NOT NULL,
  largura float(4,2) NOT NULL,
  metragem float(5,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria) REFERENCES produtos (produto)
); 


CREATE TABLE ordem_producao (
  id int AUTO_INCREMENT,
  categoria varchar(50) NOT NULL,
  EE int NOT NULL,
  largura_tecido float(4,2) NOT NULL,
  metragem_tecido float(5,2) NOT NULL,
  lonas int NOT NULL,
  setor varchar(20) not NULL,
  observacao varchar(500) not NULL,
  espessura varchar(50) not NULL,
  met_extra float(4,2) not  NULL,
  status varchar(100) not null,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria) REFERENCES produtos (produto)
); 


CREATE TABLE pedidos (
  id int NOT NULL,
  nome_cliente varchar(255) NOT NULL,
  data_fechamento varchar(10) not NULL,
  data_embarque varchar(10) not NULL,
  observacao varchar(500) not NULL,
  status varchar(100) not null,
  PRIMARY KEY (id)
); 


CREATE TABLE pedidos_op (
  vinc int NOT NULL AUTO_INCREMENT,
  id_op int NOT NULL,
  id int NOT NULL,
  nome_cliente varchar(255) NOT NULL,
  largura float(4,2) not NULL,
  metragem float(5,2) not NULL,
  PRIMARY KEY (vinc),
  FOREIGN KEY (id_op) REFERENCES ordem_producao (id),
  foreign key (id) REFERENCES pedidos(id)
); 



Create Table relatorios_op(
  id int not null,
  
  cal_dataInicio varchar(10) not null,
  cal_horaInicio varchar(5) not null,
  cal_horaFim varchar(5) not null,
  cal_dataFim varchar(10) not null,
  cal_espessura varchar(50) not null,
  cal_responsavel varchar(100) not null,
  cal_obs varchar(500),
  
  pre_dataInicio varchar(10) not null,
  pre_horaInicio varchar(5) not null,
  pre_horaFim varchar(5) not null,
  pre_dataFim varchar(10) not null,
  pre_tempo varchar(5) not null,
  pre_responsavel varchar(100) not null,
  pre_obs varchar(500),

  cor_dataInicio varchar(10) not null,
  cor_horaInicio varchar(5) not null,
  cor_horaFim varchar(5) not null,
  cor_dataFim varchar(10) not null,
  cor_concerto varchar(3) not null,
  cor_responsavel varchar(100) not null,
  cor_obs varchar(500),
  
  primary key(id),
  foreign key(id) references ordem_producao(id)
);




insert into usuarios (login,senha,permissao) values ("cris","2404","ADM")