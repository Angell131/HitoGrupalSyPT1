package Server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Servidor{
    private static ArrayList<Personaje> listaPersonaje = new ArrayList<>();
    public static void main(String[] args) {
        //Llamamos a la función para leer el csv y comprobar si la lectura es correcta.
        leerCSV();
        try {
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("192.168.1.18", 2000);

            servidor.bind(direccion);

            // Vinculamos el servidor con la dirección establecida por el objeto InetSocketAddress
            System.out.println("Servidor creado y escuchando.");
            System.out.println("Dirección IP: " + direccion.getAddress());
            Socket enchufeAlCliente = servidor.accept();

            //Detiene el proceso hasta que un usuario solicite una conexion.
            System.out.println("Comunicación entrante");
            ObjectInputStream entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());

            //Abrirmos los flujos de entrada y salida para las comunicaciones.
            String texto = "";
            while (!texto.trim().equals("FIN")) {
                texto = (String) entrada.readObject();

                //Lee mensaje del usuario (readObject)
                switch (texto.trim()) {
                    case "Luffy" -> {
                        pintarLuffy();
                        salida.writeObject(pintarLuffy());
                    }
                    case "Zoro" -> {
                        pintarZoro();
                        salida.writeObject(pintarZoro());}

                    case "Nami" -> {
                        pintarNami();
                        salida.writeObject(pintarNami());
                    }
                    case "Sanji" -> {
                        pintarSanji();
                        salida.writeObject(pintarSanji());
                    }
                    case "Chopper" -> {
                        pintarChopper();
                        salida.writeObject(pintarChopper());
                    }
                }
            }

        entrada.close();
            salida.close();
            enchufeAlCliente.close();
            servidor.close();
            System.out.println("Comunicación cerrada");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }//Cierra main

    //Función para leer el csv
    private static void leerCSV() {
        File fichero = new File("hito.csv");
        Scanner lector;
        try {
            lector = new Scanner(fichero);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                newPersonaje(linea);
            }
            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido leer el archivo");
            System.out.println(e.getMessage());
        }
    }

    //Delimitador y set para los atributos de la clase Personaje
    public static void newPersonaje(String linea) {
        Scanner lector = new Scanner(linea);
        lector.useDelimiter(";");
        String funcion = lector.next();
        String nombre = lector.next();
        int edad = lector.nextInt();

        Personaje personaje = new Personaje();
        personaje.setFuncion(funcion);
        personaje.setNombre(nombre);
        personaje.setEdad(edad);


        lector.close();

        listaPersonaje.add(personaje);
    }


    //Funciones para cada personaje (mostrar sus datos)
    private static Personaje pintarChopper() {
        Personaje chopper = listPersonajeByName("Chopper");
        return chopper;
    }

    private static Personaje pintarSanji() {
        Personaje sanji = listPersonajeByName("Sanji");
        return sanji;
    }

    private static Personaje pintarNami() {
        Personaje nami = listPersonajeByName("Nami");
        return nami;
    }

    private static Personaje pintarZoro() {
        Personaje zoro = listPersonajeByName("Zoro");
        return zoro;
    }

    private static Personaje pintarLuffy() {
        Personaje luffy = listPersonajeByName("Luffy");
        return luffy;

    }

    //Recorrer array hasta encontrar el nombre que le pasamos en el case
    private static Personaje listPersonajeByName(String nombre) {
        for (Personaje p : listaPersonaje) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }



}


