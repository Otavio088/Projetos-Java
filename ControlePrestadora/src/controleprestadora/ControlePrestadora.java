//Aluno: Otávio Augusto de Melo Ribeiro.
//2° Período ADS (Noturno).
//Prof: Sandra Cristina.
package controleprestadora;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ControlePrestadora {
    //1) Declare campos para as quatro colunas da tabela. Crie um construtor que receba os dados e armazene nos campos.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int op = 0;
        ControleServicos vetPresta[] = new ControleServicos[9];
        //6) chame o método que carrega os dados para o vetor e, em seguida, 
        dadosPrestadora(vetPresta);
        /*7) crie o seguinte menu de opções, dentro de um laço do-while
        Menu
        1 – Pesquisa por cliente
        2 – Pesquisa por serviço
        3 – Valor total recebido
        4 – Sair
        8) Na opção 1, solicite que o usuário digite o nome de um cliente e exiba todos os serviços contratados por ele, o valor total pago
        por cada serviço e valor total pago pelo cliente por todos os serviços. 1,0
        9) Na opção 2, exiba o serviço, a quantidade total de horas e o valor total recebido para cada um dos três tipos de serviço. 1,0
        10) Na opção 3, exiba o total recebido por todos os serviços. 0,5
        11) Na opção 4, encerre a execução do aplicativo.*/
        do{
            System.out.println("---------------------------------------------");
            System.out.println("[1] Pesquisa por Cliente\n" 
                             + "[2] Pesquisa por Serviço\n" 
                             + "[3] Valor Total Recebido\n"
                             + "[4] Sair");
            System.out.println("---------------------------------------------");
            System.out.print("Opção: ");
            op = scan.nextInt();
            System.out.println("---------------------------------------------");
            switch(op){
                case 1:
                    descricaoValor(vetPresta);
                break;
                case 2:
                    horasValor(vetPresta);
                break;
                case 3:
                    double valorTotal = 0;
                    for (int i = 0; i < 9; i++) {
                        valorTotal = (valorTotal + vetPresta[i].valorFinalServico());
                    }
                    System.out.println("Total recebido por todos os serviços: " + valorTotal);
                break;
                case 4:
                    System.out.println("Finalizando Programa...");
                break;
            }
        }while (op!=4);
    }
    
    //3) Método que lê os dados da tabela em um arquivo de texto, armazena em um vetor de serviçoc e exibe na tela.
    public static void dadosPrestadora(ControleServicos[] vetPresta) throws FileNotFoundException {
        File arq = new File("informacoes.txt");
        Scanner scan = new Scanner(arq);
        
        System.out.println("---------------------------------------------");
        System.out.printf("%10s %10s %12s %10s\n", scan.next(), scan.next(), scan.next(), scan.next());
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 9; i++) {
            vetPresta[i] = new ControleServicos(scan.nextInt(), scan.next(), scan.next(), scan.nextInt());
            System.out.printf("%10d %10s %12s %10d\n", vetPresta[i].codServico, vetPresta[i].cliente, vetPresta[i].descricao, vetPresta[i].qtdHoras);
        }
        System.out.println("---------------------------------------------");
        System.out.println("");
    }
    
    /*4) Método que recebe o vetor de serviço, o nome de um cliente e exibe a descrição e o valor de cada serviço contratado por este
      cliente. Se o usuário digitar um nome que não está na tabela, exiba a mensagem “Cliente inexistente”*/
    public static void descricaoValor(ControleServicos vetPresta[]) {
        Scanner scan = new Scanner (System.in);
        String cliente = "";
        int a = 0;
        System.out.print(">Nome do Cliente: ");
        cliente = scan.next();
        for (int i = 0; i < 9; i++) {
            if (cliente.equals(vetPresta[i].cliente)){
                System.out.println("Descrição: " + vetPresta[i].descricao);
                System.out.println("Valor de serviço: " + vetPresta[i].valorFinalServico());
                a = a+1;
            } 
        }
        if (a==0) {
            System.out.println("Cliente inexistente!");
        }
        System.out.println("---------------------------------------------");
    }
    
    /*5) Método que recebe um vetor de Servico, calcula e exibe a quantidade de horas e o valor recebido por cada um dos três tipos de
      serviços realizados.*/
    public static void horasValor(ControleServicos vetPresta[]) {
        int acumuloHorasp = 0;
        int acumuloHorasj = 0;
        int acumuloHorasf = 0;
        double valorPintura = 0;
        double valorJardinagem = 0;
        double valorFaxina = 0;
        for (int i = 0; i < 9; i++) {
            if (vetPresta[i].descricao.equals("pintura")){
                acumuloHorasp = (acumuloHorasp + vetPresta[i].qtdHoras);
                valorPintura = (valorPintura + vetPresta[i].valorFinalServico());
            }
            if (vetPresta[i].descricao.equals("jardinagem")){
                acumuloHorasj = (acumuloHorasj + vetPresta[i].qtdHoras);
                valorJardinagem = (valorJardinagem + vetPresta[i].valorFinalServico());
            }
            if (vetPresta[i].descricao.equals("faxina")){
                acumuloHorasf = (acumuloHorasf + vetPresta[i].qtdHoras);
                valorFaxina = (valorFaxina + vetPresta[i].valorFinalServico());
            }
        }
        System.out.println("Pintura: " + acumuloHorasp + " horas trabalhadas e " + valorPintura + " de valor recebido");
        System.out.println("Jardinagem: " + acumuloHorasj + " horas trabalhadas e " + valorJardinagem + " de valor recebido");
        System.out.println("Faxina: " + acumuloHorasf + " horas trabalhadas e " + valorFaxina + " de valor recebido");
    }
}