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
public class CustomersDTO {
 
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date addedDate;
}