package diginamic.fr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "Assurance_vie")
public class AssuranceVie extends Compte{
    @Column (name= "DATE_FIN")
    private LocalDate dateFin;


    @Column(name= "TAUX")
    private double taux;

    public AssuranceVie(String numero, double solde, LocalDate date, double taux) {
        super(numero, solde);
        this.dateFin = date;
        this.taux = taux;
    }

    public AssuranceVie() {
        super();
    }

    /**
     * Getter
     *
     * @return taux
     **/
    public double getTaux() {
        return taux;
    }

    /**
     * Setter
     *
     * @param : taux
     **/

    public AssuranceVie setTaux(double taux) {
        this.taux = taux;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LivretA{");
        sb.append("taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
