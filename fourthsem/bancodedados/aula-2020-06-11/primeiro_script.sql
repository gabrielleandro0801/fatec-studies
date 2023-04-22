create database gerenciafut;
use gerenciafut;

create table pessoa (
    idPessoa integer not null auto_increment,
    nome varchar(50),
    cpf varchar(15),
    salario double,
    dataContratacao date,

    primary key(idPessoa)
);

create table presidente (
    idPessoa integer not null,
    idPresidente int not null auto_increment,
    duracaoMandato date,

    primary key(idPessoa, idPresidente),
    foreign key(idPessoa) references pessoa(idPessoa)
);
 
create table diretor_executivo (
    idPessoa integer not null,
    idDirExec integer not null auto_increment,
    capacidadeContratacao integer not null,
    idPresidente integer not null,

    primary key (idPessoa, idDirExec),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idPresidente) references presidente (idPresidente)
);
 
create table preparador_de_goleiro (
    idPessoa integer not null,
    idPrepGol integer not null auto_increment,
    formacao varchar(30),
    idDirExec integer not null,

    primary key (idPessoa, idPrepGol),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idDirExec) references diretor_executivo (idDirExec)
);
 
create table preparador_fisico (
    idPessoa integer not null,
    idPrepFisi integer not null auto_increment,
    formacao varchar(30),
    idDirExec integer not null,

    primary key (idPessoa, idPrepFisi),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idDirExec) references diretor_executivo (idDirExec)
);
 
create table treinador (
    idPessoa integer not null,
    idTreinador integer not null auto_increment,
    autorizacaoNacional integer not null,
    idDirExec integer not null,

    primary key (idPessoa, idTreinador),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idDirExec) references diretor_executivo (idDirExec)
);
 
create table jogador (
    idPessoa integer not null,
    idJogador integer not null auto_increment,
    experiencia integer not null,
    numeroCamisa integer not null,
    idPrepFisi integer not null,
    idTreinador integer not null,
    idDirExec integer not null,

    primary key (idPessoa, idJogador),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idPrepFisi) references preparador_fisico (idPrepFisi),
    foreign key (idTreinador) references treinador (idTreinador),
    foreign key (idDirExec) references diretor_executivo (idDirExec)
);
 
create table goleiro (
    idPessoa integer not null,
    idJogador integer not null,
    idGol integer not null auto_increment,
    qtdPenaltisDefendidos integer not null,
    idPrepGol integer not null,

    primary key (idPessoa, idJogador, idGol),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idJogador) references jogador (idJogador),
    foreign key (idPrepGol) references preparador_de_goleiro (idPrepGol)
);
 
create table jogador_de_linha (
    idPessoa integer not null,
    idJogador integer not null,
    idJogLin integer not null auto_increment,
    horasTreinadas integer not null,
    velocidadeMaxima integer not null,
    altura integer not null,
    qtdAssistencias integer not null,
    qtdGols integer not null,

    primary key (idPessoa, idJogador, idJogLin),
    foreign key (idPessoa) references pessoa (idPessoa),
    foreign key (idJogador) references jogador (idJogador)
);

-- SCRIPT POO
DROP DATABASE MERCEARIA;
create database mercearia;
use mercearia;
 
create table produto (
    idProduto integer not null auto_increment,
    nome varchar(50) not null,
    dataValidade varchar(20) not null,
    preco double not null,

    primary key (idProduto)
);
 
insert into produto (nome, dataValidade, preco) values ('Açúcar', '23/07/2021',  2.69);
insert into produto (nome, dataValidade, preco) values ('Arroz', '05/06/2022', 26.99);
insert into produto (nome, dataValidade, preco) values ('Biscoitos', '30/12/2020', 3.99);
insert into produto (nome, dataValidade, preco) values ('Café', '01/03/2022', 8.39);
insert into produto (nome, dataValidade, preco) values ('Farinha', '08/08/2021', 4.99);
insert into produto (nome, dataValidade, preco) values ('Feijão', '07/04/2022', 7.39);
insert into produto (nome, dataValidade, preco) values ('Fermento', '15/12/2020', 3.60);
insert into produto (nome, dataValidade, preco) values ('Iogurte', '30/01/2021', 2.49);
insert into produto (nome, dataValidade, preco) values ('Leite', '07/10/2021', 3.29);
insert into produto (nome, dataValidade, preco) values ('Macarrão', '24/04/2023', 2.09);
insert into produto (nome, dataValidade, preco) values ('Margarina', '15/01/2021', 4.79);
insert into produto (nome, dataValidade, preco) values ('Molho de tomate', '22/06/2021', 1.29);
insert into produto (nome, dataValidade, preco) values ('Óleo', '25/03/2022', 6.39);
insert into produto (nome, dataValidade, preco) values ('Ovos', '27/12/2020', 11.70);
insert into produto (nome, dataValidade, preco) values ('Pães', '12/12/2020', 1.40);
insert into produto (nome, dataValidade, preco) values ('Queijo ralado', '17/08/2022', 3.80);
insert into produto (nome, dataValidade, preco) values ('Sal', '19/03/2024', 1.90);
insert into produto (nome, dataValidade, preco) values ('Água Sanitária', '14/05/2025', 6.99);
insert into produto (nome, dataValidade, preco) values ('Álcool em gel', '26/02/2023', 19.99);
insert into produto (nome, dataValidade, preco) values ('Amaciante', '11/11/2021', 6.75);
insert into produto (nome, dataValidade, preco) values ('Desinfetante', '10/07/2022', 2.79);
insert into produto (nome, dataValidade, preco) values ('Detergente', '27/03/2023', 1.70);
insert into produto (nome, dataValidade, preco) values ('Esponja de aço', '14/01/2023', 1.59);
insert into produto (nome, dataValidade, preco) values ('Esponja de pia', '05/07/2022', 2.40);
insert into produto (nome, dataValidade, preco) values ('Sabão em barra', '04/12/2021', 1.60);
insert into produto (nome, dataValidade, preco) values ('Sabão em pó', '01/04/2021', 6.90);
insert into produto (nome, dataValidade, preco) values ('Sacos de lixo', '10/10/2025', 13.00);
insert into produto (nome, dataValidade, preco) values ('Absorventes', '05/11/2022', 9.90);
insert into produto (nome, dataValidade, preco) values ('Água oxigenada', '19/09/2021', 5.80);
insert into produto (nome, dataValidade, preco) values ('Algodão', '30/09/2022', 5.99);
insert into produto (nome, dataValidade, preco) values ('Barbeador descartável', '17/03/2022', 1.16);
insert into produto (nome, dataValidade, preco) values ('Curativos', '01/01/2025', 8.15);
insert into produto (nome, dataValidade, preco) values ('Creme dental', '03/05/2021', 1.65);
insert into produto (nome, dataValidade, preco) values ('Desodorante', '01/07/2022', 20.00);
insert into produto (nome, dataValidade, preco) values ('Escova de dente', '02/02/2022', 2.39);
insert into produto (nome, dataValidade, preco) values ('Fio dental', '11/09/2024', 6.99);
insert into produto (nome, dataValidade, preco) values ('Papel higiênico', '12/03/2021', 14.80);
insert into produto (nome, dataValidade, preco) values ('Sabonete', '16/04/2021', 2.25);
insert into produto (nome, dataValidade, preco) values ('Shampoo', '20/01/2022', 9.89);
insert into produto (nome, dataValidade, preco) values ('Condicionador', '21/12/2023', 11.09);
insert into produto (nome, dataValidade, preco) values ('Caixa de Fósforo', '20/12/2026', 3.09);
insert into produto (nome, dataValidade, preco) values ('Lâmpadas', '02/10/2023', 4.31);
insert into produto (nome, dataValidade, preco) values ('Papel Alumínio', '30/01/2025', 3.34);
insert into produto (nome, dataValidade, preco) values ('Papel Filme', '05/06/2024', 6.90);
insert into produto (nome, dataValidade, preco) values ('Papel toalha', '07/09/2021', 5.19);

select * from produto;
