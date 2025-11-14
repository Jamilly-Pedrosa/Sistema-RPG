package decorator;

import entidades.PersonagemAbstrato;

public class PocaoVida extends PocaoDecorator{

	public PocaoVida(PersonagemAbstrato personagem) {
		super(personagem);
		curar();
	}
	
	private void curar() {
		int novaVida = personagemBase.getVida() + 10;
		personagemBase.setVida(novaVida);
	}
	
	@Override 
	public String getNome() {
		return personagemBase.getNome() + " ✨";
	}

}
