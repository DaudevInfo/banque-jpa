package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
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
}
