CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    email        text         NOT NULL,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
);

CREATE TABLE users_roles
(
    authority_id int references authorities (id),
    person_id   int references users (id)
);

ALTER TABLE users_roles
    ADD PRIMARY KEY (authority_id,  person_id);


