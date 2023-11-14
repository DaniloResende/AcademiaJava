import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public Cliente criarCliente(Cliente cliente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(cliente);
            transaction.commit();
            return cliente;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public Cliente lerCliente(Long clienteId) {
        return em.find(Cliente.class, clienteId);
    }

    public void atualizarCliente(Long clienteId, String novoNome) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Cliente cliente = em.find(Cliente.class, clienteId);
            if (cliente != null) {
                cliente.setNome(novoNome);
                em.merge(cliente);
            } else {
                System.out.println("Cliente não encontrado com o ID: " + clienteId);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deletarCliente(Long clienteId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Cliente cliente = em.find(Cliente.class, clienteId);
            if (cliente != null) {
                em.remove(cliente);
            } else {
                System.out.println("Cliente não encontrado com o ID: " + clienteId);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
