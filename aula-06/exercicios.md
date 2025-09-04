Implemente as seguinte APIs REST. Para todas as entidades implementar as rotas de criar, editar, listar e buscar um pela chave (id, cpf,...).

---

### 1. **Biblioteca Online**

* **Livro** (título, ano, ISBN) -> ISBN como chave
* **Autor** (nome, cpf, nacionalidade) -> CPF como chave
* **Categoria** (id, nome, descrição)


* Relações:
  * Um **autor** pode ter vários **livros** e um **livro** tem um autor.
  * Um **livro** pertence a uma **categoria**.

---

### 2. **Sistema de Cinema**

* **Filme** (id, título, gênero, duração)
* **Sessão** (id, horário, sala)
* **Ingresso** (id, número, clienteNome)
* **Cliente** (cpf, nome)


* Relações:
  * Um **filme** pode ter várias **sessões**, e uma **sessão** tem um filme.
  * Uma **sessão** pode ter vários **ingressos**, e um **ingresso** é sempre de uma sessão.
  * Um **ingresso** pertence a um cliente.

---

### 3. **Rede Social Simplificada**

* **Usuário** (email, nome, email) -> email chave
* **Post** (id, conteúdo, data)
* **Comentário** (id, texto)

* Relações:
  * Um **usuário** pode criar vários **posts**, um **post** peretence a um **usuário**.
  * Um **post** pode ter vários **comentários**, que também vêm de um **usuário**.

---

### 4. **Plataforma de Cursos**

* **Curso** (id, título, descrição)
* **Professor** (nome, cpf, especialidade)
* **Aluno** (id, nome, email)

  
* Relações:
  * Um **professor** pode ministrar vários **cursos** e um **curso** tem um professr.
  * Um **aluno** pode se inscrever em vários **cursos** e um **curso pode se inscrever em vários curso.
