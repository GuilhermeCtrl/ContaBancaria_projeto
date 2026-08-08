import java.util.Scanner;

public class OperacoesBanco {
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

    public static void depositarDinheiro(ContaBanco conta, Scanner scanner) {

        System.out.println("Quanto deseja depositar?");
        conta.saldo += scanner.nextDouble();
        conta.saldo -= conta.taxa;
        conta.taxa = 0;
        conta.chequeEspecial = conta.limiteChequeEspecial;
        System.out.println("Saldo depositado!");
    }



}
