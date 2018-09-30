package br.com.gube.Loja.Gube;

import br.com.gube.Loja.Gube.model.MercadoAlvo;
import br.com.gube.Loja.Gube.model.Produto;
import br.com.gube.Loja.Gube.repository.ProdutoRepository;
import br.com.gube.Loja.Gube.service.ProdutoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Priority;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutosTest {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private ProdutoService produtoService;

  @Test
  public void teste1salvar() {
    ArrayList<String> tecnologias = new ArrayList<>();
    tecnologias.add("Java");
    tecnologias.add("Oracle");
    Produto produto = new Produto(1L,"teste","JDK", MercadoAlvo.PROGRAMADORES, tecnologias);

    Produto produtoSalvo = produtoService.save(produto);
    List<Produto> produtos = produtoService.getAll();
    Assert.assertTrue(produtos.size() > 0 && produtos.size() < 2);
  }

  @Test
  public void teste2getProdutoSalvo() {
    Optional<Produto> produtoRecuperado = produtoService.getProduto(1L);
    Assert.assertEquals(produtoRecuperado.get().getNomeProduto(),"JDK");
  }

  @Test
  public void teste3getTecnologiaUsada() {
    List<Produto> produtosRecuperado = produtoService.buscaProdutosPorTecnologias("Java");
    Assert.assertTrue(produtosRecuperado.size() > 0);
  }

  @Test
  @DependsOn("getProdutoSalvo")
  public void teste4deleteProduto() {
    produtoService.deleteProduto(1L);
    Optional<Produto> produtoRecuperado = produtoService.getProduto(1L);
    Assert.assertFalse(produtoRecuperado.equals(false));
  }
}
