import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("****************************************************");
            System.out.println("Bienvenidos al CONVERSOR DE MONEDAS BY Alberto Alum");
            System.out.println("*****************************************************");

            String opciones = """
                             1) Dólar =>> Peso argentino
                             2) Peso argentino =>> Dólar
                             3) Euro =>> Peso argentino
                             4) Peso argentino =>> Euro
                             5) Dólar =>> Real brasileño
                             6) Real brasileño =>> Dólar
                             7) Dólar =>> Boliviano
                             8) Boliviano =>> Dólar
                             9) Dólar =>> Peso colombiano
                             10) Peso colombiano =>> Dólar
                             11) Dólar =>> Euro
                             12) Euro =>> Dólar
                             13) Salir
                    """;

            System.out.println(opciones);

            try {
                System.out.println("Seleccione una opcion válida: ");
                opcion= Integer.parseInt(lectura.nextLine());

                if (opcion < 1 || opcion > 13) {
                    throw new InputMismatchException();
                }

                if(opcion == 13){
                    break;
                }

                double valor;

                while (true) {
                    System.out.println("Ingrese el valor que desea convertir: ");
                    try {
                        valor = Double.parseDouble(lectura.nextLine());

                        if (valor < 0) {
                            throw new NumberFormatException();
                        }

                        Codigo from, to;
                        switch (opcion) {
                            case 1:
                                from = Codigo.USD;
                                to = Codigo.ARS;
                                break;
                            case 2:
                                from = Codigo.ARS;
                                to = Codigo.USD;
                                break;
                            case 3:
                                from = Codigo.EUR;
                                to = Codigo.ARS;
                                break;
                            case 4:
                                from = Codigo.ARS;
                                to = Codigo.EUR;
                                break;
                            case 5:
                                from = Codigo.USD;
                                to = Codigo.BRL;
                                break;
                            case 6:
                                from = Codigo.BRL;
                                to = Codigo.USD;
                                break;
                            case 7:
                                from = Codigo.USD;
                                to = Codigo.BOB;
                                break;
                            case 8:
                                from = Codigo.BOB;
                                to = Codigo.USD;
                                break;
                            case 9:
                                from = Codigo.USD;
                                to = Codigo.COP;
                                break;
                            case 10:
                                from = Codigo.COP;
                                to = Codigo.USD;
                                break;
                            case 11:
                                from = Codigo.USD;
                                to = Codigo.EUR;
                                break;
                            case 12:
                                from = Codigo.EUR;
                                to = Codigo.USD;
                                break;
                            default:

                                return;

                        }
                        ConversorMoneda conversor = new ConversorMoneda();
                        double valorCovertido = conversor.convertir(from, to, valor);

                        if(valorCovertido != -1) {
                            System.out.println("\nEl valor de " + valor + " [" + from + "] corresponde al valor de " + valorCovertido + " [" + to + "]`\n");
                        }else{
                            opcion=13;
                        }

                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("\nError, valor no válido.\n");
                    }
                }


            } catch (NumberFormatException e) {
                System.out.println("\nError, ingrese una opcion válida. - \n");
                opcion=-1;
            }

        } while (opcion != 13);

        System.out.println("\n ********** Gracias por utilizar el conversor de monedas. ¡Hasta luego! *********");
    }

}
