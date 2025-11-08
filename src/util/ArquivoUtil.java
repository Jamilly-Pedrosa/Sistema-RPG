package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.PersonagemAbstrato;
import factory.PersonagemFactory;

public class ArquivoUtil {
	
	private static final String CAMINHO = "personagens.txt";
	
	public static void salvarPersonagem(PersonagemAbstrato p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO, true))) {
            bw.write(p.getNome() + ";" + p.getClasse());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar personagem!");
        }
    }
	
	/*public static void salvarPersonagem(String dados) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO, true))) {
			bw.write(dados);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("✗ Erro ao salvar personagem: " + e.getMessage());
        }
	}*/
	
	/*public static List<String> carregarPersonagens() {
        List<String> personagens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                personagens.add(linha);
            }
        } catch (IOException e) {
            System.out.println("✗ Nenhum personagem encontrado ainda.");
        }
        return personagens;
    }*/
	
	// Retorna todos os personagens salvos como lista
	public static List<PersonagemAbstrato> carregarPersonagens() {
        List<PersonagemAbstrato> personagens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    String nome = dados[0];
                    String classe = dados[1];
                    PersonagemAbstrato p = PersonagemFactory.criarPersonagem(classe, nome);
                    if (p != null) {
                        personagens.add(p);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Nenhum personagem encontrado.");
        }
        
        return personagens;     
	}
	
	public static void listarPersonagens() {
		List<PersonagemAbstrato> personagens = carregarPersonagens();
		if (personagens.isEmpty()) {
			System.out.println("⚠️ Nenhum personagem salvo.");
		} else {
			for (int i = 0; i < personagens.size(); i++) {
				PersonagemAbstrato p = personagens.get(i);
	            System.out.println((i + 1) + " - " + p.getNome() + " (" + p.getClasse() + ")");
	        }
	    }
	}
}
