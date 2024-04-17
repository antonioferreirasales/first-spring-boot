package br.com.sales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  @PostMapping("/metodoBodyParams")
  public String metodoBodyParams(@RequestBody Usuario usuario) {
    return "Este é um método POST: " + usuario.username;
  }

}
