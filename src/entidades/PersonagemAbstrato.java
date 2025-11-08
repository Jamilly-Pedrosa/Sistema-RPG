package entidades;

public abstract class PersonagemAbstrato {
	protected String nome;
	protected String classe;
	protected int vida;
	protected int ataque;
	
	public PersonagemAbstrato(String nome, String classe, int vida, int ataque) {
		this.nome = nome;
		this.classe = classe;
		this.vida = vida;
		this.ataque = ataque;
	}

    public String getNome() {
        return nome;
    }
    
    public String getClasse() {
        return classe;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
    
    public void exibirStatus() {
        System.out.println("\n「 ✦ Status do Personagem ✦ 」");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("•┈๑⋅⋯⋅⋯⋅⋯⋅⋯⋅⋅⋯⋅⋯⋯⋅⋯⋅⋯⋅⋯⋯⋅๑┈•");
    }

}
