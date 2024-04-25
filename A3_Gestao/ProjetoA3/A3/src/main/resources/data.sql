INSERT INTO tb_imc (id, imc, classificacao)
VALUES
    (18.5, 1,  'Baixo peso'),
    (24.9, 2,  'Peso normal'),
    (29.9, 3,  'Excesso de peso'),
    (34.9, 4,  'Obesidade de Classe 1'),
    (39.9, 5, 'Obesidade de Classe 2'),
    (40.0, 6, 'Obesidade de Classe 3');

INSERT INTO tb_usuario (user_name, user_email, user_cpf, peso, altura)
VALUES
(1,'Lucas', 'lucas@gmail.com', '111.111.111-11', 70.5, 1.75),
(2,'Amanda', 'amanda@outlook.com', '222.222.222-22', 65.2, 1.68),
(3,'Taina', 'taina@gmail.com', '333.333.333-33', 80.0, 1.80),
(4,'Valter', 'valter@outlook.com', '444.444.444-44', 90.7, 1.85),
(5,'Luis', 'luis@gmail.com', '555.555.555-55', 75.3, 1.70);


INSERT INTO tb_endereco (logradouro, cidade, estado, cep, usuario_id)
VALUES
('Rua A', 'Cidade A', 'Estado A', '11111-111', LAST_INSERT_ID(1)),
('Rua B', 'Cidade B', 'Estado B', '22222-222', LAST_INSERT_ID(2)),
('Rua C', 'Cidade C', 'Estado C', '33333-333', LAST_INSERT_ID(3)),
('Rua D', 'Cidade D', 'Estado D', '44444-444', LAST_INSERT_ID(4)),
('Rua E', 'Cidade E', 'Estado E', '55555-555', LAST_INSERT_ID(5));