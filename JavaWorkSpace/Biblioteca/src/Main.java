import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da classe Livro
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "1954");
        
        // Imprimindo informações sobre o livro
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("isbn: " + livro.getIsbn());
        
        // Criando uma instância da classe Biblioteca
        Biblioteca biblioteca = new Biblioteca();
        
        // Adicionando o livro à biblioteca
        biblioteca.adicionarLivro("livro1", "autor1", "1");
        biblioteca.adicionarLivro("livro2", "autor2", "2");
        biblioteca.adicionarLivro("livro3", "autor3", "3");
        biblioteca.adicionarLivro("livro4", "autor4", "4");
        biblioteca.adicionarLivro("livro5", "autor5", "5");
        biblioteca.adicionarLivro("livro6", "JK", "6");
        
        // Imprimindo informações sobre a biblioteca
        biblioteca.listarLivros();

        //removendo um livro
        //biblioteca.removerLivro("1");
        biblioteca.listarLivros();
        
        biblioteca.buscarPorTitulo("livro3");
        //biblioteca.getCatalogo().get(1).getTitulo();
        // ArrayList<Livro> LivrosCatalogo = biblioteca.getCatalogo();
        // LivrosCatalogo.get(0).reservar();

        // emprestar livro biblioteca
        biblioteca.emprestarLivro("4");
        biblioteca.listarLivrosEmprestados();

        //devolver e calcular multa
        biblioteca.devolverLivro("4");
        


    }
}
