package br.com.gube.Loja.Gube.repository;

import br.com.gube.Loja.Gube.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

  Optional<Produto> findById(Long id);

  List<Produto> findByTecnologiasUsadas(String tecnologiasUsadas);

}
