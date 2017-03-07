INSERT INTO parameter_type (id, library_name) VALUES (1, 'java.lang.Integer')
INSERT INTO parameter_type (id, library_name) VALUES (2, 'java.lang.Character')
INSERT INTO parameter_type (id, library_name) VALUES (3, 'java.lang.String')
INSERT INTO parameter_type (id, library_name) VALUES (4, '[Ljava.lang.String;')

INSERT INTO coding_challenge (id, date_created, name, difficulty, description, method_signature) VALUES (1, '2001-01-01', 'fizzbuzz', 'easy', 'Write a function "fizzBuzz" that takes an integer. If the supplied integer is divisible 3, return "fizz". If the supplied integer is divisible by 5, return "buzz". If the supplied integer is divisible by 3 and 5, return "fizzbuzz". For all other integers, return an empty string.', 'String fizzBuzz(int num)')
INSERT INTO coding_challenge_parameter_types (challenge_id, parameter_type_id) VALUES (1, 1)

INSERT INTO coding_challenge (id, date_created, name, difficulty, description, method_signature) VALUES (2, '2002-01-01', 'reverseString', 'easy', 'Write a function "reverseString" that takes a string and returns a string with its characters order reversed.', 'String reverseString(String string)')
INSERT INTO coding_challenge_parameter_types (challenge_id, parameter_type_id) VALUES (2, 3)

INSERT INTO coding_challenge (id, date_created, name, difficulty, description, method_signature) VALUES (3, '2003-01-01', 'concatStrings', 'easy', 'Write a function "concatStrings" that takes an array of strings and returns a string. The returned string should be all of the strings concatenated.', 'String concatStrings(String[] strings)')
INSERT INTO coding_challenge_parameter_types (challenge_id, parameter_type_id) VALUES (3, 4)

INSERT INTO coding_challenge (id, date_created, name, difficulty, description, method_signature) VALUES (4, '2004-01-01', 'characterCount', 'easy', 'Write a function "characterCount" that takes a char and a string. Return the number of occurrences of the character in the string.', 'int characterCount(char character, String string)')
INSERT INTO coding_challenge_parameter_types (challenge_id, parameter_type_id) VALUES (4, 2)
INSERT INTO coding_challenge_parameter_types (challenge_id, parameter_type_id) VALUES (4, 3)


INSERT INTO solution (id, execution_time, passes_tests, source_code, coding_challenge_id) VALUES (1, 1000, 'false', 'public class Solution { public String fizzbuzz(int num) { return "fizzbuzz"; } }', 1)
INSERT INTO solution (id, execution_time, passes_tests, source_code, coding_challenge_id) VALUES (2, 2000, 'false', 'public class Solution { public String fizzbuzz(int num) { return "fizz"; } }', 1)
INSERT INTO solution (id, execution_time, passes_tests, source_code, coding_challenge_id) VALUES (3, 3000, 'false', 'public class Solution { public String fizzbuzz(int num) { return "buzz"; } }', 1)

