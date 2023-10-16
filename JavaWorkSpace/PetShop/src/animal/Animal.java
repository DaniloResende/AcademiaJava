
package animal;
import java.time.LocalDate;

public abstract class Animal {
    private String nome;
    private String especie;
    private String raca;
    private LocalDate dataNascimento;
    private String proprietario;
    
    public Animal(String nome, String especie, String raca, LocalDate dataNascimento, String proprietario) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
    }
  

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEspecie(){
        return this.especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }

    public String getRaca(){
        return this.raca;
    }
    public void setRaca(String raca){
        this.raca = raca; 
    }

    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }
    public void setDataNascimento(LocalDate data){
        this.dataNascimento = data;
    }

    public String getProprietario(){
        return this.proprietario;
    }
    public void setProprietario(String nomeProprietario){
        this.proprietario = nomeProprietario;
    }

}


