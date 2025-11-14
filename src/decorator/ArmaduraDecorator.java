package decorator;

import entidades.PersonagemAbstrato;

public class ArmaduraDecorator extends PersonagemDecorator {

	public ArmaduraDecorator(PersonagemAbstrato personagem) {
		super(personagem);
	}
	
	@Override
	public int getDefesa() {
		return personagemBase.getDefesa() + 10; //bônus da armadura
	}
	
	@Override
	public String getNome() {
		return personagemBase.getNome() + " 🛡️"; //Um charme para mostrar que o persona está com mais defesa
	}

}