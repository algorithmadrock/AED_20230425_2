/*
 RESUMO		 : B) Construção da lista de objetos (conjunto de nós)
 PROGRAMADORA: Luiza Felix
 DATA		 : 05/05/2023
 */

package br.edu.fateczl.listas;

public class StringLista {
	
	StringNo zero; //nome baseado no INDICE, primeiro sempre vem a casa 0
	
	public StringLista() {
		zero = null;
	}
	
	public boolean vazia() {
//		teste base para todos os outros
		if (zero == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addfirst(String valor) {
		StringNo novo = new StringNo();
		novo.dado = valor;
		novo.proximo = zero;
		zero = novo;
	}
	
	public void addlast(String valor) throws Exception{
		
		if (vazia()) {
//			para adc um dado no fim, eu preciso ter um começo (casa 0 inicializada)
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);
		
		StringNo novo = new StringNo();
		novo.dado = valor;
		novo.proximo = null;
		
		//pego meu último nó (o indice de nós é igual o de um vetor) e adiciono o meu novo último como sua referência
		StringNo n = getno(size); 
		n.proximo = novo;
	}
	
	public void add (String valor, int indice) throws Exception{
//		adiciono um dado em qualquer lugar, sabendo a posição desejada
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = size();	
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		
		if (indice == 0) {
			addfirst(valor);
		} else if(indice == size) {
			addlast(valor);
		} else {
			StringNo novo = new StringNo();
			novo.dado = valor;
			
			StringNo anterior = getno(indice - 1); //dado que está antes da posção 
			novo.proximo = anterior.proximo; // passo o endereço do próximo para não foder a sequencia
			anterior.proximo = novo; //vai apontar para o novo, o que vinha antes é apontado pelo anterior
		}
	}
	
	public void removefirst() throws Exception {
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		zero = zero.proximo;
	}
	
	public void removelast() throws Exception {
//		apago o nó sem o usuário conseguir pegar nesse dado
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		StringNo penultimo = getno(size()-2);
		penultimo.proximo = null;
	}

	public void remove(int indice) throws Exception {
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		
		int size = size();
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		if (indice == 0) {
			removefirst();
		} else {
//			não preciso adicionar nada para o último pois o esquema é o mesmo
			
			StringNo anterior = getno(indice-1); //posição anterior a mencinada;
			StringNo atual = getno(indice);
			anterior.proximo = atual.proximo; //copio o caminho e o no atual se perde para todo o sempre	
		}
	}

	private StringNo getno(int indice) throws Exception {
		if (indice < 0) {
			throw new Exception("Posição Inválida");
		}
		
		StringNo aux = zero;
		int i = 0;
		while (i < indice) {
			aux = aux.proximo;
			i++;
		}
		return aux;
	}
	
	public int size() {
		int i = 0;
		if (!vazia()) {
			StringNo aux = zero;
			while(aux!= null) {
				i++;
				aux = aux.proximo;
			}
		}
		return i;
	}

	public String get(int indice) throws Exception{
		
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);
		if (indice < 0 || indice > size) {
			throw new Exception("Posição Inválida");
		}
		
		StringNo aux = zero;
		int i = 0;
		while(i < indice) {
			aux = aux.proximo;
			i++;
		}
		return aux.dado;
		
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		try {
			int size = size();
			for (int i = 0 ; i < size ; i++) {
				buffer.append( get(i)+ "	");
				if (i == size - 1) {
					buffer.append("NULL");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	
}
