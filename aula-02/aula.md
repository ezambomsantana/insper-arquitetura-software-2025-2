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

from datetime import datetime, date

# Lista para armazenar funcionários
funcionarios = []

def anos_na_empresa(func):
    data_contratacao = datetime.strptime(func["dataDeContratacao"], "%Y-%m-%d").date()
    return date.today().year - data_contratacao.year

def cadastrar_funcionario():
    nome = input("Digite o nome do funcionário: ")
    funcao = input("Digite a função: ")
    salario = float(input("Digite o salário: "))
    data_contratacao = input("Digite a data de contratação (YYYY-MM-DD): ")
    
    funcionario = {
        "nome": nome,
        "funcao": funcao,
        "salario": salario,
        "dataDeContratacao": data_contratacao
    }
    
    funcionarios.append(funcionario)
    print(f"\n✅ Funcionário {nome} cadastrado com sucesso!\n")

def excluir_funcionario():
    nome = input("Digite o nome do funcionário a ser excluído: ")
    for func in funcionarios:
        if func["nome"].lower() == nome.lower():
            funcionarios.remove(func)
            print(f"\n🗑️ Funcionário {nome} excluído com sucesso!\n")
            return
    print("\n⚠️ Funcionário não encontrado.\n")

def aumentar_salario():
    nome = input("Digite o nome do funcionário que terá aumento: ")
    for func in funcionarios:
        if func["nome"].lower() == nome.lower():
            porcentagem = float(input("Digite a porcentagem de aumento: "))
            func["salario"] *= (1 + porcentagem / 100)
            print(f"\n💰 Salário de {nome} atualizado para {func['salario']:.2f}\n")
            return
    print("\n⚠️ Funcionário não encontrado.\n")

def listar_funcionarios():
    if not funcionarios:
        print("\n⚠️ Nenhum funcionário cadastrado.\n")
        return
    print("\n📋 Lista de Funcionários:")
    for func in funcionarios:
        anos = anos_na_empresa(func)
        print(f"- {func['nome']} | {func['funcao']} | R$ {func['salario']:.2f} | {anos} anos na empresa")
    print()

def main():
    while True:
        print("=== Sistema de Gestão de Funcionários ===")
        print("1. Cadastrar funcionário")
        print("2. Excluir funcionário")
        print("3. Aumentar salário")
        print("4. Listar funcionários")
        print("5. Sair")
        
        opcao = input("Escolha uma opção: ")
        
        if opcao == "1":
            cadastrar_funcionario()
        elif opcao == "2":
            excluir_funcionario()
        elif opcao == "3":
            aumentar_salario()
        elif opcao == "4":
            listar_funcionarios()
        elif opcao == "5":
            print("\n👋 Encerrando o sistema.")
            break
        else:
            print("\n⚠️ Opção inválida! Tente novamente.\n")

if __name__ == "__main__":
    main()


```
