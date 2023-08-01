//Aluno: Otávio Augusto de Melo Ribeiro.
//2° Período ADS (Noturno).
//Prof: Sandra Cristina.
package contasbancariasp2;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ContasBancariasP2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int op = 0;
        int nConta = 0;
        int senhaEscolha = 0;
        double valorDepositado = 0;
        Conta vetorBanco[] = new Conta[9];
        
        metDados(vetorBanco);
        
        while (op != 4){
            System.out.println("--------MENU--------\n"
                + "[1] Saldo\n"
                + "[2] Depósito\n"
                + "[3] Saque\n"
                + "[4] Sair\n"
                + "------------------");
        System.out.print("Opção: ");
        op = scan.nextInt();
        System.out.println("------------------");
        switch (op) {
            case 1:
                System.out.print("Número da Conta: ");
                nConta = scan.nextInt();
                int a = 0;
                int b = 0;
                for (int i = 0; i < 9; i++) {
                    if (nConta == vetorBanco[i].conta) {
                        a = a+1;
                        System.out.print("Senha: ");
                        senhaEscolha = scan.nextInt();
                        if (senhaEscolha == vetorBanco[i].senha) {
                            b = b+1;
                            System.out.println(vetorBanco[i].metSaldo());
                        }
                        if (b == 0) {
                            System.out.println("Senha Inválida! ");
                        }
                    }
                }
                if (a == 0) {
                System.out.println("Conta Inexistente! ");
                }
            break;
            case 2:
                int a1 = 0;
                int b1 = 0;
                System.out.print("Número da Conta: ");
                nConta = scan.nextInt();
                for (int i = 0; i < 9; i++) {
                    if (nConta == vetorBanco[i].conta) {
                        a1 = a1+1;
                        System.out.print("Senha: ");
                        senhaEscolha = scan.nextInt();
                        if (senhaEscolha == vetorBanco[i].senha) {
                            b1 = b1+1;
                            System.out.print("Valor a ser Depositado: ");
                            valorDepositado = scan.nextDouble();
                            System.out.println(vetorBanco[i].metDeposito(valorDepositado));
                        }
                        if (b1 == 0) {
                            System.out.println("Senha Inválida! ");
                        }   
                    }
                }
                if (a1 == 0) {
                System.out.println("Conta Inexistente! ");
                }
            break;
            case 3:
                int a2 = 0;
                int b2 = 0;
                System.out.print("Número da Conta: ");
                nConta = scan.nextInt();
                for (int i = 0; i < 9; i++) {
                    if (nConta == vetorBanco[i].conta) {
                        a2 = a2+1;
                        System.out.print("Senha: ");
                        senhaEscolha = scan.nextInt();
                        if (senhaEscolha == vetorBanco[i].senha) {
                            b2 = b2+1;
                            System.out.print("Valor a ser sacado: ");
                            double vSaque = scan.nextDouble();
                            System.out.println(vetorBanco[i].metSaque(vSaque));
                        }
                        if (b2 == 0) {
                            System.out.println("Senha Inválida! ");
                        } 
                    }
                }
                if (a2 == 0) {
                System.out.println("Conta Inexistente! ");
                }
            break;
            case 4:
                System.out.println("Finalizando Programa...");
            break;
            
        }
        
    }
    }
    
    public static void metDados(Conta[] vetorBanco) throws FileNotFoundException {
        File arq = new File("dados.txt");
        Scanner scan = new Scanner(arq) ;
        
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%10s %10s %12s %10s %15s\n", scan.next(), scan.next(), scan.next(), scan.next(), scan.next());
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < vetorBanco.length; i++) {
            vetorBanco[i] = new Conta(scan.nextInt(), scan.nextInt(), scan.next(), scan.nextDouble(), scan.nextDouble());
            System.out.printf("%10d %10d %12s %10.2f %15.2f\n", vetorBanco[i].conta, vetorBanco[i].senha, vetorBanco[i].cliente, vetorBanco[i].saldo, vetorBanco[i].limiteEspecial);
        }
        System.out.println("-------------------------------------------------------------");
    }

}
