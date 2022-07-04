import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {

        String[][] layout = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
        Keypad k = new Keypad(layout);

         // Enter data using BufferReader
         BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        while(true){
            // Reading data using readLine
            System.out.println("Enter a number");
            String number = reader.readLine();
            
            if(k.checkEasyNumber(number)){
                System.out.println(number + " is easy to dial");
            }else {
                System.out.println(number + "is NOT easy to dial");
            }
        }
    }
}
