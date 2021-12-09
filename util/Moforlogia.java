package util;

// erosão
// dilatação
// abertura
// fechameto
// gradiente
// smoothing

public class Moforlogia {
    public Imagem erosao(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int r = (ee.length-1)/2;
        int min;

        for (int c = 0; c < nCanais; c++) {
            for (int y = r; y < alt-r; y++) {
                for (int x = r; x < larg-r; x++) {
                    min = 255;
                    for (int dy = -r; dy <= r; dy++) {
                        for (int dx = -r; dx <= r; dx++) {
                            min = Math.min(min, (matIn[c][y+dy][x+dx]-ee[dy+1][dx+1]));
                        }
                    }
                    matOut[c][y][x] = min;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem dilatacao(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int r = (ee.length-1)/2;
        int max;

        for (int c = 0; c < nCanais; c++) {
            for (int y = r; y < alt-r; y++) {
                for (int x = r; x < larg-r; x++) {
                    max = 0;
                    for (int dy = -r; dy <= r; dy++) {
                        for (int dx = -r; dx <= r; dx++) {
                            max = Math.max(max, (matIn[c][y+dy][x+dx]+ee[dy+1][dx+1]));
                        }
                    }
                    matOut[c][y][x] = max;
                }
            }
        }
        return new Imagem(matOut);
    }

    public Imagem abertura(Imagem in, int ee[][]) {
        Imagem imgErodida = erosao(in, ee);
        int matOut[][][] = dilatacao(imgErodida, ee).getMatriz();

        return new Imagem(matOut);
    }

    public Imagem fechamento(Imagem in, int ee[][]) {
        Imagem imgDilatada = dilatacao(in, ee);
        int matOut[][][] = erosao(imgDilatada, ee).getMatriz();

        return new Imagem(matOut);
    }

    public Imagem gradiente(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matOut[][][] = new int[nCanais][alt][larg];

        int[][][] imgDilatada = dilatacao(in, ee).getMatriz();
        int[][][] imgErodida = erosao(in, ee).getMatriz();

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = imgDilatada[c][y][x] - imgErodida[c][y][x];
                }
            }
        }
        return new Imagem(matOut);
    }

    public Imagem smoothing(Imagem in, int ee[][]) {
        Imagem imgAberta = abertura(in, ee);
        int matOut[][][] = fechamento(imgAberta, ee).getMatriz();

        return new Imagem(matOut);
    }
}
