package factory;

import entidades.Guerreiro;
import entidades.Mago;
import entidades.PersonagemAbstrato;

public class PersonagemFactory {
	
	public static PersonagemAbstrato criarPersonagem(String classe, String nome) {
		
		if (classe == null) {
            System.out.println("❌ Classe inválida!");
            return null;
        }

        classe = classe.trim().toLowerCase(); // padroniza o texto

        switch (classe) {
            case "guerreiro":
                return new Guerreiro(nome);
            case "mago":
                return new Mago(nome);
            default:
                System.out.println("❌ Classe inválida!");
                return null;
        }
		
	}

}
