
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Banco {
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Conta pesquisarContasCliente(String cpf){
        
    }

    private Cliente getCliente(String cpf){
        for (Cliente c : clientes) {
            if(c.getCliente() == cpf){
                return c;
            }
        }
        return null;
    }
}