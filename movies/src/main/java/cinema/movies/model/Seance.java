package cinema.movies.model;



import java.sql.Date;

import org.hibernate.annotations.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Seance extends AbstractModel<Long>{
	private static final long serialVersionUID = 6992208427439369561L;

	@Column(name = "date_projection")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateProjection;
	
	@Column(name = "heure_debut")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
    private Date heureDebut;
	
	@Column(name = "heure_fin")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
    private Date heureFin;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Film_ID")
    private Film film;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="salle_ID")
    private Salle salle;
}
