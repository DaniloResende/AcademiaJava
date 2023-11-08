# Resumo *Java*
-tipos primitivos comecam com letra minuscula int boolean char
-tipos primitivos nao admitem null
-classes wrapper: Integer Boolean Character => sao classes que representam os tipos primitivos
- para instanciar um objeto usa se o metodo valueOf
-classes wrapper admitem null e tem metodos uteis
- wrapper significa embrulhar
### tipos de *Wrapper* correspondentes
- int => Integer
- boolean => Boolean
- char => Character
- double => Double
- float => Float
- long => Long
- short => Short
- byte => Byte

### Casting
![](/printsJava/TypeCastingJava.png)

### Widening Casting (automatically) - converting a smaller type to a larger type size
``byte -> short -> char -> int -> long -> float -> double``

### Narrowing Casting (manually) - converting a larger type to a smaller size type
```double -> float -> long -> int -> char -> short -> byte```

### Casting em classes Wrapper
- faz o casting utilizando metodo .intValue() .doubleValue() .floatValue() .longValue() .shortValue() .byteValue()
- exemplo: Integer i = 10; int x = i.intValue(); // x = 10
- ao comparar variaveis que armazenam objetos com ==, o resultado sera true se as variaveis apontarem para o mesmo objeto. Na classe Wrapper o cache armazena somente numeros de -128 a 127. se passar desses valores, sera criado um novo objeto a cada atribuicao.
- usar .equals() para comparar objetos
- equals compara conteudo e TIPOS! //  == compara referencia
- metodo .CompareTo() => retorna 0 se os 2 numeros forem iguais, -1 se o primeiro numero for menor e 1 se o primeiro numero for maior


### Quando usar Wrappers e quando usar tipos primitivos?
- quando nao for possivel usar tipos primitivos
- quando for necessario usar NULL


### recurso varargs
- cria um array do tamanho do numero de argumentos passado na chamada do metodo! 
-exemplo: `ServicoDeComunicacao.enviarEmail("Olá", "segundoArgumentoDoArray", "terceiroArgumentoDoArray");`
- `Tipo...` variavel
- declara um metodo que pode receber um numero variavel de argumentos do mesmo tipo
- exemplo: public void imprimeNumeros(int... numeros) { for (int numero : numeros) { System.out.println(numero); } }
- varargs deve ser o ultimo parametro do metodo, pois ele recebe um numero variavel de argumentos e todo argumento passado apos ele sera considerado parte do varargs.
- varargs aceita argumentos vazios!! != de arrays


# Gerenciamento de Memoria & JVM
- Java Virtual Machine
-Memoria Heap & memoria nao Heap
- memoria heap: onde ficam os objetos
- memoria stack - dentro da NAO HEAP: onde ficam os metodos, variaveis estaticas, etc
- NativeMemoryTracking: ferramenta para monitorar a memoria nao heap


## Pilha de chamadas
- stack trace: pilha de chamadas
- a cada chamada de metodos vamos empilhando um dentro do outro dentro da call stack
- fluxo de Baixo para Cima, empilhando chamada de metodos!
- fluxo de Cima para Baixo, desempilhando chamada de metodos! e ativando o garbage collector, onde variaveis de referencia deixam de existir ao sair do escopo ( metodo desempilhou e nao tem mais referencia para o objeto, logo o objeto pode ser coletado pelo garbage collector)
- o mesmo vale para variaveis do tipo primitivo, porem SEM envolvimento do Garbage colector, pois elas ficam na stack memory e sao liberadas imediatamente ao sair do escopo do metodo
- variaveis do tipo **primitivo** ficam na stack memory
- variaveis do tipo **referencia** ficam na stack memory, **Objetos**!

## Memoria heap com Runtime API
- ``Runtime.getRuntime().maxMemory()`` =>  retorna o maximo de memoria que a JVM pode usar em bytes
- ``.totalMemory()`` => retorna o total de memoria que a JVM esta usando em bytes, reservada no momento! ***.totalMemory()***
- ``freeMemory()`` => Quanto da memoria ja reservada está disponivel na memoria Heap para alocacao de novos oBjetos ***.freeMemory()***
- **memoria em uso no momento**: ``totalMemory() - freeMemory()``

## configurando Memoria Heap
- no consolo digite `java -Xmx1024m Teste` => aumenta o maximo de memoria que a JVM pode usar para 1024 MB ( maxMemory() )
- valor inicial de memoria `java -Xms1024m Teste` => 1024 MB = > util quando o programa requer mais memoria que o valor inicial padrao pela JVM
- liberacao de memoria é feita pelo Garbage collector

## Garbage Collector
- coleta de lixo => identificar objetos que nao estao mais sendo referenciados, e desaloca-los da memoria heap
- Assim que uma variavel de referencia é atribuida como NULL `String teste = "ssss" de teste = null;`, **caso nenhuma variavel esteja usando a variavel teste (declarada antes do teste = null)  e de tempo de o garbage entrar em acao** 
- ![Exemplo](/JavaWorkSpace/Resumos/prints/Screenshot%202023-10-29%20103737.png)

- nao temos garantia de quando o garbage vai rodar!
- **Sytem.gc()** => chama o garbage collector, mas nao temos garantia de que ele vai rodar!
- Garbage Collector é um processo que roda em uma thread separada da JVM
- OutOfMemoryError => significa que nao tem mais espaco para alocar novos objetos

## Memory Leak
- ocorre quando um objeto nao é mais utilizado, mas nao é coletado pelo garbage collector
- no caso da retirada de elemento de uma pilha, o elemento nao é mais utilizado, mas nao é coletado pelo garbage collector, pois a variavel de referencia ainda aponta para ele.
- **boa pratica (Exceção)** = > retirar objetos oBSLETOS que voce notar nao ser observado pelo Garbage com NULL => no exemplo da pilha => array atribuindo NULL, ao remover da pilha.

## inalcançabilidade de objetos
- um objeto é inalcancavel quando nao temos mais referencia para ele
- 1 caso de inalcancabilidade: quando uma variavel de referencia **aponta para NULL**
- 2 caso de inalcancabilidade: quando uma variavel de referencia **aponta para outra variavel de referencia que aponta para NULL**
- 3 caso => apos a execucao do metodo, a variavel de referencia fica inalcancavel( != de deixar de existir) e elegivel para a coleta pelo garbage collector
-4 **ilha de isolamento**=> quando 2 objetos( da Mem Heap) apontam um para o outro, mas nao sao apontados por nenhuma outra variavel de referencia ( da call stack ), logo, sao inalcancaveis e elegiveis para a coleta pelo garbage collector
- ![Ilha de Isolamento](/JavaWorkSpace/Resumos/printsJava/isolamento.png)


# Construtores
- construtor é um metodo especial que tem o **mesmo nome da classe** e é responsavel por Inicializar objetos de uma classe
- construtor **nao tem retorno**
- Chamado quando um objeto é criado com a palavra **new**
- Nao tem como chamar construtor como um metodo!! somente na **criacao de um objeto**
- o construtor default em java é o construtor sem argumentos, que nao recebe parametros e nao faz nada

- exemplo 
```java
public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    
    // Construtor default que pode ser alterado!
    public Carro(){} 
        
    // Construtor com parametros
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    // Sobrecarga de construtores
    public Carron(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}
```	
- ao criar um construtor com argumentos, o construtor default deixa de existir
- ao criar construtor privado, NAO se permite a instanciacao da classe -> pratica para criar classes utilitarias,com metodos estaticos.

### Sobrecarga de construtores
- *CUIDADO* Se voce alterar o construtor da classe, todos objetos que instanciam essa classe vao precisar de manutencao! 
- solucao: sobrecarga de construtores -> criar mais de um construtor na classe, *NECESSARIAMENTE* *Com MESMO NOME*  e com diferentes argumentos
- Dependendo de quantos argumentos forem passados ao criar um objeto, o construtor correspondente sera chamado, inclusive o **DEFAULT** => new Carro(); => sem passar argumentos

### Validar Argumentos de Construtores
- é uma **boa pratica** validar os argumentos passados ao construtor, para evitar que o objeto seja criado com valores invalidos
- exemplo: 
```java
public class Carro {
    private String marca;
    private String modelo;
    private int ano;  
    // Construtor com parametros
    public Carro(String marca, String modelo, int ano) {
        Objects.requireNonNull(marca, "Marca nao pode ser nula");
      
        // ou Objects.requireNonNull(modelo, "Modelo nao pode ser nulo");
        if (modelo == null) {
            throw new NullPointerException("Modelo nao pode ser nulo");
        }
        // Objects.requireNonNull(ano, "Ano nao pode ser nulo");
        if (ano < 0) {
            throw new IllegalArgumentException("Ano nao pode ser negativo");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
   
}

```
### Encadeamento de chamadas de construtores
- É possivel chamar um construtor dentro de outro construtor da ``mesma classe``, utilizando a palavra **``this``** e passando os argumentos necessarios
- ``this`` serve para referenciar a variavel local
- Somente dentro do bloco de outro construtor, podemos chamar outro construtor da mesma classe
- ``this()`` deve ser a primeira instrucao do construtor, pois caso tenha alguma instrucao antes, o compilador vai determinar que o construtor ja esta construido
- *NAO* existe limite para encadeamento de construtores!
```java
public Carro(){ // ao criar um objeto sem passar argumentos esse construtor chama o de baixo passando a string Fiat como Marca.
    this("Fiat");
}
public Carro(String marca){
    Objects.requireNonNull(marca, "Marca nao pode ser nula");
    this.marca = marca;

}
```

### Modificadores final em variaveis de instancia!
- **static final** => variavel de classe constante
- **final** => variavel de instancia constante
    - Ao declarar uma variavel como final, ela nao pode ser alterada depois de inicializada => e Necessita ser inicializada na declaracao **ou no construtor** (*XOR*) => somente em um dos dois | OU um OU outro| !!


- Para inicializar  ao instanciar o objeto, declara-se a variavel como **final** e inicializa-se no construtor
-exemplo
```java
public class ExemploClasse {
    // Variável de instância final
    private final String variavelFinal;

    public ExemploClasse(String valor) {
        // Inicializando a variável final com o valor passado como argumento ao instancia o objeto!
        this.variavelFinal = valor;
    }
```
- **UUID** => identificador unico universal => classe que gera um identificador unico para cada objeto criado
    - UUID.randomUUID().toString() => gera um identificador unico em formato de String
    - utiliza na declaracao de uma variavel final de instancia para gerar um identificador unico para cada objeto criado
    - normalmente declarado no construtor
        ``- this.id = UUID.randomUUID().toString();`` >> fe132e3e-2b1e-4b0e-8b0a-5e0e1e1e1e1e output

### Organizando as classes *Java* em pacotes
- **Convencao de nomes de pacotes** => nomes de pacote em *minusculo*
    - dominio ao contrario =>`` br.com.alura.bytebank``
    - ``com.github.nomeDoUsuario.nomeDoProjeto``
- para criar um pacote ao criar classe voce pode declarar diretamente no nome da classe => `animal.Gato` => com o PONTO . voce cria um pacote dentro de outro pacote
- necessario atribuir no comeco da classe o pacote onde ela esta => class Gato precisa declarar ``package animal``;

### Importando classes de outros pacotes
- para importar uma classe de outro pacote, basta declarar no comeco da classe o pacote onde a classe esta => ``import animal.Gato;``
- para importar todas as classes de um pacote => ``import animal.*;`` o * significa todos.
    - porem é uma **Boa pratica** importar uma por uma, e somente as que voce ira usar!
- ao importar classes com metodos ou construtores private  nao sera possivel acessar esses metodos ou construtores => pois private só pode ser acessado dentro da própria classe em que foi definido.
   

## Modificadores de acesso
- **Boa pratica** -> restringir o acesso a classe e seus membros o MAXIMO possivel quando possivel

### Modificadores de acesso default e public
- **default** => nao precisa declarar, pois é o padrao	
    - Default (ou Package-Private): Se um método ou construtor não tem um modificador de acesso explícito, ele é tratado como default ou package-private. Isso significa que o método ou construtor **pode ser acessado apenas por outras classes no mesmo pacote.**
- **public** => pode ser acessado por qualquer classe
    - Public: Um método ou construtor declarado como public **pode ser acessado por qualquer outra classe**.

### Modificadores de acesso private e protected
- **private** => somente a classe onde foi declarado pode acessar atributos e metodos ou construtores private
    - Private: Um método ou construtor declarado como private **pode ser acessado apenas por outras classes na mesma classe.**
    - ``metodos Public da classe podem acessar metodos private da mesma classe, é a forma de acessar metodos/ atributos com modificadores private!``
- **protected** => somente a classe onde foi declarado pode acessar atributos e metodos ou construtores protected , e **classes filhas ( mesmo em pacotes diferentes)** => ``é um private + classes filhas ``

### importando membros Estaticos
- ``import static`` -> importa membros estaticos de uma classe, **metodos ou atributos**
    - nao precisar chamar pela classe -> como padrão de static 
    - chama-se direto pelo nome do metodo ou atributo
    - exemplo de atributo:
    ```java
    import static java.lang.Math.PI; // importando a constante PI
    system.out.println(PI); // chamando a constante PI
    ```
    - exemplo de metodo:
    ```java
    import static java.lang.Math.random; // importando o metodo random
    system.out.println(random()); // chamando o metodo random
    ```
### Multiplas classes NAO PUBLIC em um mesmo arquivo!
- **Boa pratica** -> criar uma classe por arquivo
- **classe publica** -> OBRIGATORIAMENTE deve ser declarada em um arquivo com seu nome
- Nao deve ser usado, somente em palestras / aulas / exemplos

## Encapsulamento
- A falta de encapsulamento pode levar a problemas de manutencao e seguranca
    - uma classe externa altera o estado de uma classe interna, sem que a classe interna saiba! => **problema de seguranca**
    - Manuntencao: alterar o estado de uma classe interna, pode quebrar o funcionamento de uma classe externa => **problema de manutencao**

- **Encapsulamento** => esconder detalhes de implementacao de uma classe, expondo somente o necessario para que outras classes possam interagir com ela

- Logicas de validacao -> recomendadas ser implementadas nos **metodos de acesso (getters e setters)**

- **Nao se altera assinatura de metodos**, somente o seu funcionamento interno, para nao quebrar o codigo de outras classes que utilizam esse metodo, nao há problema em adicionar atributos ou alterar seus nomes( no caso de eles possuirem getters & setters)
### Tell dont ask
- Regra de classes :  **Tell dont ask**
    - ``Tell`` : Você deve dizer a um objeto o que fazer, chamando um de seus métodos e deixando o objeto cuidar de seu próprio comportamento interno. Isso significa que você confia no objeto para fazer a coisa certa com os dados que ele possui.
    - ``Don't Ask`` : Você não deve perguntar a um objeto sobre seu estado interno e, em seguida, tomar decisões com base nesse estado. Fazer isso viola o encapsulamento, pois expõe os detalhes internos do objeto e transfere a lógica que deveria pertencer ao objeto para fora dele
### JavaBeans e Getter e Setter
- **Convencoes do JavaBeans**:
    - Propriedades Privadas
    - Construtor Sem Argumentos
    - Métodos Getter e Setter
    - Serializável
    - Seguir essas convenções é importante porque **muitas ferramentas e bibliotecas Java dependem delas** para inspecionar e manipular classes de maneira programática
- Getters e Setters -> metodos de acesso
- Getters -> metodo de leitura
- Setters -> metodo de escrita
- Convencao -> getTitulo() e setTitulo() -> **get** e **set** + nome do atributo com a primeira letra maiuscula
-exemplo:
```java
public class Livro {
    private String titulo;
    private boolean emprestado;
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void isEmprestado() { // convecao para getter de boolean primito
        return emprestado;
    }
}
```
- interface **serializable**:
    - interface que indica que a classe pode ser serializada =>  transformada em um fluxo de bytes para ser transferida! 

### Codigo Limpo -> Lei de Demeter
- sugestao ocasionalmente util -> segundo martin fowler
- train wreck -> chamadas encadeadas de metodos
`metodo1().metodo2().metodo3()`
    - é um anti pattern -> codigo ruim, pois dificulta leitura do codigo e ``aumenta acoplamento``, e qualquer pequena alteracao pode quebrar o codigo.
- ``Lei de Demeter`` -> um objeto deve conhecer o minimo possivel sobre estrutura de outros objetos!
    - Metodo pode chamar outro metodo do proprio objeto!
    - Metodo pode chamar outro Metodo de parametro que recebe!
    - pode chamar metodo de um objeto instanciado dentro do metodo!
    - pode chamar metodos de variaveis de instancias!
- **Boa pratica** -> nao chamar metodos de objetos que foram retornados por outros metodos

### Crie copias defensivas de objetos mutaveis!
- **Boa pratica** -> nao retornar o objeto original, retornar uma copia defensiva dele!
- considerando que a classe é mutavel, ou seja, seus atributos podem ser alterados a qualquer momento -> fazer copias defensivas, instanciando um novo objeto e passando os valores do objeto a ser copiado!
    -exemplo:
    ```java
    public class Agendamento {
        private final Horario horario // o final nao impede que o objeto seja alterado, somente a referencia para ele!
        public Agendamento(Horario horario) {
            this.horario = new Horario(horario.getHora(), horario.getMinuto()); // copia defensiva, criando um novo Objeto Horario e passando os valores do objeto a ser copiado!
        }

        public Horario getHorario() {
            return new Horario(horario.getHora(), horario.getMinuto()); // copia da copia, para nao permitir que o objeto original seja alterado!
        }
    }
    ```
- caso a classe Horario fosse imutavel, com atributos primitivos final, nao seria necessario criar copias defensivas!

### Minimize a **mutabilidade** dos objetos
- ``Classe imutavel`` -> quando os objetos instanciados dessa classe, nao podem ter seus estados alterados depois de instanciado!
- ``Classe mutavel`` -> quando os objetos instanciados dessa classe, podem ter seus estados alterados depois de instanciado!
- **Boa pratica** -> Metodos que recebem objetos como argumentos nao devem alterar o estado desses objetos!
    - Utilizar uma ``classe imutavel`` mitiga esse problema!
-Diretrizes para criar classes imutaveis :
        - ``variaveis de instancia`` devem ser **private e final**
        - NAO ter metodos que alterem o estado do objeto *SETTERS*
        - NAO permitir que a classe seja HERDADA -> ``final`` na declaracao da classe -> `public final class Horario`
- Como não se consegue alterar uma classe imutavel -> solucao é return uma nova instancia da classe, com os valores alterados.`return new Horario(horaAlterada, horario.getMinuto());` // horaAlterada é o novo valor passado como argumento
- **Desvantagem** -> criar uma nova instancia daquele objeto, sempre que precisar alterar o seu valor!
-**Quando Usar** -> Ideal para ``multi-Thread`` e representar valores para tipos de dados abstratos ou `Value Objects` -> objetos que representam valores, como data, hora, CPF, CNPJ, etc. 

### Records
-  RECURSO Lancado no java 16 -> nos ajuda a enxugar o codigo ao criar classes IMUTAVEIS!
- Ao criar a classe imutavel deve-se designar -> `public record NomeClasse(int propriedades){} `
  - No lugar de `class` usamos `record` e coloca-se as propriedades dentro dos parenteses -> que viram os atributos da classe private e final!
  - a classe `record` cria o construtor automaticamente! -> diferente do construtor padrao vazio de classes normais, o construtor do record recebe as propriedades como parametro e inicializa!
    - NAO se pode mudar o nome dos parametros, precisa ser IGUAL ao das propriedades
  - Construtor COMPACTO -> ao criar o construtor da forma -> `public NomeClasse{}` -> o compilador entende que eh um construtor compacto e atribui os parametros as variaveis de instancia automaticamenteo!
    - ```java
      public record NomeClasse(int propriedades){
        public NomeClasse{
            // this.propriedades = propriedades ja esta incluso!
          if(propriedades < 0){
            throw new IllegalArgumentException("Propriedades nao pode ser menor que 0");
          }
        }
        public NomeClasse(int propriedades){ // esse construtor nao precisa ser criado, ja é criado automaticamente!
            this.propriedades = propriedades;
        }
      }
      ```
- **Records** cria automaticamente os Getters, porém com nome igual ao da variavel de instancia -> private final hora -> ao inves de getHora() sera somente *hora()*
  - NAO existem Setters nas classes records -> pois elas sao classes imutaveis, entao nao faz sentido ter setters!
- **Records** tambem implementa toString(), hashCode() e equals() automaticamente 
  -  **toString()** retorna o nome da classe e os valores das variaveis de instancia e **equals()** compara os valores das variaveis de instancia!
  - **hashCode()** -> que retorna um numero inteiro que representa o objeto! 

- na **UML** um record é atribuido com o esteriótipo ``<<dataType>>``

## Herança
- **Heranca** -> mecanismo que permite que uma classe herde ``atributos e metodos`` de outra classe






