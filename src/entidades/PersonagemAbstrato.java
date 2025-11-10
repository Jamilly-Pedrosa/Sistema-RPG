package entidades;

import strategy.AtaqueStrategy;

public abstract class PersonagemAbstrato {
	protected String nome;
	protected String classe;
	protected int vida;
	protected int ataque;
	protected int defesa;
	protected AtaqueStrategy estrategiaAtaque; //Atributo para armazenar a estrátegia atual 
	
	public PersonagemAbstrato(String nome, String classe, int vida, int ataque, int defesa) {
		this.nome = nome;
		this.classe = classe;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
	}
	
	// Métodos para definir e usar a estratégia
	public void setEstrategiaAtaque(AtaqueStrategy estrategiaAtaque) {
		this.estrategiaAtaque = estrategiaAtaque;
	}
	
	public void atacar(PersonagemAbstrato alvo) {
		if (estrategiaAtaque == null) {
			System.out.println("❌ Nenhuma estrátegia de ataque definida!");
		} else {
			estrategiaAtaque.atacar(this, alvo);
		}
	}
	
	public void exibirStatus() {
        System.out.println("\n「 ✦ Status do Personagem ✦ 」");
        System.out.println("🧾 " + nome + " (" + classe + ")");
        System.out.println("❤️ Vida: " + vida);
        System.out.println("🗡️ Ataque: " + ataque);
        System.out.println("🛡️ Defesa: " + defesa);
        /*System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);*/
        System.out.println("•┈๑⋅⋯⋅⋯⋅⋯⋅⋯⋅⋅⋯⋅⋯⋯⋅⋯⋅⋯⋅⋯⋯⋅๑┈•");
    }
	
	// Getters e setters
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
    
    public int getDefesa() {
    	return defesa;
    }
    
    public void setVida(int vida) {
    	this.vida = vida;
    }
}
