package cinema.movies.dto;
 
import java.util.Date;
 
import cinema.movies.model.Personne.TypePersonne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDTO {
 
    private Long id;
    private String nom;
    private String prenom;
    private String photo;
    private Date dateNaissance;
    private TypePersonne typePersonne;
    private Date addedDate;
 
    private Long nationaliteId;
}