package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Instancia de um objeto string
		
		Jogo rpg = new Jogo();
		rpg.menuInicial(input);
		
		input.close(); // fecha o scanner no final da aplicação

	}

}
