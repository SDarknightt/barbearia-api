CREATE TABLE corte (
                           id serial not null primary key,
                           nome VARCHAR(255) NOT NULL,
                           descricao TEXT,
                           barbeariaid INT REFERENCES barbearias(id)
);
-- Cortes Barbearia 1
INSERT INTO corte (nome, descricao, barbeariaid)
VALUES
    ('Corte Buzz', 'Um corte curto e raspado para um visual minimalista e prático. Ideal para o calor do verão.', 1),
    ('Corte Pompadour', 'Um corte elegante com os lados curtos e o topo mais longo, perfeito para um visual retrô.', 1),
    ('Corte Undercut', 'Um corte ousado com os lados raspados e o topo mais longo para um visual moderno.', 1);

-- Cortes Barbearia 2
INSERT INTO corte (nome, descricao, barbeariaid)
VALUES
    ('Corte Razor Fade', 'Um corte com um desbotamento perfeito usando navalha para um visual limpo e nítido.', 2),
    ('Corte Quiff', 'Um corte com topo volumoso e penteado para trás para um estilo único e marcante.', 2),
    ('Corte Caesar', 'Um corte curto com franja reta inspirado no imperador romano, um clássico atemporal.', 2);
