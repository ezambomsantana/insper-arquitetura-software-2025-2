Implemente as seguinte APIs REST

---

### 1. **Biblioteca Online**

* **Livro** (título, ano, ISBN) -> ISBN como chave
* **Autor** (nome, cpf, nacionalidade) -> CPF como chave
* **Categoria** (id, nome, descrição)
  ➡️ Relações:
* Um **autor** pode ter vários **livros**.
* Um **livro** pertence a uma **categoria**.

---

### 2. **Plataforma de Cursos**

* **Curso** (id, título, descrição)
* **Professor** (nome, cpf, especialidade)
* **Aluno** (id, nome, email)
  ➡️ Relações:
* Um **professor** pode ministrar vários **cursos**.
* Um **aluno** pode se inscrever em vários **cursos**

---

### 3. **Rede Social Simplificada**

* **Usuário** (id, nome, email)
* **Post** (id, conteúdo, data, usuario\_id)
* **Comentário** (id, texto, usuario\_id, post\_id)
  ➡️ Relações:
* Um **usuário** pode criar vários **posts**.
* Um **post** pode ter vários **comentários**, que também vêm de **usuários**.

---

### 4. **Sistema de Cinema**

* **Filme** (id, título, gênero, duração)
* **Sessão** (id, horário, sala)
* **Ingresso** (id, número, cliente\_nome)
  ➡️ Relações:
* Um **filme** pode ter várias **sessões**.
* Uma **sessão** pode ter vários **ingressos**.
