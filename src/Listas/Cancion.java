//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Playlist inteligente
//Luis Quan
//201927151

package src.Listas;

// Creamos la clase canción
public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;
    private int numero;

    //Construimos la clase
    public Cancion(String titulo, String artista, int duracion, int numero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.numero = numero;
    }

    //Métodos getters

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getNumero() {
        return numero;
    }

    //Método mostrar la canción como una cadena de texto
    @Override
    public String toString() {
        // Formato: "Número. Título - Artista (Duración en segundos)"
        return numero + ". " + titulo + " - " + artista + " (" + duracion + "s)";
    }
}