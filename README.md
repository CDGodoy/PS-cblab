
# Processo seletivo CBLab
## Como utilizar
- Baixe este repositório.
- Escolha sua <a href="Branch">branch</a> utilizando no terminal o seguinte comando: ``git checkout nomeDaBranch``
- Execute o seguinte comando para criar uma tabela no banco Mysql para a API ``mysql> create database cblab``
- Altere o login e senha do banco no arquivo pom.xml (localizado na raiz do projeto)
- ```xml
	# PS-cblab/pom.xml
	spring.datasource.url=jdbc:mysql://localhost:3306/cblab
	spring.datasource.username=SEU LOGIN DO BANCO DE DADOS
	spring.datasource.password=SUA SENHA DO BANCO DE DADOS
	```
- Na pasta raiz do projeto, rode o seguinte comando: ``mvn spring-boot:run``
- Caso não possua o maven em sua máquina, poderá executar na branch master, um dos 2 arquivos .jar disponíveis, apenas garanta que o login e senha do seu bando de dados seja: `login: admin ` `senha: 12345678`
### Credenciais:
#### Super Usuário: 
Login: admin@admin.com
senha: admin
#### Usuário:
Login: usuario@usuario.com
senha: usuario

#### Cadastro de super usuário
Por motivos de segurança, decidi não disponibilizar o cadastro de um super usuário, imaginando a situação de um usuário mal intencionado conseguir a senha de um super usuário e assim, criar um super usuário para si.
## Requisitos
- [x] Um usuário deve ter nome, email, senha e se é um super usuário
- [x] Cadastrar, listar e logar um usuário
- [x]  Somente super usuários podem listar e cadastrar usuários
- [x] Usuários comuns só podem logar e ver seus dados
- [ ] A autenticação deve ser feita seguindo o protocolo Oauth2

## Branch
Este repositório possui duas branches com duas variações do mesmo projeto. Por questões de usabilidade, recomendo utilizar a branch `finalFront` para teste e utilizar a branch `master` para análise de código da API REST

 `master` temos uma API REST sem um client, com autenticação pelo spring security, você pode testa-la utilizando um RESTClient (Postman, Insomnia, etc..) e seguindo as instruções do tópico <a href="Rotas de uso">Rotas de uso</a>
 
Na branch `finalFront` temos um app spring que possui autenticação com spring security e uma inferface criada utilizando HTML, CSS, Bootstrap e thymeleaf (Para mais informações sobre a escolha das tecnologias, <a href="Tecnologias">clique aqui</a>).

## Rotas de uso
- `GET`/usuario/todos - Obtém um JSON com todos os usuários cadastrados no sistema, informando, ID, nome, email e se é um super usuário
- `POST`/usuario - Cadastra um usuário no sistema, devem ser passados por JSON: Nome, email e senha.
- `GET`/usuario - Mostra as informações do usuário logado.
- `GET`/usuario/{id} - Mostra o usuário com o id informado.
## Tecnologias

<div style="display: inline_block" align="center"><br>
  <img align="center" alt="Judeu-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
  <img align="center" alt="Judeu-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
  <img align="center" alt="Judeu-Mysql" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg">
  <img align="center" alt="Judeu-HTML" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original.svg">
  <img align="center" alt="Judeu-CSS" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original.svg">
   <img align="center" alt="Judeu-CSS" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-original.svg">
</div>

- Java 11;
- Spring 2.5.6;
- Mysql;
- HTML 5;
- CSS3;
- Bootstrap;
### Motivos
Essas tecnologias foram escolhidas principalmente por conhecimento, afinidade e experiência com as mesmas.

## Problemas
### Autenticação OAuth2
Infelizmente não conhecia o OAuth2 e  o tempo não foi suficiente para aprender a utilizar e implementar o mesmo no spring. Para não deixar sem nenhuma segurança, implementei o Spring security.
### Construção de um client
Por não possuir experiência, nem muitos estudos com Front-end, não consegui construir um client com algum framework (seja React, Vue ou Angular). Foram realizadas tentativas de construir um client mas sem sucesso, pois além da construção do mesmo, seria necessário implementar o OAuth2.

## Aos avaliadores
Primeiramente gostaria de agradecer a oportunidade de estar participando deste processo seletivo. Infelizmente não consegui atender a todos os critérios descritos no email, mas aprendi bastante tentando implementa-los.
Espero conseguir ser aprovado, mas caso contrário, ser selecionado para esta fase do processo já foi bastante gratificante.
Atenciosamente, Carlos Daniel Godoy.
