CREATE TABLE user_role (
  id SERIAL,
  id_user INT NOT NULL,
  id_role INT NOT NULL,
  CONSTRAINT fk_user_role_user FOREIGN KEY (id_user) REFERENCES "user"(id),
  CONSTRAINT fk_user_role_role FOREIGN KEY (id_role) REFERENCES role(id),
  PRIMARY KEY (id)
);