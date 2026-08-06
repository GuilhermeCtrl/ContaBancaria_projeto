import java.util.Scanner;

public class operacoesBanco {
//scanner pra ler as resposta
    static Scanner scanner = new Scanner(System.in);

    public static void consultarSaldo(double saldo, double chequeEspecial) {
        System.out.printf("Seu saldo atual é: %s + %s de cheque especial%n", saldo, chequeEspecial);
        //voltar ou sair menu
        Menu.perguntarMenu();
    }

    public static void consultarLimiteChequeEspecial(double limiteChequeEspecial, double chequeEspecial) {
        System.out.printf("Seu limite de cheque especial é de: %s e o valor atual é: %s\n", limiteChequeEspecial, chequeEspecial);
        //voltar ou sair menu
        Menu.perguntarMenu();
    }
    public static double depositarDinheiro(double saldo, double taxa, double chequeEspecial, double limiteChequeEspecial) {
        System.out.println("Quanto deseja depositar?");
        saldo += scanner.nextDouble();
        saldo -= taxa;
        taxa = 0;
        chequeEspecial = limiteChequeEspecial;
        System.out.println("Saldo depositado!");


        //voltar ou sair menu
        Menu.perguntarMenu();
    }



}
