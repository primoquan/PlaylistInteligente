//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Playlist inteligente
//Luis Quan
//201927151

package src.Metodos;

import src.Listas.*;
import java.util.*;

//Creamos la clase para las playlist
public class PlaylistMetodo {
    private Map<Integer, Playlist> playlists;
    private List<Cancion> cancionesGenerales;
    private int contadorPlaylists;

    //Construimos la clase
    public PlaylistMetodo(Map<Integer, Playlist> playlists, List<Cancion> cancionesGenerales, int contadorPlaylists) {
        this.playlists = playlists;
        this.cancionesGenerales = cancionesGenerales;
        this.contadorPlaylists = contadorPlaylists;
    }

    //Método para crear una nueva playlist
    public void crearPlaylist(Scanner scanner) {
        System.out.print("Ingrese el nombre de la nueva playlist: ");
        String nombrePlaylist = scanner.nextLine();
        playlists.put(contadorPlaylists, new Playlist(nombrePlaylist, contadorPlaylists));
        System.out.println("Playlist creada con éxito (Su número de playlist es: " + contadorPlaylists + ").");
        contadorPlaylists++;
    }

    //Método para mostrar todas las playlists que se crearon
    public void mostrarPlaylists() {
        System.out.println("Listas de reproducción disponibles:");
        for (Map.Entry<Integer, Playlist> entry : playlists.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getNombre());
        }
    }

    //Método para mostrar una playlist que se le solicita al usuario
    public void mostrarPlaylist(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numMostrar = scanner.nextInt();
        scanner.nextLine();
        Playlist plMostrar = playlists.get(numMostrar);
        if (plMostrar != null) {
            plMostrar.mostrarPlaylist();
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    // Método para agregar una canción a una playlist
    public void agregarCancionAPlaylist(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numPl = scanner.nextInt();
        scanner.nextLine();
        Playlist playlist = playlists.get(numPl);
        if (playlist != null) {
            while (true) {
                System.out.println("Listado general de canciones:");
                for (Cancion cancion : cancionesGenerales) {
                    System.out.println(cancion);
                }
                System.out.print("Ingrese el número de la canción a agregar o 0 para salir: ");
                int numCancion = scanner.nextInt();
                scanner.nextLine();
                if (numCancion == 0) {
                    break;
                }
                Cancion cancionSeleccionada = cancionesGenerales.stream()
                        .filter(c -> c.getNumero() == numCancion)
                        .findFirst()
                        .orElse(null);
                if (cancionSeleccionada != null) {
                    playlist.agregarCancion(cancionSeleccionada);
                    System.out.println("Canción agregada a la playlist.");
                } else {
                    System.out.println("Canción no encontrada.");
                }
            }
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    //Método para eliminar una canción de una playlist
    public void eliminarCancionDePlaylist(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numEliminar = scanner.nextInt();
        scanner.nextLine();
        Playlist plEliminar = playlists.get(numEliminar);
        if (plEliminar != null) {
            while (true) {
                plEliminar.mostrarPlaylist();
                System.out.print("Ingrese el número de la canción a eliminar o 0 para salir: ");
                int numCancion = scanner.nextInt();
                scanner.nextLine();
                if (numCancion == 0) {
                    break;
                }
                plEliminar.eliminarCancion(numCancion);
                System.out.println("Canción eliminada.");
            }
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    // Método para ordenar una playlist por duración
    public void ordenarPlaylistPorDuracion(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numOrdenarDur = scanner.nextInt();
        scanner.nextLine();
        Playlist plDur = playlists.get(numOrdenarDur);
        if (plDur != null) {
            plDur.ordenarPorDuracion();
            System.out.println("Playlist ordenada por duración.");
        }
    }

    //Método para ordenar una playlist por artista
    public void ordenarPlaylistPorArtista(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numOrdenarArt = scanner.nextInt();
        scanner.nextLine();
        Playlist plArt = playlists.get(numOrdenarArt);
        if (plArt != null) {
            plArt.ordenarPorArtista();
            System.out.println("Playlist ordenada por artista.");
        }
    }

    //Método para reproducir una playlist en orden normal
    public void reproducirPlaylist(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numReproducir = scanner.nextInt();
        scanner.nextLine();
        Playlist plReproducir = playlists.get(numReproducir);
        if (plReproducir != null) {
            plReproducir.mostrarOrdenReproduccion();
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    //Método para reproducir una playlist en orden aleatorio
    public void reproducirPlaylistAleatorio(Scanner scanner) {
        System.out.print("Ingrese el número de la playlist: ");
        int numAleatorio = scanner.nextInt();
        scanner.nextLine();
        Playlist plAleatorio = playlists.get(numAleatorio);
        if (plAleatorio != null) {
            plAleatorio.reproducirAleatorio();
            plAleatorio.mostrarOrdenReproduccion();
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }
}