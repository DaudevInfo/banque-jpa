package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Client : permet de gérer les clients de la banque

 */
@Entity
@Table (name="client")
public class Client implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;


    @ManyToOne
    @JoinColumn (name="ID_BANQUE")
    private Banque banque;


    @ManyToMany
    @JoinTable (name ="portefeuille",
                joinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn (name= "ID_COMPTE", referencedColumnName = "ID"))
    private Set<Compte> comptes;

    {
        comptes = new HashSet<Compte>();
    }

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse , Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        setBanque(banque);
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
     * Setter
     *
     * @param : nom
     **/

    public Client setNom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Getter
     *
     * @return prenom
     **/
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter
     *
     * @param : prenom
     **/

    public Client setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    /**
     * Getter
     *
     * @return dateNaissance
     **/
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter
     *
     * @param : dateNaissance
     **/

    public Client setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    /**
     * Getter
     *
     * @return banque
     **/
    public Banque getBanque() {
        return banque;
    }

    /**
     * Setter
     *
     * @param : banque
     **/

    public void setBanque(Banque banque) {
        if (this.banque != null) {
            this.banque.getClients().remove(this);
        }
        this.banque = banque;
        if (this.banque != null) {
            this.banque.getClients().add(this);
        }
    }
    /**
     * Getter
     *
     * @return comptes
     **/
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * Setter
     *
     * @param : comptes
     **/

    public Client setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
