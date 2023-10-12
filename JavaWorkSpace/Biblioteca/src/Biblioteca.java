import java.util.ArrayList;

public class Biblioteca {
    // dica => utilizar metodo  1 .add de arrayList // 2 .get(indice) 3. olhar classe arraylist 
    private ArrayList<Livro> catalogo;
    

    public Biblioteca(){
        this.catalogo = new ArrayList<Livro>();
    }

    // public boolean adicionar_livro(Livro livro){
    //     catalogo.add(livro);
    // }
    public boolean adicionar_livro(String titulo, String autor, String isbn ){
    Livro novoLivro = new Livro( titulo,  autor,  isbn );
    this.catalogo.add(novoLivro);
    return true;
    }

    public void remover_livro(String isbn){
        // int tamanhoCatalogo = this.catalogo.size();
        for(int i = 0; i < this.catalogo.size(); i++){
            Livro livroAtual = this.catalogo.get(i);
            if (livroAtual.getIsbn().equals(isbn)){
                this.catalogo.remove(i);
            }
        }
    }

    public ArrayList<Livro> buscar_por_titulo(titulo){
        for(int i = 0; i < this.catalogo.size(); i++){
            Livro livroAtual = this.catalogo.get(i);
            
        }
    }
}

// 