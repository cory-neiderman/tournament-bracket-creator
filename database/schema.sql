-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE SEQUENCE app_user_id_seq
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
	
CREATE TABLE app_user (
	user_id integer NOT NULL DEFAULT nextval('app_user_id_seq'),
	user_name varchar(20) UNIQUE NOT NULL,
	password varchar(32) NOT NULL,
	user_role varchar(20),
	CONSTRAINT pk_app_user_user_id PRIMARY KEY (user_id)
	);
	
CREATE SEQUENCE tournament_id_seq
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
	
CREATE TABLE tournament (
	tournament_id integer NOT NULL DEFAULT nextval('tournament_id_seq')
	sport varchar(20) NOT NULL,
	tournament_name varchar(50) UNIQUE NOT NULL,
	champion_id integer,
	start_date date,
	end_date date,
	min_teams integer,
	max_teams integer,
	CONSTRAINT pk_tournament_tournament_id PRIMARY KEY (tournament_id)
	);

CREATE SEQUENCE competitor_id_sequence
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
	
CREATE TABLE competitor (
	competitor_id integer NOT NULL DEFAULT nextval('competitor_id_seq')
	competitor_name varchar(50) UNIQUE NOT NULL,
	CONSTRAINT pk_competitor_competitor_id PRIMARY KEY (competitor_id)
	);
	
CREATE TABLE tournament_competitor (
    tournament_id integer NOT NULL,
    competitor_id integer NOT NULL,
    CONSTRAINT pk_tournament_competitor_tournament_id_competitor_id PRIMARY KEY (tournament_id, competitor_id)
	);

CREATE TABLE app_user_competitor (
	user_id integer NOT NULL,
	competitor_id integer NOT NULL,
	CONSTRAINT pk_app_user_competitor_user_id_competitor_id PRIMARY KEY (user_id, competitor_id)
	);

COMMIT;