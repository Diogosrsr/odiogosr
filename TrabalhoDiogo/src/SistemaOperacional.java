public class SistemaOperacional extends TrabalhoProcessadores {
    private String versao;

    public SistemaOperacional(String nome, String descricao, String Marca, String Modelo, String Velocidade) {
        super(nome, descricao, Velocidade, Velocidade, Velocidade);
        this.versao = versao;
    }

    // Getters e setters
    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}


