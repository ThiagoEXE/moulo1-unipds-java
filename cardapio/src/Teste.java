

void main() {

    Cardapio cardapio = new Cardapio();

    String linha = IO.readln("Digite um ID de item do cardápio: ");
    long idSelecionado = Long.parseLong(linha); // Parseando a string lida

    ItemCardapio itemSelecionado = cardapio.itens[((int) idSelecionado) - 1];//buscando o item selecionado no array de cardápio pelo índice (id - 1)
        /*for (ItemCardapio item : cardapio) {
            if (item.id == idSelecionado) {
                itemSelecionado = item;
                break;
            }
        }*/
    IO.println("Soma dos preços: " + cardapio.obtemSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.obtemTotalDeItensEmPromocao());
    double precoLimite = 10.00;
    IO.println("O primeiro preço que é maior que " + precoLimite + ": " + cardapio.obtemPrimeiroPrecoMaiorQueLimite(precoLimite));
    IO.println("-------");

    //imprimir todos os preços menores ou iguais ao limite
    for (ItemCardapio item : cardapio.itens) {
        if (item.preco <= precoLimite) {
            IO.println("Preço menor que " + precoLimite + ": " + item.preco);
        }

    }

    IO.println("== Item do Cardápio ==");
    IO.println("Id: " + itemSelecionado.id);

    IO.println("Nome: " + itemSelecionado.nome);
    IO.println("Descrição: " + itemSelecionado.descricao);

    if (itemSelecionado.emPromocao) {
        IO.println("Item em promoção!");
        double porcentagemDesconto = itemSelecionado.calculaPorcentagemDesconto();
        IO.println("Porcentagem de desconto: " + porcentagemDesconto);
        IO.println("Preço de : " + itemSelecionado.preco + " por " + itemSelecionado.precoComDesconto);
    } else {
        IO.println("Preco: " + itemSelecionado.preco);
        IO.println("Item não está em promoçõo");
    }
    IO.println("Categoria: " + itemSelecionado.obtemNomeCategoria());
}

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

}

class Cardapio {

    ItemCardapio[] itens;

    public Cardapio() {
        ItemCardapio item1 = new ItemCardapio(1L, "Refresco do Chaves", "Suco de limão que parece de tamarindo e tem gosto de groselha.", 2.99, CategoriaCardapio.BEBIDAS);

        ItemCardapio item2 = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves", "Sanduíche de presunto simples, mas feito com muito amor.", 3.50, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item2.definePromocao(2.99);

        ItemCardapio item3 = new ItemCardapio(3L, "Torta de Frango da Dona Florinda", "Torta de frango com recheio cremoso e massa crocante.", 12.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item3.definePromocao(10.99);

        ItemCardapio item4 = new ItemCardapio(4L, "Pipoca do Quico", "Balde de pipoca preparado com carinho pelo Quico.", 4.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item4.definePromocao(3.99);

        ItemCardapio item5 = new ItemCardapio(5L, "Água de Jamaica", "Água aromatizada comhibisco e toque de açúcar.", 2.50, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item5.definePromocao(2.00);

        ItemCardapio item6 = new ItemCardapio(6L, "Churros do Chaves", "Churros recheados com doce de leite, clássicos e irresistíveis.", 4.99, CategoriaCardapio.SOBREMESAS);
        item6.definePromocao(3.99);

        ItemCardapio item7 = new ItemCardapio(7L, "Tacos de Carnitas", "Tacos recheados com carne tenra.", 25.90, CategoriaCardapio.PRATOS_PRINCIPAIS);

        itens = new ItemCardapio[7];
        itens[0] = item1;
        itens[1] = item2;
        itens[2] = item3;
        itens[3] = item4;
        itens[4] = item5;
        itens[5] = item6;
        itens[6] = item7;

    }

    double obtemSomaDosPrecos() {
        double totalDePrecos = 0.0;
        for (ItemCardapio item : itens) {
            totalDePrecos += item.preco;
        }
        return totalDePrecos;
    }

    int obtemTotalDeItensEmPromocao() {
        int totalItensEmPromocao = 0;
        for (ItemCardapio item : itens) {
            if (item.emPromocao) {
                totalItensEmPromocao++;
            }
        }
        return totalItensEmPromocao;
    }

    double obtemPrimeiroPrecoMaiorQueLimite(double precoLimite) {
        double premoMaiorQueLimite = -1.0;
        for (ItemCardapio item : itens) {
            if (item.preco > precoLimite) {
                premoMaiorQueLimite = item.preco;
                break;
            }
        }
        return premoMaiorQueLimite;
    }

}

enum CategoriaCardapio {
    ENTRADA, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS;
}