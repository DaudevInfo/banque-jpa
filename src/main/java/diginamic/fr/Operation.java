package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table (name="operation")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "Type")
@DiscriminatorValue("O")
public class Operation implements Serializable {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "MONTANT")
    private double montant;

    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne
    @JoinColumn (name="ID_COMPTE")
    private Compte compte;

    public Operation() {
    }

    public Operation(LocalDate date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

}
