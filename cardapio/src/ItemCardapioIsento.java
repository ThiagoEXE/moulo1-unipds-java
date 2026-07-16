class ItemCardapioIsento extends ItemCardapio{

    ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);// chama construtor da super classe/classe mãe
    }
    //reescrita de metodo(override)
    @Override // opcional, mas ajuda na documentação e compilador
    // sem @Override o metodo da supercalsse pode mudar de nome e influenciar em bugs como um itemCardapio sem isensão de imposto
    double calculaImposto() {
        return 0.0;
    }
}