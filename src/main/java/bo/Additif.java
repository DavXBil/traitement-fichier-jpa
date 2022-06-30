package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Additif {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Additif() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Additif{");
        sb.append("libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
