package br.com.sales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/primeira")
public class PrimeiraController {
  // recebe uma requisição com path params
  @GetMapping("/metodo/{id}")
  public String getMethod(@PathVariable String id) {
    return new String("O parâmetro é " + id);
  }

  // define um query params para receber
  @GetMapping("/metodoQuery")
  public String getMethodQuery(@RequestParam String id) {
    return new String("O parâmetro com Query Params é " + id);
  }

  // recebe vários query params e os mapeia
  @GetMapping("/multiQuery")
  public String getMultiQuery(@RequestParam Map<String, String> allParams) {
    return new String("O parâmetro com Query Params é " + allParams.entrySet());
  }

  record Usuario(String username) {
  }

  // recebe um body no método POST
  @PostMapping("/metodoBodyParams")
  public String metodoBodyParams(@RequestBody Usuario usuario) {
    return "Este é um método POST: " + usuario.username;
  }

  // recebe um header
  @PostMapping("/metodoHeaders")
  public String metodoHeaders(@RequestHeader("name") String name) {
    return "Este é um método POST: " + name;
  }

  // recebe e mapeia vários headers
  @PostMapping("/metodoManyHeaders")
  public String ManyHeaders(@RequestHeader Map<String, String> headers) {
    return "Este é um método POST: " + headers.entrySet();
  }

  @GetMapping("/responseEntity/{id}")
  public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id) {
    var usuario = new Usuario("Rita");
    if (id > 5) {
      return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensagem de erro");
  }

}
