CREATE TABLE cliente (
                           id serial not null primary key,
                           nome VARCHAR(255) NOT NULL,
                           telefone VARCHAR(20),
                           email VARCHAR(255) NOT NULL,
                           barbeariaid INT REFERENCES barbearias(id)
);
