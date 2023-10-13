import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Biblioteca {
    // dica => utilizar metodo  1 .add de arrayList // 2 .get(indice) 3. olhar classe arraylist 
    private ArrayList<Livro> catalogo;
    private LocalDate diaDevolucao;
    private long MAXIMO_DIAS = 14;
    

    public Biblioteca(){
        this.catalogo = new ArrayList<Livro>();
    }

    public ArrayList<Livro> getCatalogo() {
        return this.catalogo;
    }

    public void setCatalogo(ArrayList<Livro> catalogo) {
        this.catalogo = catalogo;
    }

    // public boolean adicionar_livro(Livro livro){
    //     catalogo.add(livro);
    // }
    public boolean adicionarLivro(String titulo, String autor, String isbn ){
    Livro novoLivro = new Livro( titulo,  autor,  isbn );
    this.catalogo.add(novoLivro);
    return true;
    }

    public void removerLivro(String isbn){
        // int tamanhoCatalogo = this.catalogo.size();
        for (int i = 0; i < this.catalogo.size(); i++){
            Livro livroAtual = this.catalogo.get(i);
            if (livroAtual.getIsbn().equals(isbn)){
                this.catalogo.remove(i);
            }
        }
    }

    public ArrayList<Livro> buscarPorTitulo(String titulo){ // retorna uma lista com todos livros com titulo especificado
        ArrayList<Livro> lista = new ArrayList<>();
        for (int i = 0; i < this.catalogo.size(); i++){
            Livro livroAtual = this.catalogo.get(i);
            if (livroAtual.getTitulo().equals(titulo)){
                lista.add(livroAtual);;
            }
        }
        if (lista.isEmpty()){
            System.out.println("Livro não encontrado");
        }
        else {
            for (int i = 0; i < lista.size(); i++){
                System.out.println(lista.get(i));
            }
        }
         
        return lista; // caso livro nao seja encontrado retorna null
    }

    public Boolean emprestarLivro(String isbn){
        for (Livro livro: this.catalogo){
            String isbnAtual = livro.getIsbn();
            if (isbnAtual.equals(isbn)){
                if (!livro.isEmprestado()){
                    System.out.println("Reserva realizada com sucesso! :)");
                    livro.reservar();
                    return true; // execucao do metodo é interrompida!
                }

            }
        }
        System.out.println("Livro não encontrado");
        return false;
    }
    public void devolverLivro(String isbn){
        for (Livro livro: this.catalogo){
            if (livro.getIsbn().equals(isbn)){
                livro.devolver();
                this.diaDevolucao = LocalDate.now();
                LimiteDias(livro.getDiaEmprestimo()); // passa o diaemprestimo do livro atual da iteracao como parametro!
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    public ArrayList<Livro> listarLivros(){
        for (Livro livro : this.catalogo) {
            System.out.println(" titulo: " + livro.getTitulo() +
            " autor: " + livro.getAutor() + " isbn: " + livro.getIsbn());
        }
        return this.catalogo;
    }

    public ArrayList<Livro> listarLivrosEmprestados(){
        ArrayList<Livro> livrosEmprestados = new ArrayList<>();
        for (Livro livro : this.catalogo) {
            if (livro.isEmprestado()){
                livrosEmprestados.add(livro);
                System.out.println(livro);
            }
        }
        return livrosEmprestados;
    }

    public void LimiteDias(LocalDate diaEmprestimo){

    long diasEmprestado = ChronoUnit.DAYS.between(diaEmprestimo, this.diaDevolucao);
    if (diasEmprestado > MAXIMO_DIAS) {
        int DiasAtrasados = (int) (diasEmprestado - MAXIMO_DIAS); // cast para transformar em int
        System.out.println("voce devolveu " + DiasAtrasados + "dias atrasado");
        int multa = (int) (DiasAtrasados * 0.50);
        System.out.println("Está com uma divida de " + multa + "Reais a biblioteca");
    }
    else{
        System.out.println("Você devolveu no prazo correto!");
    }
    }

}

