CREATE TABLE public.categoria
(
    id_categoria bigint NOT NULL,
    nome character varying(100) NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria)
);

CREATE TABLE public.comprador
(
    id_comprador bigint NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100),
    CONSTRAINT comprador_pkey PRIMARY KEY (id_comprador)
);

CREATE TABLE public.vendedor
(
    id_vendedor bigint NOT NULL,
    nome character varying(255) NOT NULL,
    CONSTRAINT vendedor_pkey PRIMARY KEY (id_vendedor)
);

CREATE TABLE public.produto
(
    id_produto bigint NOT NULL,
    nome character varying(100) NOT NULL,
    descricao character varying(2000) NOT NULL,
    data_criacao timestamp without time zone,
    id_categoria bigint,
    CONSTRAINT produto_pkey PRIMARY KEY (id_produto),
    CONSTRAINT fkbb0k43mtsufg8bfhq0gyaxhhm FOREIGN KEY (id_categoria)
        REFERENCES public.categoria (id_categoria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.venda
(
    id_venda bigint NOT NULL,
    data_criacao timestamp without time zone,
    pedido character varying(255) NOT NULL,
    quantidade integer,
    avaliacao integer,
    id_comprador bigint,
    id_produto bigint,
    id_vendedor bigint,
    CONSTRAINT venda_pkey PRIMARY KEY (id_venda),
    CONSTRAINT fkft0c9oih15djirj7htag78pu7 FOREIGN KEY (id_produto)
        REFERENCES public.produto (id_produto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhbvuaxtkpn6k45sf5ff90jfj6 FOREIGN KEY (id_comprador)
        REFERENCES public.comprador (id_comprador) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fki5bthi4ggn2nhs8tkaiq6vao3 FOREIGN KEY (id_vendedor)
        REFERENCES public.vendedor (id_vendedor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE SEQUENCE public.seq_vendedor
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.seq_comprador
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.seq_venda
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.seq_produto
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.seq_categoria
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_categoria OWNER TO hotmart;
ALTER SEQUENCE public.seq_venda OWNER TO hotmart;
ALTER SEQUENCE public.seq_vendedor OWNER TO hotmart;
ALTER SEQUENCE public.seq_comprador OWNER TO hotmart;
ALTER SEQUENCE public.seq_produto OWNER TO hotmart;

ALTER TABLE public.categoria OWNER to hotmart;
ALTER TABLE public.comprador OWNER to hotmart;
ALTER TABLE public.produto OWNER to hotmart;
ALTER TABLE public.venda OWNER to hotmart;
ALTER TABLE public.vendedor OWNER to hotmart;