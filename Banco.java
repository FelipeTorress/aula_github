
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
        System.out.println("\n\nCADASTRO DE CONTA\n");
        System.out.println("\nDiga o CPF do cliente: ");
		String cpf = s.nextLine();
        Cliente cli = getCliente(cpf);

        while (cli==null){
            System.out.println("\nCPF não cadastrado! Cliente não existe! Digite um novo: [-1 para cancelar]");
            cpf = s.nextLine();
            if (cpf.equals("-1")){
                return;
            }else{
                cli = getCliente(cpf);
            }
        }

        ArrayList<Conta> contasCli = pesquisarContasCliente(cli.getCpf());
        int tamContaCli = contasCli.size()+1;


        String confirma = "";
        while(!confirma.equals("s") && !confirma.equals("S") && !confirma.equals("n") && !confirma.equals("N")){
            System.out.println("\nConfirma a Criacao da conta?[s - para confirmar][n - para cancelar] ");
		    confirma = s.nextLine();
        }
        if(confirma.equals("n") || confirma.equals("N")) return;
        
        contas.add(new Conta("1606", Integer.toString(tamContaCli), cli));
        System.out.println("\nConta criada com sucesso\n");
        System.out.println("\nAgencia: 1606, Numero da Conta: "+tamContaCli+"\n\n");
    }
    public void alterarConta () {

    }
    public void excluirConta () {

    }



    public void cadastrarCliente () {
        System.out.println("\n\nCADASTRO DE CLIENTE\n");
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