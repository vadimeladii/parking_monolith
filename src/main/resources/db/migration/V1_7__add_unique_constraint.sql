ALTER TABLE "user" ADD CONSTRAINT uq_username_email UNIQUE (username, email);

ALTER TABLE role ADD CONSTRAINT uq_type UNIQUE (type);

ALTER TABLE parking_lot ADD CONSTRAINT  uq_name UNIQUE (name)