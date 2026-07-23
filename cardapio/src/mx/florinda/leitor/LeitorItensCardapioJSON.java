package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioJSON extends LeitorItensCardapioBase{

    private static final String SEPARADOR = ":";

    public LeitorItensCardapioJSON(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    protected ItemCardapio processaLinha(String linha) {
        linha = linha.replace("[", "");
        linha = linha.replace("]", "");
        linha = linha.replace("{", "");
        linha = linha.replace("}", "");
        linha = linha.replace("\"", "");
        String[] partes = linha.split(",");

        String parteId = partes[0];
        String[] propriedadeEValorId = parteId.split(SEPARADOR);
        String valorId = propriedadeEValorId[1].trim();
        //IO.println(valorId);
        Long id = Long.parseLong(valorId);
        //IO.println(id);

        String parteNome = partes[1];
        String[] propriedadeEValorNome = parteNome.split(SEPARADOR);
        String nome = propriedadeEValorNome[1].trim();

        String parteDescricao = partes[2];
        String[] propriedadeEValorDescricao = parteDescricao.split(SEPARADOR);
        String descricao = propriedadeEValorDescricao[1].trim();

        String partePreco = partes[3];
        String[] propriedadeEValorPreco = partePreco.split(SEPARADOR);
        String valorPreco = propriedadeEValorPreco[1].trim();
        double preco = Double.parseDouble(valorPreco);

        String parteCategoria = partes[4];
        String[] propriedadeEValorCategoria = parteCategoria.split(SEPARADOR);
        String valorCategoria = propriedadeEValorCategoria[1].trim();
        CategoriaCardapio categoria = CategoriaCardapio.valueOf(valorCategoria);

        ItemCardapio item = new ItemCardapio(id, nome, descricao, preco, categoria);

        String parteEmPromocao = partes[5];
        String[] propriedadeEValorEmPromocao = parteEmPromocao.split(SEPARADOR);
        String valorEmPromocao = propriedadeEValorEmPromocao[1].trim();

        String parteImpostoIsento = partes[7];
        String[] propriedadeEValorImpostoIsento = parteImpostoIsento.split(SEPARADOR);
        String valorImpostoIsento = propriedadeEValorImpostoIsento[1].trim();

        boolean impostoIsento = Boolean.parseBoolean(valorImpostoIsento);

        if (impostoIsento) {
            item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
        } else {
            item = new ItemCardapio(id, nome, descricao, preco, categoria);
        }
        boolean emPromocao = Boolean.parseBoolean(valorEmPromocao);

        if(emPromocao) {
            String partePrecoDesconto = partes[6];
            String[] propriedadeEValorPrecoDescono = partePrecoDesconto.split(SEPARADOR);
            String valorPrecoDesconto = propriedadeEValorPrecoDescono[1].trim();
            double precoDesconto = Double.parseDouble(valorPrecoDesconto);
            item.setPromocao(precoDesconto);
        }
        return item;
    }
}
