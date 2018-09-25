package br.com.gube.Loja.Gube;


import br.com.gube.Loja.Gube.model.MercadoAlvo;
import br.com.gube.Loja.Gube.model.Produto;
import br.com.gube.Loja.Gube.repository.ProdutoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoTeste {

  @Autowired
  ProdutoRepository produtoRepository;

  @Test
  public void salvar() {
    ArrayList<String> tecnologias = new ArrayList<>();
    tecnologias.add("Java");
    tecnologias.add("Oracle");
    Produto produto = new Produto.Builder().nomeProduto("JDK")
                                      .mercadoAlvo(MercadoAlvo.PROGRAMADORES)
                                      .tecnologiasUsadas(tecnologias);

    produtoRepository.save(produto);
    List<Produto> produtos = produtoRepository.findAll();
    Assert.assertTrue(produtos.size() > 0 && produtos.size() < 2);
  }

  @Test
  public void naoSalvar() {
    ArrayList<String> tecnologias = new ArrayList<>();
    tecnologias.add("Java");
    tecnologias.add("Oracle");
    Produto produto = new Produto.Builder().nomeProduto(null)
            .mercadoAlvo(MercadoAlvo.PROGRAMADORES)
            .tecnologiasUsadas(tecnologias);

    produtoRepository.save(produto);
    Optional<Produto> produtoRecuperado = produtoRepository.findById(produto.getId());
    Assert.assertTrue(produtoRecuperado.equals(null));
  }
}
