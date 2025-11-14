package main;

import java.util.List;
import java.util.Scanner;

import decorator.ArmaduraDecorator;
import decorator.PocaoVida;
import entidades.PersonagemAbstrato;
import factory.PersonagemFactory;
import strategy.AtaqueFisico;
import strategy.AtaqueMagico;
import util.ArquivoUtil;
import util.TratarErros;

public class Jogo {
	
	private PersonagemAbstrato personagemSelecionado; //guarda o personagem atual
	
	public void menuInicial(Scanner input) {
		int opcao;
		do{
			System.out.println("\n====== 「 ⚔️ MENU RPG ⚔️ 」 ======");
			System.out.println(".✦ [1] Menu Personagens ");
			System.out.println(".✦ [2] Menu Ataques ");
			System.out.println(".✦ [3] Menu Melhorias ");
			System.out.println(".✦ [4] Iniciar Combate ");
			System.out.println(".✦ [0] Sair ");
			
			// Usa a função da classe TratarErros para ler a opção do usuário com segurança
			opcao = TratarErros.LerOpcaoInteira(input, "🎲 Sua opção: ");
			
			switch (opcao) {
			case 1:
				menuPersonagem(input); //factory
                break;
            case 2:
            	if (personagemSelecionado == null) {
            		System.out.println("❌ Selecione um personagem (Menu Personagem) antes de escolher um ataque!");
            	} else {
            		menuAtaque(input); //Strategy
            	}
                break;
            case 3:
            	if (personagemSelecionado == null) {
            		System.out.println("❌ Selecione um personagem (Menu Personagem) antes de escolher um ataque!");
            	} else {
            		menuDecorator(input); //Decorator
            	}
                break;
            case 4:
                if (personagemSelecionado == null) {
                	System.out.println("❌ Selecione um personagem (Menu Personagem) antes de iniciar um combate!");
                } else {
                	Combate.iniciar(personagemSelecionado);
                }
                break;
            case 0:
                System.out.println("Saindo do jogo...");
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
		
		} while (opcao != 0);
	}
	
	//menu personagem
	private void menuPersonagem(Scanner input) {
		int opcao;
		do {
			System.out.println("\n====== 「 👤 MENU PERSONAGEM  」 ======");
			System.out.println(".✦ [1] Criar Personagem ");
			System.out.println(".✦ [2] Selecionar Personagem ");
			System.out.println(".✦ [3] Listar Personagens ");
			System.out.println(".✦ [0] Voltar ");
			
			opcao = TratarErros.LerOpcaoInteira(input, "🎲 Sua opção: ");
			
			switch (opcao) {
				case 1:
					criarPersonagem(input);
					break;
                
				case 2:
					selecionarPersonagem(input);
					break;
				
				case 3:
					System.out.println("\n•┈๑⋅⋯ 📜 Lista de personagens: ⋯⋅๑┈•");
                    ArquivoUtil.listarPersonagens();
                    break;
                
				case 0:
					System.out.println("↩ Voltando ao menu principal...");
					break;
					
				default:
					System.out.println("❌ Opção inválida!");
			}
			
		} while(opcao != 0);
	}
	
	private void criarPersonagem(Scanner input) {
		String nome = TratarErros.LerOpcaoString(input, "\n•┈๑⋅⋯Nome do personagem: ");
		String classe = TratarErros.LerOpcaoString(input, "•┈๑⋅⋯ Classes Disponiveís ⋯⋅๑┈•"
				+ "\n🧙🏻‍♂ Mago"
				+ "\n⚔️ Guerreiro"
				+ "\n•┈๑⋅⋯Nome da classe: ");
		
		PersonagemAbstrato novo = PersonagemFactory.criarPersonagem(classe, nome);

        if (novo != null) {
        	ArquivoUtil.salvarPersonagem(novo);
            System.out.println("\n✔ Personagem criado com sucesso!");
            novo.exibirStatus();
        }
		
	}
	
	private void selecionarPersonagem(Scanner input) {
		List<PersonagemAbstrato> personagens = ArquivoUtil.carregarPersonagens();
		if (personagens.isEmpty()) {
	    	System.out.println("❌ Nenhum personagem disponível para seleção.");
	    	return;
	    }

	    System.out.println("\n•┈๑⋅⋯ 📜 Personagens disponíveis: ⋯⋅๑┈•");
	    for (int i = 0; i < personagens.size(); i++) {
	    	System.out.println((i + 1) + " - " + personagens.get(i).getNome() + " (" + personagens.get(i).getClasse() + ")");
	    }
	        
	    // Escolher o personagem pelo índice da lista
	    int escolha = TratarErros.LerOpcaoInteira(input, "Escolha o número do personagem: ") - 1;

	    if (escolha >= 0 && escolha < personagens.size()) {
	    	personagemSelecionado = personagens.get(escolha);
	        System.out.println("✔ " + personagemSelecionado.getNome() + " selecionado com sucesso!");
	        personagemSelecionado.exibirStatus(); //exibe o statutus "automatico"
	    } else {
	    	System.out.println("❌ Escolha inválida.");
	    }
	}

	//menu ataque
	private void menuAtaque(Scanner input) {
		int opcao;
		do {
			System.out.println("\n====== 「 💥 MENU ATAQUE  」 ======");
			System.out.println(".✦ [1] Ataque Físico ");
			System.out.println(".✦ [2] Ataque Mágico ");
			System.out.println(".✦ [0] Voltar ");
			
			opcao = TratarErros.LerOpcaoInteira(input, "🎲 Sua opção: ");
			
			switch (opcao) {
				case 1:
					personagemSelecionado.setEstrategiaAtaque(new AtaqueFisico());
					System.out.println("💪 Ataque físico selecionado!");
					break;
					
				case 2:
					personagemSelecionado.setEstrategiaAtaque(new AtaqueMagico());
					System.out.println("🔮 Ataque mágico selecionado!");
					break;
					
				case 0:
					System.out.println("↩ Voltando ao menu principal...");
					break;
					
				default:
					System.out.println("❌ Tipo de ataque inválido!");
			}
		} while (opcao != 0);
	}
	
	//menu decorator
	private void menuDecorator(Scanner input) {
		int opcao;
		do {
			System.out.println("\n====== 「 ☘︎ MENU MELHORIAS  」 ======");
			System.out.println(".✦ [1] Equipar Armadura (+ 10 🛡️)");
			System.out.println(".✦ [2] Poção de Vida (+ 10 ❤️)");
			System.out.println(".✦ [0] Voltar ");
			
			opcao = TratarErros.LerOpcaoInteira(input, "🎲 Sua opção: ");
			
			switch (opcao) {
			case 1:
				personagemSelecionado = new ArmaduraDecorator(personagemSelecionado);
				System.out.println("🛡️ Armadura equipada! Defesa atual: " + personagemSelecionado.getDefesa());
				break;
				
			case 2:
				personagemSelecionado = new PocaoVida(personagemSelecionado);
				System.out.println("❤️ Poção de vida usada! Vida atual: " + personagemSelecionado.getVida());		
				break;
				
			case 0:
				System.out.println("↩ Voltando ao menu principal...");
				break;
				
			default:
				System.out.println("❌ Opção inválida!");
			
			}
			
		} while (opcao != 0);
	}

}
