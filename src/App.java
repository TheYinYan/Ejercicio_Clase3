public class App {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) throws Exception {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        int max = 0;
        int med = 0;
        int min = 0;
        boolean correcto = false;
        do {
            try {
                System.out.printf("%n");
                num1 = Integer.parseInt(System.console().readLine("Introduzca num 1 entero: "));
                System.out.printf("%n");
                num2 = Integer.parseInt(System.console().readLine("Introduzca num 2 entero: "));
                System.out.printf("%n");
                num3 = Integer.parseInt(System.console().readLine("Introduzca num 3 entero: "));
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero entero");
                correcto = false;
            } catch (Exception e) {
                System.out.println("Se a prodicido un Error Inesperado, Intentelo de nuevo");
                correcto = false;
            }
        } while (!correcto);

        max = Math.max(Math.max(num1, num2), Math.max(num2, num3));
        min = Math.min(Math.min(num1, num2), Math.min(num2, num3));

        if (num1 != max && num1 != min)
            med = num1;
        else if (num2 != max && num2 != min)
            med = num2;
        else if (num3 != max && num3 != min)
            med = num3;

        System.out.println("""

                1. Horizontal

                2. Vertical

                3. Horizontal y Vertical

                """);
        int opcion = Integer.parseInt(System.console().readLine("Introduzca la opción: "));

        if (opcion == 1 || opcion == 3) {
            System.out.println();
            System.out.println("Versión Horizontal");
            System.out.println();
            
            for (int i = 1; i <= 3; i++) {
                System.out.printf("num %s ", i);
                for (int j = 0; j < ((i == 1) ? num1 : (i == 2) ? num2 : num3); j++) {

                    if (max == ((i == 1) ? num1 : (i == 2) ? num2 : num3)) {
                        System.out.print(GREEN + "█" + RESET);
                    }
                    if (med == ((i == 1) ? num1 : (i == 2) ? num2 : num3)) {
                        System.out.print(YELLOW + "█" + RESET);
                    }
                    if (min == ((i == 1) ? num1 : (i == 2) ? num2 : num3)) {
                        System.out.print(RED + "█" + RESET);
                    }
                }
                System.out.printf("%n%n");
            }
        }
        // System.out.println("""
        // 1 2 3
        // ####
        // #### ####
        // #### #### ####
        // num1 num2 num3
        // """);

        if (opcion == 2 || opcion == 3) {
            System.out.println();
            System.out.println("Versión Vertical");
            System.out.println();

            System.out.printf("%7d%7d%7d%n", num1, num2, num3);
            for (int i = max; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) {
                    int valor = (j == 1) ? num1 : (j == 2) ? num2 : num3;

                    if (i <= valor) {
                        if (valor == max)
                            System.out.printf(GREEN + "%7s" + RESET, "████");
                        else if (valor == med)
                            System.out.printf(YELLOW + "%7s" + RESET, "████");
                        else
                            System.out.printf(RED + "%7s" + RESET, "████");
                    } else {
                        System.out.printf("%7s", "");
                    }
                }
                System.out.println();
            }
            System.out.printf("%7s%7s%7s%n", "num1", "num2", "num3");
            System.out.println();

        }

        System.out.printf("%s %d %s %d %s %d%s", GREEN + "Maximo", max, YELLOW + "Medio", med, RED + "Bajo", min,
                " " + RESET);

    }

}
