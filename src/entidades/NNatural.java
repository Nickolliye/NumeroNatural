/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author dobne
 */

/**
 * representar um numero natural
 */

public class NNatural {

	/**
	 * persiste um numero natural
	 */
	private long numero = 0;

	/**
	 * Construtor de cópia - parametro objeto da classe
	 */
	public NNatural(NNatural objeto) {
            this.numero = objeto.numero;
	}
	/**
	 * Construtor - parametro numero inteiro
	 */
	public NNatural(long numero) throws Exception{
            if(numero < 0) throw new Exception("Número não pode ser < 0");
            this.numero = numero;
	}
	/**
	 * Construtor padrão
	 */
	public NNatural() {

	}
	public void set(long numero) throws Exception{
            if(numero < 0) throw new Exception("Número não pode ser < 0");
            this.numero = numero;
	}

	/**
	 * Copiar um objeto NNatural em outro
	 */
	public void set(NNatural objeto) {
            this.numero = objeto.numero;
	}

	/**
	 * obter o valor do atributo
	 */
	public long get() {
		return numero;
	}
	public NNatural eFatorial() {
            long fatorial = 1;
            for(long auxiliar = numero; auxiliar >= 1; auxiliar--) fatorial *= auxiliar;
            NNatural resposta = new NNatural();
            resposta.numero = fatorial;
            return resposta;
	}
	public boolean eNumeroPerfeito() {
            int auxiliar = 0;
            for (int i = 1; i < numero; i++) {
                if (numero % i == 0) auxiliar += i;
            }
            return numero == auxiliar;
	}
	public boolean eCapicua() {
            long invertido = 0;
            long auxiliar = numero;
            
            while(auxiliar > 0){
                invertido = invertido * 10 + auxiliar % 10;
                auxiliar = auxiliar / 10;
            }
            return numero == invertido;
	}
	public boolean eQuadradoPerfeito() {
            int i = 1;
            while(i*i <= numero){
                if(i*i == numero) return true;
                i++;
            }
            return false;
	}
	public boolean eNumeroPrimo() {
            for(int j = 2; j < numero; j++){
                if(numero % j == 0) return false;
            }
            return true;
	}
	public String mudarBase(int base) {
            String convertido = "";
            String resto = "0123456789ABCDEF";
            long copiaNumero = numero;
            while(copiaNumero > 0){
                convertido = resto.charAt((int)copiaNumero % base) + convertido;
                copiaNumero /= base;
            }
            return convertido;
        }
	public NNatural calcularMdc(NNatural objeto) {
            long numero1 = numero;
            long numero2 = objeto.get();
            long resto = 1;
            
            while(resto != 0){
                resto = numero2 % numero1;
                numero1 = numero2;
                numero2 = resto;
            } 
            NNatural resposta = new NNatural();
            resposta.numero = numero1;
            return resposta;
        }
	public NNatural calcularMmc(NNatural objeto) {
            long numero1 = numero;
            long numero2 = objeto.get();
            NNatural resposta = new NNatural();
            long mmc = numero1 * numero2 / calcularMdc(objeto).get();
            resposta.numero = mmc;
            return resposta;
        }
	public boolean primosEntreSi(NNatural objeto) {
            return calcularMdc(objeto).get() == 1;
        } 
}

