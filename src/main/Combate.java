package main;

import java.util.Random;

import entidades.Inimigo;
import entidades.PersonagemAbstrato;
import strategy.AtaqueFisico;

public class Combate {
	
	public static void iniciar(PersonagemAbstrato jogador) {
		if (jogador.getEstrategiaAtaque() == null) {
            System.out.println("❌ Escolha um tipo de ataque antes de iniciar o combate!");
            return;
        }
		
		System.out.println("\n⚔️ Iniciando combate...");
		
		//Gera inimigo aleatório
		Inimigo inimigo = gerarInimigo();
		inimigo.setEstrategiaAtaque(new AtaqueFisico()); // inimigo sempre ataca fisicamente
		System.out.println("👹 Um " + inimigo.getNome() + " apareceu!");
		inimigo.exibirStatus();
		
		//Loop de batalha
		while (jogador.getVida() > 0 && inimigo.getVida() > 0) {
			System.out.println("\n🎯 Seu turno!");
			jogador.atacar(inimigo);
			
			if (inimigo.getVida() <= 0) {
				System.out.println("\n🏆 " + jogador.getNome() + " venceu a batalha!");
				break;
			}
			
			System.out.println("\n💢 Turno do inimigo!");
			inimigo.atacar(jogador);
			
			if (jogador.getVida() <= 0) {
				System.out.println("\n💀 Você foi derrotado pelo " + inimigo.getNome() + "...");
				break;
			}
		}
		
		System.out.println("\n⚔️ Fim do combate.");
	}

	private static Inimigo gerarInimigo() {
		Random random = new Random();
		int tipo = random.nextInt(3);
		
		switch (tipo) {
			case 0:
				return new Inimigo("Goblin", 50, 10, 5); //Nome, vida, ataque, defesa
			case 1:
				return new Inimigo("Esqueleto", 40, 12, 6);
			default:
				return new Inimigo("Orc", 80, 14, 8);
		}
	}

}
