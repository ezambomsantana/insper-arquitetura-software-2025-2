# Herança

Muitas aplicações possuem classes que possuem estruturas muito parecidas, exemplos:

- Classes Aluno, Professor, Coordenador: possuem vários campos parecidos como nome, cpf, dataNascimento. Podem ter também métodos parecidos como um para mostrar os dados básicos de cada classe. Porém, também
possuem dados diferentes, como matrícula para o aluno, salário para proofessores e coordenadores.
- Classes Credito, Pix e Boleto, possuem dados como  valor e a data do pagamento. Porém, dados diferentes, como o número e a validade do cartão, a chave pix e o código de barras do boleto. Toodas podem possuir
métodos parecidos como validarDados e realizarPagamento, mas que possuem implementações diferentes.

Se não usarmos nenhuma técnica, temos que repetir um monte de código. Como evitar isso? Herança!


Em Java (e em praticamente toda as linguagens orientadas a objeto) podemos definir que um classe herda os atributos e métodos de outra classe.

Exemplo:

- A classe Pessoa tem os atributos nome, idade e endereço e um método chamado apresentar, em que a pessoa se apresenta falando seu nome e idade. Além disso, uma pessoa pode ter um carro.
- A classe Professor possui exatamente os atributos da pessoa, mais o seu salário e o departamento que eles está ligado. O professor pode alterar um pouco a sua apresentação para também dizer o departamento que pertence.
- A classe coordenador que é um professor, mas além disso também tem o curso que oesse professor coordena.
- A classe Aluno também possui exatamente os mesmos atributos da pessoa, mais a sua mensalidade e o curso que pertence. O aluno também pode alterar um pouco a sua apresentação para falar o seu curso.
  
Chamamos a herança de um relacionamento é-um. Um aluno é uma pessoa, assim como um Professor é uma pessoa.
