import java.io.IOException;

public class Conta {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(String agencia, String numconta, Cliente cliente){
        this.agencia = agencia;
        this.numeroConta = numconta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public boolean setSaldo(double valor, int operacao){
        if (operacao == 1){
            saldo = saldo + valor;
            return true;
        }
        else if(operacao == 2 && saldo >= valor){
            saldo = saldo - valor;
            return true
        }else{
            return false;
        }
    }
}