--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: candidat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidat (
    id_candidat integer NOT NULL,
    nom character varying(100) NOT NULL,
    prenom character varying(100) NOT NULL,
    date_naissance date,
    email character varying(150),
    telephone character varying(20)
);

ALTER TABLE public.candidat OWNER TO postgres;

--
-- Name: candidat_id_candidat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.candidat_id_candidat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.candidat_id_candidat_seq OWNER TO postgres;

--
-- Name: candidat_id_candidat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.candidat_id_candidat_seq OWNED BY public.candidat.id_candidat;


--
-- Name: correcteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.correcteur (
    id_correcteur integer NOT NULL,
    nom character varying(100) NOT NULL,
    prenom character varying(100) NOT NULL,
    email character varying(150),
    telephone character varying(20),
    specialite character varying(100)
);


ALTER TABLE public.correcteur OWNER TO postgres;

--
-- Name: correcteur_id_correcteur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.correcteur_id_correcteur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.correcteur_id_correcteur_seq OWNER TO postgres;

--
-- Name: correcteur_id_correcteur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.correcteur_id_correcteur_seq OWNED BY public.correcteur.id_correcteur;

--
-- Name: matiere; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matiere (
    id_matiere integer NOT NULL,
    nom_matiere character varying(100) NOT NULL,
    coefficient integer DEFAULT 1
);

ALTER TABLE public.matiere OWNER TO postgres;

--
-- Name: matiere_id_matiere_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matiere_id_matiere_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.matiere_id_matiere_seq OWNER TO postgres;

--
-- Name: matiere_id_matiere_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matiere_id_matiere_seq OWNED BY public.matiere.id_matiere;


--
-- Name: note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.note (
    id_note integer NOT NULL,
    id_candidat integer NOT NULL,
    id_matiere integer NOT NULL,
    id_correcteur integer NOT NULL,
    valeur numeric(5,2) NOT NULL,
    date_evaluation date DEFAULT CURRENT_DATE
);


ALTER TABLE public.note OWNER TO postgres;

--
-- Name: note_id_note_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.note_id_note_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.note_id_note_seq OWNER TO postgres;

--
-- Name: note_id_note_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.note_id_note_seq OWNED BY public.note.id_note;


--
-- Name: operateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operateur (
    id_operateur integer NOT NULL,
    signe character varying(5) NOT NULL
);

ALTER TABLE public.operateur OWNER TO postgres;

--
-- Name: operateur_id_operateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.operateur_id_operateur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.operateur_id_operateur_seq OWNER TO postgres;

--
-- Name: operateur_id_operateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.operateur_id_operateur_seq OWNED BY public.operateur.id_operateur;

--
-- Name: parametre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parametre (
    id_parametre integer NOT NULL,
    valeur numeric(10,2) NOT NULL,
    id_matiere integer NOT NULL,
    id_operateur integer NOT NULL,
    id_resolution integer NOT NULL
);


ALTER TABLE public.parametre OWNER TO postgres;

--
-- Name: parametre_id_parametre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parametre_id_parametre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.parametre_id_parametre_seq OWNER TO postgres;

--
-- Name: parametre_id_parametre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.parametre_id_parametre_seq OWNED BY public.parametre.id_parametre;


--
-- Name: resolution; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resolution (
    id_resolution integer NOT NULL,
    nom_resolution character varying(100) NOT NULL
);


ALTER TABLE public.resolution OWNER TO postgres;

--
-- Name: resolution_id_resolution_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resolution_id_resolution_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.resolution_id_resolution_seq OWNER TO postgres;

--
-- Name: resolution_id_resolution_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resolution_id_resolution_seq OWNED BY public.resolution.id_resolution;


--
-- Name: candidat id_candidat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidat ALTER COLUMN id_candidat SET DEFAULT nextval('public.candidat_id_candidat_seq'::regclass);


--
-- Name: correcteur id_correcteur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.correcteur ALTER COLUMN id_correcteur SET DEFAULT nextval('public.correcteur_id_correcteur_seq'::regclass);


--
-- Name: matiere id_matiere; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matiere ALTER COLUMN id_matiere SET DEFAULT nextval('public.matiere_id_matiere_seq'::regclass);


--
-- Name: note id_note; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note ALTER COLUMN id_note SET DEFAULT nextval('public.note_id_note_seq'::regclass);


--
-- Name: operateur id_operateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operateur ALTER COLUMN id_operateur SET DEFAULT nextval('public.operateur_id_operateur_seq'::regclass);


--
-- Name: parametre id_parametre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametre ALTER COLUMN id_parametre SET DEFAULT nextval('public.parametre_id_parametre_seq'::regclass);


--
-- Name: resolution id_resolution; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resolution ALTER COLUMN id_resolution SET DEFAULT nextval('public.resolution_id_resolution_seq'::regclass);


--
-- Data for Name: candidat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.candidat (id_candidat, nom, prenom, date_naissance, email, telephone) FROM stdin;
7	Canditat1	Jean	2002-05-10	0340000001	Java
8	Canditat2	Paul	2002-05-10	0340000002	Java
9	Canditat2	Marie	2002-05-10	0340000003	Java
\.


--
-- Data for Name: correcteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.correcteur (id_correcteur, nom, prenom, email, telephone, specialite) FROM stdin;
15	Correcteur1	Tiana	2002-06-10	ay@test.com	0320000001
16	Correcteur2	Tiana	2002-04-10	ast.com	0320000001
17	Correcteur3	Tiana	2002-07-10	@test.cm	0320000001
\.


--
-- Data for Name: matiere; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matiere (id_matiere, nom_matiere, coefficient) FROM stdin;
2	Programmation Java	2
3	Programmation PHP	2
\.


--
-- Data for Name: note; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.note (id_note, id_candidat, id_matiere, id_correcteur, valeur, date_evaluation) FROM stdin;
1	7	2	15	15.00	2026-03-12
2	7	2	16	10.00	2026-03-12
3	7	2	17	12.00	2026-03-12
4	7	3	15	9.00	2026-03-12
5	7	3	16	8.00	2026-03-12
6	7	3	17	11.00	2026-03-12
\.


--
-- Data for Name: operateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.operateur (id_operateur, signe) FROM stdin;
1	>
2	<
3	>=
4	<=
\.


--
-- Data for Name: parametre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parametre (id_parametre, valeur, id_matiere, id_operateur, id_resolution) FROM stdin;
2	7.00	2	3	2
3	2.00	3	4	1
4	2.00	3	1	3
1	7.00	2	2	3
\.


--
-- Data for Name: resolution; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resolution (id_resolution, nom_resolution) FROM stdin;
1	1
2	2
3	3
\.


--
-- Name: candidat_id_candidat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.candidat_id_candidat_seq', 9, true);


--
-- Name: correcteur_id_correcteur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.correcteur_id_correcteur_seq', 17, true);


--
-- Name: matiere_id_matiere_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matiere_id_matiere_seq', 3, true);


--
-- Name: note_id_note_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.note_id_note_seq', 1, false);


--
-- Name: operateur_id_operateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.operateur_id_operateur_seq', 1, false);


--
-- Name: parametre_id_parametre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parametre_id_parametre_seq', 1, false);


--
-- Name: resolution_id_resolution_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resolution_id_resolution_seq', 1, false);


--
-- Name: candidat candidat_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidat
    ADD CONSTRAINT candidat_email_key UNIQUE (email);


--
-- Name: candidat candidat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidat
    ADD CONSTRAINT candidat_pkey PRIMARY KEY (id_candidat);


--
-- Name: correcteur correcteur_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.correcteur
    ADD CONSTRAINT correcteur_email_key UNIQUE (email);


--
-- Name: correcteur correcteur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.correcteur
    ADD CONSTRAINT correcteur_pkey PRIMARY KEY (id_correcteur);


--
-- Name: matiere matiere_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matiere
    ADD CONSTRAINT matiere_pkey PRIMARY KEY (id_matiere);


--
-- Name: note note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id_note);


--
-- Name: operateur operateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operateur
    ADD CONSTRAINT operateur_pkey PRIMARY KEY (id_operateur);


--
-- Name: operateur operateur_signe_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operateur
    ADD CONSTRAINT operateur_signe_key UNIQUE (signe);


--
-- Name: parametre parametre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametre
    ADD CONSTRAINT parametre_pkey PRIMARY KEY (id_parametre);


--
-- Name: resolution resolution_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resolution
    ADD CONSTRAINT resolution_pkey PRIMARY KEY (id_resolution);


--
-- Name: note fk_note_candidat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT fk_note_candidat FOREIGN KEY (id_candidat) REFERENCES public.candidat(id_candidat) ON DELETE CASCADE;


--
-- Name: note fk_note_correcteur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT fk_note_correcteur FOREIGN KEY (id_correcteur) REFERENCES public.correcteur(id_correcteur) ON DELETE CASCADE;


--
-- Name: note fk_note_matiere; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT fk_note_matiere FOREIGN KEY (id_matiere) REFERENCES public.matiere(id_matiere) ON DELETE CASCADE;


--
-- Name: parametre fk_parametre_matiere; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametre
    ADD CONSTRAINT fk_parametre_matiere FOREIGN KEY (id_matiere) REFERENCES public.matiere(id_matiere) ON DELETE CASCADE;


--
-- Name: parametre fk_parametre_operateur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametre
    ADD CONSTRAINT fk_parametre_operateur FOREIGN KEY (id_operateur) REFERENCES public.operateur(id_operateur) ON DELETE CASCADE;


--
-- Name: parametre fk_parametre_resolution; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parametre
    ADD CONSTRAINT fk_parametre_resolution FOREIGN KEY (id_resolution) REFERENCES public.resolution(id_resolution) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

