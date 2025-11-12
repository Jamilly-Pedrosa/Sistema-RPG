package strategy;

import entidades.PersonagemAbstrato;

public class AtaqueMagico implements AtaqueStrategy{
	// O ataque mágico depende do ataque base do personagem 
	@Override
	public void atacar(PersonagemAbstrato atacante, PersonagemAbstrato alvo) {
		int dano = (int) (atacante.getAtaque() * 1.5) - (alvo.getDefesa() / 3); //add getDefesa
		if (dano < 0) dano = 0;
		
		alvo.setVida(alvo.getVida() - dano); // A vida do alvo recebe o dano
		
		System.out.println("✨ " + atacante.getNome() + " realizou um feitiço contra "
				+ alvo.getNome() + " causando " + dano + " de dano mágico!");
		System.out.println("❤️ Vida restante de " + alvo.getNome() + ": " + alvo.getVida());
		
	}

}
