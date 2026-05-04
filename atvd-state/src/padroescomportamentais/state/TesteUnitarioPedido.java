package padroescomportamentais.state;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioPedido {

    @Test
    public void testEstadoInicialRecebido() {
        Pedido pedido = new Pedido();
        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    public void testConfirmarPedido() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.confirmar());
        assertEquals("Em Preparo", pedido.getNomeEstado());
    }

    @Test
    public void testFinalizarPedido() {
        Pedido pedido = new Pedido();
        pedido.confirmar();
        assertTrue(pedido.finalizar());
        assertEquals("Pronto", pedido.getNomeEstado());
    }

    @Test
    public void testEntregarPedido() {
        Pedido pedido = new Pedido();
        pedido.confirmar();
        pedido.finalizar();
        assertTrue(pedido.entregar());
        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    public void testCancelarPedidoRecebido() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    public void testCancelarPedidoEmPreparo() {
        Pedido pedido = new Pedido();
        pedido.confirmar();
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    public void testNaoPodeConfirmarPedidoPronto() {
        Pedido pedido = new Pedido();
        pedido.confirmar();
        pedido.finalizar();
        assertFalse(pedido.confirmar());
        assertEquals("Pronto", pedido.getNomeEstado());
    }

    @Test
    public void testNaoPodeCancelarPedidoEntregue() {
        Pedido pedido = new Pedido();
        pedido.confirmar();
        pedido.finalizar();
        pedido.entregar();
        assertFalse(pedido.cancelar());
        assertEquals("Entregue", pedido.getNomeEstado());
    }
}