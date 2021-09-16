
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    
	Scanner s = new Scanner(System.in);
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private Cliente getCliente(String cpf){
        for (Cliente c : clientes) {
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    private ArrayList<Conta> pesquisarContasCliente(String cpf){
        ArrayList<Conta> cont = new ArrayList<Conta>();
        Cliente cli = getCliente(cpf);

        for (Conta c : contas) {
            if(c.getCliente() == cli){
                cont.add(c);
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
        System.out.println("\nCADASTRO DE CLIENTE\n");
        System.out.println("\nCPF do cliente: ");
		String cpf = s.nextLine();
        while (getCliente(cpf)!=null){
            System.out.println("\nCPF ja utilizado! Digite um novo: [-1 para cancelar]");
            cpf = s.nextLine();
        }
        if (cpf.equals("-1")) return;
        System.out.println("\nNome do cliente: ");
		String nome = s.nextLine();
        System.out.println("\nTelefone do cliente: ");
		String telefone = s.nextLine();
        clientes.add(new Cliente(nome, cpf, telefone));
        System.out.println("\nCadastrado com sucesso!\n\n");
    
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