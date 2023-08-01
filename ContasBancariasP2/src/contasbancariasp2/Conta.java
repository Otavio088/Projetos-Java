package contasbancariasp2;

public class Conta {
    int conta;
    int senha;
    String cliente;
    double saldo;
    double limiteEspecial;
    
    public Conta (int conta, int senha, String cliente, double saldo, double limiteEspecial){
        this.conta = conta;
        this.senha = senha;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limiteEspecial = limiteEspecial;
}
    public boolean metSenha(int senha) {
        if ((this.senha) == (senha) ) {
            return true;
        } else
            return false;
    }
    
    public String metSaldo() {       
        return "Cliente: " + cliente + "\nSaldo: " + saldo;
    }
    
    public String metSaque(double vSaque) {
        if ((saldo > vSaque) || (saldo == vSaque)) {
            saldo = (saldo-vSaque);
            return "Saque efetuado com sucesso!";
        } else
            return "Saldo insuficiente!";
    } 
    
    public String metDeposito(double valorDepositado) {
        saldo = (saldo + valorDepositado);
        return "Depósito efetuado com sucesso!";
    }
}
    
