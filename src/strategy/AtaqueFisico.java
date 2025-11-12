package strategy;

import entidades.PersonagemAbstrato;

public class AtaqueFisico implements AtaqueStrategy{
	// O ataque físico causa dano baseado no ataque do personagem e na defesa do inimigo
	@Override
	public void atacar(PersonagemAbstrato atacante, PersonagemAbstrato alvo) {
		int dano = atacante.getAtaque() - (alvo.getDefesa() / 2); //add getDefesa
		if (dano < 0) dano = 0;
		
		alvo.setVida(alvo.getVida() - dano); //add getVida
		
		System.out.println("💥 " + atacante.getNome() + " realizou um ataque físico em "
				+ alvo.getNome() + " causando " + dano + " de dano!");
		System.out.println("❤️ Vida restante de " + alvo.getNome() + ": " + alvo.getVida());
		
	}
}