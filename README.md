
# Processo seletivo CBLab
## Como utilizar
- Baixe este repositório.
- Escolha sua <a href="#">branch</a>
- ``mysql> create database cblab``
- Altere o login e senha do banco no arquivo pom.xml (localizado na raiz do projeto)
- ```xml
	# PS-cblab/pom.xml
	spring.datasource.url=jdbc:mysql://localhost:3306/cblab
	spring.datasource.username=SEU LOGIN DO BANCO DE DADOS
	spring.datasource.password=SUA SENHA DO BANCO DE DADOS
	```
## Branch
Este repositório possui duas branches com duas variações do mesmo projeto.
Na branch `master` temos uma API REST com autenticação pelo spring security.
Na branch `finalFront` temos um app spring com autenticação pelo spring security e uma inferface criada utilizando HTML, CSS, Bootstrap e thymeleaf. (Para mais informações sobre a escolha das tecnologias, <a href="#">clique aqui</a>

