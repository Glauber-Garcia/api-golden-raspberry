<h1 align="center">
    API golden raspberry wards - TEXO IT
</h1>

<h3 align="center">
    Api teste para ingresso na empresa TEXO IT utilizando Java com Spring, JPA e Hibernate
</h3>

<p align="center">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/Glauber-Garcia/api-golden-raspberry?style=for-the-badge&logo=appveyor">

  <a href="https://github.com/Glauber-Garcia/api-golden-raspberry/commits/master?style=for-the-badge&logo=appveyor">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/Glauber-Garcia/api-golden-raspberry?style=for-the-badge&logo=appveyor">
  </a>

   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen?style=for-the-badge&logo=appveyor">

  <a href="https://rocketseat.com.br">
    <img alt="Feito por Glauber Garcia" src="https://img.shields.io/badge/feito%20por-Glauber Garcia-blue?style=for-the-badge&logo=appveyor">
  </a>



</p>

<h4 align="center">
	🚧   Concluído 🚀 🚧
</h4>

Tabela de conteúdos
=================
<!--ts-->
* [Sobre o projeto](#-sobre-o-projeto)
* [Funcionalidades](#-funcionalidades)
* [Como executar o projeto](#-como-executar-o-projeto)
* [Tecnologias](#-tecnologias)
* [Autor](#-autor)
* [Licença](#user-content--licença)
<!--te-->


## 💻 Sobre o projeto

️ Esse projeto é um teste solicitado para a empresa TEXOIT.

---

## ⚙️ Funcionalidades

- [x] Retornos da API:
    - [x] Retorna os produtores com o maior intervalo entre dois prêmios consecutivos;
    - [x] Retorna os produtores que obtiveram dois prêmios mais rápido;
    - [x] Lista dos Indicados;
    - [x] Lista dos vencedores;

---

## 🚀 Como executar o projeto

Backend (pasta server)

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina o java na versão 11 ou maior:
[JAVA](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html).

#### 🎲 Rodando o Backend (servidor)

```bash

# Clone este repositório
$ git clone git@github.com:Glauber-Garcia/api-golden-raspberry.git

# Acesse a pasta do projeto no terminal/cmd
$ cd api-golden-raspberry

# Vá para a pasta server
$ cd target

# execute o arquivo jar
$ java -jar api-golden-raspberry-0.0.1-SNAPSHOT.jar 

# O servidor inciará na porta:8080 - acesse http://localhost:8080 
# Para testar o retorno da API utilize o SwaggerUI

```
#### 🎲 Testando a API com o SwaggerUI
```bash

# Acesse o Swagger através do 
$ http://localhost:8080/swagger-ui.html#/

# Selecione o controlador que deseja utilizar

# Selecione o método que deseja executar

# Clique em Try it out
# Depois clique em Execute 

# Ao rolar para baixo você verá o retorno da requisição REST

```

---

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- Linguagem : **[Java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)**
- Servidor Web:  **[Spring](https://spring.io//)**
- Persistencia:  **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
- Mapeamento:  **[Hibernate](https://hibernate.org/)**
- IDE:  **[IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)**
- Base de Dados inMemory: **[h2](https://h2database.com/html/main.html)**
- Teste de API:  **[Swagger](https://swagger.io/)**



## 🦸 Autor

 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/39419369?v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Glauber Garcia</b></sub>
 <br />

[![Linkedin Badge](https://img.shields.io/badge/-Glauber-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/glauber-lucas-garcia-correa-leite-33390b158/)](https://www.linkedin.com/in/glauber-lucas-garcia-correa-leite-33390b158/)
[![Gmail Badge](https://img.shields.io/badge/-glaubercorreagarcia@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:glaubercorreagarcia@gmail.com)](mailto:glaubercorreagarcia@gmail.com)

---

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).

