CREATE TABLE agendamento (
                       id serial not null primary key,
                       descricao TEXT,
                       usuarioid INT REFERENCES usuarios(id),
                       clienteid INT REFERENCES cliente(id),
                       corteid INT REFERENCES corte(id),
                       barbeariaid INT REFERENCES barbearias(id)
);

-- Agendamentos
INSERT INTO agendamento (descricao, usuarioid, clienteid, corteid, barbeariaid)
VALUES
    ('Agendamento Maggios', 1, 1, 1, 1),
    ('Agendamento Maggios', 2, 2, 2, 1),
    ('Agendamento Leader', 3, 3, 4, 2),
    ('Agendamento Leader', 4, 4, 5, 2);
;
