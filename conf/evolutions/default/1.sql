# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table client;

drop table person;

drop table product;

SET FOREIGN_KEY_CHECKS=1;

