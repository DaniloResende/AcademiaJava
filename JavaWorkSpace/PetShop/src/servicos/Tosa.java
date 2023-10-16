package servicos;

public class Tosa extends Servico {

    @Override
    public String descricao() {
        
        return "Tosa completa do animal";
    }

    @Override
    public Float preco() {
        return 100.00f;
    }
    
}
