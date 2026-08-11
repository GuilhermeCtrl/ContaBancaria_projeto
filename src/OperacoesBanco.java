import java.util.Scanner;

public class OperacoesBanco {

//opção 1
    public static void consultarSaldo(double saldo, double chequeEspecial) {
        System.out.printf("Seu saldo atual é: %s + %s de cheque especial%n", saldo, chequeEspecial);
        //voltar ou sair menu

    }

//opção 2
    public static void consultarLimiteChequeEspecial(double limiteChequeEspecial, double chequeEspecial) {
        System.out.printf("Seu limite de cheque especial é de: %s e o valor atual é: %s\n", limiteChequeEspecial, chequeEspecial);
        //voltar ou sair menu

    }

//opção 3
    public static void depositarDinheiro(ContaBanco conta, Scanner scanner) {

        System.out.println("Quanto deseja depositar?");
        conta.saldo += scanner.nextDouble();
        conta.saldo -= conta.taxa;
        conta.taxa = 0;
        conta.chequeEspecial = conta.limiteChequeEspecial;
        System.out.println("Saldo depositado!");

    }

//opção 4
    public static void sacarDinheiro(ContaBanco conta, Scanner scanner) {
        System.out.println("Quanto deseja sacar?");
        conta.saque = scanner.nextDouble();
        if (conta.saque > conta.saldo){
            System.out.println("Saldo insuficiente para completar o saque!");
            System.out.println("Deseja utilizar seu cheque especial?");
            conta.option = scanner.next();
            if (conta.option.equalsIgnoreCase("Sim")){
                if (conta.saque > conta.saldo + conta.chequeEspecial){
                    System.out.println("Saldo + cheque especial insuficiente para completar o saque!");

                }else{
                    conta.valorUsadoCheque = conta.saque - conta.saldo;
                    conta.chequeEspecial -= conta.valorUsadoCheque;
                    conta.saldo = 0;
                    System.out.printf("Saque realizado, seu saldo atual é de %s R$ e seu cheque de: %s R$\n", conta.saldo, conta.chequeEspecial);
                    conta.taxa = conta.valorUsadoCheque * 0.20;
                    System.out.printf("Como foi utilizado cheque especial, o valor da taxa é de: %s R$\n", conta.taxa);
                    conta.chequeUtilizado = conta.valorUsadoCheque;

                }
            }else{
                System.out.println("Saldo insuficiente para completar o saque!");

            }
        }else{
            System.out.println("Saque realizado!");
            conta.saldo -= conta.saque;

        }
    }

//opção 5
    public static void pagarBoleto(ContaBanco conta, Scanner scanner) {
            System.out.println("Qual o valor de seu boleto?");
            conta.valorBoleto = scanner.nextDouble();
            if (conta.valorBoleto <= 0) {
                do {
                    System.out.println("Por favor, insira um valor válido.");
                    conta.valorBoleto = scanner.nextDouble();
                } while (conta.valorBoleto <= 0);
            }
            conta.saldoFinal = conta.saldo - conta.valorBoleto;
            //verificar se precisa de cheque especial
            if (conta.saldoFinal < 0) {
                System.out.println("Deseja pagar seu boleto juntamente com o cheque especial?");
                conta.optionBoleto = scanner.next();
                if (conta.optionBoleto.equalsIgnoreCase("Sim")) {
                    conta.chequeFinal = conta.chequeEspecial + conta.saldoFinal;
                    if (conta.chequeFinal < 0) {
                        System.out.println("Seu saldo + limite não atinge o valor do boleto.");

                    } else {
                        System.out.println("Boleto pago!");
                        conta.taxa = (conta.chequeEspecial - conta.chequeFinal) * 0.20;
                        conta.chequeUtilizado = (conta.chequeEspecial - conta.chequeFinal);
                        conta.chequeEspecial = conta.chequeFinal;
                        conta.saldo = conta.saldoFinal;
                        System.out.printf("Por usar seu cheque especial, em seu próximo depósito, você pagará %s R$ de taxa.\n",conta.taxa);

                    }
                } else {
                    System.out.println("Infelizmente o pagamento não pode ser feito, seu saldo + limite não atinge o valor do boleto.");

                }

            } else {
                System.out.println("Boleto pago!");
                conta.saldo = conta.saldoFinal;

            }
        }

//opção 6
    public static void verUsoCheque(ContaBanco conta) {
        System.out.printf("Seu valor último valor utilizado do cheque especial foi de: %s R$\n",conta.chequeUtilizado);
        System.out.printf("A taxa a ser paga pelo valor utilizado será de: %s R$\n", conta.taxa);
    }

    }

