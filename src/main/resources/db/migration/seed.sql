insert into valuta (cod)
values ('USD'), ('EUR'), ('RON'), ('RUB'), ('UAH');

insert into operator (nume, prenume)
values ('Andrei', 'Popa'), ('Ion', 'Albu'), ('Andreea', 'Balaur');

insert into numerar (valuta_id, suma, operator_id, "data")
values (1, 5000, 1, CURRENT_DATE),
	(1, 5000, 2, CURRENT_DATE),
	(1, 5000, 3, CURRENT_DATE),

	(2, 3000, 1, CURRENT_DATE),
	(2, 3000, 2, CURRENT_DATE),
	(2, 3000, 3, CURRENT_DATE),

	(3, 2000, 1, CURRENT_DATE),
	(3, 2000, 2, CURRENT_DATE),
	(3, 2000, 3, CURRENT_DATE),

	(4, 1000, 1, CURRENT_DATE),
	(4, 1000, 2, CURRENT_DATE),
	(4, 1000, 3, CURRENT_DATE),

	(5, 4000, 1, CURRENT_DATE),
	(5, 4000, 2, CURRENT_DATE),
	(5, 4000, 3, CURRENT_DATE);