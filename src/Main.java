import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boxes = 3;
        double[] possiblePlaces = new double[boxes];
        int[] boxesWeight = new int [boxes];
        int realWeight = 713;
        int wrongCounter = 0;
        int rightCounter = 0;

        ArrayList<Integer> realPlaces = new ArrayList<>();
        adding(realPlaces);
        Collections.shuffle(realPlaces);


        for(int i = 0; i < boxes; i++){


            possiblePlaces[i] = scanner.nextInt();
            System.out.println(realPlaces.get(i));

            boxesWeight[i] = (int)(Math.random()*10);

            if(possiblePlaces[i] == realPlaces.get(i)){
                rightCounter++;
                int weight = 0;
                if(rightCounter == 3){
                    for(int in = 0; in < boxes; in++){
                        weight += boxesWeight[i];
                    }
                    if(weight == realWeight){
                        System.out.println("You found all boxes");
                    }
                    else{
                        System.out.println("You found all locations. But their weight are not 713. Try again!!!");
                    }
                }

            }
            else{
                if(realPlaces.get(i) != possiblePlaces[i]){
                    wrongCounter++;
                }
            }
            if(i == 2 && wrongCounter > 0){
                i-=3;
                if(rightCounter == 1){
                    System.out.println("You find correctly " + rightCounter + " box.Try again!");
                }else{
                    System.out.println("You find correctly " + rightCounter + " boxes.Try again!");
                }
                rightCounter = 0;
                Collections.shuffle(realPlaces);

            }
        }
    }
    public static void adding(ArrayList<Integer>realPlaces){
        for (int i = 1; i <= 7; i++) {
            realPlaces.add(i);
        }
    }
}