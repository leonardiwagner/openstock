CREATE TABLE stockdata
(
  "id" serial NOT NULL,
  "stockid" int NOT NULL,
  "date" timestamp without time zone NOT NULL,
  "value" numeric NOT NULL,
  "change" numeric NOT NULL,

  CONSTRAINT "PK_STOCKDATA" PRIMARY KEY (id),
  CONSTRAINT "FK_STOCKDATA_DATA" FOREIGN KEY (stockid)
        REFERENCES stock (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);