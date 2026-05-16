/**
 * Class SerieDeTV
 */
package sistema.multimedia;
import java.util.ArrayList;


//Subclase que SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada>listaTemporadas;
    

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
        
    }

    public int getTemporadas() {
        return temporadas;
    }
    public void agregarTemporada(Temporada temporada) {
    	listaTemporadas.add(temporada);
    	}
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println();
    }
}