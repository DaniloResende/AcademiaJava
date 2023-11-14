import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }
// ao criar um pedido temos que passar um cliente para poder associar o pedido a esse cliente!
    public Pedido criarPedido(Pedido pedido, Cliente cliente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(pedido);
            cliente.addPedido(pedido);
            transaction.commit();
            return pedido;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public Pedido lerPedido(Long pedidoId) {
        return em.find(Pedido.class, pedidoId);
    }

    public void atualizarStatusPedido(Long pedidoId, String novoStatus) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Pedido pedido = em.find(Pedido.class, pedidoId);
            if (pedido != null) {
                pedido.setStatus(novoStatus);
                em.merge(pedido);
            } else {
                System.out.println("Pedido não encontrado com o ID: " + pedidoId);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deletarPedido(Long pedidoId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Pedido pedido = em.find(Pedido.class, pedidoId);
            if (pedido != null) {
                em.remove(pedido);
            } else {
                System.out.println("Pedido não encontrado com o ID: " + pedidoId);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    //REMOVE o pedido vinculado a determinado cliente
    public void deletarPedidoDeCliente(Long clienteId, Long pedidoId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    
        try {
            Cliente cliente = em.find(Cliente.class, clienteId);
            Pedido pedido = em.find(Pedido.class, pedidoId);
    
            if (cliente != null && pedido != null && cliente.getPedidos().contains(pedido)) {
                cliente.getPedidos().remove(pedido); // Remove o pedido da lista de pedidos do cliente
                pedido.setCliente(null); // Remover a referência do cliente no pedido, se for um relacionamento bidirecional
    
                em.remove(pedido); // Deleta o pedido do banco de dados
            } else {
                System.out.println("Cliente ou Pedido não encontrado, ou o Pedido não pertence ao Cliente.");
            }
    
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
