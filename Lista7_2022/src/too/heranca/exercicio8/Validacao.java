package too.heranca.exercicio8;

import java.util.Arrays;

public class Validacao {

	public static boolean validarCPF(String cpf) {
		int[] cpfInteiro; 
		int digito1, digito2;
		
		if(!cpf.matches("\\d{11}"))
			return false;
		
		cpfInteiro = converterEmInteiro(cpf);
		
		if(!verificarNumerosIguais(cpfInteiro))
			return false;

		digito1 = calcularDigito(cpfInteiro, 9, 10);
		digito2 = calcularDigito(cpfInteiro, 10, 11);
		
		return digito1 == cpfInteiro[9] && digito2 == cpfInteiro[10];
	}

	private static int calcularDigito(int[] cpfInteiro, int tamanhoVetorVerificado, int multiplicador) {
		int soma = 0;
		int digito;
		
		for(int indice = 0; indice < tamanhoVetorVerificado; indice++) {
			soma += cpfInteiro[indice] * multiplicador;
			multiplicador--;
		}
		digito = 11 - (soma % 11);
		
		return digito <= 9 ? digito : 0;
	}

	private static int[] converterEmInteiro(String cpf) {
		int[] cpfInteiro = new int[11];
		
		for(int indice = 0; indice < cpf.length(); indice++)
			cpfInteiro[indice] = Character.getNumericValue(cpf.charAt(indice));
		
		return cpfInteiro;
	}

	private static boolean verificarNumerosIguais(int[] cpf) {
		int[] cpfOrganizado = Arrays.copyOf(cpf, 11);
		
		Arrays.sort(cpfOrganizado);
		
		if(cpfOrganizado[0] == cpfOrganizado[10])
			return false;
		
		return true;
	}
}
