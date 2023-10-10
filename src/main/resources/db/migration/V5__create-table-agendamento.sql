CREATE TABLE agendamento (
                       id serial not null primary key,
                       descricao TEXT,
                       usuarioid INT REFERENCES usuarios(id),
                       corteid INT REFERENCES corte(id),
                       barbeariaid INT REFERENCES barbearias(id)
);