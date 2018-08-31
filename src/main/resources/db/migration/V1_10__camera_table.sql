CREATE TABLE camera (
id SERIAL,
number VARCHAR ,
id_parking INTEGER NOT NULL ,
CONSTRAINT fk_id_parking_camera FOREIGN KEY (id_parking) REFERENCES parking_lot(id),
CONSTRAINT pk_id_camera PRIMARY KEY (id)
);