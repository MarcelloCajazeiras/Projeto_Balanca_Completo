package org.example.balanca_toledo;

import org.example.Produto;
import org.example.balancas.balancaexporter;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Toledo implements balancaexporter<Produto> {
    @Override
    public void exportar(@NotNull List<Produto> produtos, String Save_diretorio) {
        try (FileWriter writer = new FileWriter(Save_diretorio + "/ITENSMGV.txt")) {
            for (Produto produto : produtos) {
                String codigo = String.format("%06d", produto.getCodigo());
                String tipoProduto = produto.getTipo();
                String descricao = String.format("%-50s", produto.getDescricao());
                int valor = (int) (produto.getValor() * 1000);
                String valorFormatado = String.format("%06d", valor);
                String validade = (produto.getValidade() != null ? produto.getValidade() : "000") + "0";

                String linha = codigo + "*" + tipoProduto + valorFormatado + validade +
                        descricao + departamentosAssociados + codigoExtraInfo + codigoImagem + codigoNutricao
                        + dataExpiracao + dataImpressaoEmbalagem + codigoFornecedor + lot + ean_13 + precoVersao
                        + codigoDoSom + codigoTaraDeterminado + codigoFracionador + campoExtra1 + campoExtra2 + codigoConsevacao
                        + fornecedorEan_13 + glaciamentoPercentual + sequenciaAssociacaoDepartamento + descricaoLinhaItem3
                        + descricaoLinhaItem4 + campoExtra3 + campoExtra4 + codigoMedia + "0000000|0000|0||" + "\n";

                writer.write(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao exportar para Toledo: " + e.getMessage());
        }
    }
}

