package imobiliariap3;

public class Imovel {
    int codigo;
    String categoria;
    double aluguelBase;
    String situacao;
    
    public Imovel (int codigo, String categoria, double aluguelBase, String situacao){
        this.codigo = codigo;
        this.categoria = categoria;
        this.aluguelBase = aluguelBase;
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getAluguelBase() {
        return aluguelBase;
    }

    public void setAluguelBase(double aluguelBase) {
        this.aluguelBase = aluguelBase;
    }
    
    
    public double metAluguelFinalImovel(){
        if ((categoria).equals("r")) {
            return(aluguelBase + ((5/100)*(aluguelBase)));
        } else if ((categoria).equals("g")) {
            return(aluguelBase + ((7/100)*(aluguelBase)));
        } else
            return(aluguelBase + ((10/100)*(aluguelBase)));
    }
}