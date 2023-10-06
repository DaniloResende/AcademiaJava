
    public class Livro {
        private String titulo;
        private String autor;
        private int nroPaginas;
        private int paginaAtual = 1;

        public Livro(String titulo, String autor, int nroPaginas){
            this.titulo = titulo;
            this.autor = autor;
            this.nroPaginas = nroPaginas;
        }
        public void virarPagina(){
            if (this.nroPaginas == this.paginaAtual)
                return;
            this.paginaAtual++;
        }
        public void retrocederPagina(){
            if (1 == this.paginaAtual)
                return;
            this.paginaAtual--;
        }
        public void irParaPagina(int pagina){
    
            this.paginaAtual = pagina;
            
        }



        public static void main(String[] args) throws Exception {
            System.out.println("Hello, World!");
        }
    }

