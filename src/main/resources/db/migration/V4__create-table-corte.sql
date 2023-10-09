CREATE TABLE corte (
                           id serial not null primary key,
                           nome VARCHAR(255) NOT NULL,
                           descricao TEXT,
                           barbeariaid INT REFERENCES barbearias(id)
);