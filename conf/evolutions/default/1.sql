# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cartao_credito (
  cod_pedido                bigint auto_increment not null,
  numero                    varchar(255),
  tipo                      varchar(255),
  data_exp                  datetime,
  last_update               datetime not null,
  constraint pk_cartao_credito primary key (cod_pedido))
;

create table cartao_debito (
  cod_pedido                bigint auto_increment not null,
  numero                    varchar(255),
  last_update               datetime not null,
  constraint pk_cartao_debito primary key (cod_pedido))
;

create table client (
  cod_cliente               bigint auto_increment not null,
  nome                      varchar(255),
  cpf                       varchar(255),
  cnpj                      varchar(255),
  endereco                  varchar(255),
  cartao_credito            varchar(255),
  last_update               datetime not null,
  constraint pk_client primary key (cod_cliente))
;

create table dinheiro (
  cod_pedido                bigint auto_increment not null,
  dinheiro_caixa            float,
  last_update               datetime not null,
  constraint pk_dinheiro primary key (cod_pedido))
;

create table nota_fiscal (
  cod_nota                  bigint auto_increment not null,
  num_nota                  bigint,
  descricao                 varchar(255),
  valor_total               float,
  last_update               datetime not null,
  constraint pk_nota_fiscal primary key (cod_nota))
;

create table pagamento (
  cod_pagamento             bigint auto_increment not null,
  valor_total               float,
  last_update               datetime not null,
  constraint pk_pagamento primary key (cod_pagamento))
;

create table pedido (
  cod_pedido                bigint auto_increment not null,
  data                      datetime,
  status                    varchar(255),
  valor_total               float,
  last_update               datetime not null,
  constraint pk_pedido primary key (cod_pedido))
;

create table pedido_detalhe (
  cod_pedido                bigint auto_increment not null,
  quantidade                bigint,
  tax_status                varchar(255),
  last_update               datetime not null,
  constraint pk_pedido_detalhe primary key (cod_pedido))
;

create table person (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create table product (
  cod_prod                  bigint auto_increment not null,
  nome                      varchar(255),
  preco_compra              float,
  preco_venda               float,
  qtd_estoque               bigint,
  last_update               datetime not null,
  constraint pk_product primary key (cod_prod))
;

create table user (
  id                        integer auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table cartao_credito;

drop table cartao_debito;

drop table client;

drop table dinheiro;

drop table nota_fiscal;

drop table pagamento;

drop table pedido;

drop table pedido_detalhe;

drop table person;

drop table product;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

