void main() {

    int initialOption = 0;
    var scanner = new Scanner(System.in);
    String option;

    //variaveis de valores
    int saldo = 0;
    int chequeEspecial = 0;

    System.out.println("Informe o valor inicial de depósito:");
    saldo = scanner.nextInt();

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

                System.out.printf("Seu saldo atual é: %s\n", saldo);
                if (saldo < 500) {
                    chequeEspecial = 50;
                } else {
                    chequeEspecial = saldo / 2;
                }

                System.out.println("Deseja voltar ao menu?");
                option = scanner.next();
                if (option.equalsIgnoreCase("sim")) {
                    initialOption = 9;
                } else {
                    System.out.println("OK, saindo!");
                    initialOption = 0;

                }
            }

//opção 2 do menu
            if (initialOption == 2) {

                System.out.printf("Seu cheque especial é de: %s\n", chequeEspecial);
                //voltar ou sair menu
                System.out.println("Deseja voltar ao menu?");
                option = scanner.next();
                if (option.equalsIgnoreCase("sim")) {
                    initialOption = 9;
                } else {
                    System.out.println("OK, saindo!");
                    initialOption = 0;

                }
        }
//opção 3 do menu
        if (initialOption == 3) {
            System.out.println("Quanto deseja depositar?");
            saldo += scanner.nextInt();
            //voltar ou sair menu
            System.out.println("Deseja voltar ao menu?");
            option = scanner.next();
            if (option.equalsIgnoreCase("sim")) {
                initialOption = 9;
            } else {
                System.out.println("OK, saindo!");
                initialOption = 0;
            }

        }
//opção 4 do menu
        if (initialOption == 4) {
            System.out.println("Quanto deseja sacar?");
            saldo -= scanner.nextInt();
            System.out.println("OK!");

            //voltar ou sair menu
            System.out.println("Deseja voltar ao menu?");
            option = scanner.next();
            if (option.equalsIgnoreCase("sim")) {
                initialOption = 9;
            } else {
                System.out.println("OK, saindo!");
                initialOption = 0;
            }

        }
//opção menu 5
        if (initialOption == 5) {
            System.out.println("Qual o valor de seu boleto?");
        }

    }while (initialOption != 0) ;


}