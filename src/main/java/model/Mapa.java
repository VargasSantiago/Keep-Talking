
package model;

public class Mapa {
    private int[][] puntos;
    private String img;

    public Mapa(int x1, int y1, int x2, int y2, String img) {
        puntos = new int[2][2];
        puntos[0][0] = x1;
        puntos[0][1] = y1;
        puntos[1][0] = x2;
        puntos[1][1] = y2;
        this.img = img;
    }

    public String getImg() {
        return img;
    }
    
    

    public boolean contienePuntos(int x1, int y1, int x2, int y2) {
        return (puntos[0][0] == x1 && puntos[0][1] == y1 && puntos[1][0] == x2 && puntos[1][1] == y2) ||
                (puntos[0][0] == x2 && puntos[0][1] == y2 && puntos[1][0] == x1 && puntos[1][1] == y1);
    }
}
