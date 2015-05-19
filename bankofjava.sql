--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2015-05-19 18:29:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 24577)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE account (
    email character varying,
    balance numeric,
    created timestamp with time zone,
    id integer NOT NULL
);


ALTER TABLE account OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 24591)
-- Name: account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE account_id_seq OWNER TO postgres;

--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 173
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE account_id_seq OWNED BY account.id;


--
-- TOC entry 175 (class 1259 OID 32770)
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE stock (
    id integer NOT NULL,
    name character varying,
    currentvalue numeric,
    lastchange numeric,
    lastchangedate timestamp with time zone,
    fullname character varying
);


ALTER TABLE stock OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 32768)
-- Name: stock_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stock_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stock_id_seq OWNER TO postgres;

--
-- TOC entry 2031 (class 0 OID 0)
-- Dependencies: 174
-- Name: stock_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stock_id_seq OWNED BY stock.id;


--
-- TOC entry 177 (class 1259 OID 32781)
-- Name: stockdata; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE stockdata (
    id integer NOT NULL,
    stockid integer,
    date timestamp with time zone,
    value numeric,
    change numeric
);


ALTER TABLE stockdata OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 32779)
-- Name: stockdata_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stockdata_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stockdata_id_seq OWNER TO postgres;

--
-- TOC entry 2032 (class 0 OID 0)
-- Dependencies: 176
-- Name: stockdata_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stockdata_id_seq OWNED BY stockdata.id;


--
-- TOC entry 1896 (class 2604 OID 24593)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY account ALTER COLUMN id SET DEFAULT nextval('account_id_seq'::regclass);


--
-- TOC entry 1897 (class 2604 OID 32773)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stock ALTER COLUMN id SET DEFAULT nextval('stock_id_seq'::regclass);


--
-- TOC entry 1898 (class 2604 OID 32784)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stockdata ALTER COLUMN id SET DEFAULT nextval('stockdata_id_seq'::regclass);


--
-- TOC entry 2016 (class 0 OID 24577)
-- Dependencies: 172
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY account (email, balance, created, id) FROM stdin;
julius@julius.com	0	2015-05-10 00:25:13.463-03	2
test@user.com	0	2015-05-10 19:35:50.756-03	3
\.


--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 173
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('account_id_seq', 3, true);


--
-- TOC entry 2019 (class 0 OID 32770)
-- Dependencies: 175
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stock (id, name, currentvalue, lastchange, lastchangedate, fullname) FROM stdin;
25	MSFT	48.4	0.22000122	2015-05-17 17:00:45.879-03	Microsoft
26	KO	40.5	-0.27000046	2015-05-17 17:00:46.303-03	Coca-Cola
27	MCD	96.73	0.6800003	2015-05-17 17:00:46.707-03	Mc Donalds
34	BAC	15.92	-0.20000076	2015-05-17 17:00:47.095-03	Bank Of America
35	AAPL	125.3	-2.9599915	2015-05-17 17:00:48.384-03	Apple
36	CSCO	28.78	-0.289999	2015-05-17 17:00:48.8-03	Cisco
37	GE	26.99	-0.26000023	2015-05-17 17:00:49.215-03	General Eletronics
38	PBR	9.35	-0.21000004	2015-05-17 17:00:49.659-03	Petobras
\.


--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 174
-- Name: stock_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stock_id_seq', 38, true);


--
-- TOC entry 2021 (class 0 OID 32781)
-- Dependencies: 177
-- Data for Name: stockdata; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stockdata (id, stockid, date, value, change) FROM stdin;
51	25	2015-05-15 00:00:00-03	48.05	0
52	25	2015-05-14 00:00:00-03	48.03	0
53	25	2015-05-13 00:00:00-03	47.57	0
54	25	2015-05-12 00:00:00-03	46.42	0
55	25	2015-05-11 00:00:00-03	47.37	0
56	25	2015-05-08 00:00:00-03	47.52	0
57	25	2015-05-07 00:00:00-03	46.16	0
58	25	2015-05-06 00:00:00-03	46.02	0
59	25	2015-05-05 00:00:00-03	47.31	0
60	25	2015-05-04 00:00:00-03	48.18	0
61	25	2015-05-01 00:00:00-03	48.4	0
62	26	2015-05-15 00:00:00-03	41.43	0
63	26	2015-05-14 00:00:00-03	41.26	0
64	26	2015-05-13 00:00:00-03	40.72	0
65	26	2015-05-12 00:00:00-03	40.52	0
66	26	2015-05-11 00:00:00-03	40.88	0
67	26	2015-05-08 00:00:00-03	40.85	0
68	26	2015-05-07 00:00:00-03	40.51	0
69	26	2015-05-06 00:00:00-03	40.39	0
70	26	2015-05-05 00:00:00-03	40.68	0
71	26	2015-05-04 00:00:00-03	40.77	0
72	26	2015-05-01 00:00:00-03	40.5	0
73	27	2015-05-15 00:00:00-03	97.54	0
74	27	2015-05-14 00:00:00-03	97.28	0
75	27	2015-05-13 00:00:00-03	97.28	0
76	27	2015-05-12 00:00:00-03	96.92	0
77	27	2015-05-11 00:00:00-03	97.15	0
78	27	2015-05-08 00:00:00-03	97.79	0
79	27	2015-05-07 00:00:00-03	96.12	0
80	27	2015-05-06 00:00:00-03	95.88	0
81	27	2015-05-05 00:00:00-03	95.57	0
82	27	2015-05-04 00:00:00-03	96.05	0
83	27	2015-05-01 00:00:00-03	96.73	0
84	34	2015-05-15 00:00:00-03	16.3	0
85	34	2015-05-14 00:00:00-03	16.45	0
86	34	2015-05-13 00:00:00-03	16.36	0
87	34	2015-05-12 00:00:00-03	16.35	0
88	34	2015-05-11 00:00:00-03	16.43	0
89	34	2015-05-08 00:00:00-03	16.22	0
90	34	2015-05-07 00:00:00-03	16.09	0
91	34	2015-05-06 00:00:00-03	16.08	0
92	34	2015-05-05 00:00:00-03	16.33	0
93	34	2015-05-04 00:00:00-03	16.12	0
94	34	2015-05-01 00:00:00-03	15.92	0
95	35	2015-05-15 00:00:00-03	128.21	0
96	35	2015-05-14 00:00:00-03	127.16	0
97	35	2015-05-13 00:00:00-03	125.87	0
98	35	2015-05-12 00:00:00-03	124.82	0
99	35	2015-05-11 00:00:00-03	125.63	0
100	35	2015-05-08 00:00:00-03	126.11	0
101	35	2015-05-07 00:00:00-03	124.02	0
102	35	2015-05-06 00:00:00-03	123.36	0
103	35	2015-05-05 00:00:00-03	125.78	0
104	35	2015-05-04 00:00:00-03	128.26	0
105	35	2015-05-01 00:00:00-03	125.3	0
106	36	2015-05-15 00:00:00-03	29.16	0
107	36	2015-05-14 00:00:00-03	28.97	0
108	36	2015-05-13 00:00:00-03	29.13	0
109	36	2015-05-12 00:00:00-03	28.8	0
110	36	2015-05-11 00:00:00-03	29.2	0
111	36	2015-05-08 00:00:00-03	28.99	0
112	36	2015-05-07 00:00:00-03	28.74	0
113	36	2015-05-06 00:00:00-03	28.69	0
114	36	2015-05-05 00:00:00-03	28.84	0
115	36	2015-05-04 00:00:00-03	29.07	0
116	36	2015-05-01 00:00:00-03	28.78	0
117	37	2015-05-15 00:00:00-03	27.25	0
118	37	2015-05-14 00:00:00-03	27.15	0
119	37	2015-05-13 00:00:00-03	26.92	0
120	37	2015-05-12 00:00:00-03	26.75	0
121	37	2015-05-11 00:00:00-03	26.86	0
122	37	2015-05-08 00:00:00-03	27.22	0
123	37	2015-05-07 00:00:00-03	26.66	0
124	37	2015-05-06 00:00:00-03	26.61	0
125	37	2015-05-05 00:00:00-03	26.85	0
126	37	2015-05-04 00:00:00-03	27.25	0
127	37	2015-05-01 00:00:00-03	26.99	0
128	38	2015-05-15 00:00:00-03	9.71	0
129	38	2015-05-14 00:00:00-03	9.77	0
130	38	2015-05-13 00:00:00-03	9.8	0
131	38	2015-05-12 00:00:00-03	9.64	0
132	38	2015-05-11 00:00:00-03	9.55	0
133	38	2015-05-08 00:00:00-03	9.54	0
134	38	2015-05-07 00:00:00-03	9.43	0
135	38	2015-05-06 00:00:00-03	9.64	0
136	38	2015-05-05 00:00:00-03	9.95	0
137	38	2015-05-04 00:00:00-03	9.56	0
138	38	2015-05-01 00:00:00-03	9.35	0
\.


--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 176
-- Name: stockdata_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stockdata_id_seq', 138, true);


--
-- TOC entry 1900 (class 2606 OID 24601)
-- Name: pk_account; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT pk_account PRIMARY KEY (id);


--
-- TOC entry 1902 (class 2606 OID 32778)
-- Name: pk_stock; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT pk_stock PRIMARY KEY (id);


--
-- TOC entry 1905 (class 2606 OID 32789)
-- Name: pk_stockdata; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY stockdata
    ADD CONSTRAINT pk_stockdata PRIMARY KEY (id);


--
-- TOC entry 1903 (class 1259 OID 32795)
-- Name: fki_stockdata_stock; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_stockdata_stock ON stockdata USING btree (stockid);


--
-- TOC entry 1906 (class 2606 OID 32790)
-- Name: fk_stockdata_stock; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stockdata
    ADD CONSTRAINT fk_stockdata_stock FOREIGN KEY (stockid) REFERENCES stock(id);


--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-05-19 18:29:43

--
-- PostgreSQL database dump complete
--

