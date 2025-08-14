# ======================================
# 1. VARIÁVEIS E TIPAGEM DINÂMICA
# ======================================
# Em Python não precisamos declarar o tipo da variável.
# O tipo é definido automaticamente pelo valor atribuído.

var1 = "texto"       # Tipo string
print(var1)

var1 = len(var1)     # Agora var1 vira inteiro (int)
print(var1)

# ======================================
# 2. CONDICIONAIS (if / elif / else)
# ======================================
# O 'elif' é equivalente ao 'else if' no Java.

if var1 > 10:
    print("maior que 10")
elif var1 > 5:
    print("maior que 5")
else:
    print("menor que 5")

# ======================================
# 3. LISTAS
# ======================================
# Listas em Python aceitam qualquer tipo de valor e têm métodos prontos.
# Aqui criamos uma lista de inteiros.

var1 = [1, 2, 3, 4, 5]

# Loop "for each"
for num in var1:
    print(num)

# Loop com range (1 até 19)
for i in range(1, 20):
    print(i)

# Loop com índice e valor (enumerate)
for idx, x in enumerate(var1):
    print(idx, x)

# Adicionando um elemento na lista
var1.append(20)
print(var1)

# ======================================
# 4. CONJUNTOS (set)
# ======================================
# Sets não permitem valores duplicados e não têm ordem garantida.

var1 = {1, 5, 3, 1}
print(var1)  # O valor 1 repetido será ignorado

# ======================================
# 5. DICIONÁRIOS (dict)
# ======================================
# Dicionários guardam pares chave-valor.

var1 = {'a': 1, 'b': 2}
print(var1)

# ======================================
# 6. ENTRADA DE DADOS
# ======================================
# O input() sempre retorna uma string.
# Se quisermos outro tipo (ex.: int) precisamos converter.

var1 = input("nome: ")
print(var1)

# ======================================
# 7. DICIONÁRIO ANINHADO
# ======================================
# Estruturas podem conter listas e outros dicionários dentro.

var1 = {
    'nome': 'Filme 1',
    'ano': 20202,
    'atores': [
        'ator-1', 'ator-2'
    ]
}
print(var1)

# ======================================
# 8. CLASSES E OBJETOS
# ======================================
# Classes em Python usam o 'self' para acessar atributos e métodos.
# Podemos criar atributos dinamicamente no construtor (__init__).

class Filme:
    def __init__(self, nome, ano):
        self.nome = nome
        self.ano = ano
        self.atores = []

    def get_nome(self):
        print(self.nome)  # Corrigido: era self.name no original

    def adiciona_ator(self, ator):
        self.atores.append(ator)
        print(f"Ator {ator} adicionado.")

# Criando um objeto da classe Filme
filme = Filme("Teste", 2023)
filme.adiciona_ator("ator-1")
filme.adiciona_ator("ator-2")

# Acessando atributo diretamente
print(filme.nome)

# ======================================
# FIM DO EXEMPLO
# ======================================
