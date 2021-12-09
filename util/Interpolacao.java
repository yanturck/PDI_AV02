package util;

// Interpolacao por vizinhos mais proximo

public class Interpolacao {
    public Imagem vizinhosProximos(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                }
            }
        }

        return new Imagem(matOut);
    }
}
