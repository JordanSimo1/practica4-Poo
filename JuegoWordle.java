import java.util.ArrayList;


public class JuegoWordle {
    private ITablero tablero;
    private ITeclado teclado;
    private ArrayList<Casillas> casillas;
    private ArrayList<String> palabras;
    private int intentos =0, maximoIntento =5;
    private String palabra;
    private String intento ;
    public JuegoWordle(ITablero tablero, ITeclado teclado) {
        this.tablero = tablero;
        this.teclado = teclado;
        casillas = new ArrayList<Casillas>();
        for (int i = 0; i <5; i++) {
            casillas.add(new Casillas());
        }
        palabras = new ArrayList<>();
        palabras.add("zorro");
        palabras.add("limón");
        palabras.add("delta");
        palabras.add("nubes");
        palabras.add("barco");
        palabras.add("técnico");
        palabras.add("drama");
        palabras.add("plaza");
        palabras.add("rápido");

        intento=" ";
    }


    
    public void jugar() {
        
        palabra = getPalabra();
        
        do {
            verificarPalabra();
            intentos += 1;
            System.out.println("Intentos:"+ intentos);
            //if(intento.equals(palabra)) break;
            if(algortimo()) break;
        }while(!(intentos>= maximoIntento));    // POR SI LOS 5 INTENTOS ACABARON
    }
    
    public String getPalabra(){      
       int indice =(int) Math.floor(Math.random() * palabras.size());
       return palabras.get(indice);
    }
    
    public boolean algortimo(){ 
        for (int i = 0; i < intento.length(); i++) {      //intentos
            for (int j = 0; j < palabra.length(); j++) {  //palabra a descubrir
                if (intento.charAt(i) == palabra.charAt(j)){
                    if (i == j) {
                       casillas.get(i).setColor("verde");                         
                       //celda.get(i).setColor("#80A867"); 
                    }else{
                       casillas.get(i).setColor("amarillo");                         
                       //celda.get(i).setColor("#FDEC6F"); 
                    }
                    break;
                }    
            }
            casillas.get(i).setValor(intento.charAt(i));
        }
            mostrarColores();
            mostrarLetra();
        return intento.equals(palabra);
    }

    public void verificarPalabra(){
            do {
                intento =this.teclado.getIntento();
                 
                if(intento.length()!=5) System.out.println("ingrese una palabra de 5 letras");    
            } while (intento.length()!=5);  //HACE QUE DE AFUERZA SE TEMGA QUE INGRESAR UNA PALABRA DE 5 LETRAS    
    }
    
    public void mostrarLetra(){
        for (int i = 0; i < casillas.size(); i++) {
            System.out.print(casillas.get(i).getValor());
            System.out.print(",");
            
        }
        System.out.println("");
    }
    
        public void mostrarColores(){
        for (int i = 0; i < casillas.size(); i++) {
            System.out.print(casillas.get(i).getColor());
            System.out.print(",");  
            casillas.get(i).setColor("gris");
        }
            System.out.println("");
    }
}
