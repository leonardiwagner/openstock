CREATE TABLE account
(
  id serial NOT NULL,
  email character varying(255) NOT NULL,
  balance numeric NOT NULL,
  created timestamp without time zone NOT NULL,
  CONSTRAINT "PK_ACCOUNT" PRIMARY KEY (id)
);