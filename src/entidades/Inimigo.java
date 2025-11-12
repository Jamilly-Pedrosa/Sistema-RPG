package entidades;

public class Inimigo extends PersonagemAbstrato{

	public Inimigo(String nome, int vida, int ataque, int defesa) {
		super(nome, "Inimigo", vida, ataque, defesa);
	}
}
