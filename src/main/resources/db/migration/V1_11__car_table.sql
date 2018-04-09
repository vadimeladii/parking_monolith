CREATE TABLE car(
  id SERIAL,
  number VARCHAR NOT NULL ,
  id_user INTEGER,
  CONSTRAINT fk_id_user_car FOREIGN KEY (id_user) REFERENCES "user"(id),
  CONSTRAINT pk_id_car PRIMARY KEY (id)
);