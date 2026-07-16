package mx.florinda.modelo.isento;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;

public class ItemCardapioIsento extends ItemCardapio {

    public ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);// chama construtor da super classe/classe mãe
    }
    //reescrita de metodo(override)
    @Override // opcional, mas ajuda na documentação e compilador
    // sem @Override o metodo da supercalsse pode mudar de nome e influenciar em bugs como um itemCardapio sem isensão de imposto
    public double getImposto() {
        return 0.0;
    }
}