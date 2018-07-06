package com.br.mindwestbank.Data;

import java.util.Hashtable;

import com.br.mindwestbank.contas.modelo.Conta;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
/**Classe para Valida�oes necessarias para crina�ao de objetos do tipo pessoa.

 * @author Matheus Castro

 * @version 1.0
 */
public class DataBase {
	
	private static Hashtable<Integer,Conta> contas;
	private static Hashtable<String,Pessoa> pessoas;
	
	
	   /** M�todo para salvar contas
		* @param  conta - Objeto conta*/
	public static void salvaConta(Conta conta) throws DataBaseException {
		if(!contas.containsKey(conta.getNumero())) {
			contas.put(conta.getNumero(),conta);
		}else {
			throw new DataBaseException("Conta ja existente");
		}
	}
	   /** M�todo para salvar pessoas
		* @param pessoa  - Objeto pessoa*/
	public static void salvaConta(Pessoa pessoa) throws DataBaseException {
		if(!pessoas.containsKey(pessoa.getNome())) {
			pessoas.put(pessoa.getNome(),pessoa);
		}else {
			throw new DataBaseException("Pessoa ja existente");
		}
	}
	   /** M�todo para buscar contas
		* @param numero  - Numero da conta*/
	public static  Conta getConta(int numero) throws DataBaseException {
		if(contas.containsKey(numero)) {
			return contas.get(numero);
		}else {
			throw new DataBaseException("Conta nao encontrada");
		}
	}
	   /** M�todo para buscar pessoas
		* @param Nome  - Nome de pessoa*/
	public static Pessoa getPessoa(String nome) throws DataBaseException {
		if(pessoas.containsKey(nome)) {
			return pessoas.get(nome);
		}else {
			throw new DataBaseException("Pessoa nao encontrada");
		}
	}
}
