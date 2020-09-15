CREATE TABLE public.booking
(
    booking_id bigint NOT NULL,
    date timestamp without time zone,
    nb_person integer,
    payed boolean,
    status integer,
    trip_id bigint,
    user_id bigint,
    CONSTRAINT booking_pkey PRIMARY KEY (booking_id)
)

TABLESPACE pg_default;

ALTER TABLE public.booking
    OWNER to wildadventure;
    
    
CREATE TABLE public.cart
(
    cart_id bigint NOT NULL,
    nb_person integer,
    total_price bigint,
    trip_id bigint,
    user_id bigint,
    CONSTRAINT cart_pkey PRIMARY KEY (cart_id),
    CONSTRAINT uk_9emlp6m95v5er2bcqkjsw48he UNIQUE (user_id)
)

TABLESPACE pg_default;

ALTER TABLE public.cart
    OWNER to wildadventure;