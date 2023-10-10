CREATE TABLE barbearias (
                           id serial not null primary key,
                           cnpj VARCHAR(14) NOT NULL,
                           nome VARCHAR(255) NOT NULL,
                           email varchar(100) not null ,
                           telefone VARCHAR(20),
                           bairro varchar(100) not null,
                           cep varchar(9) not null,
                           complemento varchar(100),
                           numero varchar(20),
                           uf char(2) not null,
                           cidade varchar(100) not null
);

-- Barbearia 1
INSERT INTO barbearias (cnpj, nome, email, telefone, bairro, cep, complemento, numero, uf, cidade)
VALUES
    ('12345678901234', 'Barbearia Maggios', 'contato@barbeariamaggios.com', '(11) 1234-5678', 'Centro', '12345-678', 'Sala 101', '123', 'SP', 'São Paulo');

-- Barbearia 2
INSERT INTO barbearias (cnpj, nome, email, telefone, bairro, cep, complemento, numero, uf, cidade)
VALUES
    ('98765432109876', 'Barbearia Leader', 'contato@barbeariadaleader.com', '(21) 9876-5432', 'Bairro da Moda', '54321-876', 'Loja 202', '456', 'RJ', 'Rio de Janeiro');
