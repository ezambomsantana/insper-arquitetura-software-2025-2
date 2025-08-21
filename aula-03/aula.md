# Relacinamento entre classes

Quando criamos várias classes em um sistema, muitas vezes elas precisam trabalhar juntas. Esse vínculo entre classes é chamado de relacionamento.

Um relacionamento acontece quando um objeto usa outro objeto para realizar alguma ação ou representar uma ideia do mundo real.

Existem três tipos principais de relacionamento:

- Associação: Representa quando uma classe se relaciona com outra, mas ambas podem existir separadamente.

    - Exemplo: um Professor leciona uma disciplina, mas disciplina e professor existem independentemente uma da outra.

- Agregação: É um tipo especial de associação, quando uma classe é formada por várias outras, mas os objetos podem existir independentemente.

    - Exemplo: uma Disciplina possui vários Alunos, mas os alunos continuam existindo mesmo sem a disciplina.

- Composição: É o relacionamento mais forte: um objeto só existe dentro do outro. Se o objeto “todo” deixar de existir, suas partes também deixam.

    - Exemplo: um Pedido é formado por Produtos dentro dele. Se o pedido é apagado, aqueles produtos (no contexto do pedido) deixam de existir.

## Exemplo

Um exemplo em Python, que vamos transformar em Java, é a ligação de alunos com curso.


```python
# Lista de alunos
aluno1 = {"nome": "Maria", "matricula": "A001"}
aluno2 = {"nome": "João", "matricula": "A002"}
aluno3 = {"nome": "Ana", "matricula": "A003"}

# Curso com a lista de alunos
curso = {
    "nome": "Engenharia de Software",
    "codigo": "C001",
    "alunos": [aluno1, aluno2]  # começa com dois alunos
}

# Funções de manipulação
def adicionar_aluno(curso, aluno):
    curso["alunos"].append(aluno)

def listar_alunos(curso):
    print(f"Alunos do curso {curso['nome']}:")
    for aluno in curso["alunos"]:
        print(f"- {aluno['nome']} ({aluno['matricula']})")

def remover_aluno(curso, matricula):
    curso["alunos"] = [a for a in curso["alunos"] if a["matricula"] != matricula]


listar_alunos(curso)

print("\nAdicionando novo aluno...")
adicionar_aluno(curso, aluno3)
listar_alunos(curso)


print("\nRemovendo o aluno João...")
remover_aluno(curso, "A002")
listar_alunos(curso)
```


## Exercícios

- Exercício 1:

  - Classe Pessoa e Carro:
    - Carro -> Atributos: nome, modelo, placa e anoFrabricacao.
      
            -> Métodos: calculaIdade.
    
    - Pessoa -> Atributos: nome, cpf e uma lista de carros.
      
             -> Métodos: adicionarCarro, removerCarro e listarCarros.
 
- Exercício 2
