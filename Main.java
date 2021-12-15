import util.Imagem;
import util.Interpolacao;
import util.Moforlogia;
import util.MoforlogiaBin;
import util.Segmentacao;
import util.Dithering;

public class Main {
    static String IMAGEM_B = "img/b.png";
    public static String IMAGEM_LENNA = "img/lenna.png";
    static String IMAGEM_OLHO = "img/olho.png";
    static String IMAGEM_MASSA = "img/massa.jpg";
    static String IMAGEM_TOMOGRAFIA = "img/tomografia.gif";

    public static void main(String args[]) {
        // menuSegmentacao();
        new Menu();
    }

    public static void menuMorfologia(int opc) {
        Imagem img = new Imagem(Main.IMAGEM_LENNA);
        img.mostrar("Imagem Original");
        Moforlogia mb = new Moforlogia();
        int [][]ee = {{255, 255, 255},{255, 255, 255},{255, 255, 255}};

        switch(opc) {
            case 1: mb.erosao(img, ee).mostrar("Erosão");
            break;
            case 2: mb.dilatacao(img, ee).mostrar("Dilatação");
            break;
            case 3: mb.abertura(img, ee).mostrar("Abertura");
            break;
            case 4: mb.fechamento(img, ee).mostrar("Fechamento");
            break;
            case 5: mb.gradiente(img, ee).mostrar("Gradiente");
            break;
            case 6: mb.smoothing(img, ee).mostrar("Smoothing");
            break;
        }
    }

    public static void menuInterpolação() {
        Imagem img = new Imagem(Main.IMAGEM_LENNA);
        img.mostrar("Imagem Original");
        Interpolacao.vizinhosProximos(img, 2).mostrar("Imagem Ampliada - 2x");
    }

    public static void menuMorfologiaBin(int opc) {
        Imagem img = new Imagem(Main.IMAGEM_B);
        img.mostrar("Imagem Original");
        MoforlogiaBin mb = new MoforlogiaBin();
        int [][]ee = {{255, 255, 255},{255, 255, 255},{255, 255, 255}};

        switch(opc) {
            case 1: mb.erosao(img, ee).mostrar("Erosão");
            break;
            case 2: mb.dilatacao(img, ee).mostrar("Dilatação");
            break;
            case 3: mb.abertura(img, ee).mostrar("Abertura");
            break;
            case 4: mb.fechamento(img, ee).mostrar("Fechamento");
            break;
            case 5: mb.bordaInterna(img, ee).mostrar("Borda Interna");
            break;
            case 6: mb.bordaExterna(img, ee).mostrar("Borda Externa");
            break;
            case 7: mb.preenchimentoRegioes(img, ee).mostrar("Preenchimento de Regiões");
            break;
        }
    }

    public static void menuDithering(int opc) {
        Imagem img = new Imagem(Main.IMAGEM_LENNA);
        img.mostrar("Imagem Original");
        Dithering d = new Dithering();
        int[][] D2 = {{0, 2},{3, 1}};
        int[][] D3 = {{6, 8, 4},{1, 0, 3},{5, 2, 7}};
        int[][] D4 = {{0, 8, 2, 10},{12, 4, 14, 6},{3, 11, 1, 9},{15, 7, 13, 5}};

        switch(opc) {
            case 1: d.periodicoDisperso(img, D2).mostrar("Periodico Disperso - D2");
            break;
            case 2: d.periodicoDisperso(img, D3).mostrar("Periodico Disperso - D3");
            break;
            case 3: d.periodicoDisperso(img, D4).mostrar("Periodico Disperso - D4");
            break;
            case 4: d.periodicoAglomerado(img, D2).mostrar("Periodico Aglomerado - D2");
            break;
            case 5: d.periodicoAglomerado(img, D3).mostrar("Periodico Aglomerado - D3");
            break;
            case 6: d.periodicoAglomerado(img, D4).mostrar("Periodico Aglomerado - D4");
            break;
            case 7: d.aperiodico(img).mostrar("Aperiodica");
            break;
        }
    }

    public static void menuSegmentacao() {
        Imagem img1 = new Imagem(Main.IMAGEM_MASSA);
        img1.mostrar("Imagem Original");

        Segmentacao s = new Segmentacao();
        s.crescimentoRegioes(img1).mostrar("Imagem Segmentada");
    }
}