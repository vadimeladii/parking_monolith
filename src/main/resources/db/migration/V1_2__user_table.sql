CREATE TABLE "user"(
  id SERIAL ,
  username VARCHAR NOT NULL ,
  password VARCHAR NOT NULL ,
  balance DECIMAL NOT NULL ,
  CONSTRAINT pk_id_user PRIMARY KEY (id)
);

