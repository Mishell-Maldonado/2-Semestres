package poo;
import sistema.multimedia.*;
public class PruebaAudioVisual {
    public static void main(String[] args) {
        // 1. Ampliamos el arreglo a 5 para que quepan todas las clases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];

        // 2. Creamos los objetos de las primeras etapas
        contenidos[0] = new Pelicula("Oppenheimer", 180, "Biografía/Drama", "Universal Pictures");
        contenidos[1] = new SerieDeTV("One Piece", 24, "Aventura/Fantasía", 20);
        contenidos[2] = new Documental("Nuestro Planeta", 50, "Naturaleza", "Vida Silvestre");

        // 3. Creamos los objetos de la Etapa 4 
        // Primero los objetos de relación
        Actor invitadoTwitch = new Actor(" Gerard Piqué");
        Investigador expertoTiktok = new Investigador(" David Attenborough");

        // Luego las instancias de Twitch y Tiktok
        contenidos[3] = new Twitch("Kings League Final", 180, "Deportes", "Ibai", "Final", invitadoTwitch);
        contenidos[4] = new Tiktok("Tips de Java", 1, "Educativo", "MoureDev", "Lofi", expertoTiktok);

        // 4. Paso 2: Prueba de funcionalidades (Bucle para mostrar todo)
        System.out.println("--- LISTADO COMPLETO DE CONTENIDOS ---");
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido != null) {
                contenido.mostrarDetalles();
            }
        }
    }
}
