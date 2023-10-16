import java.time.LocalDate;
import java.time.LocalTime;

import animal.Animal;
import animal.Gato;
import servicos.Banho;
import servicos.Servico;

public class Agenda {
    // private Animal animal; 
    // MELHORIA A FAZER! E DUVIDA sobre como conectar o que o usuario digitou a classe 
    // private Servico servico;
    private Animal animal; // classe animal  ou String?
    private Servico servico;
    private LocalDate data;
    private LocalTime horario;
    
    public Agenda(Animal animal, Servico servico, LocalDate data, LocalTime horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void agendar(Servico servico, Animal animal, LocalDate data, LocalTime horario){
        setAnimal(animal);
        setServico(servico);
        setData(data);
        setHorario(horario);
        System.out.printf("Serviço de: %s agendado com sucesso para o animal: %s, no dia: %s e no horario: %s ",
         getServico(), getAnimal(), getData(), getHorario());
    }

    //public void agendar(String animal, String servico, LocalDate data, LocalDate horario)

    public static void main(String[] args) {
        Gato animal1 = new Gato("bob", "gato",  "bengal", LocalDate.of(2022, 05, 06), "danilo");
        Banho servico1 = new Banho();
        
        Agenda agenda = new Agenda(animal1, servico1, LocalDate.of(2022, 05, 06), LocalTime.of(14, 30));
        agenda.agendar(servico1, animal1, LocalDate.of(2022, 05, 06), LocalTime.of(14, 30));
    }
}
