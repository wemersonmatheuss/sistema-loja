CREATE DATABASE loja_db;
USE loja_db;
-- Tabela Cliente
USE loja_db;
CREATE TABLE cliente (
cpf VARCHAR(14) PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
endereco VARCHAR(150)
);
-- Tabela Funcionario
CREATE TABLE funcionario (
cpf VARCHAR(14) PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
salario DECIMAL(10,2)
);
-- Tabela Produto
CREATE TABLE produto (
id INT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
preco DECIMAL(10,2)
);


