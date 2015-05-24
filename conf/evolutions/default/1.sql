# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog (
  id                        bigint not null,
  header                    varchar(255),
  text                      TEXT,
  constraint pk_blog primary key (id))
;

create table client (
  cod_cliente               integer not null,
  nome                      varchar(255),
  cpf                       varchar(255),
  cnpj                      varchar(255),
  endereco                  varchar(255),
  cartao_credito            varchar(255),
  constraint pk_client primary key (cod_cliente))
;

create table comment (
  id                        bigint not null,
  text                      varchar(255),
  blog_id                   bigint,
  constraint pk_comment primary key (id))
;

create table person (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create sequence blog_seq;

create sequence client_seq;

create sequence comment_seq;

create sequence person_seq;

alter table comment add constraint fk_comment_blog_1 foreign key (blog_id) references blog (id) on delete restrict on update restrict;
create index ix_comment_blog_1 on comment (blog_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists blog;

drop table if exists client;

drop table if exists comment;

drop table if exists person;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists blog_seq;

drop sequence if exists client_seq;

drop sequence if exists comment_seq;

drop sequence if exists person_seq;

