CREATE TABLE rsmc
(
	rsmc_id		  INTEGER  NOT NULL ,
	rsmc_name	  VARCHAR2(20)  NULL ,
	rsmc_type	  INTEGER  NULL 
);

CREATE TABLE station_delegation
(
	delegation_id INTEGER  NOT NULL ,
	rsmc_id		  INTEGER  NOT NULL ,
	point_id	  INTEGER  NOT NULL 
);

CREATE TABLE station_point
(
	point_id	  INTEGER  NOT NULL ,
	point_name    VARCHAR2(20)  NULL ,
	latitude	  NUMBER  NULL ,
	longitude	  NUMBER  NULL ,
	sea_height	  NUMBER  NULL 
);

CREATE TABLE wind
(
	wind_id		  INTEGER  NOT NULL ,
	point_id	  INTEGER  NOT NULL ,
	type		  INTEGER  NULL ,
	datetime	  DATE  NULL ,
	prediction	  INTEGER  NULL ,
	course		  NUMBER  NULL ,
	force		  NUMBER  NULL
);
