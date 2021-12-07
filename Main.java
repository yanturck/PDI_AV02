import util.Imagem;
import util.Moforlogia;

public class Main {
    static String IMAGEM_LENNA = "img/lenna.png";

    public static void main(String args[]) {
        testeMoforlogia();
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
}