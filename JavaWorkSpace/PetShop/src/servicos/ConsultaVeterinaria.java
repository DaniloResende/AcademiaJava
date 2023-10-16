package servicos;

public class ConsultaVeterinaria extends Servico{

    @Override
    public String descricao() {
        return "consulta veterinaria completa";
    }

    @Override
    public Float preco() {
        // TODO Auto-generated method stub
        return 200.00f;
    }
    
}
