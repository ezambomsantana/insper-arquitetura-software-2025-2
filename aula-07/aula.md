# Serviço de Autenticação

Na maioria das APIs, precisamos identificar um usuário que está acessando a API, existem vários padrões de autenticação, vamos implementar um simples neste semestre usado
um token opaco, que pode ser um UUID por exemplo.

Um token opaco é um token que não possui informações do usuário no token, ele é apenas uma string aleatória, que o usuário envia sempre no header da requisição.

## Login

A rota de login pode ser no formato:


```json
POST /login
{
   "username": "username (pode ser e-mail, cpf, ..)",
   "password": "senha"
}
```

e o retorno, pode ser apenas o token:

```json
{
   "token": "..."
}
```

Esse token deve ser armazenado junto ao usuário que fez login, assim sempre que o token for passado, é possível recuperar qual o usuário que está chamando uma rota.

## Chamadas a rotas

Agora, toda chamada a rotas fechadas, o token deve ser passado no header, da seguinte maneira:

```java
@RequestHeader(name = "token") String token
```

Assim, a rota exige um header chamado token como entrada na rota.

## Logout

Para fazer logout, o usuário pode chamar a rota de logout da seguinte forma:

```json
POST /logout
```

Essa rota não exige nenhum body, apenas o header, indicando que aquele token deve ser invalidado.



