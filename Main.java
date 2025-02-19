
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		Menu contaMenu =  new Menu("Menu Conta", Arrays.asList("Cadastrar", "Alterar", "Excluir", "Voltar"));
		Menu clienteMenu =  new Menu("Menu Cliente", Arrays.asList("Cadastrar", "Alterar", "Excluir", "Voltar"));
		Menu operacoesMenu =  new Menu("Menu Operacoes", Arrays.asList("Transferencia", "Saque", "Deposito", "Voltar"));
		Banco banco = new Banco();

		int opc1 = -1;
		int opc2 = -1;
		while (opc1 != 4){
			opc1 = mainMenu.getSelection();
			switch (opc1){
				case 1:
					opc2 = -1;
					while (opc2 != 4){
						opc2 = contaMenu.getSelection();
						switch (opc2){
							case 1:
								banco.cadastrarConta();
								break;
							case 2:
								banco.alterarConta();
								break;
							case 3:
								banco.excluirConta();
								break;
							case 4:
								break;
						}
					}
					break;
				case 2:
					opc2 = -1;
					while (opc2 != 4){
						opc2 = clienteMenu.getSelection();
						switch (opc2){
							case 1:
								banco.cadastrarCliente();
								break;
							case 2:
								banco.alterarCliente();
								break;
							case 3:
								banco.excluirCliente();
								break;
							case 4:
								break;
						}
					}
					break;
				case 3:
					opc2 = -1;
					while (opc2 != 4){
						opc2 = operacoesMenu.getSelection();
						switch (opc2){
							case 1:
								banco.transferencia();
								break;
							case 2:
								banco.saque();
								break;
							case 3:
								banco.deposito();
								break;
							case 4:
								break;
						}
					}
					break;
				case 4:
					break;
			}
		}


		//System.out.println(mainMenu.getSelection() + "foi selecionada");
		//System.out.println("Fim");
	}

}
