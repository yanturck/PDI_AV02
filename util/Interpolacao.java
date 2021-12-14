package util;

// Interpolacao por vizinhos mais proximo

public class Interpolacao {
    public static Imagem vizinhosProximos(Imagem in, int ampl) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt*ampl][larg*ampl];
        int Ymin, Xmin;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt*ampl; y++) {
                for (int x = 0; x < larg*ampl; x++) {
                    Ymin = (int)((((alt-1)*y)/((alt*ampl)-1)));
                    Xmin = (int)((((larg-1)*x)/((larg*ampl)-1)));
                    matOut[c][y][x] = matIn[c][Ymin][Xmin];
                }
            }
        }

        return new Imagem(matOut);
    }
}
