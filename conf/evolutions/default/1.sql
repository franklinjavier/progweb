# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog (
  id                        bigint auto_increment not null,
  header                    varchar(255),
  text                      TEXT,
  constraint pk_blog primary key (id))
;

create table client (
  cod_cliente               integer auto_increment not null,
  nome                      varchar(255),
  cpf                       varchar(255),
  cnpj                      varchar(255),
  endereco                  varchar(255),
  cartao_credito            varchar(255),
  constraint pk_client primary key (cod_cliente))
;

create table comment (
  id                        bigint auto_increment not null,
  text                      varchar(255),
  blog_id                   bigint,
  constraint pk_comment primary key (id))
;

create table person (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

alter table comment add constraint fk_comment_blog_1 foreign key (blog_id) references blog (id) on delete restrict on update restrict;
create index ix_comment_blog_1 on comment (blog_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table blog;

drop table client;

drop table comment;

drop table person;

SET FOREIGN_KEY_CHECKS=1;

