import java.util.Scanner;

public class Menu {

    static boolean perguntarMenu() {
    String option;
    Scanner scanner = new Scanner(System.in);

        //voltar ou sair menu
        do {
            System.out.println("Deseja voltar ao menu?");
            option = scanner.next();
            if (option.equalsIgnoreCase("sim")) {
                return true;
            } else if (option.equalsIgnoreCase("não")) {
                System.out.println("OK, saindo!");
                return false;
            }else{
                System.out.println("Por favor, digite um valor válido, SIM ou NÃO!");
            }
        }while (!option.equalsIgnoreCase("sim") && !option.equalsIgnoreCase("não"));
        return false;
    }
}

