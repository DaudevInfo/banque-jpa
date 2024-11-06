package diginamic.fr;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {

    @Column(name= "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {

    }

    public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }
}
