package util;

// erosão
// dilatação
// abertura
// fechamento
// borda interna
// borda externa
// preenchimento de regiões

public class MoforlogiaBin {
    public Imagem erosao(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[1][alt][larg];
        int r = (ee.length-1)/2;
        boolean iguais;

        for (int y = r; y < alt-r; y++) {
            for (int x = r; x < larg-r; x++) {
                iguais = true;
                for (int dy = -r; dy <= r && iguais; dy++) {
                    for (int dx = -r; dx <= r && iguais; dx++) {
                        if (matIn[0][y+dy][x+dx] != ee[r+dy][r+dx]) iguais = false;
                    }
                }
                matOut[0][y][x]=iguais?255:0;
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem dilatacao(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[1][alt][larg];
        int r = (ee.length-1)/2;
        boolean iguais;
        
        for (int y = r; y < alt-r; y++) {
            for (int x = r; x < larg-r; x++) {
                iguais = true;
                for (int dy = -r; dy <= r && iguais; dy++) {
                    for (int dx = -r; dx <= r && iguais; dx++) {
                        if (matIn[0][y+dy][x+dx] == ee[r+dy][r+dx]) iguais = false;
                    }
                }
                matOut[0][y][x]=!iguais?255:0;
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

    public Imagem bordaInterna(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int imgErodida [][][] = erosao(in, ee).getMatriz();
        int matOut[][][] = new int[1][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = matIn[0][y][x] - imgErodida[0][y][x];
            }
        }
        return new Imagem(matOut);
    }

    public Imagem bordaExterna(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int imgDilatada [][][] = dilatacao(in, ee).getMatriz();
        int matOut[][][] = new int[1][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = imgDilatada[0][y][x] - matIn[0][y][x];
            }
        }
        return new Imagem(matOut);
    }

    public Imagem preenchimentoRegioes(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem complementoIn = complemento(in);
        int matOut[][][] = new int[1][alt][larg];
        int matX[][][] = new int[1][alt][larg];

        for (int x = 0; x < larg; x++) {
            matX = interseccao(dilatacao(new Imagem(matX), ee), complementoIn) ;
        }
        
        matOut = uniao(new Imagem(matX), in);

        return new Imagem(matOut);
    }
// ============ FUNCOES PARA PREENCHIMENTO ===================================================================
    static Imagem complemento (Imagem imgA) {
        int matA[][][] = imgA.getMatriz();
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor;
        int matOut[][][] = new int[1][alt][larg];

            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = matA[0][y][x];
                    cor=cor==0?255:0;
                    matOut[0][y][x] = cor;
                }
            }
        return new Imagem(matOut);
    }
    static int[][][] interseccao (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];

                    if (corA == 255 && corB == 255) cor = 255;
                    else cor = 0;
                    
                    matOut[c][y][x] = cor;
                }
            }
        }
        return matOut;
    }
    static int[][][] uniao (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];

                    if (corA == 0 && corB == 0) cor = 0;
                    else cor = 255;
                    
                    matOut[c][y][x] = cor;
                }
            }
        }
        return matOut;
    }
}
