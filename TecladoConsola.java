import java.util.Scanner;


public class TecladoConsola implements ITeclado {

    @Override
    public String getIntento() {
       Scanner in = new Scanner(System.in);
       System.out.print("Ingresa palabra: ");
       return in.nextLine();
    }
    
}