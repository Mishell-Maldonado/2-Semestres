/**
 * Class Documental
 */
package sistema.multimedia;
import java.util.ArrayList;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador>investigadores;
    

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this .investigadores=new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    public void agregarInvestigador(Investigador investigador){
    	    this.investigadores.add(investigador); // Esto guarda al investigador en la 'bolsa'
    }
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores; // Devuelve la variable, no el método
    }    
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        
        // Un for pequeño para listar los investigadores
        for (Investigador inv : investigadores) {
            System.out.println("Investigador: " + inv.getNombre());
        }
        System.out.println();
    }
}
