package diginamic.fr;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
public class Adresse implements Serializable {


    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "RUE")
    private String rue;

    @Column(name = "CODE_POSTAL",length = 5)
    private int codePostal;

    @Column(name = "VILLE")
    private String ville;

    public Adresse() {
    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }


    /**
     * Getter
     *
     * @return numero
     **/
    public int getNumero() {
        return numero;
    }

    /**
     * Setter
     *
     * @param : numero
     **/

    public Adresse setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    /**
     * Getter
     *
     * @return ville
     **/
    public String getVille() {
        return ville;
    }

    /**
     * Setter
     *
     * @param : ville
     **/

    public Adresse setVille(String ville) {
        this.ville = ville;
        return this;
    }

    /**
     * Getter
     *
     * @return codePostal
     **/
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Setter
     *
     * @param : codePostal
     **/

    public Adresse setCodePostal(int codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    /**
     * Getter
     *
     * @return rue
     **/
    public String getRue() {
        return rue;
    }

    /**
     * Setter
     *
     * @param : rue
     **/

    public Adresse setRue(String rue) {
        this.rue = rue;
        return this;
    }
}
