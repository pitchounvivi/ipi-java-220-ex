import com.ipiecoles.java.java220.Commercial;
import com.ipiecoles.java.java220.Employe;
import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Employe employe = new Employe("a","b","1", LocalDate.now(),500.0);

        employe.augmenterSalaire(0.50);
        System.out.println(employe);

//        Commercial commercial = new Commercial("c","d","2",LocalDate.now(),1000d,100000d);
//        System.out.println(commercial.getPrimeAnnuelle(8000000d));


    }
}
