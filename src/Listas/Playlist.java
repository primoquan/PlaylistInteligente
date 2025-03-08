//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Playlist inteligente
//Luis Quan
//201927151

package src.Listas;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

// Creamos la clase de la playlist
public class Playlist {
    private String nombre;
    private LinkedList<Cancion> canciones;
    private int numero;

    //Construimos la clase
    public Playlist(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.canciones = new LinkedList<>();
    }

    //Métodos getters

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    //Método para agregar una canción a la playlist
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    //Método para eliminar una canción de la playlist
    public void eliminarCancion(int numero) {
        canciones.removeIf(c -> c.getNumero() == numero);
    }

    //Método para ordenar las canciones de la playlist por duración
    public void ordenarPorDuracion() {
        canciones.sort(Comparator.comparingInt(Cancion::getDuracion));
    }

    //Método para ordenar las canciones de la playlist por artista
    public void ordenarPorArtista() {
        canciones.sort(Comparator.comparing(Cancion::getArtista));
    }

    //Método para reproducir la playlist en orden aleatorio
    public void reproducirAleatorio() {
        Collections.shuffle(canciones);
    }

    // Método para mostrar todas las canciones de la playlist
    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
        } else {
            canciones.forEach(System.out::println);
        }
    }

    //Método para mostrar el orden de reproducción de la playlist
    public void mostrarOrdenReproduccion() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
        } else {
            System.out.println("Orden de reproducción:");
            canciones.forEach(System.out::println);
        }
    }
}