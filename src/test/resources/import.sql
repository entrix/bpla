
--DROP TABLE bpla_journal


DROP TABLE aggregate IF EXISTS



DROP TABLE bpla IF EXISTS



--DROP TABLE det_journal



DROP TABLE detail IF EXISTS



--DROP TABLE det_type



--DROP TABLE records



DROP TABLE warehouse IF EXISTS



CREATE TABLE aggregate (det_id INTEGER NULL IDENTITY PRIMARY KEY , bpla_id INTEGER NULL)
CREATE TABLE bpla ( bpla_id INTEGER NOT NULL IDENTITY PRIMARY KEY, state VARCHAR2(40) NULL , location VARCHAR2(40) NULL )
--CREATE TABLE bpla_journal (record_id  INTEGER NULL IDENTITY PRIMARY KEY, bpla_id  INTEGER NULL)
--CREATE TABLE det_journal(record_id INTEGER NULL IDENTITY PRIMARY KEY, det_id  INTEGER NULL)
CREATE TABLE det_type (det_type_id  INTEGER NOT NULL IDENTITY PRIMARY KEY, det_name CHAR(50) NULL , det_weight INTEGER NULL , det_size VARCHAR2(40) NULL)
CREATE TABLE detail (det_id INTEGER NOT NULL IDENTITY PRIMARY KEY, det_type_id  INTEGER NULL, state   VARCHAR2(40) NULL ,  raids INTEGER NULL )
--CREATE TABLE records (record_id INTEGER NOT NULL IDENTITY PRIMARY KEY, rec_state VARCHAR2(40) NULL , date_time DATE NULL , storage_id INTEGER NULL , notes  VARCHAR2(200) NULL )
CREATE TABLE warehouse (storage_id  INTEGER NOT NULL IDENTITY PRIMARY KEY, stor_type  VARCHAR2(20) NULL , address  VARCHAR2(20) NULL )

insert into det_type(det_type_id, det_name, det_weight, det_size) values (1,'фюзеляж',1000,'0.45x0.3x0.2')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (2,'левая консоль крыла',1000,'0.7x0.03x0.2')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (3,'правая консоль крыла',1000,'0.7x0.03x0.2')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (4,'хвостовая балка',1000,'0.5x0.01x0.2')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (5,'хвостовое оперение',1000,'0.1x0.1x0.1')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (6,'винты',1000,'0.3x0.03x0.01')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (7,'силовая установка',1000,'0.1x0.1x0.1')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (8,'микропилот',1000,'0.1x0.1x0.03')
insert into det_type(det_type_id, det_name, det_weight, det_size) values (9,'фотоаппаратура',1000,'0.18x0.2x0.15')

insert into detail(det_id, det_type_id, state, raids) values (1,1,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (2,1,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (3,1,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (4,2,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (5,2,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (6,2,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (7,3,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (8,3,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (9,3,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (10,4,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (11,4,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (12,4,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (13,5,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (14,5,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (15,5,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (16,6,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (17,6,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (18,6,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (19,7,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (20,7,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (21,7,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (22,8,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (23,8,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (24,8,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (25,9,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (26,9,'эксплуатируется',0)
insert into detail(det_id, det_type_id, state, raids) values (27,9,'эксплуатируется',0)

insert into bpla(bpla_id, state, location) values (1,'эксплуатируется','Москва')
insert into bpla(bpla_id, state, location) values (2,'эксплуатируется','Санкт-Петербург')
insert into bpla(bpla_id, state, location) values (3,'эксплуатируется','Сочи')

insert into aggregate(bpla_id, det_id) values (1,1)
insert into aggregate(bpla_id, det_id) values (1,4)
insert into aggregate(bpla_id, det_id) values (1,7)
insert into aggregate(bpla_id, det_id) values (1,10)
insert into aggregate(bpla_id, det_id) values (1,13)
insert into aggregate(bpla_id, det_id) values (1,16)
insert into aggregate(bpla_id, det_id) values (1,19)
insert into aggregate(bpla_id, det_id) values (1,22)
insert into aggregate(bpla_id, det_id) values (1,25)

insert into aggregate(bpla_id, det_id) values (2,2)
insert into aggregate(bpla_id, det_id) values (2,5)
insert into aggregate(bpla_id, det_id) values (2,8)
insert into aggregate(bpla_id, det_id) values (2,11)
insert into aggregate(bpla_id, det_id) values (2,14)
insert into aggregate(bpla_id, det_id) values (2,17)
insert into aggregate(bpla_id, det_id) values (2,20)
insert into aggregate(bpla_id, det_id) values (2,23)
insert into aggregate(bpla_id, det_id) values (2,26)

insert into aggregate(bpla_id, det_id) values (3,3)
insert into aggregate(bpla_id, det_id) values (3,6)
insert into aggregate(bpla_id, det_id) values (3,9)
insert into aggregate(bpla_id, det_id) values (3,12)
insert into aggregate(bpla_id, det_id) values (3,15)
insert into aggregate(bpla_id, det_id) values (3,18)
insert into aggregate(bpla_id, det_id) values (3,21)
insert into aggregate(bpla_id, det_id) values (3,24)
insert into aggregate(bpla_id, det_id) values (3,27)


insert into warehouse(storage_id, stor_type, address) values (1,'филиал','Москва')
insert into warehouse(storage_id, stor_type, address) values (2,'филиал','Санкт-Петербург')
insert into warehouse(storage_id, stor_type, address) values (3,'филиал','Сочи')

