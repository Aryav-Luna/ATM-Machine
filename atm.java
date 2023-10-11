// For this code initial balance in the account is 100 Rs.
import java.util.*;
class transaction_history{
    public void history(String[] arr , int n , int balance){
        if(n==0){
            System.out.println("No records found");
            return;
        }
        int i=0;
        while(i<n){
            System.out.println(arr[i]);
            i++;
        }
        System.out.println("your total balance in the account is "+balance);
    }
}
class withdraw{
    Scanner sc = new Scanner(System.in);
    int n=0;
    withdraw(){
        System.out.println("Enter amount you need to withdraw:- ");
        n = sc.nextInt();
    }
    public int decrement(int balance){
        if(n<=balance){
            System.out.println("Withdrawn Successfuly , collect your cash please.");
            return balance-n;
        }
        else{
            System.out.println("Not sufficient balance");
            return balance;
        }
    }
    public void change_d(String[] arr , int i , int balance){
        if(n<=balance){
            arr[i]=(i+1)+"."+" "+n+" Rs debited";
        }
        else{
            arr[i]=(i+1)+"."+" "+n+" Rs debited - FAILED";
        }
    }
}
class deposit{
    Scanner sc = new Scanner(System.in);
    int n=0;
    deposit(){
        System.out.println("Enter amount you need to deposit and place the cash properly:- ");
        n = sc.nextInt();
    }
    public int increment(int balance){
        System.out.println("Money added to your account Successfuly");
        return balance+n;
    }
    public void change_d(String[] arr , int i){
        arr[i]=(i+1)+"."+" "+n+" Rs credited";
    }
}
class fund_transfer{
    Scanner sc = new Scanner(System.in);
    int n=0;
    fund_transfer(){
        System.out.println("Enter amount you need to transfer:- ");
        n = sc.nextInt();
    }
    public int decrement(int balance){
        if(n<=balance){
            System.out.println("Money transferred Successfuly");
            return balance-n;
        }
        else{
            System.out.println("Not sufficient balance to transfer");
            return balance;
        }
    }
    public void change_d(String[] arr , int i , int balance){
        if(n<=balance){
            arr[i]=(i+1)+"."+" "+n+" Rs transferred";
        }
        else{
            arr[i]=(i+1)+"."+" "+n+" Rs transferred - FAILED";
        }
    }
}
class exit{
    exit(){
        System.out.println("Thanks for using the ATM.");
    }
}
class atm{
    static void options1(){
        System.out.println("WELCOME");
        System.out.println("Choose any one function :- ");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Fund Transfer");
        System.out.println("5. Exit");
    }
    public static void main(String[] args){
        // The User id and pin already registered for this programme are 1234 and 5678 respectively.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Id :- ");
        int user_id = sc.nextInt();
        System.out.println("Enter User Id :- ");
        int pin = sc.nextInt();
        // Checking whether entered user id and pin is correct or not. 
        int balance =100;
        String[] arr = new String[9999999];
        if(user_id == 1234 && pin == 5678){
            options1();
            int n = -1;
            int m=0;
            while(n!=5){
                n = sc.nextInt();
                if(n==1){
                    transaction_history t1 = new transaction_history();
                    t1.history(arr , m , balance);
                    options1();
                }
                else if(n==2){
                    withdraw w1 = new withdraw();
                    balance = w1.decrement(balance);
                    w1.change_d(arr,m,balance);
                    m++;
                    options1();
                }
                else if(n==3){
                    deposit d1 = new deposit();
                    balance = d1.increment(balance);
                    d1.change_d(arr,m);
                    m++;
                    options1();
                }
                else if(n==4){
                    fund_transfer f1 = new fund_transfer();
                    balance = f1.decrement(balance);
                    f1.change_d(arr,m,balance);
                    m++;
                    options1();
                }
                else if(n==5){
                    exit e1 = new exit();
                }
                else{
                    System.out.println("Please enter a valid option.");
                    options1();
                }
            }
        }
        else{
            System.out.print("Incorrect user id or pin please check your user id and pin again.");
        }
    }
}
