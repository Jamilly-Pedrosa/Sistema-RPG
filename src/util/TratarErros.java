package util;

import java.util.Scanner;

public class TratarErros {
	
	public static int LerOpcaoInteira(Scanner input, String mensagem) {
		int numero;
			
		while(true) {
			System.out.print(mensagem); // exibe a mensagem personalizada 
			String entrada = input.nextLine().trim(); // Lê a entrada como String e remove espaços em branco nas extremidades
				
			if (entrada.isEmpty()) {
				System.out.println("✗ Entrada vazia! Digite um número.");
				System.out.println("─────────────────────────────");
				continue; 
			}
				
			try {
				numero = Integer.parseInt(entrada); //Tenta converter a entrada em um número inteiro
				return numero;
			} catch (NumberFormatException e) { //Se o usuário digitou algo que não é um número
				System.out.println("✗ Entrada inválida! Digite um número inteiro.");
				System.out.println("─────────────────────────────");
			}
		}	
	}	
	
	public static String LerOpcaoString(Scanner input, String mensagem) {
		while(true) {
			System.out.print(mensagem); 
			String entrada = input.nextLine().trim();
			
			if (entrada.isEmpty()) {
				System.out.println("✗ Campo obrigatório! Por favor, digite algo.");
				System.out.println("─────────────────────────────");
				continue; 
			} else {
				return entrada;
			}
				
		}	
	}


}
