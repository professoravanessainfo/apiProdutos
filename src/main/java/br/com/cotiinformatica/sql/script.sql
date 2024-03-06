create database bd_apiprodutos;
use bd_apiprodutos;

#criando a tabela de fornecedores
create table fornecedor(
	id				integer			auto_increment		primary key,
	razaoSocial		varchar(100)	not null,
	cnpj			varchar(20)		not null
);

create table produto(
	id				integer			auto_increment		primary key,
	nome			varchar(100)	not null,
	preco			double			not null,
	quantidade		integer			not null,
	id_fornecedor	integer			not null,
	foreign key(id_fornecedor) references fornecedor(id)
);

#cadastrando fornecedores na tabela
insert into fornecedor (razaoSocial, cnpj) values
('ByteZone Ltda.', '12345678901234'),
('TechNest S.A.', '56789012345678'),
('DataDen Informática LTDA', '90123456789012'),
('Circuit Central Comércio de Eletrônicos', '34567890123456');

#consultando os fornecedores
select * from fornecedor;
