/*
 RESUMO		 : C) Construção da lista de objetos (conjunto de nós)
 PROGRAMADORA: Luiza Felix
 DATA		 : 05/05/2023
 */

package br.edu.fateczl.listas;

public class ObjectLista {
	
	ObjectNo zero; //nome baseado no INDICE, primeiro sempre vem a casa 0
	
	public ObjectLista() {
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

	public void addfirst(Object valor) {
		ObjectNo novo = new ObjectNo();
		novo.dado = valor;
		novo.proximo = zero;
		zero = novo;
	}
	
	public void addlast(Object valor) throws Exception{
		
		if (vazia()) {
//			para adc um dado no fim, eu preciso ter um começo (casa 0 inicializada)
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);
		
		ObjectNo novo = new ObjectNo();
		novo.dado = valor;
		novo.proximo = null;
		
		//pego meu último nó (o indice de nós é igual o de um vetor) e adiciono o meu novo último como sua referência
		ObjectNo n = getno(size); 
		n.proximo = novo;
	}
	
	public void add (Object valor, int indice) throws Exception{
//		adiciono um dado em qualquer lugar, sabendo a posição desejada
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);	
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		
		if (indice == 0) {
			addfirst(valor);
		} else if(indice == size) {
				addlast(valor);
		} else {
			ObjectNo novo = new ObjectNo();
			novo.dado = valor;
			
			ObjectNo anterior = getno(indice); //dado que está nessa posição agr
			novo.proximo = anterior.proximo; // passo o endereço do próimo para nã foder a sequencia
			anterior.proximo = novo; //meu novo dado nessa posição 
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
		ObjectNo penultimo = getno(size()-2);
		penultimo.proximo = null;
	}

	public void remove(int indice) throws Exception {
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		
		int size = (size() - 1);
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		if (indice == 0) {
			removefirst();
		} else {
//			não preciso adicionar nada para o último pois o esquema é o mesmo
			
			ObjectNo anterior = getno(indice-1); //posição anterior a mencinada;
			ObjectNo atual = getno(indice);
			anterior.proximo = atual.proximo; //copio o caminho e o no atual se perde para todo o sempre	
		}
	}
	
	
	private ObjectNo getno(int indice) throws Exception {
		if (indice < 0) {
			throw new Exception("Posição Inválida");
		}
		
		ObjectNo aux = zero;
		int i = 0;
		while (i < indice) {
			aux = aux.proximo;
			indice++;
		}
		return aux;
	}
	
	
	public int size() {
		int i = 0;
		if (!vazia()) {
			ObjectNo aux = zero;
			while(aux!= null) {
				i++;
				aux = aux.proximo;
			}
		}
		return i;
	}

	public Object get(int indice) throws Exception{
		
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);
		if (indice < 0 || indice > size) {
			throw new Exception("Posição Inválida");
		}
		
		ObjectNo aux = zero;
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
