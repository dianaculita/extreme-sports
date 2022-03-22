INSERT INTO COUNTRIES (country_id, country_name) VALUES (1, 'Austria');
INSERT INTO COUNTRIES (country_id, country_name) VALUES (2, 'Romania');

INSERT INTO REGIONS (region_id, region_name, country_id) VALUES (1, 'Tirol', 1);
INSERT INTO REGIONS (region_id, region_name, country_id) VALUES (2, 'Brasov', 2);

INSERT INTO PLACES (place_id, place_name, region_id) VALUES (1, 'Soelden', 1);
INSERT INTO PLACES (place_id, place_name, region_id) VALUES (2, 'Brasov', 2);
INSERT INTO PLACES (place_id, place_name, region_id) VALUES (3, 'Azuga', 2);

INSERT INTO EXTREME_SPORTS (sport_id, sport_name, start_period, end_period) VALUES (1, 'ski', PARSEDATETIME('01-12-2022','dd-MM-yyyy'), PARSEDATETIME('31-03-2023','dd-MM-yyyy'));
INSERT INTO EXTREME_SPORTS (sport_id, sport_name, start_period, end_period) VALUES (2, 'snowboard', PARSEDATETIME('01-12-2022','dd-MM-yyyy'), PARSEDATETIME('31-03-2023','dd-MM-yyyy'));
INSERT INTO EXTREME_SPORTS (sport_id, sport_name, start_period, end_period) VALUES (3, 'paragliding', PARSEDATETIME('01-05-2022','dd-MM-yyyy'), PARSEDATETIME('31-08-2022','dd-MM-yyyy'));
INSERT INTO EXTREME_SPORTS (sport_id, sport_name, start_period, end_period) VALUES (4, 'bungee jumping', PARSEDATETIME('01-05-2022','dd-MM-yyyy'), PARSEDATETIME('30-09-2022','dd-MM-yyyy'));

INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (1, 1, 1, 1, 250);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (1, 1, 1, 2, 230);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (1, 1, 1, 3, 500);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (2, 2, 2, 3, 400);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (2, 2, 2, 1, 150);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (2, 2, 3, 1, 160);
INSERT INTO SPORTS_BY_PLACES (country_id, region_id, place_id, sport_id, price_per_day) VALUES (2, 2, 3, 2, 200);

