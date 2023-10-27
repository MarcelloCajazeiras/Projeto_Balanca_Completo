package org.example;

import org.example.balanca_filizola.Filizola;
import org.example.balanca_toledo.Toledo;
import org.example.balanca_urano.Urano;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        var produto1 = new Produto(184, "P", "QUEIJO GRUYERE KG", 21.90);
        var produto2 = new Produto(288, "P", "QUEIJO PROVOLETE KG", 12.29);
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);


        var destinoDiretorio = "C:\\Users\\marce\\OneDrive\\Documentos\\Atv_Balança_Completo";

        try {
            var urano = new Urano();
            urano.exportar(listaProdutos, destinoDiretorio);
        } catch (Exception e) {
            System.err.println("Erro ao exportar para Urano: " + e.getMessage());
        }

        try {
            var toledo = new Toledo();
            toledo.exportar(listaProdutos, destinoDiretorio);
        } catch (Exception e) {
            System.err.println("Erro ao exportar para Toledo: " + e.getMessage());
        }

        try {
            var filizola = new Filizola();
            filizola.exportar(listaProdutos, destinoDiretorio);
        } catch (Exception e) {
            System.err.println("Erro ao exportar para Filizola: " + e.getMessage());
        }
    }
}
