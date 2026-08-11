import java.util.Scanner;

public class Menu {

    public static void clearRunConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    static public boolean perguntarMenu(Scanner scanner) {
    String option;

        //voltar ou sair menu
        while(true) {
            System.out.println("Deseja voltar ao menu?");
            option = scanner.next();
            if (option.equalsIgnoreCase("sim")) {
                clearRunConsole();
                return true;

            } else if (option.equalsIgnoreCase("não")) {
                clearRunConsole();
                return false;
            }else{
                System.out.println("Por favor, digite um valor válido, SIM ou NÃO!");
            }
        }
    }
}

