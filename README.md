# Descrição

Implantação de microsserviços utilizando Docker, SpringBoot, maven e tomcat.

# Pré-requisitos

<li>Java 1.8.0_171</li>
<li>Maven 3.5.2</li>
<li>STS</li>
<li>Docker 17.05.0-ce</li>
<li>Mysql v. 14 14 for linux</li>

# Instruções

Todos os comandos deverão ser executado via terminal.

Fazer o checkout via GitHub e na raiz do projeto executar o comando abaixo:

- mvn clean install

Com o build realizado com sucesso, executar o comando abaixo para criar os conteiners Java e Mysql-server e realizar a carga inicial do banco:

- docker-compose up --build

A partir de agora você poderá acessar os serviços pelos endpoints.

# Endpoints

Endpoints necessário para consumir os serviços da aplicação:

<li>Criar colaborador</li>

 - POST - http://localhost:8080/api/colaborador/create
 
 Segue abaixo, exemplo com os campos para realizar a chamada JSON:
 
 { 
 "nome":"",
 "email":"",
 "telefone":"",
 "cpf":"",
 "setor":{
 "id":""
 }}
 
<li>Listar colaboradores</li>

- GET - http://localhost:8080/api/colaborador/list

<li>buscar colaborador</li>

- GET - http://localhost:8080/api/colaborador/{id}

<li>Deletar colaborador</li>

- DELETE - http://localhost:8080/api/colaborador/{id}/delete








 
 
 
 
