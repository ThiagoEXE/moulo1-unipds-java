package mx.florinda.modelo;

public class ItemCardapio {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private boolean emPromocao;
    private double precoComDesconto;
    private CategoriaCardapio categoria;//enum CategoriaCardapio { ENTRADA, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS }

    protected ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
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

    void setPromocao(double precocomDesconto) {
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