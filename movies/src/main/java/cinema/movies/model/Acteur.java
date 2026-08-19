

package cinema.movies.model;

import jakarta.persistence.*;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // hna dert ghir id , nom , email, prenom hta nchofo wcha nzido
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String prenom;

    @Column(unique = true)
    private String email;

    public Acteur() {
    }

    public Acteur(Long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}