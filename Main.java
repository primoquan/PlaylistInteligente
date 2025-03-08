//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Playlist inteligente
//Luis Quan
//201927151

import src.Listas.*;
import src.Metodos.*;
import java.util.*;


// Clase principal del programa en este vamos a crear nuestros menus y vamos a llamar a los metodos
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitamos el nombre del usuario a usar la playlist inteligente
        System.out.print("Bienvenido, ingresa tu nombre: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Bienvenido, " + nombreUsuario + ", vamos a crear tu Playlist con tus canciones favoritas!");

        // Estructuras de datos para almacenar playlists y canciones
        Map<Integer, Playlist> playlists = new HashMap<>();
        List<Cancion> cancionesGenerales = new ArrayList<>();
        int contadorPlaylists = 1;
        int contadorCanciones = 1;

        // Metodos para manejar las canciones y las playlists
        CancionMetodo cancionService = new CancionMetodo(cancionesGenerales, contadorCanciones);
        PlaylistMetodo playlistService = new PlaylistMetodo(playlists, cancionesGenerales, contadorPlaylists);


        boolean continuar = true;

        // Este es nuestro menu principal
        while (continuar) {
            System.out.println("Menú Principal:");
            System.out.println("1. Administrar canciones");
            System.out.println("2. Administrar playlists");
            System.out.println("3. Reproducir playlist");
            System.out.println("4. Reproducir playlist en orden aleatorio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            // Switch para entrar a cada opcion del menu, en donde vamos a llamar a nuestros metodos principales
            switch (opcionPrincipal) {
                case 1:
                    administrarCanciones(scanner, cancionService);
                    break;
                case 2:
                    administrarPlaylists(scanner, playlistService);
                    break;
                case 3:
                    playlistService.reproducirPlaylist(scanner);
                    break;
                case 4:
                    playlistService.reproducirPlaylistAleatorio(scanner);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    //Llamamos al metodo para administras las canciones este es un submenu
    private static void administrarCanciones(Scanner scanner, CancionMetodo cancionService) {
        boolean enAdministrarCanciones = true;

        while (enAdministrarCanciones) {
            System.out.println("Administrar Canciones:");
            System.out.println("1. Crear una canción");
            System.out.println("2. Mostrar listado general de canciones");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcionCanciones = scanner.nextInt();
            scanner.nextLine();

            // Switch para el submenu y sus metodos
            switch (opcionCanciones) {
                case 1:
                    cancionService.crearCancion(scanner);
                    break;
                case 2:
                    cancionService.mostrarCanciones();
                    break;
                case 3:
                    enAdministrarCanciones = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    //Llamamos al método para administrar playlists y creamos un submenu
    private static void administrarPlaylists(Scanner scanner, PlaylistMetodo playlistService) {
        boolean enAdministrarPlaylist = true; // Controlar el bucle del submenú

        while (enAdministrarPlaylist) {
            System.out.println("Administrar Playlist:");
            System.out.println("1. Crear una playlist");
            System.out.println("2. Mostrar todas las playlists");
            System.out.println("3. Mostrar una playlist");
            System.out.println("4. Agregar canción a una playlist");
            System.out.println("5. Eliminar canción de una playlist");
            System.out.println("6. Ordenar playlist por duración");
            System.out.println("7. Ordenar playlist por artista");
            System.out.println("8. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcionPlaylist = scanner.nextInt();
            scanner.nextLine();

            // Switch para el submenu y sus metodos
            switch (opcionPlaylist) {
                case 1:
                    playlistService.crearPlaylist(scanner);
                    break;
                case 2:
                    playlistService.mostrarPlaylists();
                    break;
                case 3:
                    playlistService.mostrarPlaylist(scanner);
                    break;
                case 4:
                    playlistService.agregarCancionAPlaylist(scanner);
                    break;
                case 5:
                    playlistService.eliminarCancionDePlaylist(scanner);
                    break;
                case 6:
                    playlistService.ordenarPlaylistPorDuracion(scanner);
                    break;
                case 7:
                    playlistService.ordenarPlaylistPorArtista(scanner);
                    break;
                case 8:
                    enAdministrarPlaylist = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}