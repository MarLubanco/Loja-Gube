package br.com.gube.Loja.Gube.model;

public enum MercadoAlvo {

  PROGRAMADORES("programadores"),
  DBA("dba"),
  BIGDATA("bigdata");

  private final String mercadoAlvo;

  MercadoAlvo(String mercadoAlvo) {
    this.mercadoAlvo = mercadoAlvo;
  }

  public String mercadoAlvo() {
    return mercadoAlvo;
  }
}


