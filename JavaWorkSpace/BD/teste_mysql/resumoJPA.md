# Resumo JPA
- Java persistence API
- automatiza o mapeamento de objetos para o banco de dados
- JPA especifica uma documentacao como que deve ser feito o mapeamento de objetos para o banco de dados de forma padronizada, e o ``Hibernate`` implementa essa especificacao.
- ``Hibernate`` ->  framework de persistencia mais popular do mundo, o qual implementa a JPA.
- Vantagens: ENORME dimuincao de codigo e de (12 linhas JDBC puro x 1 linha JPA)produtividade pois nao precisamos digitar os comandos SQL para fazer o CRUD, facilita manutenabilidade e portabilidade pois o codigo fica independente do banco de dados.

### ORM
- ``ORM: Object Relational Mapping`` -> mapeamento objeto relacional
- banco de dados relacional é um banco que nos permite ao mesmo tempo armazenar dados e crie relacoes entre eles
- o `ORM` -> é voce representar uma tabela do banco de dados relacional como uma classe no seu codigo java, e as colunas dessa tabela como atributos dessa classe. De forma que possa AUTOMATIZAR  geracao do SQL.
    - **tabela -> classe**
    - **coluna -> atributo**
    - **linha -> objeto**

### JPA -> nome novo JAKARTA PERSISTENCE API
- principais anotaces de mapeamento:
    - ``@Entity`` -> indica que a classe é uma entidade, ou seja, uma ``tabela`` do banco de dados. e vai ser Persistida.
    - ``@Table`` -> indica o nome da tabela no banco de dados.
    - ``@Id`` -> indica que o atributo é uma chave primaria.
    - ``@GeneratedValue`` -> indica que o valor do atributo é gerado automaticamente.
    - ``@Column`` -> indica o nome da coluna no banco de dados.
    - ``@Transient`` -> indica que o atributo nao é persistido no banco de dados.
    - ``@Temporal`` -> indica que o atributo é um tipo de data.


    
# Resumo JPA
- Java persistence API
- automatiza o mapeamento de objetos para o banco de dados
- JPA especifica uma documentacao como que deve ser feito o mapeamento de objetos para o banco de dados de forma padronizada, e o ``Hibernate`` implementa essa especificacao.
- ``Hibernate`` ->  framework de persistencia mais popular do mundo, o qual implementa a JPA.
- Vantagens: ENORME dimuincao de codigo e de (12 linhas JDBC puro x 1 linha JPA)produtividade pois nao precisamos digitar os comandos SQL para fazer o CRUD, facilita manutenabilidade e portabilidade pois o codigo fica independente do banco de dados.

### ORM
- ``ORM: Object Relational Mapping`` -> mapeamento objeto relacional
- banco de dados relacional é um banco que nos permite ao mesmo tempo armazenar dados e crie relacoes entre eles
- o `ORM` -> é voce representar uma tabela do banco de dados relacional como uma classe no seu codigo java, e as colunas dessa tabela como atributos dessa classe. De forma que possa AUTOMATIZAR  geracao do SQL.
    - **tabela -> classe**
    - **coluna -> atributo**
    - **linha -> objeto**

### JPA -> nome novo JAKARTA PERSISTENCE API
- principais anotaces de mapeamento:
    - ``@Entity`` -> indica que a classe é uma entidade, ou seja, uma ``tabela`` do banco de dados. e vai ser Persistida.
    - ``@Table`` -> indica o nome da tabela no banco de dados.
    - ``@Id`` -> indica que o atributo é uma chave primaria.
    - ``@GeneratedValue`` -> indica que o valor do atributo é gerado automaticamente.
    - ``@Column`` -> indica o nome da coluna no banco de dados.
    - ``@Transient`` -> indica que o atributo nao é persistido no banco de dados.
    - ``@Temporal`` -> indica que o atributo é um tipo de data.



