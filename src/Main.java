void main() {

    boolean continuar = true;
    int initialOption;
    var scanner = new Scanner(System.in);

    //variaveis de valores
    ContaBanco conta = new ContaBanco();

    System.out.println("Informe o valor inicial de depósito:");
    conta.saldo = scanner.nextDouble();
    while (conta.saldo <= 0){
        System.out.println("Informe um valor válido:");
        conta.saldo = scanner.nextDouble();
    }

    //double saldoInicial = saldo;
    if (conta.saldo <= 500) {
        conta.limiteChequeEspecial = 50;
        conta.chequeEspecial = 50;
    } else {
        conta.limiteChequeEspecial = conta.saldo / 2;
        conta.chequeEspecial = conta.saldo / 2;
    }

    do {
        System.out.println("======== BANCO ========");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Consultar cheque especial");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Pagar boleto");
        System.out.println("6 - Verificar uso do cheque especial");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        initialOption = scanner.nextInt();

//opções do menu
        switch(initialOption) {
            case 1:
                OperacoesBanco.consultarSaldo(conta.saldo, conta.limiteChequeEspecial);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 2:
                OperacoesBanco.consultarLimiteChequeEspecial(conta.saldo, conta.limiteChequeEspecial);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 3:
                OperacoesBanco.depositarDinheiro(conta, scanner);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 4:
                OperacoesBanco.sacarDinheiro(conta, scanner);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 5:
                OperacoesBanco.pagarBoleto(conta, scanner);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 6:
                OperacoesBanco.verUsoCheque(conta);
                continuar = Menu.perguntarMenu(scanner);
                break;

            case 0:
                System.out.println("OK, SAINDO...");
                break;

            default:
                System.out.println("ERRO, INVALIDO, INSIRA UM VALOR VÁLIDO!");
        }

    } while (continuar);
        System.out.println("OK, SAINDO...");

}
