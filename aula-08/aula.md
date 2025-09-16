# Aprimorando nossa API

Nossas APIs já estão funcionais, mas ainda falta deixar ela mais bem documentada e mais tolerante à erros. Vamos ver algumas técnicas que usamos para melhorar a qualidade da nossa API.

## Tratamento de Erros

Em Java, podemos lançar exceções em Java com a palavra reservada throw, como por exemplo:

```java
if (usuario == null) {
    throw new RuntimeException("Token invalido");
}
```

Porém RuntimeException é um erro genérico, em uma API Rest, esse error irá retornar apenas um erro 500 para o usuário, podemos melhorar isso usando o ResponseStatusException

```java
if (usuario == null) {
    throw new ResponseStatusException(HttpStatus.FORBIDDEN);
}
```

Essse tipo  de erro já irá retornar o código de erro correto para a nossa necessidade, mas ele ainda apenas retorna uma mensagem padrão, podemos melhorar mais ainda para
retorna uma mensagem amigável para o usuário, para isso podemos criar a classe `Erro` que irá formatar como o erro será exibido para o usuário:


```java
package br.edu.insper.biblioteca.error;

import java.time.LocalDateTime;

public class Error {

    private String mensagem;
    private Integer codigo;
    private LocalDateTime data;

    // gets e sets
}

```

Por último podemos customizar como a mensagem de erro será retornada para o usuário:

```java
package br.edu.insper.biblioteca.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    public Error responseStatusHandler(ResponseStatusException exception) {
        Error error = new Error();
        error.setMensagem(exception.getReason());
        error.setCodigo(exception.getStatusCode().value());
        error.setData(LocalDateTime.now());

        return error;

    }

}

```
## Documentação da API

Vimos que com o Spring é bem fácil criar um swagger para a nossa API, basta adicionar a biblioteca `springdoc-openapi-starter-webmvc-ui` no arquivo pom.xml.


```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.9</version>
</dependency>
```

Assim, a API já pode ser acessada no endereço `http://localhost:8080/swagger-ui.html`.

Porém, podemos deixar a documentação bem mais completa, usando algumas anotações, entre elas:

```java
@Tag(name = "Autores", description = "Operações relacionadas a autores")
```

A @Tag que pode ser adicionada na classe do controller.

```java
@Operation(
        summary = "Lista todos os autores",
        description = "Retorna uma lista com todos os autores cadastrados no sistema."
)
```

O @Operation que adiciona uma descrição curta e uma longa para cada rota.


```java
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Autor encontrado",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Autor.class))),
        @ApiResponse(responseCode = "404", description = "Autor não encontrado", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Error.class)))
})
```

```java
@Parameter(description = "CPF do autor a ser buscado", example = "12345678900")
```

## DTOs

Em algumas rotas, usar as classes de modelo diretamente pode deixar a API "estranha", pois existem campos que não podemm ser utilizados pelo usuário, como por exemplo
na rota de edição de autores:


```java
@PutMapping("/{cpf}")
public Autor editarAutor(@PathVariable String cpf, @RequestBody Autor autor) {
    return autorService.editarAutor(cpf, autor);
}
```

Na classe autor, existem os campos cpf e id que não podem ser editados, mas esses cammpos existem na classe autor. Isso atrapalha a geração da documentação do swagger, já
que a biblioteca não consegue enteder  que os campos id e cpf não podem ser editados.

Por isso, usamos um padrão de projeto chamado DTO (Data Transfer Object), nele podemos criar classes diferentes apenas para a transmissão dos dados. Por exemplo, para
a edição de um Autor:

```java
public class EditAutorDTO {
    
    private String nome;
    private String nacionalidade;

    // gets e sets
}

```

Assim, podemos usar o


```java
@PutMapping("/{cpf}")
public Autor editarAutor(@PathVariable String cpf, @RequestBody EditAutorDTO autor) {
    return autorService.editarAutor(cpf, autor);
}
```
