import util.Imagem;
import util.Moforlogia;
import util.Segmentacao;
import util.Dithering;

public class Main {
    static String IMAGEM_LENNA = "img/lenna.png";
    static String IMAGEM_OLHO = "img/olho.png";
    static String IMAGEM_MASSA = "img/massa.jpg";
    static String IMAGEM_TOMOGRAFIA = "img/tomografia.gif";

    public static void main(String args[]) {
        // testeMoforlogia();
        // testeDithering();
        testeSegmentacao();
    }

    private static void testeMoforlogia() {
        Imagem img = new Imagem(Main.IMAGEM_LENNA);
        img.mostrar("Imagem Original");
        Moforlogia mb = new Moforlogia();
        int [][]ee = {{255, 255, 255},{255, 255, 255},{255, 255, 255}};
        mb.erosao(img, ee).mostrar("Erosão");
        mb.dilatacao(img, ee).mostrar("Dilatação");
        mb.abertura(img, ee).mostrar("Abertura");
        mb.fechamento(img, ee).mostrar("Fechamento");
        mb.gradiente(img, ee).mostrar("Gradiente");
        mb.smoothing(img, ee).mostrar("Smoothing");
    }

    private static void testeDithering() {
        Imagem img = new Imagem(Main.IMAGEM_LENNA);
        img.mostrar("Imagem Original");
        Dithering d = new Dithering();
        int[][] D2 = {{0, 2},{3, 1}};
        int[][] D3 = {{6, 8, 4},{1, 0, 3},{5, 2, 7}};
        int[][] D4 = {{0, 8, 2, 10},{12, 4, 14, 6},{3, 11, 1, 9},{15, 7, 13, 5}};
        d.aperiodico(img).mostrar("Aperiodica");
        d.periodicoDisperso(img, D2).mostrar("Periodico Disperso - D2");
        // d.periodicoDisperso(img, D3).mostrar("Periodico Disperso - D3");
        // d.periodicoDisperso(img, D4).mostrar("Periodico Disperso - D4");
        d.periodicoAglomerado(img, D2).mostrar("Periodico Aglomerado - D2");
        // d.periodicoAglomerado(img, D3).mostrar("Periodico Aglomerado - D3");
        // d.periodicoAglomerado(img, D4).mostrar("Periodico Aglomerado - D4");
    }

    private static void testeSegmentacao() {
        Imagem img1 = new Imagem(Main.IMAGEM_MASSA);
        Imagem img2 = new Imagem(Main.IMAGEM_OLHO);
        Imagem img3 = new Imagem(Main.IMAGEM_TOMOGRAFIA);
        img1.mostrar("Imagem Original");
        img2.mostrar("Imagem Original");
        img3.mostrar("Imagem Original");

        Segmentacao s = new Segmentacao();
        s.crescimentoRegioes(img1).mostrar("Imagem Segmentada");
        s.crescimentoRegioes(img2).mostrar("Imagem Segmentada");
        s.crescimentoRegioes(img3).mostrar("Imagem Segmentada");
    }
}