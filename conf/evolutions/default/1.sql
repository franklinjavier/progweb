# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
  cod_cliente               integer auto_increment not null,
  nome                      varchar(255),
  cpf                       varchar(255),
  cnpj                      varchar(255),
  endereco                  varchar(255),
  cartao_credito            varchar(255),
  constraint pk_client primary key (cod_cliente))
;

create table person (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table client;

drop table person;

SET FOREIGN_KEY_CHECKS=1;

