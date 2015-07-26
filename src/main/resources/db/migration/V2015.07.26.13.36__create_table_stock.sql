CREATE TABLE stock
(
  "id" serial NOT NULL,
  "name" character varying(4) NOT NULL,
  "fullName" character varying(100) NOT NULL,
  "currentValue" numeric NOT NULL,
  "lastChange" numeric NOT NULL,
  "lastChangeDate" timestamp without time zone NOT NULL,
  CONSTRAINT "PK_STOCK" PRIMARY KEY (id)
);