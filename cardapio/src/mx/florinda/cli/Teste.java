import mx.florinda.modelo.Cardapio;
import mx.florinda.modelo.ItemCardapio;
//import mx.florinda.modelo.ItemCardapio;

void main() {

    Cardapio cardapio = new Cardapio();

    String linha = IO.readln("Digite um ID de item do cardápio: ");
    long idSelecionado = Long.parseLong(linha); // Parseando a string lida

    ItemCardapio itemSelecionado = cardapio.getItemPorId(idSelecionado);//buscando o item selecionado no array de cardápio pelo índice (id - 1)
        /*for (ItemCardapio item : cardapio) {
            if (item.id == idSelecionado) {
                itemSelecionado = item;
                break;
            }
        }*/
    IO.println("Soma dos preços: " + cardapio.getSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.getTotalDeItensEmPromocao());
    double precoLimite = 10.00;
    IO.println("O primeiro preço que é maior que " + precoLimite + ": " + cardapio.getPrimeiroPrecoMaiorQueLimite(precoLimite));

    IO.println("== Item do Cardápio ==");
    IO.println("Id: " + itemSelecionado.getId());

    IO.println("Nome: " + itemSelecionado.getNome());
    IO.println("Descrição: " + itemSelecionado.getDescricao());

    if (itemSelecionado.isEmPromocao()) {
        IO.println("Item em promoção!");
        double porcentagemDesconto = itemSelecionado.getPorcentagemDesconto();
        IO.println("Porcentagem de desconto: " + porcentagemDesconto);
        IO.println("Preço de : " + itemSelecionado.getPreco() + " por " + itemSelecionado.getPrecoComDesconto());
    } else {
        IO.println("Preco: " + itemSelecionado.getPreco());
        IO.println("Item não está em promoçõo");
    }
    IO.println("Categoria: " + itemSelecionado.getCategoria());

    IO.println("Imposto: " + itemSelecionado.getImposto());
    IO.println("-------");

    //imprimir todos os preços menores ou iguais ao limite
    for (ItemCardapio item : cardapio.getItens()) {
        if (item.getPreco() <= precoLimite) {
            IO.println("Preço menor que " + precoLimite + ": " + item.getPreco());
        }

    }
}





