package cinema.movies.dto;
 
import java.util.Date;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeanceDTO {
 
    private Long id;
 
    private Date dateProjection;
    private Date heureDebut;
    private Date heureFin;
 
    private Long filmId;
    private Long salleId;
}