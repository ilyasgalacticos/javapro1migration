CREATE TABLE t_owners (
    id bigint auto_increment,
    name VARCHAR(255),
    nick_name VARCHAR(255),
    primary key (id)
);

CREATE TABLE t_tyres(
    id bigint auto_increment,
    name VARCHAR(255),
    profile VARCHAR(255),
    price integer,
    manufacturer VARCHAR(255),
    owner_id bigint,
    primary key (id)
);

ALTER TABLE t_tyres
ADD CONSTRAINT tyres_owners_fk
FOREIGN KEY (owner_id) REFERENCES t_owners(id);
