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
