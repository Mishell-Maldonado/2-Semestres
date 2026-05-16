package sistema.multimedia;
public class Tiktok extends ContenidoAudiovisual {
    private String usuario;
    private String musica;
    private Investigador investigador;

    public Tiktok(String titulo, int duracionEnMinutos, String genero, String usuario, String musica, Investigador investigador ) {
        // "super" llama al constructor de ContenidoAudiovisual
        super(titulo, duracionEnMinutos, genero);
        this.usuario = usuario;
        this.musica = musica;
        this.investigador = investigador;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de TikTok:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Usuario: @" + usuario);
        System.out.println("Música: " + musica);
        System.out.println("Investigador asociado:" + investigador.getNombre());
        System.out.println();
    }

}
