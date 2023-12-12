CREATE TABLE agendamento (
                       id serial not null primary key,
                       descricao TEXT,
                       datacorte TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       usuarioid INT REFERENCES usuarios(id),
                       clienteid INT REFERENCES cliente(id),
                       corteid INT REFERENCES corte(id),
                       barbeariaid INT REFERENCES barbearias(id)
);

-- Agendamentos
INSERT INTO agendamento (descricao, datacorte, usuarioid, clienteid, corteid, barbeariaid)
VALUES
    ('Agendamento Maggios', CURRENT_TIMESTAMP, 1, 1, 1, 1),
    ('Agendamento Maggios', CURRENT_TIMESTAMP, 2, 2, 2, 1),
    ('Agendamento Leader', CURRENT_TIMESTAMP, 3, 3, 4, 2),
    ('Agendamento Leader', CURRENT_TIMESTAMP, 4, 4, 5, 2);
;
