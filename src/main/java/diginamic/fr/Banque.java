package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table (name="banque")
public class Banque implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public void ajouterClient(Client client) {
        client.setBanque(this);
    }

    /**
     * Setter
     *
     * @param : clients
     **/

    public Banque setClients(Set<Client> clients) {
        this.clients = clients;
        return this;
    }

    /**
     * Getter
     *
     * @return clients
     **/
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Getter
     *
     * @return nom
     **/
    public String getNom() {
        return nom;
    }

    /**
     * Getter
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banque banque)) return false;
        return Objects.equals(nom, banque.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}
