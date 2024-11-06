package diginamic.fr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "livretA")
public class LivretA extends Compte{
    @Column(name= "TAUX")
    private double taux;

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public LivretA() {
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

    public LivretA setTaux(double taux) {
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
