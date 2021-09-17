
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
        int tamContaCli;
        if(contasCli.size() == 0){
            tamContaCli = contasCli.size()+1;
        }else{
            tamContaCli =  Integer.parseInt(contasCli.get(contasCli.size()-1).getNumeroConta())+ 1;
        }
            
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
        System.out.println("\n\nALTERACAO DE CONTA\n");
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
        if(contasCli.size()==0){
            System.out.println("\nNao ha contas existentes para o cpf informado!");
            return;
        }else{
            System.out.println("\nQual conta deseja alterar?:");
            for (Conta cont: contasCli){
                System.out.println("\nAgencia: "+cont.getAgencia()+" Conta: "+cont.getNumeroConta());
            }
        }
        System.out.println("Diga a agencia e conta: [ex: 1606 1]");
        String contaAlterada = s.nextLine();
        Conta contaParaAlterar = new Conta("-1","-1",cli);
        boolean digitouCorretamente = true;
        while(true){
            contaAlterada = contaAlterada.trim();
            String[] newStr = contaAlterada.split("\\s+");
            if(newStr.length != 2 ) digitouCorretamente = false;
            
            if(digitouCorretamente == true){
                for (Conta c: contasCli){
                    if(newStr[0].equals(c.getAgencia()) && newStr[1].equals(c.getNumeroConta())){
                        contaParaAlterar = c;
                        break;
                    }
                }
                if(contaParaAlterar.getNumeroConta().equals("-1")){
                    System.out.println("Digite corretamente agencia e conta: [ex: 1606 1]\n");
                    contaAlterada = s.nextLine();
                    continue;
                }
                break;
            }
            System.out.println("Digite corretamente agencia e conta: [ex: 1606 1]\n");
            contaAlterada = s.nextLine();
            digitouCorretamente = true;
            continue;
        }
        System.out.println("\n\nPor problemas temporarios no sistema apenas a troca de Agencia esta disponivel no momento");
        String confirma = "";
        while(!confirma.equals("s") && !confirma.equals("S") && !confirma.equals("n") && !confirma.equals("N")){
            System.out.println("\nDeseja realizar a troca de Agencia para esta conta?[s- sim | n - nao]: \n");
		    confirma = s.nextLine();
        }
        if(confirma.equals("n") || confirma.equals("N")) return;

        System.out.println("\n\nDigite a nova Agencia [codigo numerico]: ");
        confirma = s.nextLine();
        boolean integerouNao = confirma.matches("-?\\d+");
        while(integerouNao == false){
            System.out.println("\n\nErro, digite novamente: ");
            confirma = s.nextLine();
        }

        for (Conta c : contas) {
            if(c.getNumeroConta() == contaParaAlterar.getNumeroConta()){
                c.setAgencia(confirma);
            }
        }
        System.out.println("\n\nAGENCIA ALTERADA COM SUCESSO! ");
        return;
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