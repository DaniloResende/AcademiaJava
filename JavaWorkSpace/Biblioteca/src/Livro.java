import java.time.LocalDate;

public class Livro implements Imprimivel {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private LocalDate diaEmprestimo;

    public LocalDate getDiaEmprestimo() {
        return this.diaEmprestimo;
    }
    public void setDiaEmprestimo(LocalDate diaEmprestimo) {
        this.diaEmprestimo = diaEmprestimo;
    }
    public String getTitulo() {
        System.out.println(this.titulo);
        return this.titulo;
    }
    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    private void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbn() {
        return this.isbn;
    }
    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean isEmprestado() {
        return this.emprestado;
    }
    private void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    public Livro(String titulo, String autor, String isbn ){ //
      this.emprestado = false;
      this.titulo = titulo;
      this.autor = autor;
      this.isbn = isbn;

    }
      public Livro(String titulo, String autor ){
      this.emprestado = false;
      this.titulo = titulo;
      this.autor = autor;
      this.isbn = "";
    }

    public boolean reservar(){
        if (this.isEmprestado()){
            System.out.println("Livro ja esta emprestado");
            return false;
        }
        else{
            System.out.println("Reserva realizada!");
            this.setEmprestado(true);
            this.diaEmprestimo = LocalDate.now();
            return true;
        }
    }

    public boolean devolver(){
        if (this.isEmprestado()){
            System.out.println("devolução realizada! ");
            this.setEmprestado(false);
            return true;
        }
        else {
            System.out.println("livro esta na biblioteca!");
            return false;
        }
        
    }
    
    public String exibir_info(){
        String informacoes =  "Título: " + this.getTitulo() + "\n" +
               "Autor: " + this.getAutor() + "\n" +
               "Emprestado: " + (this.isEmprestado() ? "O livro esta emprestado" : "Disponivel");

        if (this.getIsbn() != ""){
            System.out.println("Título: " + this.getTitulo() + "\n" +
               "Autor: " + this.getAutor() + "\n" +
               "Emprestado: " + (this.isEmprestado() ? "O livro esta emprestado" : "Disponivel"));
        }
        return informacoes;
    }
    @Override
    public boolean imprimir() {
        if (!this.emprestado) {
        System.out.println("livro Impresso com sucesso!!");
        return true;
        } else {
            System.out.println("Não foi possivel imprimir, livro emprestado no momento");
            return false;
        }

    }
    
}
