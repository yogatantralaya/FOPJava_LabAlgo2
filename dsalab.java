import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class Main {

    Scanner sc = new Scanner(System.in);

    //pay money method
    public void payMoney(ArrayList<Integer> arrayOne){
        int targetValue=0;
        int sum;
        boolean targetAchieved;
        System.out.println("Enter the total no. of targets that need to be achieved:");
        int numTargets = sc.nextInt();
        for(int i=0; i<numTargets; i++){
            System.out.println("Enter the value of target:");
            targetValue = sc.nextInt();
            sum=0;
            targetAchieved = false;
            for(int j=0; j<arrayOne.size(); j++){
                sum += arrayOne.get(j);
                if(targetValue<=sum){
                    System.out.println("Target achieved after " + (j+1) + " transactions");
                    targetAchieved = true;
                    break;
                }
            }
            if(!targetAchieved){
                System.out.println("Given target is not achieved");
            }
        }
    }

    //currency denomination method
    public void currencyDenominations(ArrayList<Integer> arrayTwo) {
        int amount = 0;
        int rem = 0;
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the amount you want to pay:");
        amount = sc.nextInt();
        rem = amount;
        for (int k = 0; k < arrayTwo.size(); k++) {
            while (rem >= arrayTwo.get(k)) {
                rem -= arrayTwo.get(k);
                if (map.containsKey(arrayTwo.get(k))) {
                    map.put(arrayTwo.get(k), map.get(arrayTwo.get(k)) + 1);
                } else {
                    map.put(arrayTwo.get(k), 1);
                }
            }
            if(rem==0){
                break;
            }
        }
        if (rem==0) {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (Map.Entry val : map.entrySet()) {
                System.out.println(val.getKey() + ":" + val.getValue());
            }
        }
        else{
            System.out.println("Invalid inputs!");
        }
    }

    //main method
    public static void main(String[] args) {

        Main obj = new Main();
        int size=0;
        Scanner sc = new Scanner(System.in);
        int value=0;
        //transaction Problem
        System.out.println("Enter the size of the array:");
        size = sc.nextInt();
        ArrayList<Integer> arrayOne = new ArrayList<>();
        System.out.println("Enter the value(s) of the array:");
        for(int i=0; i<size; i++){
            value = sc.nextInt();
            arrayOne.add(value);
        }
        obj.payMoney(arrayOne);
        //currency denomination problem
        System.out.println("Enter the size of the currency denomination:");
        size = sc.nextInt();
        ArrayList<Integer> arrayTwo=new ArrayList<Integer>();
        System.out.println("Enter the currency denomination value(s)");
        for(int j=0; j<size; j++) {
            value = sc.nextInt();
            arrayTwo.add(j, value);
        }
        arrayTwo.sort(Comparator.reverseOrder());
        obj.currencyDenominations(arrayTwo);

    }
}
