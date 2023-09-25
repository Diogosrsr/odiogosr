public class Computador extends TrabalhoProcessadores {
    private String tipo;

    public Computador(String nome, String descricao, String tipo) {
        super(nome, descricao, tipo, tipo, tipo);
        this.tipo = tipo;
    }

    // Getters e setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}