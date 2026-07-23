package mx.florinda.modelo;

import java.util.Objects;

public class ItemCardapio {

    private final long id;
    private final String nome;
    private final String descricao;
    private final double preco;
    private boolean emPromocao;
    private double precoComDesconto;
    private final CategoriaCardapio categoria;//enum CategoriaCardapio { ENTRADA, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS }

    public ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public double getPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }


    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", emPromocao=" + emPromocao +
                ", precoComDesconto=" + precoComDesconto +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCardapio that = (ItemCardapio) o;
        return id == that.id && Double.compare(preco, that.preco) == 0 && emPromocao == that.emPromocao && Double.compare(precoComDesconto, that.precoComDesconto) == 0 && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && categoria == that.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, emPromocao, precoComDesconto, categoria);
    }

    public void setPromocao(double precocomDesconto) {
        this.emPromocao = true;
        this.precoComDesconto = precocomDesconto;
    }

    public double getImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }
        return imposto;
    }

}