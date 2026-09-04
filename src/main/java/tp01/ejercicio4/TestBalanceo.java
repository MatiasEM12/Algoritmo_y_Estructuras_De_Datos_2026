package tp01.ejercicio4;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio3.PilaGenerica;

public class TestBalanceo {

    public static void main() {

        String test1 = "{()[()]}"; //balanceado
        String test2 = "([)]"; //no balanceado


        System.out.println("Test 1: " + test1);
        esBalanceado(test1);
        System.out.println("Test 2: " + test2);
        esBalanceado(test2);

    }

    private static void esBalanceado(String test) {

        if(test.isEmpty()) {
            System.out.println("balanceado");
            return;
        }
        PilaGenerica<Character> pila = new PilaGenerica<>();
        for (char c : test.toCharArray()){

            if (validoApertura(c)) {
                pila.apilar(c);
            } else if (validoCierre(c)) {

               Character apertura = pila.desapilar();
                if(apertura == null || !corresponde(apertura, c)){
                    System.out.println("No balanceado");
                    return;
                }

            } else  {
                System.out.println("No balanceado");
                return;
            }
        }

        System.out.println("balanceado");

    }

    private static   boolean validoCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean validoApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean corresponde(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }
}
