-- Criação da tabela 'usuarios'
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Criação da tabela 'perfis'
CREATE TABLE perfis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

-- Tabela de associação entre 'usuarios' e 'perfis' (muitos-para-muitos)
CREATE TABLE usuarios_perfis (
    usuario_id INT NOT NULL,
    perfil_id INT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);

-- Criação da tabela 'topicos'
CREATE TABLE topicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    autor INT NOT NULL,
    curso VARCHAR(100),
    FOREIGN KEY (autor) REFERENCES usuarios(id)
);

-- Criação da tabela 'respostas'
CREATE TABLE respostas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    topico INT NOT NULL,
    dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor INT NOT NULL,
    solucao BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico) REFERENCES topicos(id),
    FOREIGN KEY (autor) REFERENCES usuarios(id)
);