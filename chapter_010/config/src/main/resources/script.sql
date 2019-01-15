-- Table: public.items

-- DROP TABLE public.items;

CREATE TABLE public.items
(
    id integer NOT NULL DEFAULT nextval('items_id_seq'::regclass),
    description character varying(400) COLLATE pg_catalog."default",
    created timestamp with time zone,
    done boolean,
    CONSTRAINT items_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.items
    OWNER to postgres;