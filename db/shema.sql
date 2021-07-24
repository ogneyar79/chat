ALTER TABLE users
    ADD last_name CHARACTER VARYING(50) NOT NULL;


CREATE table users_roles
(
    authority_id int references authorities (id),
    person_id    int references users (id)

)

CREATE table roles_privileges
(
    authority_id int references authorities (id),
    privilege_id int references privileges (id)

)
