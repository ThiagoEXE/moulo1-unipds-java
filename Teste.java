void main() {
    ItemCardapio item2 = new ItemCardapio(1L, "Refresco do Chaves", "Suco de limão que parece de tamarindo e tem gosto de groselha", 2.99, 4);

    item2.definePromocao(2.99);

    IO.println("Nome: " + item2.nome);
    if(item2.emPromocao) {
        double porcentagemDesconto = item2.calculaPorcentagemDesconto();
        IO.println("Porcentagem de desconto: " + porcentagemDesconto);
        IO.println("Preço de : " + item2.preco + " por " + item2.precoComDesconto);
    } else{
        IO.println("Preco: " + item2.preco);
        IO.println("Item não está em promoçõo");
    }
        IO.println("Categoria: " + item2.obtemNomeCategoria());
}

class ItemCardapio {

    long id;
    String nome;
    String descricao;
    double preco;
    boolean emPromocao;
    double precoComDesconto;
    int categoria;

    ItemCardapio(long id, String nome, String descricao, double preco, int categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    double calculaPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }

    String obtemNomeCategoria() {
        /*
        1 - Entradas
        2 - Pratos Principais
        3 - Sobremesas
        4 - Bebidas

        */
       String nomeCategoria;
       switch(categoria) {
           case 1:
               nomeCategoria = "Entradas";
               break;
           case 2:
               nomeCategoria = "Pratos Principais";
               break;
           case 3:
               nomeCategoria = "Sobremesas";
               break;
           case 4:
               nomeCategoria = "Bebidas";
               break;
           default:
               nomeCategoria = "Categoria inválida";
       }
       return nomeCategoria;
    }

    void definePromocao(double precocomDesconto) {
        this.emPromocao = true;
        this.precoComDesconto = precocomDesconto;
    }

}