package diginamic.test;

import diginamic.fr.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
            EntityManager em;
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Adresse adr = new Adresse(10, "rue des Lilas",36410, "Barre");
            Banque bqe = new Banque("Credit National");
            Client  cli = new Client("DURAND","Paul", LocalDate.parse("2000-01-01"),adr,bqe);
            LivretA cpt1 = new LivretA("CN123456789",100000.22,.1);
            AssuranceVie cpt2 = new AssuranceVie("CN0000789",100.00,LocalDate.now(),.1);
            Operation op1 = new Operation(LocalDate.parse("2024-11-06"), 1000, "RET CB PERSO", cpt1);
            Operation op2 = new Operation(LocalDate.parse("2024-11-06"), 2000, "Loyer", cpt2);

            em.persist(cpt1);
            em.persist(cpt2);
            em.persist(op1);
            em.persist(op2);
            em.persist(bqe);

            HashSet<Compte> cs = new HashSet<Compte>() ;

            cs.add(cpt1);
            cs.add(cpt2);
            cli.setComptes(cs);
            em.persist(cli);

            Virement vir1 = new Virement(LocalDate.now(),100, "Vir1", cpt1,"Seb");
            Virement vir2 = new Virement(LocalDate.now(),1000, "Vir2", cpt1,"Seb");
            em.persist(vir1);
            em.persist(vir2);

            em.getTransaction().commit();
            em.close();
            emf.close();
    }
}
