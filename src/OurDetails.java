import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OurDetails {
    private String oldDetails;
    private String newDetails;

    public String getOldDetails() {
        return oldDetails;
    }

    public void setOldDetails(String oldDetails) {
        this.oldDetails = oldDetails;
    }

    public String getNewDetails() {
        return newDetails;
    }

    public void setNewDetails(String newDetails) {
        this.newDetails = newDetails;
    }
    static Scanner input1 = new Scanner(System.in);

    //this method is overridden in "AboutUs class" and "VisionMission class"....
    public void getDetails(){

    }

    public static void getOurDetails(){

        boolean isContinue = false;
        OurDetails ourDetails = new AboutUs();
        OurDetails ourDetails1 = new VisionMission();


        System.out.println("In here you can get Our details.....");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("01. About us");
        System.out.println("02. Our Vision & Mission");
        System.out.println("03. Our Contact Details");
        System.out.println();

        do {
            Scanner input2 = new Scanner(System.in);
            int option1;

            try{
                System.out.print("Enter your option : ");
                option1 = input2.nextInt();

                switch (option1){
                    case 1:
                        ourDetails.getDetails();
                        System.out.println();
                        break;
                    case 2:
                        ourDetails1.getDetails();
                        System.out.println();
                        break;
                    case 3:
                        ContactDetails contactDetails = new ContactDetails();
                        contactDetails.getEmail();
                        contactDetails.getTpNo();
                        break;
                    default:
                        System.out.println("try again...");

                }

            }catch (InputMismatchException e){
                System.out.println();
                System.out.println("Please enter a valid value !");
            }

            System.out.print("Do you want to select another option : ");
            String option2 = input1.next();
            System.out.println();
            if (option2.equals("yes") || option2.equals("Yes") || option2.equals("YES")){
                isContinue = true;
            }else {
                System.out.println();
                System.out.println("Thank You...");
                isContinue = false;
            }
        }while (isContinue);
    }
}


class AboutUs extends OurDetails{
    /**
     * overrides method in OurDetails...
     * run-time polymorphism.
     */
    @Override
    public void getDetails(){
        System.out.println();
        System.out.println("-About us-");
        System.out.println("-----------");
        System.out.println();
        System.out.println("we know that planning a vacation shouldn't be a chore, it should be fun!\n" +
                " By utilizing the latest advances in technology, such as live pricing and availability, we've \n" +
                "made it as easy as 1-2-3 to research, arrange, and book reservations online- without any hassles.\n");
    }
}


class VisionMission extends OurDetails{

    /**
     * overrides method in OurDetails...
     * run-time polymorphism.
     */
    @Override
    public void getDetails(){
        System.out.println();
        System.out.println("-Our mission & vision-");
        System.out.println("-----------");

        getMission_vissionDetails();
        System.out.println();
        getMission_vissionDetails(34);
        System.out.println();
        System.out.println("Thank you..");
    }


    /**
     * Method overloading...
     * compile-time polymorphism
     */
    public static void getMission_vissionDetails(){
        System.out.println("our mission - to provide the best and most unique service and food to our\n" +
                "\t\t\tguests through our dedicated crew and dedicated management ");
    }

    /**
     *Method overloading...
     * compile-time polymorphism
     * @param a - int value
     */
    public static void getMission_vissionDetails(int a){
        System.out.println("our vision - Vision: to become the leading hospitality and catering\n" +
                "\t\tcompany for cruise and remote sites (oil fields, civil constructions, mines, etc) \n" +
                "\t\taround the world.");
    }
}
