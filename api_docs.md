# Endpoints

**GET /v1/subject/{slugOrId}**
----
  Retorna uma pauta baseado em seu ID ou seu [Slug](https://pt.wikipedia.org/wiki/Slug_(programa%C3%A7%C3%A3o)).

*  **Parâmetros**

   **Obrigatório:** `slugOrId=[string]`


**GET /v1/subject/?page={page}&size={size}**
----
  Retorna uma lista de pautas de forma paginada

*  **Parâmetros**

   **Não obrigatório (Valor Padrão=1):** `page=[int]`

   **Não obrigatório (Valor Padrão=100):** `page=[int]`


**POST /v1/subject/**
----
  Cria uma pauta nova.
  **Não é possível inserir duas pautas com o mesmo título.**

*  **Corpo**

  ```
  {
  	"title": "Título da pauta",
  	"description": "Descrição da pauta"
  }
  ```


**GET /v1/votesession/{id}**
----
  Retorna uma sessão de votação de uma pauta pelo seu ID.

*  **Parâmetros**

   **Obrigatório:** `id=[string]`


**GET /v1/votesession/?page={page}&size={size}**
----
  Retorna uma lista de sessões de votação de forma paginada

*  **Parâmetros**

   **Não obrigatório (Valor Padrão=1):** `page=[int]`

   **Não obrigatório (Valor Padrão=100):** `page=[int]`


**GET /v1/votesession/{id}/result**
----
  Retorna o resultado de uma sessão de votação.
  Se a sessão ainda está aberta, esse resultado é parcial.

*  **Parâmetros**

   **Obrigatório:** `id=[string]`

   **Conteúdo**

   ```
   {
     "optionsResults": [
       { "option": "yes", "total": 456 },
       { "option": "no", "total": 788 }
     ],
     "session": <VoteSession>
   }
   ```

**POST /v1/votesession/**
----
  Cria uma nova sessão de votação para uma pauta específica.
  **O Sistema permite criar mais de uma sessão para a mesma pauta para flexibilizar a funcionalidade,
  visto que pode ser útil em algum momento criar uma nova sessão de votação para a mesma pauta,
  para verificar se a opinião dos associados em relação a esta pauta mudou.**

*  **Corpo**

  ```
  {
  	"subjectId": "Id da pauta a qual essa sessão será referente.",
  	"expiresAt": "yyyy-MM-dd HH:mm:ss"
  }
  ```


**POST /v1/vote/**
----
  Cria um novo voto para de um associado em uma sessão específica.
  **É permitido somente um voto por associado em uma sessão de votação**

*  **Corpo**

  ```
  {
  	"associateId": "Id do associado.",
  	"sessionId": "Id da sessão de votação a ser vinculado",
  	"option": "yes/no",
  }
  ```

