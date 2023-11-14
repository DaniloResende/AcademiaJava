import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("academiajava");
            em = emf.createEntityManager();

            ClienteDAO clienteDAO = new ClienteDAO(em);
            PedidoDAO pedidoDAO = new PedidoDAO(em);

            em.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "juan@example.com", "Rua ABC, 123", "123456789");
            Cliente cliente2 = new Cliente("danilo", "danilo@example.com", "Rua ABC, 123", "123123123");
            Cliente cliente3 = new Cliente("richard", "richard@example.com", "Rua ABC, 123", "1231231");
            clienteDAO.criarCliente(cliente);
            clienteDAO.criarCliente(cliente2);
            clienteDAO.criarCliente(cliente3);

            Pedido pedido1 = new Pedido(140.0, LocalDate.now(), "Em andamento", cliente.getEndereco());
            Pedido pedido2 = new Pedido(180.0, LocalDate.now(), "Em andamento", cliente.getEndereco());
            Pedido pedido3 = new Pedido(220.0, LocalDate.now(), "Em andamento", cliente.getEndereco());
            pedidoDAO.criarPedido(pedido1, cliente);
            pedidoDAO.criarPedido(pedido2, cliente2);
            pedidoDAO.criarPedido(pedido3, cliente3);

            em.getTransaction().commit();

            

            




            // Recupera o cliente do banco de dados usando o ID
            Cliente clienteRecuperado = clienteDAO.lerCliente(cliente.getId());

            Pedido pedidoRecuperado = pedidoDAO.lerPedido(pedido1.getId());

            // Imprime as informações do cliente e seus pedidos recuperados do banco de dados
            System.out.println("Cliente recuperado do banco de dados: " + clienteRecuperado);
            System.out.println("Pedidos do cliente: " + clienteRecuperado.getPedidos());

            // Imprime as informações do pedido
            System.out.println("Pedido recuperado do banco de dados: " + pedidoRecuperado);
            System.out.println("Pedido pelo cliente: " + pedidoRecuperado.getCliente());
            
            //Atualiza o status do pedido
            pedidoDAO.atualizarStatusPedido(pedido2.getId(), "Concluído");

            //Remover pedido associado ao cliente de id 1 e id 3 de pedido.
            pedidoDAO.deletarPedidoDeCliente(cliente.getId(), pedido3.getId());
            
            // Atualiza o nome do cliente
            clienteDAO.atualizarCliente(clienteRecuperado.getId(), "João");

            //deleta cliente 2 -> danilo
            clienteDAO.deletarCliente(cliente2.getId());

            // Re-obtém o cliente do banco de dados após as alterações
            clienteRecuperado = clienteDAO.lerCliente(cliente.getId());

            // Imprime as informações do cliente recuperado do banco de dados após as alterações
            System.out.println("Cliente recuperado do banco de dados após alterações: " + clienteRecuperado);

        } catch (Exception e) {
            // Trate a exceção aqui, se necessário
            e.printStackTrace();
        } finally {
            // Fecha o EntityManager e o EntityManagerFactory no bloco finally
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}