/*1. Selecionar todos os registros e atributos da entidade cargo.

select
	*
from
	cargo;

2. Selecionar o nome e a quantidade de vereadores da entidade cidade,
ordenado pelo nome da cidade. 
select
	nome,
	qt_vereadores
from
	cidade
order by
	cidade.nome;

3. Selecionar o nome e a quantidade de vereadores da entidade cidade,
somente das cidades que possuem mais de 9 vereadores.
select
	nome,
	qt_vereadores
from
	cidade
where
	cidade.qt_vereadores > 9
order by
	nome;

4. Selecionar quantas cidades possuem mais de 9 vereadores. 
select
	count(*)
from
	cidade
where
	qt_vereadores > 9;

5. Selecionar a quantidade máxima de vereadores que uma cidade possui. 
select
	max(qt_vereadores)
from
	cidade;

6. Selecionar o nome da cidade que possui mais vereadores

select
	nome
from
	cidade
where
	qt_vereadores = (
	select
		max(qt_vereadores)
	from
		cidade);

7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select
	distinct nome
from
	candidato
where
	cargo = 1
order by
	nome;

8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome ordenados pelo nome.
select
	nome
from
	candidato
where
	cargo = 2
	and nome like '%MARIA%'
order by
	nome;

9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select
	nome
from
	candidato
where
	cargo = 2
	and nome like 'Y%'
order by
	nome;

10. Selecionar o nome dos candidatos a prefeito de cada cidade,
ordenado pelo nome da cidade e em seguida pelo nome do candidato. 
select
	CIDADE.NOME,
	candidato.nome
from
	candidato
inner join cidade on
	candidato.id = cidade.id
	and candidato.cargo = 1
order by
	cidade.nome,
	candidato.nome;

11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO',
ordenado pelo nome do candidato.
select
	nome
from
	candidato
where
	cidade = (
	select
		id
	from
		cidade
	where
		nome = 'TUBARÃO')
	and cargo = 1
order by
	nome;

12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores. 
select
	cidade.nome,
	candidato.nome
from
	cidade
inner join candidato
on
	candidato.cidade = cidade.id
	and candidato.cargo = 1
where
	cidade.qt_eleitores = (
	select
		max(qt_eleitores)
	from
		cidade);

13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO’. 
select
	count(*)
from
	candidato c
inner join cidade on
	cidade.id = c.cidade
	and cidade.nome = ' TUBARÃO'
inner join cargo on
	cargo.id = c.cargo
	and cargo.nome = ‘Vereador’;

14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.

select
	cidade.nome,
	count(cand.*)
from
	cidade
inner join candidato cand on
	cand.cidade = cidade.id
inner join cargo on
	cargo .id = cand.cargo
	and cargo.nome = ' Vereador'
group by
	cidade.nome
order by
	cidade.nome;

15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão. 

select
	cargo.nome,
	vi.brancos,
	vi.nulos 
from
	voto_invalido vi
inner join cidade on
	vi.cidade = cidade.id
	and cidade.nome = ' TUBARÃO'
inner join cargo on
	cargo.id = vi.cargo;

16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão. 


select
	vi.brancos +
	vi.nulos as invalidos
from
	voto_invalido vi
inner join cidade on
	vi.cidade = cidade.id
	and cidade.nome = ' TUBARÃO'
inner join cargo on
	cargo.id = vi.cargo
	and cargo.nome = ' Prefeito';



17. Selecionar a quantidade de votos válidos(voto.voto) para cada candidato a prefeito(candidato.cargo=1) da cidade de Tubarão(candidato.cidade = 274), ordenados pela maior quantidade de votos (order by voto desc). 

select
	voto.voto,
	candidato.nome
from
	voto
inner join candidato on
	candidato.id = voto.candidato
inner join cargo on
	cargo.id = candidato.cargo
	and cargo.nome = ' Prefeito'
inner join cidade on
	cidade.id = candidato.cidade
	and cidade.nome = ' TUBARÃO'
order by
	voto.voto desc;

18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão ordenados pela maior quantidade de votos. 

select
	voto.voto,
	candidato.nome
from
	voto
inner join candidato on
	candidato.id = voto.candidato
inner join cargo on
	cargo.id = candidato.cargo
	and cargo.nome = ' Vereador'
inner join cidade on
	cidade.id = candidato.cidade
	and cidade.nome = ' TUBARÃO'
order by
	voto.voto desc;

19. Selecionar a maior quantidade de votos para prefeito de cada cidade. 

select
	cidade.nome,
	max(voto.voto) as votos
from
	voto
inner join candidato on
	candidato.id = voto.candidato
inner join cidade on
	cidade.id = candidato.cidade
inner join cargo on
	cargo.id = candidato.cargo
	and cargo.nome = ' Prefeito'
group by
	cidade.nome;

20. Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão ordenados pela maior quantidade de votos. 

select
	partido.sigla,
	sum(voto.voto) as votos
from
	voto
inner join candidato on
	candidato.id = voto.candidato
inner join cidade on
	cidade.id = candidato.cidade
	and cidade.nome = 'TUBARÃO'
inner join partido on
	partido.id = candidato.partido
group by
	partido.sigla
order by
	votos desc;
	
21. Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os votos registrados são considerados os votos para os candidatos, mais os votos brancos e nulos. 

SELECT 
	candidato.nome, 
	SUM(voto.voto) + vi.brancos+ vi.nulos votos
FROM
	voto
INNER JOIN candidato ON
	candidato.id = voto.candidato
INNER JOIN 
	cidade ON cidade.id = candidato.cidade AND cidade.nome = 'TUBARÃO'
INNER JOIN 
	cargo ON cargo.id = candidato.cargo AND cargo.nome = 'Prefeito'
INNER JOIN
	voto_invalido vi ON vi.cidade = cidade.id AND vi.cargo = cargo.id
GROUP BY 
	vi.brancos, vi.nulos;

22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão. 

SELECT 
	cidade.qt_eleitores - (sum (voto.voto) + vi.brancos + vi.nulos) as total
FROM 
	voto
INNER JOIN 
	candidato on candidato.id = voto.candidato
INNER JOIN 
	cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
INNER JOIN 
	cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
INNER JOIN
	voto_invalido vi on vi.cargo = candidato.cargo and vi.cidade = candidato.id
GROUP BY cidade.qt_eleitores, vi.brancos, vi.nulos;

23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade, ordenado pela maior quantidade de faltantes. 

SELECT 
	cidade.nome, (cidade.qt_eleitores  - (sum(voto.voto)+ vi.brancos  + vi.nulos)) AS eleitores_faltantes
FROM 
	voto
INNER JOIN
	candidato ON candidato.id = voto.candidato
INNER JOIN
	cidade ON cidade.id = candidato.cidade
INNER JOIN
	cargo ON cargo.id = candidato.cargo and cargo.nome  = 'Prefeito'
INNER JOIN
	voto_invalido vi on vi.cidade = cidade,id and vi.cargo = cargo.id
GROUP BY
	cidade.nome, cidade.qt_eleitores, vi.brancos, vi.nulos
ORDER BY eleitores_faltantes DESC;

24. Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual. 

SELECT
	cidade.nome, 
	((cidade.qt_eleitores  - (sum(voto.voto)+ vi.brancos  + vi.nulos))/cidade.qt_eleitores) * 100 AS percentual_faltantes
FROM 
	voto
INNER JOIN
	candidato on candidato.id = voto.candidato
INNER JOIN
	cidade on cidade.id = candidato.cidade
INNER JOIN
	cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
INNER JOIN 
	voto_invalido vi on vi.cidade = cidade.id and vi.cargo = cargo.id
GROUP BY 
	cidade.nome, cidade.qt_eleitores, vi.brancos, vi.nulos
ORDER BY 
	percentual_faltantes DESC;

25. Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade.

SELECT DISTINCT ON (cidade.nome) cidade.nome, candidato.nome, voto.voto
FROM 
	voto
INNER JOIN
	candidato
	ON candidato.id = voto.candidato
INNER JOIN cidade
	ON cidade.id = candidato.cidade
INNER JOIN cargo
	ON cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
ORDER BY 
	cidade.nome, voto.voto desc;

*/
