package util;

// periódico disperso
// periódico aglomerado
// aperiódico

public class Dithering {
    private static int BLACK = 0;
    private static int WHITE = 255;

    public int[][][] quantizar(Imagem in, int L, int C) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int faixa = (L*C)-1;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = (int)((matIn[c][y][x]*faixa)/255);
                }
            }
        }
        return matOut;
    }

    public Imagem periodicoDisperso(Imagem in, int D[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int N = D.length;
        int matIn[][][] = quantizar(in, N, N);
        int i, j;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    i = x % N;
                    j = y % N;
                    if (matIn[c][y][x] > D[j][i]) {
                        matIn[c][y][x] = WHITE;
                    } else {
                        matIn[c][y][x] = BLACK;
                    }
                }
            }
        }

        return new Imagem(matIn);
    }

    public Imagem periodicoAglomerado(Imagem in, int[][] D) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int N = D.length;
        int matIn[][][] = quantizar(in, N, N+1);
        int matOut[][][] = new int[nCanais][alt*N][larg*N];
        int yOut, xOut;

        for (int c = 0; c < nCanais; c++) {
            yOut = 0;
            for (int y = 0; y < alt; y++) {
                xOut = 0;
                for (int x = 0; x < larg; x++) {
                    for (int j = 0; j < N; j++) {
                        for (int i = 0; i < N; i++) {
                            if (matIn[c][y][x] < D[j][i]) matOut[c][yOut+j][xOut+i] = WHITE;
                            else matOut[c][yOut+j][xOut+i] = BLACK;
                        }
                    }
                    xOut += N;
                }
                yOut += N;
            }
        }
        return new Imagem(matOut);
    }

    public Imagem aperiodico(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int error, threshold;
        int count = 0;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt-1; y++) {
                for (int x = 0; x < larg-1; x++) {
                    count += matIn[c][y][x];
                }
            }
        }

        threshold = count/(nCanais*alt*larg);

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt-1; y += 2) {
                for (int x = 0; x < larg-1; x += 2) {
                    if (matIn[c][x][y] < threshold) {
                        error = matIn[c][x][y] - BLACK;
                        matIn[c][x][y] = BLACK;
                    } else {
                        error = matIn[c][x][y] - WHITE;
                        matIn[c][x][y] = WHITE;
                    }
                    matIn[c][x+1][y] += (3/8)*error;
                    matIn[c][x][y+1] += (3/8)*error;
                    matIn[c][x+1][y+1] += (2/8)*error;
                }
            }
        }
        return new Imagem(matIn);
    }
}
