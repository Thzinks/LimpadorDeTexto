
import java.io.File;
import java.util.Arrays;

public class RenomeadorDeArquivos {      
    public static void main(String[] args) {
        String CaminhoDaPasta = "C:/Users/tksth/Downloads/pasta_teste";

        File Pasta = new File (CaminhoDaPasta);
        
        if (Pasta.exists() && Pasta.isDirectory()) {
            File[] arquivos = Pasta.listFiles();

            if (arquivos != null) {

                Arrays.sort(arquivos);
                int contador = 1;

                for (File arquivo : arquivos) {
                    String nomeAtual = arquivo.getName();

                    if (!nomeAtual.matches("^\\d{3}_.*")){
                        String novoNome = String.format("Imagem_%03d_", contador) + nomeAtual;
                        File novoArquivo = new File(Pasta, novoNome);

                    if (arquivo.renameTo(novoArquivo)){
                        System.out.println("Renomeado: " + arquivo.getName() + " -> " + novoNome);
                    } else {
                        System.out.println("falha ao renomear: " + arquivo.getName());
                    }
                    contador++;
                    } else {
                        System.out.println("Arquivo já renomeado: " + nomeAtual);
                    } 
                }
            } else {
                System.out.println("A pasta está vazia ou não pode ser lida.");
            }
        } else {
            System.out.println("O caminho especificado não é uma pasta válida.");
        }
    }
}