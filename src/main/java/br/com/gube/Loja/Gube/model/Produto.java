package br.com.gube.Loja.Gube.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Produto {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String descricao;

  @NotNull
  private String nomeProduto;

  @NotNull
  private MercadoAlvo mercadoAlvo;

  @Column
  @ElementCollection(targetClass=String.class)
  private List<String> tecnologiasUsadas;

  public Produto() {

  }

  public Produto(Long id, String descricao, String nomeProduto, MercadoAlvo mercadoAlvo, List<String> tecnologiasUsadas) {
    this.id = id;
    this.descricao = descricao;
    this.nomeProduto = nomeProduto;
    this.mercadoAlvo = mercadoAlvo;
    this.tecnologiasUsadas = tecnologiasUsadas;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public MercadoAlvo getMercadoAlvo() {
    return mercadoAlvo;
  }

  public void setMercadoAlvo(MercadoAlvo mercadoAlvo) {
    this.mercadoAlvo = mercadoAlvo;
  }

  public List<String> getTecnologiasUsadas() {
    return tecnologiasUsadas;
  }

  public void setTecnologiasUsadas(List<String> tecnologiasUsadas) {
    this.tecnologiasUsadas = tecnologiasUsadas;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


}
