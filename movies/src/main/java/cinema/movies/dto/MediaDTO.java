package cinema.movies.dto;
 
import java.util.Date;
 
import cinema.movies.model.Media.TypeMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO {
 
    private Long id;
 
    private String media;
    private TypeMedia typeMedia;
    private Date addedDate;
 
    private Long filmId;
}