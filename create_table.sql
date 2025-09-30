create table evento(
  id int not null auto_increment,
  descricao varchar(100),
  email varchar(100),
  `data` date,
  frequencia set('DIARIO', 'SEMANAL', 'MENSAL'),
  alarme boolean,
  primary key(id)
);