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