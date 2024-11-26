CREATE TABLE products (
	id _int8 GENERATED ALWAYS AS IDENTITY NOT NULL,
	"name" varchar NULL,
	CONSTRAINT products_unique UNIQUE (id)
);
