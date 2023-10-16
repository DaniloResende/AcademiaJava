package servicos;

import java.util.ArrayList;

public abstract class Servico {
    private static ArrayList<Servico> servicos = new ArrayList<>();
    public abstract String descricao();
    public abstract Float preco();

    public Servico() {
        servicos.add(this);
    }
        // Método estático para recuperar a lista de serviços
    public static ArrayList<Servico> getServicos() {
        return servicos;
    }


}

