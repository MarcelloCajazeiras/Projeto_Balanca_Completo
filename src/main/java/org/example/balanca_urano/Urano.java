package org.example.balanca_urano;

import org.example.Produto;
import org.example.balancas.balancaexporter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Urano implements balancaexporter<Produto> {

    @Override
    public void exportar(List<Produto> produtos, String saveDiretorio) {
        try (FileWriter writer = new FileWriter(saveDiretorio + "/CADTXT.txt")) {
            for (Produto produto : produtos) {
                String codigo = String.format("%06d", produto.getCodigo());
                String tipoProduto = produto.getTipo();
                String descricao = String.format("%-20s", produto.getDescricao());
                int valor = (int) (produto.getValor() * 1000);
                String valorFormatado = String.format("%09d", valor);
                String validade = (produto.getValidade() != null ? produto.getValidade() : "000") + "0";

                writer.write(codigo + "P" + tipoProduto + descricao + valorFormatado + validade + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao exportar para Urano: " + e.getMessage());
        }
    }
}
