package Cliente;

import Server.Personaje;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	public static void main(String[] args) {
		//Scanner para el cliente
		Scanner lector = new Scanner(System.in);
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.1.18", 2000);
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			System.out.println("Comunicación establecida con el servidor");

			//Input y output
			ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			String texto = "";
			while (!texto.equals("FIN")) {
				System.out.println("Escribe mensaje (FIN para terminar): ");
				//Mensaje de bienvenida
				System.out.println("\n");
				System.out.println("PERSONAJES ONE PIECE");
				System.out.println(" Escriba alguno de estos nombres (primera letra en mayuscula): Luffy, Zoro, Nami, Sanji o Chopper. ");
				texto = lector.nextLine();
				salida.writeObject(texto);
				Object p =  entrada.readObject();
				//Mostramos la información del personaje
				System.out.println("Informacion de personaje: " + p.toString());
			}
			//Cerramos inputs y outputs
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("Comunicacion cerrada");
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		//Cerramos scanner
		lector.close();
	}
}
