ALTER TABLE "user" ADD COLUMN email VARCHAR;

UPDATE "user" set email = 'vadimeladii@gmail.com';

ALTER TABLE "user" ALTER email SET NOT NULL ;