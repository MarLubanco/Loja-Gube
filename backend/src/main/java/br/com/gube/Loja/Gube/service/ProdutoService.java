package br.com.gube.Loja.Gube.service;

import br.com.gube.Loja.Gube.model.Produto;
import br.com.gube.Loja.Gube.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoService {

  @Autowired
  ProdutoRepository produtoRepository;

  @PostMapping
  @Transactional
  @ResponseBody
  public Produto save(@RequestBody Produto produto) {
    return produtoRepository.save(produto);
  }

  @GetMapping
  public List<Produto> getAll() {
    return produtoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Produto> getProduto(@PathVariable("id") Long id) {
    return produtoRepository.findById(id);
  }

  @PutMapping("/{id}")
  public Produto update(@PathVariable("id") Long id, @RequestBody Produto produto) {
    return produtoRepository.save(produto);
  }

  @DeleteMapping("/{id}")
  public void deleteProduto(@PathVariable("id") Long id) {
     produtoRepository.deleteById(id);
  }

  @GetMapping("busca")
  public List<Produto> buscaProdutosPorTecnologias(@RequestParam String tecnologia) {
    return produtoRepository.findByTecnologiasUsadas(tecnologia);
  }

}
