public class Casillas {
        private char valor;
        private String color;

    public Casillas() {
        this.valor = ' ';
        this.color = "gris";
       // this.color = "#888888";
    }
    
    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
