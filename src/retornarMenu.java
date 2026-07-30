import java.util.Scanner;

public class retornarMenu {

    static retornarMenu retornarMenu() {
    String option;
    int initialOption = 0;
    Scanner scanner = new Scanner(System.in);

        //voltar ou sair menu
        System.out.println("Deseja voltar ao menu?");
        option = scanner.next();
        if (option.equalsIgnoreCase("sim")) {
            initialOption = 9;
        } else if (option.equalsIgnoreCase("não")) {
            System.out.println("OK, saindo!");
            initialOption = 0;
        }else{
            System.out.println("Por favor, digite um valor válido, SIM ou NÃO!");
        }
        return null;
    }



    }

