package pila;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pila pila = new Pila();
		Pila pilaCopia = new Pila();
		boolean salir = false;
		int opcion;
		String teclado;
		Scanner entrada;

		do {
			entrada = new Scanner(System.in);
			borrarPantalla();
			mostrarMenuPrincipal();
			try {
				teclado = entrada.nextLine();
				opcion = Integer.parseInt(teclado);
				if (opcion > 5 || opcion < 0) {
					System.out.println(
							"Opcion no valida!!!. \nDebe elegir una opcion entre 1 y 8.\n0 para salir.\nPulse [Intro] para continuar");
					entrada.nextLine();
				} else {
					switch (opcion) {
					case 1:
						introducirElemento(pila);
						break;
					case 2:
						obtenerElemento(pila);
						break;
					case 3:
						copiarPila(pila, pilaCopia);
						break;
					case 4:
						listarPila(pila);
						break;
					case 5:
						listarPila(pilaCopia);
						break;
					case 0:
						salir = true;
						break;
					}
				}
				borrarPantalla();
			} catch (Exception e) {
				System.out.println("Se ha producido un error. Debes introducir un numero [1,2] y 0 para salir. Pulse [Intro] para continuar");
				entrada.nextLine();
			}

		} while (!salir);
		System.out.println("That's all folks!!!. \nGood bye!!!");
		entrada.close();
	}

	public static void introducirElemento(Pila pila) {
		Scanner entrada = new Scanner(System.in);
		int dato;
		borrarPantalla();
		System.out.println("Dame un entero para introducir en la pila");
		try {
			dato = Integer.parseInt(entrada.nextLine());
			pila.insertar(new Nodo(dato));
			System.out.println("Elemento introducido correctamente.");
		} catch (Exception e) {
			System.out.println("Se ha producido un error. Debes introducir un entero");
		}
		System.out.println("Pulse [Intro] para continuar");
		entrada.nextLine();
	}

	public static void obtenerElemento(Pila pila) {

		Scanner entrada = new Scanner(System.in);

		try {
			borrarPantalla();
			System.out.println(pila.obtener());
		} catch (Exception e) {
			System.err.println("Excepcion: " + e);
		}

		System.out.println("Pulse [Intro] para continuar");
		entrada.nextLine();
	}
	
	public static void copiarPila(Pila pila, Pila pilaCopia) {
		Pila pilaAux = new Pila();
		Nodo aux;
		Scanner entrada = new Scanner(System.in);
		
		// Vaciamos la pila
		pilaCopia.vaciar();
		
		try {
			aux = pila.obtener();			
			while (aux != null) {
				pilaAux.insertar(new Nodo(aux));				
				aux = pila.obtener();
			}
			
		} catch (Exception e) {}
			
		try{	
			aux = pilaAux.obtener();
			while (aux != null) {
				pila.insertar(new Nodo(aux));
				pilaCopia.insertar(new Nodo(aux));
				aux = pilaAux.obtener();
			}
	
		}catch (Exception e) {} 
		
		System.out.println("Pulse [Intro] para continuar");
		entrada.nextLine();
		
	}

	public static void listarPila(Pila pila) {
		Scanner entrada = new Scanner(System.in);
		borrarPantalla();
		System.out.println(pila.toString());
		System.out.println("Pulse [Intro] para continuar");
		entrada.nextLine();
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("----- Examen de Programacion -----");
		System.out.println("----------------------------------");
		System.out.println("1- Introducir elemento de la pila");
		System.out.println("2- Obtener elemento de la pila");
		System.out.println("3- Copiar pila");
		System.out.println("4- Listar pila");
		System.out.println("5- Listar pilaCopia");
		System.out.println("----------------------------------");
		System.out.println("0- Salir");
		System.out.println("----------------------------------");
	}

	public static void borrarPantalla() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
