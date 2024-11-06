package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name="banque")
public class Banque implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @OneToMany (mappedBy = "banque")
    private Set<Client> clients;

    public Banque() {
       clients = new HashSet<Client>();
    }

    public Banque(String nom) {
        this.nom = nom;
        clients = new HashSet<Client>();
    }
}
