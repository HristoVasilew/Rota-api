create table cars (
  id bigint NOT NULL AUTO_INCREMENT,
  registration_number varchar(16) NOT NULL,
  car_image_media_type varchar(10) DEFAULT NULL,
  car_image mediumblob DEFAULT NULL,
  car_type varchar(50) NOT NULL,
  make varchar(256) NOT NULL,
  model varchar(256) NOT NULL,
  year smallint NOT NULL,
  price_per_day decimal(10, 2) NOT NULL,
  fuel_type varchar(50) NOT NULL,
  number_of_seats tinyint NOT NULL,
  extras set('AC', 'NAVIGATION', 'AUTOPILOT', 'ANDROID_AUTO', 'APPLE_CARPLAY', 'CHILD_SEAT') DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY registration_number (registration_number)
);