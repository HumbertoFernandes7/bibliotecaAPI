Projeto desenvolvido em Java 17 com Spring Boot, Spring Data JPA, Hibernate, Swagger e Banco de Dados MySql.

Um projeto de API para gerenciamento de uma Biblioteca com as seguintes funções até o momento.

O projeto permite que você:

+ Adicione autores
+ Altere autores
+ Liste todos os autores cadastrados
+ Liste um autor pelo id

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

+ Adicione livros
+ Altere livros
+ Liste todos os livros
+ Liste um livro pelo id
+ Exclusão de livros pelo id

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

(Banco de dados Mysql)
Em aplication.properties o nome padrão gerado é: 
+ (bibliotecaDB)
+ Nome de usuario e senha padrão: (root)
<p>As informações acima podem ser livremente alteradas caso necessario</p>

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para realizar o cadastro de um Autor utiliza-se o seguinte formato:
+ Url: http://localhost:8080/api/autores/adicionar

+ "nome": "Um nome ",
+ "biografia": "Uma biografia"

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Para realizar o cadastro de um Livro utiliza-se o seguinte formato:
+ Url: http://localhost:8080/api/livros/adicionar

+ "titulo": "Um titulo",
+ "dataLancamento": (Uma data), (exemplo: 2000)
+ "autores": "Um autor"

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para realizar a atualização de um Autor utiliza-se o seguinte formato:
+ Url: http://localhost:8080/api/autores/atualizar/{id}

  + "id": id,
  + "nome": "Nome atualizado "
  + "biografia":"Biografia atualizada",  

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para realizar a atualização de um Livro utiliza-se o seguinte formato:
  + Url: http://localhost:8080/api/livros/atualizar/{id}

  + "id": id,
  + "titulo": "Titulo atualizado",
  + "dataLancamento": Data atualizada,
  + "autores": "autores atualizados"

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para visualizar a lista de todos Autores/Livros utiliza-se o seguinte formato:
   + Url: http://localhost:8080/api/autores

   + Url: http://localhost:8080/api/livros

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para visualizar apenas um Autor/Livro pelo seu id utiliza-se o seguinte formato:
   + Url: http://localhost:8080/api/autores/{id}

   + Url: http://localhost:8080/api/livros/{id}

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para deletar um livros pelo id utiliza-se o seguinte formato:
   + Url: http://localhost:8080/api/livros/deletar/{id}

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Observações:
+ Todos os campos são obrigatorios e não podem estar nulos.

Autor:
+ Nome não podera ultrapassar 100 caracteres
+ Biografia não podera ultrapassar 1000 caracteres



Livro:
+ Titulo não podera ultrapassar 200 caracteres
+ DataLancamento não podera ultrapassar 4 caracteres
+ Deve conter ao menos 1 autor
