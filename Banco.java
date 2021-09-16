
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Banco {
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private Cliente getCliente(String cpf){
        for (Cliente c : clientes) {
            if(c.getCliente() == cpf){
                return c;
            }
        }
        return null;
    }

    private ArrayList<Conta> pesquisarContasCliente(String cpf){
        ArrayList<Conta> cont = new ArrayList<Conta>();
        Cliente cli = getCliente(cpf);

        for (Conta c : contas) {
            if(c == cli){
                cont.Add(c);
            }
        }
        return cont;
    }



    public void cadastrarConta () {

    }
    public void alterarConta () {

    }
    public void excluirConta () {

    }



    public void cadastrarCliente () {

    }
    public void alterarCliente () {

    }
    public void excluirCliente () {

    }



    public void transferencia () {

    }
    public void saque () {

    }
    public void deposito () {

    }
    
    
}