public class CircularQueue {
    String[] myQueue;
    int front, end;
    int size = 5;
    String[] waitingListFirst;
    String[] waitingListSurname;
    int waitingListcounter;  //to count passengers in waiting list

    public CircularQueue() {
        waitingListFirst = new String[size];
        waitingListSurname =new String[size];
        myQueue = new String[size];
        front = 0;
        end = 0;
        waitingListcounter=0;
    }

    public void enQueue(String Firstname,String Surname){

        int counter1 = 0;

        for (int x = 0; x < size; x++){
            if (!(myQueue[x].equals("e"))){
                counter1++;
            }
        }
        if(counter1 == size){
            System.out.println("Queue is full");
        }
        else{
            myQueue[end]=Firstname+" "+Surname;
            waitingListFirst[end]=Firstname;
            waitingListSurname[end]=Surname;
            System.out.println(myQueue[end]+"  has been enqueued.");
            end = end + 1;
        }
        if(end == size) {
            end = 0;
        }
    }


    public String[] deQueueFirst(){
        String[] mzg =new String[2];

        int counter1 = 0;
        for (int x = 0; x < size; x++){
            if ((myQueue[x].equals("e"))){
                counter1++;
            }
        }
        if(counter1 == size){
            mzg[0]="Queue is empty";
            mzg[1]="Queue is empty";
        }
        else {
            mzg[0]=waitingListFirst[front];
            mzg[1]=waitingListSurname[front];
            myQueue[front] = "e";
            waitingListFirst[front]="e";
            waitingListSurname[front]="e";
            front = front + 1;
        }
        if(front == size){
            front = 0;
        }
        return mzg;
    }


    public void initialiseQueue() {
        for (int x = 0; x < size; x++) myQueue[x] = "e";
        for (int x = 0; x < size; x++) waitingListFirst[x] = "e";
        for (int x = 0; x < size; x++) waitingListSurname[x] = "e";
        System.out.println("initialise ");
    }
}
