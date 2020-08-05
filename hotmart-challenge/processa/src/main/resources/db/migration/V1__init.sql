create table avaliacao_produto (
  id bigint AUTO_INCREMENT,
  data_avaliacao datetime(6),
  id_produto bigint,
  nota integer,
  primary key (id)
);

create table categoria (
  categoria varchar(255) not null,
  data_processamento datetime(6),
  quantidade integer, primary key (categoria));

create table ocorrencia_venda (
  id bigint AUTO_INCREMENT,
  data_venda datetime(6),
  id_produto bigint,
  quantidade integer,
  primary key (id)
);

create table produto (
  id bigint AUTO_INCREMENT,
  id_produto bigint,
  nome varchar(255),
  descricao varchar(255),
  categoria varchar(255),
  data_criacao datetime(6),
  score double,
  primary key (id)
);
