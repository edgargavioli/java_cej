CREATE DATABASE cej;

USE cej;

CREATE TABLE itens(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    unidade_medida VARCHAR(2) NOT NULL,
    quantidade_minima INT NOT NULL,
    valor_d_compra DOUBLE NOT NULL,
    valor_d_venda DOUBLE NOT NULL,
    id_categoria INT NOT NULL,
    id_fornecedor INT NOT NULL,
    id_funcionario INT NOT NULL,
    CONSTRAINT categoria_fk
    FOREIGN KEY(id_categoria)
    REFERENCES categorias(id),
    CONSTRAINT fornecedor_fk
    FOREIGN KEY(id_fornecedor)
    REFERENCES fornecedores(id),
    CONSTRAINT funcionario_fk
    FOREIGN KEY(id_funcionario)
    REFERENCES funcionarios(id)
);

SELECT * FROM itens; 

CREATE TABLE funcionarios(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome_acesso VARCHAR(200) NOT NULL,
    senha_acesso VARCHAR(11) NOT NULL,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(11) NOT NULL
);

SELECT * FROM funcionarios; 

CREATE TABLE categorias(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(200) NOT NULL
);

CREATE TABLE fornecedores(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    cnpj VARCHAR(200) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(11) NOT NULL
);

SELECT * FROM fornecedores;

CREATE TABLE vendas(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    data_v DATE NOT NULL,
    valor_total DOUBLE NOT NULL,
    id_funcionario INT NOT NULL,
    CONSTRAINT funcionario_v_fk
    FOREIGN KEY(id_funcionario)
    REFERENCES funcionarios(id)
);

CREATE TABLE vendas_itens(
	quantidade INT NOT NULL,
    id_venda INT NOT NULL,
    id_item INT NOT NULL,
    CONSTRAINT venda_fk
    FOREIGN KEY(id_venda)
    REFERENCES vendas(id),
    CONSTRAINT item_fk
    FOREIGN KEY(id_item)
    REFERENCES itens(id),
    PRIMARY KEY(id_venda, id_item)
);
