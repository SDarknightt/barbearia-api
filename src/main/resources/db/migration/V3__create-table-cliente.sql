CREATE TABLE cliente (
                         id serial not null primary key,
                         nome VARCHAR(255) NOT NULL,
                         telefone VARCHAR(20),
                         email VARCHAR(255) NOT NULL,
                         barbeariaid INT REFERENCES barbearias(id)
);


-- Cliente Barbearia 1
INSERT INTO cliente (nome, telefone, email, barbeariaid)
VALUES
    ('Cliente João', '(11) 9876-5432', 'joao@email.com', 1);

-- Cliente Barbearia 1
INSERT INTO cliente (nome, telefone, email, barbeariaid)
VALUES
    ('Cliente Maria', '(21) 1234-5678', 'maria@email.com', 1);


-- Cliente Barbearia 2
INSERT INTO cliente (nome, telefone, email, barbeariaid)
VALUES
    ('Cliente Maicão', '(11) 9876-5432', 'maicão@email.com', 2);

-- Cliente Barbearia 2
INSERT INTO cliente (nome, telefone, email, barbeariaid)
VALUES
    ('Cliente Iolanda', '(21) 1234-5678', 'iolanda@email.com', 2);
