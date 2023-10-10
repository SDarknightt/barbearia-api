create table usuarios(
    id serial not null primary key ,
    login varchar(100) not null ,
    senha varchar(100) not null ,
    permissao varchar(20),
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    barbeariaid INT REFERENCES barbearias(id)
);
--  Usuário ADMIN 1
INSERT INTO usuarios (login, senha, permissao, cpf, nome, telefone, bairro, cep, complemento, numero, uf, cidade, barbeariaid)
VALUES
    ('admin@gmail.com', '$2a$10$7.KW2/Z3Swid8hEmRxypy.ukZb/YYUJi94gSf.WDB2h9urlehex9a', 'ROLE_ADMIN', '12345678901', 'João Silva', '(11) 9876-5432', 'Centro', '12345-678', 'Apartamento 101', '456', 'SP', 'São Paulo', 1);

-- Inserir FUNCIONARIO 1
INSERT INTO usuarios (login, senha, permissao, cpf, nome, telefone, bairro, cep, complemento, numero, uf, cidade, barbeariaid)
VALUES
    ('funcionario@gmail.com', '$2a$10$7.KW2/Z3Swid8hEmRxypy.ukZb/YYUJi94gSf.WDB2h9urlehex9a', 'ROLE_FUNCIONARIO', '98765432109', 'Maria Souza', '(21) 1234-5678', 'Bairro da Moda', '54321-876', 'Casa 202', '789', 'RJ', 'Rio de Janeiro', 1);


--  Usuário ADMIN 1
INSERT INTO usuarios (login, senha, permissao, cpf, nome, telefone, bairro, cep, complemento, numero, uf, cidade, barbeariaid)
VALUES
    ('admin2@gmail.com', '$2a$10$7.KW2/Z3Swid8hEmRxypy.ukZb/YYUJi94gSf.WDB2h9urlehex9a', 'ROLE_ADMIN', '12345678901', 'Mario Silva', '(11) 9876-5432', 'Centro', '12345-678', 'Apartamento 101', '456', 'SP', 'São Paulo', 2);

-- Inserir FUNCIONARIO 1
INSERT INTO usuarios (login, senha, permissao, cpf, nome, telefone, bairro, cep, complemento, numero, uf, cidade, barbeariaid)
VALUES
    ('funcionario2@gmail.com', '$2a$10$7.KW2/Z3Swid8hEmRxypy.ukZb/YYUJi94gSf.WDB2h9urlehex9a', 'ROLE_FUNCIONARIO', '98765432109', 'Luciana Souza', '(21) 1234-5678', 'Bairro da Moda', '54321-876', 'Casa 202', '789', 'RJ', 'Rio de Janeiro', 2);
