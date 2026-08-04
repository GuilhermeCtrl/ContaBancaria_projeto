void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);
    String option;


    //variaveis de valores
    double saldo = contaBanco.saldo;
    double limiteChequeEspecial = contaBanco.limiteChequeEspecial;
    double chequeEspecial = contaBanco.chequeEspecial;
    double valorBoleto = contaBanco.valorBoleto;

    System.out.println("Informe o valor inicial de depósito:");
    saldo = scanner.nextDouble();
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

                System.out.printf("Seu limite de cheque especial é de: %s\n", limiteChequeEspecial);

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

            //voltar ou sair menu
            if (Menu.perguntarMenu()) {
                initialOption = 9;
            }else{
                initialOption = 0;
            }
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
            System.out.println("Deseja pagar seu boleto juntamente com o cheque especial?");
            var optionBoleto =  scanner.next();

            if (optionBoleto.equals("Sim")) {}
            

        }

    }while (initialOption != 0) ;


}