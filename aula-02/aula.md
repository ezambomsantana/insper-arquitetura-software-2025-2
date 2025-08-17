# Modelagem Orientada à Objetos

Modelagem orientada a objetos é uma forma de pensar e organizar um sistema a partir de entidades do mundo real, chamadas **objetos**. Cada objeto possui **atributos** (características) e **métodos** (comportamentos), que juntos descrevem como ele funciona dentro do domínio do problema. Essa abordagem favorece a criação de modelos próximos da realidade, mais fáceis de entender, reutilizar e manter, já que os objetos podem interagir entre si formando estruturas mais complexas.  

Diferente da **programação procedural**, onde o foco está em funções e na sequência de passos a serem executados, a orientação a objetos foca em **quem executa as ações**. Na programação procedural o código tende a ser centrado em rotinas que manipulam dados soltos, enquanto na orientação a objetos os dados e as operações ficam encapsulados dentro das próprias classes. Isso traz mais organização, clareza e flexibilidade, permitindo que o mesmo objeto seja reutilizado em diferentes partes do sistema ou até em outros projetos.  

---

# Abordagem Bottom-Up

A abordagem **top-down** começa pelo todo para depois detalhar as partes. Nela, o programador primeiro pensa nas funcionalidades de mais alto nível do sistema, como telas, rotas de API ou casos de uso, e só depois vai descendo para os detalhes de implementação, como as classes e métodos necessários para suportar essas funcionalidades. Essa forma é comum em linguagens dinâmicas, como Python, onde muitas vezes se escreve primeiro o “fluxo” principal e depois se ajusta a estrutura de dados conforme a necessidade.  

Já a abordagem **bottom-up** segue o caminho inverso: parte dos blocos fundamentais do sistema — como as classes do domínio, suas relações e regras de negócio — para depois construir as funcionalidades externas em cima disso. Nessa visão, primeiro se define bem o modelo que representa a realidade (ex.: `Pessoa`, `Pedido`, `Produto`) e só depois se expõe esse modelo em APIs, interfaces gráficas ou serviços. Essa forma é muito comum em Java, que incentiva uma modelagem de domínio robusta antes de pensar na camada de apresentação.  

---

# Exemplos

## Funcionários de uma empresa

### 🔹 Em Python
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


```java
import java.time.LocalDate;

class Funcionario {
    String nome;
    String funcao;
    double salario;
    LocalDate dataDeContratacao;

    // Construtor
    public Funcionario(String nome, String funcao, double salario, LocalDate dataDeContratacao) {
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
        this.dataDeContratacao = dataDeContratacao;
    }
}
```

```java
Funcionario f = new Funcionario(
    "Maria Silva",
    "Desenvolvedora",
    8500.00,
    LocalDate.of(2022, 5, 10)
);

System.out.println(f.nome);
System.out.println(f.salario);
```




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


```python

from datetime import date, datetime

# --------------------------
# Funções de negócio
# --------------------------

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

def excluir_funcionario(lista, nome):
    for func in lista:
        if func["nome"] == nome:
            lista.remove(func)
            return True
    return False

def aumentar_salario(lista, nome, porcentagem):
    for func in lista:
        if func["nome"] == nome:
            func["salario"] *= (1 + porcentagem / 100)
            return True
    return False

# --------------------------
# Main
# --------------------------

def main():
    funcionarios = []
    
    while True:
        print("\nMenu:")
        print("1 - Cadastrar Funcionário")
        print("2 - Excluir Funcionário")
        print("3 - Aumentar Salário")
        print("4 - Listar Funcionários")
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
            nome = input("Nome do funcionário a excluir: ")
            if excluir_funcionario(funcionarios, nome):
                print("Funcionário excluído.")
            else:
                print("Funcionário não encontrado.")
        
        elif opcao == "3":
            nome = input("Nome do funcionário: ")
            porcentagem = float(input("Porcentagem de aumento: "))
            if aumentar_salario(funcionarios, nome, porcentagem):
                print("Salário atualizado.")
            else:
                print("Funcionário não encontrado.")
        
        elif opcao == "4":
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
