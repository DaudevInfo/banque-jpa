package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table (name="compte")
public class Compte implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "SOLDE")
    private Double solde;

    @OneToMany (mappedBy = "compte")
    private Set<Operation> operations;

    @ManyToMany (mappedBy="comptes")
    private Set<Client> clients;


    public Compte() {
        operations = new HashSet<Operation>();
        clients = new HashSet<Client>();
    }



    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
        operations = new HashSet<Operation>();
        clients = new HashSet<Client>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte compte)) return false;
        return Objects.equals(numero, compte.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
