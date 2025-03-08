//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Playlist inteligente
//Luis Quan
//201927151

package src.Metodos;


import src.Listas.*;
import java.util.List;
import java.util.Scanner;

//Creamos la clase con los metodos para las canciones
public class CancionMetodo {
    private List<Cancion> cancionesGenerales;
    private int contadorCanciones;

    //Construimos la clase
    public CancionMetodo(List<Cancion> cancionesGenerales, int contadorCanciones) {
        this.cancionesGenerales = cancionesGenerales;
        this.contadorCanciones = contadorCanciones;
    }

    //Método para crear una nueva canción, ponemos la opcion de 0 para salir de esta opcion
    public void crearCancion(Scanner scanner) {
        while (true) {
            System.out.print("Título de la canción o 0 para salir: ");
            String titulo = scanner.nextLine();
            if (titulo.equals("0")) {
                break;
            }

            System.out.print("Nombre del artista: ");
            String artista = scanner.nextLine();

            System.out.print("Duración de la canción en segundos: ");
            int duracion = scanner.nextInt();
            scanner.nextLine();

            cancionesGenerales.add(new Cancion(titulo, artista, duracion, contadorCanciones++));
            System.out.println("Canción creada.");
        }
    }

    // Método para mostrar todas las canciones que se crearon
    public void mostrarCanciones() {
        System.out.println("Listado general de canciones:");
        for (Cancion cancion : cancionesGenerales) {
            System.out.println(cancion);
        }
    }
}