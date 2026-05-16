package sistema.multimedia;
public class Twitch extends ContenidoAudiovisual {
    private String streamer;
    private String categoria;
    private Actor invitado;
    public Twitch(String titulo, int duracionEnMinutos, String genero, String streamer, String categoria, Actor invitado) {
        super(titulo, duracionEnMinutos, genero);
        this.streamer = streamer;
        this.categoria = categoria;
        this.invitado = invitado;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de Twitch:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Streamer: " + streamer);
        System.out.println("Categoría: " + categoria);
        System.out.println("Invitado:" + invitado.getNombre() );
        System.out.println();
    }

}
