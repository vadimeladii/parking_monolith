CREATE TABLE notification (
id SERIAL,
token VARCHAR NOT NULL ,
id_parking INTEGER NOT NULL ,
CONSTRAINT uq_token UNIQUE (token),
CONSTRAINT fk_id_parking_notification FOREIGN KEY (id_parking) REFERENCES parking_lot(id),
CONSTRAINT pk_id_notification PRIMARY KEY (id)
);