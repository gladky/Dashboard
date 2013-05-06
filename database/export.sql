--------------------------------------------------------
--  File created - poniedziałek-maj-06-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ENTRIES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DASHBOARD"."ENTRIES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 49 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ENTRIES
--------------------------------------------------------

  CREATE TABLE "DASHBOARD"."ENTRIES" 
   (	"ENTRY_ID" NUMBER(3,0), 
	"PROJECT_ID" NUMBER(3,0), 
	"AMOUNT" NUMBER(2,0), 
	"ENTRY_DATE" DATE, 
	"OWNER_ID" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROJECTS
--------------------------------------------------------

  CREATE TABLE "DASHBOARD"."PROJECTS" 
   (	"PROJECT_ID" NUMBER(3,0), 
	"NAME" VARCHAR2(50 BYTE), 
	"HOURS_PER_WEEK" NUMBER(3,0), 
	"TOTAL_HOURS" NUMBER(6,0), 
	"PRIORITY" CHAR(1 BYTE), 
	"START_DATE" DATE, 
	"OWNER_ID" NUMBER(3,0), 
	"ACTIVE_WEEKEND" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "DASHBOARD"."USERS" 
   (	"NAME" VARCHAR2(40 BYTE), 
	"USER_ID" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into DASHBOARD.ENTRIES
SET DEFINE OFF;
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('5','1','2',to_date('13/03/29','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('8','1','5',to_date('13/04/03','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('9','1','4',to_date('13/04/04','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('1','1','0',to_date('13/03/21','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('2','1','10',to_date('13/03/22','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('3','1','2',to_date('13/03/27','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('4','1','0',to_date('13/03/28','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('10','1','5',to_date('13/04/05','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('11','1','5',to_date('13/04/06','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('7','1','0',to_date('13/04/02','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('17','1','0',to_date('13/04/10','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('15','1','6',to_date('13/04/09','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('18','1','5',to_date('13/04/16','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('19','1','5',to_date('13/04/17','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('22','1','2',to_date('13/04/18','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('20','1','11',to_date('13/04/19','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('21','4','20',to_date('13/04/20','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('6','4','15',to_date('13/04/06','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('23','6','1',to_date('13/04/01','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('24','6','20',to_date('13/04/05','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('25','6','1',to_date('13/04/20','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('27','1','4',to_date('13/04/20','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('28','7','1',to_date('13/04/20','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('29','1','4',to_date('13/04/21','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('30','8','1',to_date('13/04/22','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('31','1','7',to_date('13/04/23','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('32','6','2',to_date('13/04/23','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('33','1','5',to_date('13/04/25','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('34','4','1',to_date('13/04/25','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('35','4','1',to_date('13/04/26','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('36','1','4',to_date('13/04/26','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('37','6','1',to_date('13/04/26','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('38','4','4',to_date('13/04/28','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('39','4','3',to_date('13/04/29','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('40','7','1',to_date('13/04/29','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('41','6','2',to_date('13/04/30','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('42','4','4',to_date('13/04/30','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('43','6','1',to_date('13/05/01','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('47','4','1',to_date('13/05/02','RR/MM/DD'),'1');
Insert into DASHBOARD.ENTRIES (ENTRY_ID,PROJECT_ID,AMOUNT,ENTRY_DATE,OWNER_ID) values ('48','4','6',to_date('13/05/03','RR/MM/DD'),'1');
REM INSERTING into DASHBOARD.PROJECTS
SET DEFINE OFF;
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('1','NASK','20','480','a',to_date('13/03/27','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('2','Certyfikat-eng','5','90','c',to_date('13/03/28','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('3','Hiszpanski','4','480','c',to_date('13/03/28','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('4','Dyplom','15','666','a',to_date('13/04/11','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('5','Miasto','1','50','c',to_date('13/04/11','RR/MM/DD'),'1','y');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('6','Dashboard','4','50','b',to_date('13/04/01','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('7','Ksiazki','4','666','b',to_date('13/04/19','RR/MM/DD'),'1','y');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('8','Motoryzacja','2','666','b',to_date('13/04/22','RR/MM/DD'),'1','n');
Insert into DASHBOARD.PROJECTS (PROJECT_ID,NAME,HOURS_PER_WEEK,TOTAL_HOURS,PRIORITY,START_DATE,OWNER_ID,ACTIVE_WEEKEND) values ('9','Firma','2','666','b',to_date('13/04/22','RR/MM/DD'),'1','n');
REM INSERTING into DASHBOARD.USERS
SET DEFINE OFF;
Insert into DASHBOARD.USERS (NAME,USER_ID) values ('gladky','1');
--------------------------------------------------------
--  DDL for Index ENTRIES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "DASHBOARD"."ENTRIES_PK" ON "DASHBOARD"."ENTRIES" ("ENTRY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "DASHBOARD"."USERS_PK" ON "DASHBOARD"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PROJECTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "DASHBOARD"."PROJECTS_PK" ON "DASHBOARD"."PROJECTS" ("PROJECT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table ENTRIES
--------------------------------------------------------

  ALTER TABLE "DASHBOARD"."ENTRIES" MODIFY ("PROJECT_ID" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."ENTRIES" MODIFY ("ENTRY_ID" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."ENTRIES" MODIFY ("AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."ENTRIES" MODIFY ("ENTRY_DATE" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."ENTRIES" MODIFY ("OWNER_ID" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."ENTRIES" ADD CONSTRAINT "ENTRIES_PK" PRIMARY KEY ("ENTRY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROJECTS
--------------------------------------------------------

  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("HOURS_PER_WEEK" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("PRIORITY" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("PROJECT_ID" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."PROJECTS" ADD CONSTRAINT "PROJECTS_PK" PRIMARY KEY ("PROJECT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."PROJECTS" MODIFY ("OWNER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "DASHBOARD"."USERS" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."USERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "DASHBOARD"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ENTRIES
--------------------------------------------------------

  ALTER TABLE "DASHBOARD"."ENTRIES" ADD CONSTRAINT "ENTRY_OWNER" FOREIGN KEY ("OWNER_ID")
	  REFERENCES "DASHBOARD"."USERS" ("USER_ID") ENABLE;
  ALTER TABLE "DASHBOARD"."ENTRIES" ADD CONSTRAINT "ENTRY_TO_PROJECT" FOREIGN KEY ("PROJECT_ID")
	  REFERENCES "DASHBOARD"."PROJECTS" ("PROJECT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROJECTS
--------------------------------------------------------

  ALTER TABLE "DASHBOARD"."PROJECTS" ADD CONSTRAINT "PROJECT_OWNER" FOREIGN KEY ("OWNER_ID")
	  REFERENCES "DASHBOARD"."USERS" ("USER_ID") ENABLE;
