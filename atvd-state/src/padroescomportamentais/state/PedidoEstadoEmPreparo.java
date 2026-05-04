package padroescomportamentais.state;

public class PedidoEstadoEmPreparo extends PedidoEstado {
    private PedidoEstadoEmPreparo() {};
    private static PedidoEstadoEmPreparo instance = new PedidoEstadoEmPreparo();
    public static PedidoEstadoEmPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Preparo";
    }

    public boolean finalizar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}