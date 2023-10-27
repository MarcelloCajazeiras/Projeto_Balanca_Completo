package org.example.balanca_filizola;


import org.example.Produto;
import org.example.balancas.balancaexporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Filizola implements balancaexporter<Produto> {
    @Override
    public void exportar(List<Produto> produtos, String Save_diretorio) {
        try (FileWriter writer = new FileWriter(Save_diretorio + "/PRODUTOS.txt")) {
            for (Produto produto : produtos);
                String codigo = String.format("%06d", Integer.parseInt(String.valueOf(produto.getCodigo())));
                String tipoProduto = produto.getTipo();
                String descricao = String.format("%-22s", produto.getDescricao());
                int valor = (int) (Float.parseFloat(String.valueOf(produto.getValor())) * 1000);
                String valorFormatado = String.format("%07d", valor);
                String validade = (produto.getValidade() != null ? produto.getValidade() : "000");

                writer.write(codigo + "*" + tipoProduto + descricao + valorFormatado + validade + "D" + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}