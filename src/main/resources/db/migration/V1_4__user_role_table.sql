CREATE TABLE user_role (
  id_user_role SERIAL,
  id_user INT NOT NULL,
  id_role INT NOT NULL,
  CONSTRAINT fk_user_role_user FOREIGN KEY (id_user) REFERENCES "user"(id_user),
  CONSTRAINT fk_user_role_role FOREIGN KEY (id_role) REFERENCES role(id_role),
  PRIMARY KEY (id_user_role)
);