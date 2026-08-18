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
public class SalleDTO {
 
    private Long id;
    private int numero;
    private int capacite;
    private Date addedDate;
}