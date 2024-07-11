
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class UlamNumbers {
    public static void main(String[] args) {
        List<Integer> ulam = new ArrayList<>(Arrays.asList(1,2,3,4));

        // while (ulam.size() <= 50) {
            for(int i = 0; i < ulam.size()-1; i++){
                for(int j = ulam.size()-2; j > 1; j--){
                    for(int p = 1; p < ulam.size()-2; p++){
                        System.out.println("i: "+ulam.get(i)+" i: "+ulam.get(j)+" p: "+ulam.get(p));
                    }
                }
            }
        // }

    }
}
