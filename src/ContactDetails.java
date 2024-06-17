//We have used abstraction in below "Contacts" class...
abstract class Contacts{
    abstract  void getTpNo();
    abstract void getEmail();

}

public class ContactDetails extends Contacts {
    @Override
    void getEmail() {
        System.out.println("\nOur Email");
        System.out.println("----------");
        System.out.println("ship123@gmail.com");
        System.out.println();
    }

    @Override
    void getTpNo() {
        System.out.println("Out TpNo");
        System.out.println("--------");
        System.out.println("076 3423323");
        System.out.println("0412223444");
        System.out.println();
    }
}

