import java.util.ArrayList;
public class Produto {
    private ArrayList<Produto> produtosVendidos = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String nome;
    private String categoria;
    private Float preco;
    private Integer quantidadeEstoque;

    
    public Produto(String nome, String categoria, Float preco, Integer quantidadeEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        produtos.add(this); // adiciona o objeto atual ( criado agora ) à arraylist produtos
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public Float getPreco(){
        return this.preco;
    }
    public void setPreco(Float preco){
        this.preco = preco;
    }
    public Integer getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }
    public void setQuantidadeEstoque(Integer quantidade){
        this.quantidadeEstoque = quantidade;
    }

    public void vender(String nome, Integer quantidade){
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)){
                if (this.quantidadeEstoque >= quantidade){
                continue;

                }
            } else {
                System.out.println("Quantidade fornecida é maior do que o estoque ");
                return;
            }
             
        }
        this.quantidadeEstoque -= quantidade;
        produtosVendidos.add( new Produto(nome, categoria, preco, quantidade));

        
        
    }
}

