package br.com.sales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/primeira")
public class PrimeiraController {
  @GetMapping("/metodo/{id}")
  public String getMethod(@PathVariable String id) {
    return new String("O parâmetro é " + id);
  }

  @GetMapping("/metodoQuery")
  public String getMethodQuery(@RequestParam String id) {
    return new String("O parâmetro com Query Params é " + id);
  }

  @GetMapping("/multiQuery")
  public String getMultiQuery(@RequestParam Map<String, String> allParams) {
    return new String("O parâmetro com Query Params é " + allParams.entrySet());
  }

}
