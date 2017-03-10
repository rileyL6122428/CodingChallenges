INSERT INTO parameter_type (id, library_name) VALUES (1, 'java.lang.Integer')
INSERT INTO parameter_type (id, library_name) VALUES (2, 'java.lang.Character')
INSERT INTO parameter_type (id, library_name) VALUES (3, 'java.lang.String')
INSERT INTO parameter_type (id, library_name) VALUES (4, '[Ljava.lang.String;')

INSERT INTO challenge_hint (id, hint_text) VALUES (1, 'Conditionals')
INSERT INTO challenge_hint (id, hint_text) VALUES (2, 'Modulo')

INSERT INTO coding_challenge (id, date_created, name, difficulty, description, method_signature, image_url) VALUES (1, '2001-01-01', 'figgbuzz', 'easy', 'Attacks with integers. If the supplied integer is divisible 3, return "figg". If the supplied integer is divisible by 5, return "buzz". If the supplied integer is divisible by 3 and 5, return "figgbuzz". For all other integers, return an empty string.', 'String figgbuzz(Integer num)', 'Three.svg')
INSERT INTO coding_challenge_hints_join (challenge_id, hint_id) VALUES (1, 1)
INSERT INTO coding_challenge_hints_join (challenge_id, hint_id) VALUES (1, 2)
INSERT INTO coding_challenge_parameter_types_join (challenge_id, parameter_type_id) VALUES (1, 1)





