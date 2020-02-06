package paq1;

public class FPMP {

    int numero;
    int contador;
    int y;
    int num1;
    int num2;
    int copia;
    public String operacion1, operacion2, operacion3;
    String cadena1;
    String cadena3;
    public static String cadena2;
    int k;
    int contador2;

    public FPMP() {
        contador2 = 0;
        contador = 0;
        cadena1 = "";
        cadena2 = "";
        cadena3="";
        k=0;
        
    }

    public String NumeroF(int z) {
        try {
            for (int i = 1; i <= z; i++) {
                if (z % i == 0) {
                    contador++;

                }
            }
            if (contador <= 2) {
                //System.out.println("El numero es Primo");
                operacion1 = "Primo, "; // constante de clase

            } else {
                //System.out.println("El numero no es primo");
                operacion1 = "No Primo, ";

            }
        } catch (Exception e) {

        }

        y = z;
        //for (int i = 0; i < 1000; i++) {
        do {

            //System.out.println(y);
            if (y % 2 == 0) {
                y = y / 2;
               //cadena1 = String.valueOf(y);
                //cadena2 = cadena2 + cadena1;

            } else if (y % 2 != 0) {
                y = (3 * y) + 1;
                //cadena3 = String.valueOf(y);
                //cadena2 = cadena2 + cadena3;
            }
            cadena3 = String.valueOf(y);
            cadena2 = cadena2 + " " +cadena3;
            System.out.println(k +"-"+ y);
            k++;
            if (y == 1) {
                // System.out.println(y + " Es un numero maravilloso");   
                operacion2 = "Maravilloso, ";
               

                break;
            } else {
                operacion2 = "No Maravilloso, ";
                Math.abs(z);

            }
//contador2 ++ ;
        } while (y != 1);

        for (num1 = 1, copia = 0, num2 = 1; z >= num2;) {
            copia = num2;
            num2 = num1 + num2;
            num1 = copia;
            if (z == num2) {
                // System.out.println("Es un numero de la serie de Fibonacci");
                operacion3 = "Fibonacci";
                contador = 0;
                break;
            }
        }
        if (contador != 0) {
            //System.out.println("No es un numero de la serie de fibonacci");
            operacion3 = "No Fibonacci";
        }

        return operacion1 + operacion2 + operacion3;
    }

    public String palindromo(String s) {
        String p = "";

        String aux;
        aux = "";
        // quitar espacios

        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) != ' ') {
                aux += s.charAt(x);
            }
        }

        int fin = aux.length() - 1;
        int ini = 0;
        boolean espalin = true;

        while (ini < fin) {
            if (aux.charAt(ini) != aux.charAt(fin)) {
                espalin = false;
            }
            ini++;
            fin--;
        }
        if (espalin) {
            //System.out.print("\nEs palindromo.");

            p = "Es Palindromo";
        } else {
            //System.out.print("\nNo es palindromo.");

            p = "No es Palindromo";
        }

        return p;
    }

}
