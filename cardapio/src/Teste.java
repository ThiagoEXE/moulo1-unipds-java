

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

    IO.println("Imposto: " + itemSelecionado.calculaImposto());
}





