package decorator;

import entidades.PersonagemAbstrato;

public abstract class PocaoDecorator extends PersonagemDecorator{

	public PocaoDecorator(PersonagemAbstrato personagem) {
		super(personagem);
	}
	
	@Override
	public String getNome() {
		return personagemBase.getNome();
	}

}
