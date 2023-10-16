public class Revista implements Imprimivel {
    private String titulo;
    private String empresa;
    private int edicao;
    private Boolean emprestado;
    private int nroCopias;

    
    public Revista(String titulo, String empresa, int edicao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.nroCopias = 1;
        this.emprestado = false;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public Boolean getEmprestado() {
        return emprestado;
    }
    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }
    public int getNroCopias() {
        return nroCopias;
    }
    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
    }

    public boolean reservar(){
        if (!this.emprestado) {
            this.setEmprestado(true);
            System.out.println("reserva bem sucedida");
            return true; 
        } else {
            return false;
        }
        
    }

    public void devolver(){
        this.emprestado = false;
    }
    public String exibirInfo(){
        String informacoes = "titulo: "+ this.getTitulo() + "empresa: "
         + this.getEmpresa() + "edicao: " + this.getEdicao() + "numero de copias: " + this.getNroCopias() +
         "esta emprestado ? " + (this.getEmprestado() ? "esta emprestado :(" : "disponivel!");
        return informacoes;
    }

    @Override

    public boolean imprimir(){
        if (!this.emprestado) {
            System.out.println("sucesso ao imprimir revista");
            this.setNroCopias((this.nroCopias + 1));
            return true;
        } else { 
            System.out.println("revista emrpestada, falha ao imprimir");
            return false;
        }
    }
        //     public static void main(String[] args) {
        //     Revista revista = new Revista("Revista de Tecnologia", "Editora A", 1);

        //     // Testando o método reservar
        //     System.out.println("Testando o método reservar:");
        //     System.out.println("Emprestado: " + revista.getEmprestado());
        //     revista.reservar();
        //     System.out.println("Emprestado: " + revista.getEmprestado());
        //     revista.reservar();
        //     System.out.println("Emprestado: " + revista.getEmprestado());

        //     // Testando o método devolver
        //     System.out.println("\nTestando o método devolver:");
        //     System.out.println("Emprestado: " + revista.getEmprestado());
        //     revista.devolver();
        //     System.out.println("Emprestado: " + revista.getEmprestado());

        //     // Testando o método imprimir
        //     System.out.println("\nTestando o método imprimir:");
        //     System.out.println("Número de cópias: " + revista.getNroCopias());
        //     revista.imprimir();
        //     System.out.println("Número de cópias: " + revista.getNroCopias());
        //     revista.setEmprestado(true);
        //     revista.imprimir();
        //     System.out.println("Número de cópias: " + revista.getNroCopias());

        //     // Testando o método exibirInfo
        //     System.out.println("\nTestando o método exibirInfo:");
        //     System.out.println(revista.exibirInfo());
        // }
    

}
