package servicos;

public class Banho extends Servico {

    @Override
    public String descricao() {
        // TODO Auto-generated method stub
        String descricao = "o banho do animal lavará o animal completamente e o deixará muito cheiroso!";
        System.out.println(descricao);
        return descricao;
    }

    @Override
    public Float preco() {
        float preco = 50;
        // TODO Auto-generated method stub
        System.out.println("o valor do Banho é de "+ preco +"reais");
        return preco;
    }
    
}
