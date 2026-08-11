void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);

    //variaveis de valores
    ContaBanco conta = new ContaBanco();

    System.out.println("Informe o valor inicial de depósito:");
    conta.saldo = scanner.nextDouble();
    do {
        System.out.println("Informe um valor válido:");
        conta.saldo = scanner.nextDouble();
    }while(conta.saldo <= 0);

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
//opção 1 do menu
        if (initialOption == 1) {
        OperacoesBanco.consultarSaldo(conta.saldo, conta.limiteChequeEspecial);
        }

//opção 2 do menu
        if (initialOption == 2) {
        OperacoesBanco.consultarLimiteChequeEspecial(conta.chequeEspecial, conta.limiteChequeEspecial);
        }

//opção 3 do menu

        if (initialOption == 3) {
            OperacoesBanco.depositarDinheiro(conta, scanner);
        }

//opção 4 do menu
        //double saque = 0;
        if (initialOption == 4) {
            OperacoesBanco.sacarDinheiro(conta, scanner);
        }
//opção menu 5
        if (initialOption == 5) {
        OperacoesBanco.pagarBoleto(conta, scanner);
        }

//opção menu 6
    if (initialOption == 6) {
        OperacoesBanco.verUsoCheque(conta, scanner);
    }

    } while (initialOption != 0);

    System.out.print("OK! SAINDO...");

}
