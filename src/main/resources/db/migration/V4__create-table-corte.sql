CREATE TABLE corte (
                           id serial not null primary key,
                           preco DECIMAL(10,2),
                           nome VARCHAR(255) NOT NULL,
                           descricao TEXT,
                           barbeariaid INT REFERENCES barbearias(id)
);
-- Cortes Barbearia 1
INSERT INTO corte (nome, preco, descricao, barbeariaid)
VALUES
    ('Corte Buzz', 19.99, 'Um corte curto e raspado para um visual minimalista e prático. Ideal para o calor do verão.', 1),
    ('Corte Pompadour', 29.99, 'Um corte elegante com os lados curtos e o topo mais longo, perfeito para um visual retrô.', 1),
    ('Corte Undercut', 39.99, 'Um corte ousado com os lados raspados e o topo mais longo para um visual moderno.', 1);

-- Cortes Barbearia 2
INSERT INTO corte (nome, preco, descricao, barbeariaid)
VALUES
    ('Corte Razor Fade', 19.99, 'Um corte com um desbotamento perfeito usando navalha para um visual limpo e nítido.', 2),
    ('Corte Quiff', 29.99, 'Um corte com topo volumoso e penteado para trás para um estilo único e marcante.', 2),
    ('Corte Caesar', 39.99, 'Um corte curto com franja reta inspirado no imperador romano, um clássico atemporal.', 2);
