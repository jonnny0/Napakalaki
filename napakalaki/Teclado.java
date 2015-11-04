
package napakalaki;

import java.io.*;

public class Teclado {
    public String lee() {
        String linea="";

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        boolean error;

        do {
           error = false;
           try {
                linea = br.readLine();
           }
           catch (java.io.IOException ioex) {
                error = true;
           }
        }  while (error);

        return linea;
    }
}