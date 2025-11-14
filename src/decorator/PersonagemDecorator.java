package decorator;

import entidades.PersonagemAbstrato;

public abstract class PersonagemDecorator extends PersonagemAbstrato{
	protected PersonagemAbstrato personagemBase;
	
	public PersonagemDecorator(PersonagemAbstrato personagem) {
		super(personagem.getNome(), personagem.getClasse(), personagem.getVida(), personagem.getAtaque(), personagem.getDefesa());
		this.personagemBase = personagem;
	} 
	
	@Override
	public String getNome() {
        return personagemBase.getNome();
    }
	
	@Override
	public String getClasse() {
        return personagemBase.getClasse();
    }
	
	@Override
	public int getVida() {
        return personagemBase.getVida();
    }
	
	@Override
    public void setVida(int vida) { //Aumenta a vida do personagem
        personagemBase.setVida(vida);
    }
	
	@Override
	   public int getAtaque() {
	       return personagemBase.getAtaque();
	 }
	
	@Override
    public int getDefesa() {
        return personagemBase.getDefesa();
    }

}
