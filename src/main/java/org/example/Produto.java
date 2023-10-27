package org.example;
import lombok.Data;

@Data
public class Produto {
    private int codigo;
    private String descricao, tipo;
    private double valor;
    private String validade;

    public Produto(int codigo, String descricao, String tipo, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Produto(int codigo, String descricao, String tipo, double valor, String validade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.validade = validade;
    }
}
