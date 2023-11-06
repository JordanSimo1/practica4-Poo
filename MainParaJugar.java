public class MainParaJugar {
    static public void main(String[] args) {
        ITablero tablero = new TableroHolografico();
        ITeclado teclado = new TecladoConsola();
        JuegoWordle juego = new JuegoWordle(tablero, teclado);
        
        juego.jugar();
    } 
}
