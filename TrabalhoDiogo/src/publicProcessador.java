import java.io.PrintStream;
import java.util.Scanner;

public class publicProcessador {
    protected String nomeProcessador;
    protected String MarcaProcessador;
    protected String DescriçaoProcessador;
    protected String ModeloProcessador;
    protected String VelocidadeProcessador;
    Scanner in = new Scanner(System.in);
    PrintStream out = System.out;

    public void DadosProcessadores(Scanner in, PrintStream out) {

        System.out.println("Digite o nome do processador: ");
        nomeProcessador = in.nextLine();
        System.out.println("Digite a marca do processador: ");
        MarcaProcessador = in.nextLine();
        System.out.println("Digite a descrição do processador: ");
        DescriçaoProcessador = in.nextLine();
        System.out.println("Digite o modelo do Processador: ");
        ModeloProcessador = in.nextLine();
        System.out.println("Digite a Velocidade do processador: ");
        VelocidadeProcessador = in.nextLine();
    }

    public void cadastrarProcessador() {
        DadosProcessadores(in, out);
        // Cadastrar processador
    }

    public String getNome() {
        return nomeProcessador;
    }
    //Nome Processador

    public String getMarca() {
        return MarcaProcessador;
    }
    //MarcaProcessador

    public String getDescricao() {
        return DescriçaoProcessador;
    }
    //DescriçaoProcessador;

    public String getModelo() {
        return ModeloProcessador;
    }
    //ModeloProcessador;

    public String getVelocidade() {
        return VelocidadeProcessador;
    }
    //VelocidadeProcessador;

}
