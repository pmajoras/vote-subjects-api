# Decisões Técnicas

Abaixo segue uma descrição breve sobre o que há dentro de cada pacote da aplicação e as responsabilidades dos mesmos.

## com.associates.votesubjects.api

Classes relacionadas a camada mais externa da aplicação.

* Tratamento de erros
* Models que não são persistidas.
* Constantes.

## com.associates.votesubjects.controllers

Controllers responsáveis por expor os endpoints.

* Responsáveis somente por expor os endpoints.
* Devem possuir o mínimo de lógica possível, e se houver alguma lógica deve ser algo relacionado aos parâmetros da requisição.
* Implementam da Controller base para que possuam comportamentos padrões, que reduzem o tempo de "boilerplaite" ao expor novos endpoints.
* Caso tenham algum comportamente muito específico, deve ser criado um novo método ou extender os métodos da controller base.

## com.associates.votesubjects.core

Classes bases que serão utilizadas em todas as camadas dos sistemas.

* Contém as classes bases das camadas da aplicação. (Controllers, Serviços, Repositórios)
* Aqui devem ser inseridos classes que não possuem dependencias externas, e que sejam reutilizaveis em todas partes da aplicação.

## com.associates.votesubjects.models

Classes que representam os modelos persistidos no banco de dados.

* Contém a representação do banco de dados.
* Possuí lógica miníma, com funções facilitadoras que determinam o "estado" desses models.

## com.associates.votesubjects.repositories

Contém as classes responsáveis por fazer a comunicação direta com o banco de dados.

* Utiliza-se da interface genérica MongoRepository na maioria dos casos.
* Em métodos mais específicos, como relatórios ou queries que geram dados diferentes dos modelos persistidos é criado um repositório específico.
* Principalmente para queries que envolvem uma busca de dados maior é ALTAMENTE RECOMENDÁVEL, criar uma implementação própria e
fazer uma query customizada para melhor performance.

## com.associates.votesubjects.services

Contém os serviços da aplicação, onde é a camada que contém a lógica de negócio da mesma, os mesmos extendem do serviço base,
a não ser que não sejam serviços que trabalham diretamente com um modelo do banco de dados.

* A lógica de negócio geralmente é colocado no método save, fazendo as validações necessárias ao persistir uma entidade.
* É uma boa prática criar métodos privados com nomes claros para realizar a validação de uma regra específica para maior entendimento.
* Caso a aplicação cresça e as lógicas comecem a ficar muito complexas, é possível criar mais uma camada espécifica para validação de regras de negócios.

