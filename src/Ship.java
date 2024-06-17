import java.util.Scanner;

public class Ship {
    public static void main(String[] args) {

        Passenger passengerObj=new Passenger();
        passengerObj.initialise();

        Cabin CabinObj=new Cabin();
        Ship shipobj=new Ship();

        shipobj.Menu(passengerObj,CabinObj,shipobj);
    }

    public void Menu(Passenger passengerObj,Cabin CabinObj,Ship shipobj) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t\t---MENU---\n");

        System.out.println("To view our Business details type --- > details ");
        System.out.println();
        System.out.println("Enter A\t:\tTo add a customer to a cabin");
        System.out.println("Enter V\t:\tTo view all cabins");
        System.out.println("Enter E\t:\tTo Empty cabins");
        System.out.println("Enter D\t:\tTo Delete customer from cabin");
        System.out.println("Enter F\t:\tTo Find cabin from customer name");
        System.out.println("Enter S\t:\tTo Store program data into file");
        System.out.println("Enter L\t:\tTo Load program data from file");
        System.out.println("Enter O\t:\tTo View passengers Ordered alphabetically by name.");
        System.out.println("Enter T\t:\tTo View expenses per passenger and total expenses of all passengers. ");

        System.out.print("\nEnter your input  :");
        String cmd = scanner.next().toUpperCase();
        System.out.println();


        switch (cmd) {
            case "A":
                shipobj.AddsCustomerToCabin(passengerObj,CabinObj);
                break;

            case "V":
                System.out.println(CabinObj.ViewAllCabins(passengerObj));
                break;

            case "E":
                CabinObj.emptyCabins();
                break;

            case "D":
                shipobj.DeleteCustomer(passengerObj,CabinObj);
                break;

            case "F":
                passengerObj.FindCabin();
                break;

            case "S":
                CabinObj.StoreProgramData(passengerObj);
                break;

            case "L":
                CabinObj.LoadProgramData();
                break;

            case "O":
                passengerObj.PassengersSorting();
                break;

            case "T":
                passengerObj.PassengerExpenses();
                break;
            case "DETAILS":
                OurDetails.getOurDetails();
                break;

            default:
                System.out.println("Invalid Input.");
        }

        String menuCmd;
        do {
            System.out.print("\n\nIf you want to go to the menu enter \"Y\" or to exit enter \"N\"  :");
            menuCmd = scanner.next().toUpperCase();

            if (menuCmd.equals("Y")) {
                Menu(passengerObj,CabinObj,shipobj);
            } else if (menuCmd.equals("N")) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        } while (!menuCmd.equals("Y"));
    }


    public void AddsCustomerToCabin(Passenger passengerObj,Cabin CabinObj) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("\nEnter cabin number (0-11) or 12 to stop\t:\t");
                int cabinNum = sc.nextInt();

                if (cabinNum == 12) {
                    break;

                } else if (cabinNum > 12 || cabinNum<0) {
                    System.out.println("Invalid Input");
                    continue;
                }

                if (CabinObj.PassengersInCabin[cabinNum] >= 3) {
                    System.out.println("Cabin is already full.");
                }
                else {
                    int Space = 3 - CabinObj.PassengersInCabin[cabinNum];  //counting how many empty rooms in cabin
                    System.out.println("Maximum "+Space+" can be allocate.");

                    System.out.print("How many passengers :");
                    int NOP = sc.nextInt();
                    System.out.println();


                    if (NOP > Space) {
                        System.out.println("Only " + Space + " can stay in cabin No: " + cabinNum + "\n");
                        continue;
                    }

                    if (passengerObj.getFirstNameArr()[cabinNum][CabinObj.PassengersInCabin[cabinNum]].equals("e")) {
                        for (int j = 0; j < NOP; j++) {
                            System.out.println("Cabin No :" + cabinNum + " Room No :" + CabinObj.PassengersInCabin[cabinNum]);

                            System.out.print("Enter First Name\t:\t");
                            String FirstName = sc.next().toUpperCase();
                            passengerObj.setFirstNameArr(cabinNum,CabinObj.PassengersInCabin[cabinNum],FirstName); //Updating the FirstName

                            System.out.print("Enter Surname\t:\t");
                            String SurName = sc.next().toUpperCase();
                            passengerObj.setSurNameArr(cabinNum,CabinObj.PassengersInCabin[cabinNum],SurName);


                            passengerObj.setExpensesArr(cabinNum,CabinObj.PassengersInCabin[cabinNum],1000); //Adding passengers expenses to the passenger clz
                            CabinObj.PassengersInCabin[cabinNum]++;
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }







    public void DeleteCustomer(Passenger passengerObj,Cabin CabinObj) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Enter the cabin number or 12 to stop\t:\t");
                int CabinNum = sc.nextInt();

                if (CabinNum == 12) {
                    break;
                }

                if (CabinNum > 12 || CabinNum<0) {
                    System.out.println("Invalid Input");
                    continue;
                }

                if(CabinObj.PassengersInCabin[CabinNum]==0){
                    System.out.println("Cabin is already empty.");
                }

                else {
                    String passenger = "";

                    if(CabinObj.PassengersInCabin[CabinNum]==0){
                        System.out.println("Cabin is already empty.");
                        continue;
                    }

                    for(int q=0;q<CabinObj.PassengersInCabin[CabinNum];q++){
                        passenger += passengerObj.getFirstNameArr()[CabinNum][q] + " " + passengerObj.getSurNameArr()[CabinNum][q] + "is removed from cabin No: " + CabinNum + "\n";
                        passengerObj.getFirstNameArr()[CabinNum][q] = "e";
                        passengerObj.getFirstNameArr()[CabinNum][q] = "e";
                        passengerObj.setExpensesArr(CabinNum,q,0);

                    }

                    CabinObj.PassengersInCabin[CabinNum]=0;  //Substract 1 from array item.
                    System.out.println(passenger);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
