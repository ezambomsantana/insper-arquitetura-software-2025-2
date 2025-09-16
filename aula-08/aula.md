# Erros

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

Por último precisamos mostrar a mensagem que foi passada como parâmetro na classe:

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


# DTOs
