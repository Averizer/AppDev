package source;

public class GraficaSeno {

    public static int[] pixeles;
    Double angRad;
    Double yt;
    public int y[];

    public GraficaSeno() {
        pixeles = null;
        angRad = null;
        yt = null;
        y = null;
    }

    public void grafica() {
        for (int i = 0; i <= 360; i++) { // para llenar los pixeles en un arreglo

            pixeles[i] = (120 * i) / 360; // sacar los pixeles 
            angRad = Math.toRadians(i); // convertir a radianes los 360 grados
            yt = 70 * Math.sin(angRad);   // guarda en un arreglo los radianes
            y[i] = (int) Math.abs(yt - 70);
        }

        for (int i = 0; i <= 359; i++) {
           // g.drawLine(pixeles[i], y[i], pixeles[i + 1], y[i + 1]);
        }
    }

}
