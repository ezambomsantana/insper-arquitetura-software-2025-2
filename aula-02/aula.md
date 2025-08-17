# Modelagem Orientada à Objetos

Modelagem orientada a objetos é uma forma de pensar e organizar um sistema a partir de entidades do mundo real, chamadas **objetos**. Cada objeto possui **atributos** (características) e **métodos** (comportamentos), que juntos descrevem como ele funciona dentro do domínio do problema. Essa abordagem favorece a criação de modelos próximos da realidade, mais fáceis de entender, reutilizar e manter, já que os objetos podem interagir entre si formando estruturas mais complexas.  

Diferente da **programação procedural**, onde o foco está em funções e na sequência de passos a serem executados, a orientação a objetos foca em **quem executa as ações**. Na programação procedural o código tende a ser centrado em rotinas que manipulam dados soltos, enquanto na orientação a objetos os dados e as operações ficam encapsulados dentro das próprias classes. Isso traz mais organização, clareza e flexibilidade, permitindo que o mesmo objeto seja reutilizado em diferentes partes do sistema ou até em outros projetos.  

---

# Abordagem Bottom-Up

A abordagem **top-down** começa pelo todo para depois detalhar as partes. Nela, o programador primeiro pensa nas funcionalidades de mais alto nível do sistema, como telas, rotas de API ou casos de uso, e só depois vai descendo para os detalhes de implementação, como as classes e métodos necessários para suportar essas funcionalidades. Essa forma é comum em linguagens dinâmicas, como Python, onde muitas vezes se escreve primeiro o “fluxo” principal e depois se ajusta a estrutura de dados conforme a necessidade.  

Já a abordagem **bottom-up** segue o caminho inverso: parte dos blocos fundamentais do sistema — como as classes do domínio, suas relações e regras de negócio — para depois construir as funcionalidades externas em cima disso. Nessa visão, primeiro se define bem o modelo que representa a realidade (ex.: `Pessoa`, `Pedido`, `Produto`) e só depois se expõe esse modelo em APIs, interfaces gráficas ou serviços. Essa forma é muito comum em Java, que incentiva uma modelagem de domínio robusta antes de pensar na camada de apresentação.  

---

# Exemplo

## Funcionários de uma empresa

Em Python é bastante comum representar objetos, como um funcionario, usando um dicionário:

```python
funcionario = {
    "nome": "Maria Silva",
    "funcao": "Desenvolvedora",
    "salario": 8500.00,
    "dataDeContratacao": "2022-05-10"
}

print(funcionario["nome"])
print(funcionario["salario"])
```

Em Java, nunca usamos dicionários para representar objetos da nossa aplicação, usamos classes.

Os comportamentos podem ser implementados, esperando no parâmetro de uma função um funcionário:

```python
from datetime import date, datetime

funcionario = {
    "nome": "Maria Silva",
    "funcao": "Desenvolvedora",
    "salario": 8500.00,
    "dataDeContratacao": "2022-05-10"
}

def anos_na_empresa(func):
    data_contratacao = datetime.strptime(func["dataDeContratacao"], "%Y-%m-%d").date()
    return date.today().year - data_contratacao.year

def aumentar_salario(func, porcentagem):
    func["salario"] *= (1 + porcentagem / 100)

def mudar_funcao(func, nova_funcao):
    func["funcao"] = nova_funcao

# Uso
print(anos_na_empresa(funcionario))
aumentar_salario(funcionario, 10)
mudar_funcao(funcionario, "Arquiteta de Software")

print(funcionario)

```

Em Java, os comportamentos são implementados diretamente nas classes, e para o método ser executado, deve existir um objeto do tipo da classe.


```python

from datetime import date, datetime


def anos_na_empresa(func):
    data_contratacao = datetime.strptime(func["dataDeContratacao"], "%Y-%m-%d").date()
    return date.today().year - data_contratacao.year

def cadastrar_funcionario(lista, nome, funcao, salario, data_contratacao):
    funcionario = {
        "nome": nome,
        "funcao": funcao,
        "salario": salario,
        "dataDeContratacao": data_contratacao
    }
    lista.append(funcionario)

def aumentar_salario(lista, nome, porcentagem):
    for func in lista:
        if func["nome"] == nome:
            func["salario"] *= (1 + porcentagem / 100)
            return True
    return False

def main():
    funcionarios = []
    
    while True:
        print("\nMenu:")
        print("1 - Cadastrar Funcionário")
        print("2 - Aumentar Salário")
        print("3 - Listar Funcionários")
        print("0 - Sair")
        
        opcao = input("Escolha uma opção: ")
        
        if opcao == "1":
            nome = input("Nome: ")
            funcao = input("Função: ")
            salario = float(input("Salário: "))
            data_contratacao = input("Data de contratação (YYYY-MM-DD): ")
            cadastrar_funcionario(funcionarios, nome, funcao, salario, data_contratacao)
            print("Funcionário cadastrado com sucesso!")
        
        elif opcao == "2":
            nome = input("Nome do funcionário: ")
            porcentagem = float(input("Porcentagem de aumento: "))
            if aumentar_salario(funcionarios, nome, porcentagem):
                print("Salário atualizado.")
            else:
                print("Funcionário não encontrado.")
        
        elif opcao == "3":
            if not funcionarios:
                print("Nenhum funcionário cadastrado.")
            else:
                for f in funcionarios:
                    print(f)
        
        elif opcao == "0":
            print("Saindo...")
            break
        
        else:
            print("Opção inválida!")

if __name__ == "__main__":
    main()


```

---

Exercícios

Exercício 1: Gerenciamento de Produtos

- Classe: Produto

- Atributos:

    - nome (String)
    
    - preco (double)
    
    - quantidade (int)

- Métodos:

    - aumentarPreco(double porcentagem) – aumenta o preço em uma porcentagem.
    
    - alterarEstoque(int quantidade) – reduz a quantidade do produto.
    

Implementar a classe GerenciarProdutos com as funções de criar um produto, excluir produto, aumentar o preço de um produto e alterar o estoque de um produto.

Exercício 2: Aluno

Classe: Aluno

Atributos:

nome (String)

nota1 (double)

nota2 (double)

Métodos:

media() – retorna a média das notas.

foiAprovado() – retorna true se a média for maior ou igual a 6, caso contrário false.

atualizarNota1(double novaNota) – altera a primeira nota.

Na main:

Criar um aluno.

Calcular e mostrar a média.

Verificar se foi aprovado.

Atualizar a nota1 e recalcular a média.

Exercício 3: ContaBancaria

Classe: ContaBancaria

Atributos:

titular (String)

saldo (double)

Métodos:

depositar(double valor) – aumenta o saldo.

sacar(double valor) – diminui o saldo (se houver saldo suficiente).

aplicarJuros(double porcentagem) – aumenta o saldo com base em uma porcentagem.

Na main:

Criar uma conta.

Depositar 1000.

Sacar 200.

Aplicar 10% de juros.

Mostrar o saldo final.
