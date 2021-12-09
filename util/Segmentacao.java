package util;

import java.sql.Blob;

// crescimento de regiões

public class Segmentacao {
    private static int BLACK = 0;
    private static int WHITE = 255;

    public Imagem crescimentoRegioes(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();

        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        int hist[][] = new int[256][nCanais]; // Histograma
        int histPico = 0; // Pico do Histograma
        int valuePico = 0; // Valor do Pico do Histograma

        int [][]ee = {{255, 255, 255},{255, 255, 255},{255, 255, 255}}; // 8-conectadas

        // Calculando o Histograma
        for (int coutC = 0; coutC < nCanais; coutC++) {
            for (int coutY = 0; coutY < alt; coutY++) {
                for (int coutX = 0; coutX < larg; coutX++) {
                    hist[matIn[coutC][coutY][coutX]][coutC]++;
                }
            }
        }

        // Pico do Histograma
        for (int coutC = 0; coutC < nCanais; coutC++) {
            for (int i = 0; i < hist.length; i++) {
                if (valuePico < hist[i][coutC]) {
                    histPico = i;
                    valuePico = hist[i][coutC];
                }
            }
        }

        System.out.println(histPico);

        // Limiar
        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    if(matIn[c][y][x] < histPico) matOut[c][y][x] = BLACK;
                    else matOut[c][y][x] = WHITE;
                }
            }
        }
        // return new Imagem(matOut);
        return MoforlogiaBin.dilatacao(new Imagem(matOut), ee);
    }
}
