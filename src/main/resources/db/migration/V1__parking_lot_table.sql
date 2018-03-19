CREATE TABLE parking_lot (
  id SERIAL,
  name VARCHAR NOT NULL ,
  total_places INTEGER NOT NULL ,
  available_places INTEGER NOT NULL ,
  CONSTRAINT pk_id_parking PRIMARY KEY (id)
);