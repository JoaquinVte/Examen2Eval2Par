package pila;

public class Pila implements Acceso {
	
	private Nodo cima;
	
	public Pila(){
		cima = null;
	}

	public void insertar(Nodo q){
		Nodo aux = cima;
		if (cima==null) cima = q;
		else {
			while(aux.getSiguiente()!=null){
				aux = aux.getSiguiente();
			}
			q.setAnterior(aux);
			aux.setSiguiente(q);
			cima = q;
		}		
	}
	public Nodo obtener() throws Exception{
		Nodo aux = cima;
		
		if(cima==null) throw new Exception("Pila vacia");
		else if(cima.getAnterior()==null){
			aux = cima;
			cima = null;
			return aux;
		}
		else {
			cima = cima.getAnterior();
			cima.setSiguiente(null);
			return aux;
		}
		
	}
	
	public void vaciar(){
		try{
			while(obtener()!=null);
		}catch(Exception e){}
	}
	
	public String toString(){
		Nodo aux=cima;
		String salida = "";
		while(aux!=null){
			salida = salida + aux.toString() + "\n";
			aux = aux.getAnterior();
		}
		return salida;
	}
}
