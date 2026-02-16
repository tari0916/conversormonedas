import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        List<Conversion> conversiones = new ArrayList<>();
        ConsultaApi consulta = new ConsultaApi();
        int opcion = 0;
        double monto;
        String monedaBase = "";
        String monedaDestino = "";
        String menu = """
                **********************************************
                Sea bienvenido/a al Conversor de Moneda (o.o)
                (1) Dólar --> Peso argentino
                (2) Peso argentino --> Dólar
                (3) Dólar --> Real brasileño
                (4) Real brasileño --> Dólar
                (5) Dólar --> Won surcoreano
                (6) Won surcoreano --> Dólar
                (7) Salir
                **********************************************
                Elija una opción válida
                """;

        Scanner teclado = new Scanner(System.in);
        while (opcion != 7){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    monedaBase = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaBase = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaDestino = "KRW";
                    break;
                case 6:
                    monedaBase = "KRW";
                    monedaDestino = "USD";
                    break;
                case 7:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            if(opcion==7){
                break;
            } else if (opcion>0 & opcion<7) {
                System.out.println("Ingresa el monto que deseas convertir:");
                monto = teclado.nextDouble();
                while(monto <= 0){
                    System.out.println("Ingresa un monto válido: ");
                    monto = teclado.nextDouble();
                }
                ConversionApi miConversion = consulta.convierteMoneda(monedaBase, monedaDestino, monto);
                System.out.println("El valor de " + monto + " [" + monedaBase + "] es " + miConversion.conversion_result() + " [" + monedaDestino + "]");
                Conversion conversion = new Conversion(miConversion, monto);
                conversiones.add(conversion);
            }
        }
        System.out.println("***********************");
        System.out.println("CONVERSIONES REALIZADAS:\n");
        for(Conversion conversionListada: conversiones){
            System.out.println(conversionListada);
        }
        System.out.println("***********************");
    }
}