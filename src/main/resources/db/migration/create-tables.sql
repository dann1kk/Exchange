create table valuta (
	id serial primary key,
	cod varchar unique,
    description varchar
);

create table curs_valutar (
	id serial primary key,
	valuta_id int references valuta(id),
	rata float,
	curs float,
	"data" date not null
);

create table "operator" (
	id serial primary key,
	nume varchar,
	prenume varchar
);

create table filiala (
  id serial primary key,
  denumire varchar
);

create table numerar (
	id serial primary key,
	valuta_id int references valuta(id),
	suma float,
	operator_id int references "operator"(id),
	"data" date not null
);

create table schimb_valutar (
	id serial primary key,
	suma_primita float,
	suma_eliberata float,
	curs_valutar_id int references curs_valutar(id),
	valuta_id int references valuta(id),
	operator_id int references "operator"(id),
	filiala_id int references filiala(id),
	"data" date not null
);