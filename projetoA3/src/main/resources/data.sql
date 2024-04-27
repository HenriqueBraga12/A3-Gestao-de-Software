-- Tabela tb_imc
INSERT INTO tb_imc (id, imc, classificacao) VALUES
    (1, 18.5, 'Baixo peso'),
    (2, 24.9, 'Peso normal'),
    (3, 29.9, 'Excesso de peso'),
    (4, 34.9, 'Obesidade de Classe 1'),
    (5, 39.9, 'Obesidade de Classe 2'),
    (6, 40.0, 'Obesidade de Classe 3');

-- Tabela tb_usuario
INSERT INTO tb_usuario (id_usuario, user_name, user_email, user_cpf, peso, altura) VALUES
  (1, 'Lucas', 'lucas@gmail.com', '9999999999', 70, 1.65),
  (2, 'Taina', 'taina@gmail.com', '9999999999', 60, 1.65),
  (3, 'Rodrigo', 'Rodrigo@gmail.com', '9999999999', 90, 1.85),
  (4, 'Juliana', 'ju@gmail.com', '9999999999', 70, 1.50),
  (5, 'Gabriela', 'lucas@gmail.com', '9999999999', 60, 1.70);
