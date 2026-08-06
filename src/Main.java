void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);
    String option;


    //variaveis de valores
    ContaBanco conta1 = new ContaBanco();
    double limiteChequeEspecial = contaBanco.limiteChequeEspecial;
    double chequeEspecial = contaBanco.chequeEspecial;
    double valorBoleto = contaBanco.valorBoleto;
    double saldoFinal = 0;
    double taxa = 0;
    double chequeUtilizado = 0;

    System.out.println("Informe o valor inicial de depósito:");
    saldo = scanner.nextDouble();
    double saldoInicial = saldo;
    if (saldo <= 500) {
        limiteChequeEspecial = 50;
        chequeEspecial = 50;
    } else {
        limiteChequeEspecial = saldo / 2;
        chequeEspecial = saldo / 2;
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
        operacoesBanco.consultarSaldo(saldo, limiteChequeEspecial);
        }

//opção 2 do menu
        if (initialOption == 2) {
        operacoesBanco.consultarLimiteChequeEspecial(chequeEspecial, limiteChequeEspecial);
        }

//opção 3 do menu
        if (initialOption == 3) {
            operacoesBanco.depositarDinheiro(saldo, taxa, chequeEspecial, limiteChequeEspecial);
        }

//opção 4 do menu
        double saque = 0;
        if (initialOption == 4) {
            System.out.println("Quanto deseja sacar?");
            saque = scanner.nextDouble();
            if (saque > saldo){
                System.out.println("Saldo insuficiente para completar o saque!");
                System.out.println("Deseja utilizar seu cheque especial?");
                option = scanner.next();
                    if (option.equalsIgnoreCase("Sim")){
                        if (saque > saldo + chequeEspecial){
                            System.out.println("Saldo + cheque especial insuficiente para completar o saque!");
                            Menu.perguntarMenu();
                        }else{
                            double valorUsadoCheque = saque - saldo;
                            chequeEspecial -= valorUsadoCheque;
                            saldo = 0;
                            System.out.printf("Saque realizado, seu saldo atual é de %s R$ e seu cheque de: %s R$\n", saldo, chequeEspecial);
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
                saldo -= saque;
                Menu.perguntarMenu();
            }
        }
//opção menu 5
        if (initialOption == 5) {
            System.out.println("Qual o valor de seu boleto?");
            valorBoleto = scanner.nextDouble();
            if (valorBoleto <= 0) {
                do {
                    System.out.println("Por favor, insira um valor válido.");
                    valorBoleto = scanner.nextDouble();
                } while (valorBoleto <= 0);
            }
            saldoFinal = saldo - valorBoleto;
            //verificar se precisa de cheque especial
            if (saldoFinal < 0) {
                System.out.println("Deseja pagar seu boleto juntamente com o cheque especial?");
                var optionBoleto = scanner.next();
                if (optionBoleto.equalsIgnoreCase("Sim")) {
                    double chequeFinal = chequeEspecial + saldoFinal;
                    if (chequeFinal < 0) {
                        System.out.println("Seu saldo + limite não atinge o valor do boleto.");
                        Menu.perguntarMenu();
                        initialOption = 9;
                    } else {
                        System.out.println("Boleto pago!");
                        taxa = (chequeEspecial - chequeFinal) * 0.20;
                        chequeUtilizado = (chequeEspecial - chequeFinal);
                        chequeEspecial = chequeFinal;
                        saldo = saldoFinal;
                        System.out.printf("Por usar seu cheque especial, em seu próximo depósito, você pagará %s R$ de taxa.\n",taxa);
                        Menu.perguntarMenu();
                    }
                } else {
                    System.out.println("Infelizmente o pagamento não pode ser feito, seu saldo + limite não atinge o valor do boleto.");
                    Menu.perguntarMenu();
                }

            } else {
                System.out.println("Boleto pago!");
                saldo = saldoFinal;
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