import java.util.Scanner;

public class Passenger{
    private static String[][] FirstNameArr;
    private static String[][] SurNameArr;
    private int[][] expensesArr;
    private int size=12;

    public Passenger(){
        FirstNameArr=new String[size][3];
        SurNameArr=new String[size][3];
        expensesArr=new int[size][3];

    }
    public void initialise() {
        for (int i = 0; i < FirstNameArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                FirstNameArr[i][j] = "e";
                SurNameArr[i][j] = "e";
            }
        }
    }
    public void FindCabin() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the name that you want to find :");
        String name = scanner.nextLine().toUpperCase();

        String passenger = "";
        for (int i = 0; i < getFirstNameArr().length; i++) {
            for (int j = 0; j < 3; j++) {

                if (getFirstNameArr()[i][j].equals(name) || getSurNameArr()[i][j].equals(name))
                    passenger += getFirstNameArr()[i][j] + " " + getSurNameArr()[i][j] + " : Cabin No :" + i + " Room No. " + j + " is occupied.\n";
            }
        }
        if (passenger.equals(""))
            System.out.println("Not found.");
        else
            System.out.println(passenger);
    }

    public void PassengersSorting() {
        System.out.println("\n---Passengers---\n");

        int count = 0;  //Counting how many passengers in cabin
        for (String[] strings : getFirstNameArr()) {
            for (int j = 0; j < 3; j++) {
                if (!strings[j].equals("e")) {
                    count++;
                }
            }
        }

        String[] cabinArray = new String[count];  //Adding names to the cabinArray
        count = 0;
        for (int i = 0; i < getFirstNameArr().length; i++) {
            for (int j = 0; j < 3; j++) {
                if (!getFirstNameArr()[i][j].equals("e")) {
                    cabinArray[count] = getFirstNameArr()[i][j] + " " + getSurNameArr()[i][j];
                    count++;
                }
            }
        }
        int n = cabinArray.length;   //Sorting passengers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cabinArray[j].compareTo(cabinArray[i]) < 0) {
                    String extra = cabinArray[j];
                    cabinArray[j] = cabinArray[i];
                    cabinArray[i] = extra;
                }
            }
        }

        for (String s : cabinArray) {   //Display sorting passengers
            if (!s.equals("e")) {
                System.out.println(s);
            }
        }
    }

    public void PassengerExpenses() {

        int tot = 0;
        for (int[] ints : getExpensesArr()) {   //Array to calculate total expenses
            for (int j = 0; j < 3; j++) {
                tot += ints[j];
            }
        }

        System.out.println("Passengers\t\t\t:\tExpenses(Rs.)");

        for (int i = 0; i < getFirstNameArr().length; i++) {  //Array to display passenger name and expenses
            for (int j = 0; j < 3; j++) {
                if (!getFirstNameArr()[i][j].equals("e")) {
                    System.out.println(getFirstNameArr()[i][j] + " " + getSurNameArr()[i][j] + "\t\t\t:\t" + getExpensesArr()[i][j]);
                }
            }
        }
        System.out.println("\nTotal expenses\t\t\t:\tRs." + tot);
    }


    //Creating getters and setters

    public String[][] getFirstNameArr() {
        return FirstNameArr;
    }

    /**
     *
     * @param cabinNum - cabin number
     * @param NumOfPassengers - passengers
     * @param FirstName - first name
     */
    public void setFirstNameArr(int cabinNum,int NumOfPassengers,String FirstName) {
        FirstNameArr[cabinNum][NumOfPassengers] = FirstName;

    }

    /**
     *
     * @return - surname
     */
    public String[][] getSurNameArr() {
        return SurNameArr;
    }

    public void setSurNameArr(int cabinNum,int NumOfPassengers,String surName) {
        SurNameArr[cabinNum][NumOfPassengers] = surName;
    }

    public int[][] getExpensesArr() {
        return expensesArr;
    }

    public void setExpensesArr(int cabinNum,int NumOfPassengers,int expenses) {
        this.expensesArr[cabinNum][NumOfPassengers] = expenses;
    }
}
