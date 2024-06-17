import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cabin {
    int[] PassengersInCabin ;  //Number of passengers in each cabin.
    int size=12;

    public Cabin(){
        PassengersInCabin=new int[size];
    }

    //View All the cabins in ship
    public String ViewAllCabins(Passenger passengerObj) {

        String passenger = "\n\t\t---CABINS---\n\n";
        String str = "";

        for (int i = 0; i < passengerObj.getFirstNameArr().length; i++) {
            if (getPassengersInCabin()[i] == 0) {
                passenger += "No: " + i + "cabin is occupied by e.\n";
            } else {
                for (int j = 0; j < getPassengersInCabin()[i]; j++) {
                    str += " , " + passengerObj.getFirstNameArr()[i][j] + " " + passengerObj.getSurNameArr()[i][j];
                }
                passenger += "No:\t" + i + " cabin is occupied by " + str + ".\n";
                str = "";
            }
        }
        return passenger;
    }


    //Store program data in a text file
    public void StoreProgramData(Passenger passengerObj) {
        try {
            //File file = new File("Cabin.txt");

            FileWriter myWriter = new FileWriter("Cabin.txt");

            myWriter.write(ViewAllCabins(passengerObj));

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("Error IOException is," + e);
        }
    }


    //Load program data from that file
    public void LoadProgramData() {
        try {
            File file = new File("Cabin.txt");
            file.createNewFile();
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            System.out.println("\nFile has been successfully loaded data from the file.");
            myReader.close();
        } catch (IOException e) {
            System.out.println("Error IOException is," + e);
        }
    }

    //To display all the empty cabins in ship
    public void emptyCabins() {
        System.out.println("\n---EMPTY CABINS---\n");
        for (int i = 0; i < getPassengersInCabin().length; i++) {
            if (getPassengersInCabin()[i] == 0) {
                System.out.println("Cabin No. " + i + " is empty.");
            }
        }
    }


    public int[] getPassengersInCabin() {
        return PassengersInCabin;
    }

}
