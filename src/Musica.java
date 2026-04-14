import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Musica {
    private @Getter String titulo;
    
    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("TITULO DA MUSICA: " + titulo);
        return sb.toString();
    }
}
