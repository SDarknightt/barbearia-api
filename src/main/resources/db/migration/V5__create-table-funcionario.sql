CREATE TABLE funcionarios (
                           id serial not null primary key,
                           cpf VARCHAR(11) NOT NULL,
                           nome VARCHAR(255) NOT NULL,
                           telefone VARCHAR(20),
                           email VARCHAR(255) NOT NULL,
                           bairro varchar(100) not null,
                           cep varchar(9) not null,
                           complemento varchar(100),
                           numero varchar(20),
                           uf char(2) not null,
                           cidade varchar(100) not null,
                           barbeariaid INT REFERENCES barbearias(id)
);
