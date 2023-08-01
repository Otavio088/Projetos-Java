//Aluno: Otávio Augusto de Melo Ribeiro.
//2° Período ADS (Noturno).
//Prof: Sandra Cristina.
package imobiliariap3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImobiliariaP3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in) ;
        
        Imovel vetorImobiliaria[] = new Imovel[8];
        
        metDados(vetorImobiliaria);
        metDadosTela(vetorImobiliaria);
        
        System.out.print("Código do imóvel que deseja alugar: ");
        double codEscolha = scan.nextDouble();
        int a = 0;
        int b = 1;
        for (int i = 0; i < 8; i++) {
            if (codEscolha == vetorImobiliaria[i].codigo) {
                a = a+1;
                if ((vetorImobiliaria[i].situacao).equals("desocupado")) {
                    b = b+1;
                    System.out.println(vetorImobiliaria[i].metAluguelFinalImovel());
                    vetorImobiliaria[i].situacao = "ocupado";
                }
                else {
                    System.out.println("Imóvel Ocupado!");
                }
            }
        }
            if (a == 0) {
                System.out.println("Código Inválido!");
            }
            
        metDadosTela(vetorImobiliaria);
        
        
        
        System.out.print("Valor de aluguel: ");
        double escolha = scan.nextDouble();
        System.out.println("Categoria e valor dos mais baratos que R$ " + escolha);
        
        metImobiliariaFinal (vetorImobiliaria, escolha);
    }
    
    public static void metDados(Imovel[] vetorImobiliaria) throws FileNotFoundException{
         File arq = new File("dados.txt");
        Scanner scan = new Scanner(arq) ;
       for (int i = 0; i < vetorImobiliaria.length; i++) {
            vetorImobiliaria[i] = new Imovel(scan.nextInt(), scan.next(), scan.nextDouble(), scan.next());
        }
    }
    
    public static void metDadosTela (Imovel[] vetorImobiliaria) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("       codigo       categoria    aluguelBase    situação");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < vetorImobiliaria.length; i++) {
            System.out.printf("%10d %10s %17.2f %18s\n", vetorImobiliaria[i].codigo, vetorImobiliaria[i].categoria, vetorImobiliaria[i].aluguelBase, vetorImobiliaria[i].situacao);
        }
        System.out.println("-------------------------------------------------------------");
    }
    
    public static void metImobiliariaFinal (Imovel[] vetorImobiliaria, double aluguelEscolha) {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        for (int i = 0; i < 8; i++) {
            if (vetorImobiliaria[i].metAluguelFinalImovel() < aluguelEscolha) {
                a = 1;
                System.out.println("Categoria: " + vetorImobiliaria[i].categoria);
                System.out.println("Valor final de aluguel: " + vetorImobiliaria[i].metAluguelFinalImovel());
            }
        }
        if (a == 0) {
            System.out.println("Nenhum Imóvel com aluguel final abaixo de " + aluguelEscolha);
        }
    }
}
