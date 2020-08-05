create table avaliacao_produto (
  id bigint generated by default as identity,
  data_avaliacao timestamp,
  id_produto bigint,
  nota integer,
  primary key (id)
);

create table categoria (
  categoria varchar(255) not null,
  data_processamento timestamp,
  quantidade integer, primary key (categoria));

create table ocorrencia_venda (
  id bigint generated by default as identity,
  data_venda timestamp,
  id_produto bigint,
  quantidade integer,
  primary key (id)
);

create table produto (
  id bigint generated by default as identity,
  categoria varchar(255),
  data_criacao timestamp,
  descricao varchar(255),
  id_produto bigint,
  nome varchar(255),
  primary key (id)
);

