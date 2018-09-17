# API REST para votação de pautas

A aplicação trata-se de uma API REST com as funcionalidades de criação e votação de pautas, e contabilização dos votos dos associados.

## Documentação

* [Documentação dos Endpoints](api_docs.md)
* [Breve descrição de algumas decisões técnicas](tech_decisions.md)

## Iniciando a aplicação

Ao seguir as instruções abaixo, será possível iniciar a aplicação localmente.

### Pré-Requisitos

#### Para poder iniciar a aplicação, é necessário a instalação das seguintes dependencias:

* [Git](https://git-scm.com/downloads)
* [Versão 8 do Java](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* [MongoDB (rodando na porta padrão 27017)](https://www.mongodb.com/download-center#community)

### Instalando

Clonar o repositório
```
git clone https://github.com/pmajoras/vote-subjects-api.git
cd vote-subjects-api
```

Iniciar a aplicação (Windows)
```
gradlew.bat build bootRun
```

Iniciar a aplicação (Unix)
```
./gradlew build bootRun
```

A aplicação agora está rodando na porta [8585](http://localhost:8585/).

O ideal seria utilizar [docker](https://www.docker.com/) para iniciar a aplicação, porém não houve tempo para implementação com o mesmo.