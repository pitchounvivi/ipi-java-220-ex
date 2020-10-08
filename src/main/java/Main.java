import com.ipiecoles.java.java220.Employe;
import org.joda.time.LocalDate;

public class Main {
        public static void main(String[] args) {
        System.out.println("Hello World");

            Employe employe = new Employe("a","b","1", LocalDate.now(),500.0);
            System.out.println(employe.augmenterSalaire(0.5));
    }
}
