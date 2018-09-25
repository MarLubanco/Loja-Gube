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
  private String nomeProduto;

  @NotNull
  private MercadoAlvo mercadoAlvo;

  @Column
  @ElementCollection(targetClass=String.class)
  private List<String> tecnologiasUsadas;

  public Produto(Long id, String nomeProduto, MercadoAlvo mercadoAlvo, List<String> tecnologiasUsadas) {
    this.id = id;
    this.nomeProduto = nomeProduto;
    this.mercadoAlvo = mercadoAlvo;
    this.tecnologiasUsadas = tecnologiasUsadas;
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

  public Produto() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public static class Builder extends Produto {


    private String nomeProduto;

    private MercadoAlvo mercadoAlvo;

    private List<String> tecnologiasUsadas;



      public Builder() {

      }

      public Builder nomeProduto(String nomeProduto) {
          this.nomeProduto = nomeProduto;
          return this;
      }

    public Builder mercadoAlvo(MercadoAlvo mercadoAlvo) {
      this.mercadoAlvo = mercadoAlvo;
      return this;
    }

    public Builder tecnologiasUsadas(List<String> tecnologiasUsadas) {
      this.tecnologiasUsadas = tecnologiasUsadas;
      return this;
    }

    public Produto builder() {
        return new Produto(this);
      }
  }

    private Produto(Builder builder) {
    nomeProduto = builder.nomeProduto;
    mercadoAlvo = builder.mercadoAlvo;
    tecnologiasUsadas = builder.tecnologiasUsadas;
  }
}
