void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);
    String option;


    //variaveis de valores
    ContaBanco conta = new ContaBanco();

    /*
    foi declarado na classe ContaBanco
    double limiteChequeEspecial = conta.limiteChequeEspecial;
    double chequeEspecial = conta.chequeEspecial;
    double valorBoleto = conta.valorBoleto;
*/
    double saldoFinal = 0;
    double taxa = 0;
    double chequeUtilizado = 0;

    System.out.println("Informe o valor inicial de depósito:");
    conta.saldo = scanner.nextDouble();
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
            //voltar ou sair menu
            Menu.perguntarMenu();
        }

//opção 4 do menu
        double saque = 0;
        if (initialOption == 4) {
            System.out.println("Quanto deseja sacar?");
            saque = scanner.nextDouble();
            if (saque > conta.saldo){
                System.out.println("Saldo insuficiente para completar o saque!");
                System.out.println("Deseja utilizar seu cheque especial?");
                option = scanner.next();
                    if (option.equalsIgnoreCase("Sim")){
                        if (saque > conta.saldo + conta.chequeEspecial){
                            System.out.println("Saldo + cheque especial insuficiente para completar o saque!");
                            Menu.perguntarMenu();
                        }else{
                            double valorUsadoCheque = saque - conta.saldo;
                            conta.chequeEspecial -= valorUsadoCheque;
                            conta.saldo = 0;
                            System.out.printf("Saque realizado, seu saldo atual é de %s R$ e seu cheque de: %s R$\n", conta.saldo, conta.chequeEspecial);
                            taxa = valorUsadoCheque * 0.20;
                            System.out.printf("Como foi utilizado cheque especial, o valor da taxa é de: %s R$\n", taxa);
                            chequeUtilizado = valorUsadoCheque;
                            Menu.perguntarMenu();
                        }
                    }else{
                        System.out.println("Saldo insuficiente para completar o saque!");
                        Menu.perguntarMenu();
                    }
            }else{
                System.out.println("Saque realizado!");
                conta.saldo -= saque;
                Menu.perguntarMenu();
            }
        }
//opção menu 5
        if (initialOption == 5) {
            System.out.println("Qual o valor de seu boleto?");
            conta.valorBoleto = scanner.nextDouble();
            if (conta.valorBoleto <= 0) {
                do {
                    System.out.println("Por favor, insira um valor válido.");
                    conta.valorBoleto = scanner.nextDouble();
                } while (conta.valorBoleto <= 0);
            }
            saldoFinal = conta.saldo - conta.valorBoleto;
            //verificar se precisa de cheque especial
            if (saldoFinal < 0) {
                System.out.println("Deseja pagar seu boleto juntamente com o cheque especial?");
                var optionBoleto = scanner.next();
                if (optionBoleto.equalsIgnoreCase("Sim")) {
                    double chequeFinal = conta.chequeEspecial + saldoFinal;
                    if (chequeFinal < 0) {
                        System.out.println("Seu saldo + limite não atinge o valor do boleto.");
                        Menu.perguntarMenu();
                        initialOption = 9;
                    } else {
                        System.out.println("Boleto pago!");
                        taxa = (conta.chequeEspecial - chequeFinal) * 0.20;
                        chequeUtilizado = (conta.chequeEspecial - chequeFinal);
                        conta.chequeEspecial = chequeFinal;
                        conta.saldo = saldoFinal;
                        System.out.printf("Por usar seu cheque especial, em seu próximo depósito, você pagará %s R$ de taxa.\n",taxa);
                        Menu.perguntarMenu();
                    }
                } else {
                    System.out.println("Infelizmente o pagamento não pode ser feito, seu saldo + limite não atinge o valor do boleto.");
                    Menu.perguntarMenu();
                }

            } else {
                System.out.println("Boleto pago!");
                conta.saldo = saldoFinal;
                Menu.perguntarMenu();
            }
        }

//opção menu 6
    if (initialOption == 6) {
        System.out.printf("Seu valor último valor utilizado do cheque especial foi de: %s R$\n",chequeUtilizado);
        System.out.printf("A taxa a ser paga pelo valor utilizado será de: %s R$\n", taxa);
        Menu.perguntarMenu();
    }

    } while (initialOption != 0);


}