void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);
    String option;


    //variaveis de valores
    double saldo = contaBanco.saldo;
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

                System.out.printf("Seu saldo atual é: %s + %s de cheque especial\n", saldo, chequeEspecial);

                //voltar ou sair menu
                if (Menu.perguntarMenu()) {
                    initialOption = 9;
                }else{
                    initialOption = 0;
                }

            }

//opção 2 do menu
            if (initialOption == 2) {

                System.out.printf("Seu limite de cheque especial é de: %s e o valor atual é: %s\n", limiteChequeEspecial, chequeEspecial);

                //voltar ou sair menu
                if (Menu.perguntarMenu()) {
                    initialOption = 9;
                }else{
                    initialOption = 0;
                }
        }
//opção 3 do menu
        if (initialOption == 3) {
            System.out.println("Quanto deseja depositar?");
            saldo += scanner.nextDouble();
            saldo -= taxa;
            taxa = 0;
            //voltar ou sair menu
            Menu.perguntarMenu();
        }
//opção 4 do menu
        if (initialOption == 4) {
            System.out.println("Quanto deseja sacar?");
            saldo -= scanner.nextDouble();
            System.out.println("OK!");

            //voltar ou sair menu
            if (Menu.perguntarMenu()) {
                initialOption = 9;
            }else{
                initialOption = 0;
            }
        }
//opção menu 5
        if (initialOption == 5) {
            System.out.println("Qual o valor de seu boleto?");
            valorBoleto = scanner.nextDouble();
            if (valorBoleto <= 0){
                do {
                System.out.println("Por favor, insira um valor válido.");
                valorBoleto = scanner.nextDouble();
                }while (valorBoleto <= 0);
            }
                saldoFinal = saldo - valorBoleto;
                //verificar se precisa de cheque especial
                if (saldoFinal < 0){
                    System.out.println("Deseja pagar seu boleto juntamente com o cheque especial?");
                    var optionBoleto =  scanner.next();
                    if (optionBoleto.equalsIgnoreCase("Sim")){
                        double chequeFinal = chequeEspecial + saldoFinal;
                        if (chequeFinal < 0){
                            System.out.println("Seu saldo + limite não atinge o valor do boleto.");
                            Menu.perguntarMenu();
                            initialOption = 9;
                        }else{
                        System.out.println("Boleto pago!");
                        taxa = (chequeEspecial - chequeFinal) * 0.20;
                        chequeUtilizado = (chequeEspecial - chequeFinal);
                        chequeEspecial = chequeFinal;
                        Menu.perguntarMenu();
                        }
                    }else{
                        System.out.println("Infelizmente o pagamento não pode ser feito, seu saldo + limite não atinge o valor do boleto.");
                        System.out.println("Voltando ao menu.");
                    }

                }else{
                    System.out.println("Boleto pago!");
                    saldo = saldoFinal;
                    Menu.perguntarMenu();
                }
        }

    }while (initialOption != 0) ;


}