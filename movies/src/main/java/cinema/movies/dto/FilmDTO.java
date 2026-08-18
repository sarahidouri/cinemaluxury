package cinema.movies.dto;
 
import java.util.Date;

import java.util.List;
 
import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;
 
@Getter

@Setter

@AllArgsConstructor

@NoArgsConstructor

public class FilmDTO {
 
    private Long id;
 
    private String titre;

    private int duree;

    private int annee;
 
    private Long genreId;

    private Long nationaliteId;

    private Long realisateurId;
 
    private List<Long> acteurIds;
 
    private Date addedDate;

}
 