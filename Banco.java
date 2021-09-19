
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
    
    private Conta getConta(String ag, String num) {
    	for(Conta c : contas) {
    		if(c.getAgencia().equals(ag) && c.getNumeroConta().equals(num)) {
    			return c;
    		}
    	}
    	return null;
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
        if(contas.size() == 0){
            tamContaCli = 1;
        }else{
            tamContaCli =  Integer.parseInt(contas.get(contas.size()-1).getNumeroConta())+ 1;
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
    	System.out.println("\n\n Informe a agência e número da conta provedora\n");
    	String ag1 = s.nextLine();
    	String num1 = s.nextLine();
    	
    	System.out.println("\n\n Informe a agência e número da conta receptora\n");
    	String ag2 = s.nextLine();
    	String num2 = s.nextLine();
    	
    	Conta conta1 = getConta(ag1,num1);
    	while(conta1 == null) {
    		System.out.println("\n\n Conta não encontrada, informe novamente a agência e número da conta provedora\n [digite -1 se quiser cancelar]");
        	ag1 = s.nextLine();
        	if(ag1.equals("-1")) {
        		return;
        	}
        	num1 = s.nextLine();
        	conta1 = getConta(ag1,num1);
    	}
    	Conta conta2 = getConta(ag2,num2);
    	while(conta2 == null) {
    		System.out.println("\n\n Conta não encontrada, informe novamente a agência e número da conta receptora\n [digite -1 se quiser cancelar]");
        	ag2 = s.nextLine();
        	if(ag2.equals("-1")) {
        		return;
        	}
        	num2 = s.nextLine();
        	conta2 = getConta(ag2,num2);
    	}
    	
    	System.out.println("\n\n Informe o valor da transferência:\n");
    	double valor = s.nextDouble();
    	while(valor<=0) {
    		System.out.println("\n\n Informe um valor valido:\n [digite -1 caso queira cancelar]");
        	valor = s.nextDouble();
        	if(valor == -1) {
        		return;
        	}
    	}
    	
    	if(conta1.setSaldo(valor, 2)) {
    		boolean transf = conta2.setSaldo(valor, 1);
    		System.out.println("\n\n Transferência realizada com sucesso\n");
    	}else {
    		System.out.println("\n\n Saldo insuficiente\n");
    	}
    	
    }
    public void saque () {
    	System.out.println("\n\n Informe a agência e número da conta\n");
    	String ag = s.nextLine();
    	String num = s.nextLine();
    	
      	Conta conta = getConta(ag,num);
    	while(conta == null) {
    		System.out.println("\n\n Conta não encontrada, informe novamente a agência e número da conta provedora\n [digite -1 se quiser cancelar]");
        	ag = s.nextLine();
        	if(ag.equals("-1")) {
        		return;
        	}
        	num = s.nextLine();
        	conta = getConta(ag,num);
    	}
    	System.out.println("\n\n Informe o valor do saque:\n");
    	double valor = s.nextDouble();
    	while(valor<=0) {
    		System.out.println("\n\n Informe um valor valido:\n [digite -1 caso queira cancelar]");
        	valor = s.nextDouble();
        	if(valor == -1) {
        		return;
        	}
    	}
    	if(conta.setSaldo(valor, 2)) {
    		System.out.println("\n\n Saque realizada com sucesso\n");
    	}else {
    		System.out.println("\n\n Saldo insuficiente\n");
    	}

    }
    public void deposito () {

    }
    
    
}