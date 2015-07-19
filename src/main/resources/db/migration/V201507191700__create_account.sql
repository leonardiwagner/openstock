CREATE TABLE account
(
  id serial NOT NULL,
  email character varying(255),
  balance numeric,
  created timestamp without time zone,
  CONSTRAINT "PK_ACCOUNT" PRIMARY KEY (id)
)