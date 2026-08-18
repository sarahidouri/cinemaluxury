package cinema.movies.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nationalite extends AbstractModel<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 50)
    private String libelle;
	
	@OneToMany(mappedBy = "nationalite")
	@JsonIgnore
    private List<Personne> personnes;
	
	public String toString() {
		return this.libelle;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
	
}
