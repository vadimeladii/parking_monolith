CREATE TABLE "user"(
  id_user SERIAL ,
  username VARCHAR NOT NULL ,
  password VARCHAR NOT NULL ,
  balance DECIMAL NOT NULL ,
  CONSTRAINT pk_id_user PRIMARY KEY (id_user)
);

