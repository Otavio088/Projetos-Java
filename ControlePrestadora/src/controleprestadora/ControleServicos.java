package controleprestadora;
//1) Declare campos para as quatro colunas da tabela. Crie um construtor que receba os dados e armazene nos campos.
public class ControleServicos {
    int codServico;
    String cliente;
    String descricao;
    int qtdHoras;
    
    public ControleServicos(int codServico, String cliente, String descricao, int qtdHoras){
        this.codServico = codServico;
        this.cliente = cliente;
        this.descricao = descricao;
        this.qtdHoras = qtdHoras;
    }
    
    /* 2) Implemente um método que calcula e retorna o valor da final do serviço, sendo que o serviço de pintura custa 30 reais por hora,
       o de faxina custa 20 reais por hora e o de jardinagem custa 10 por hora.*/
    public double valorFinalServico() {
            if (this.descricao.equals ("pintura")){
                return (this.qtdHoras*30);
            } else if (this.descricao.equals ("faxina")) {
                return (this.qtdHoras*20);
            } else
                return (this.qtdHoras*10);
    }
}