package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio {

    ItemCardapio[] processaArquivo();

    static LeitorItensCardapio criaLeitor(String nomeArquivo) throws IllegalAccessException {

        LeitorItensCardapio leitor = null;

        if (nomeArquivo.endsWith(".csv")){
            leitor = new LeitorItensCardapioCSV(nomeArquivo);
        } else if(nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioGSON(nomeArquivo);
        } else {
            throw new IllegalAccessException("Extensão do arquivo é inválida: " + nomeArquivo);
        }
        return leitor;
    }
}
