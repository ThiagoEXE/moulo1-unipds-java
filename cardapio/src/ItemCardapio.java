class ItemCardapio {

    long id;
    String nome;
    String descricao;
    double preco;
    boolean emPromocao;
    double precoComDesconto;
    CategoriaCardapio categoria;//enum CategoriaCardapio { ENTRADA, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS }

    ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    double calculaPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }

    CategoriaCardapio obtemNomeCategoria() {

        return categoria;
    }

    void definePromocao(double precocomDesconto) {
        this.emPromocao = true;
        this.precoComDesconto = precocomDesconto;
    }

    double calculaImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }
        return imposto;
    }

}