import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Keypad
{
    private String[][] keys;
    private HashMap<String,List<String>> adjacents  = new HashMap<String, List<String>>();

    // constructor places the keypad into a slightly larger 2d array to enable
    // quicker searching of adjacent keys around each key on the keypad.
    // the 2D keypad is surrounded by blank values.
    Keypad(String[][] keypad){

        //place keys in slightly bigger 2d array
        int keypadWidth = keypad[0].length;
        int keypadDepth = keypad.length;
        keys = new String[keypadDepth+2][keypadWidth+2];

        //iterate through original keypad and place on new layout
        for (int i = 0; i < keys.length; i++) {        
            for (int j = 0; j < keys[i].length; j++) {
                if (i==0 || j==0 || i==keypadDepth+1 || j==keypadWidth+1) {
                    keys[i][j] = "";
                }else {
                    keys[i][j] = keypad[i-1][j-1];
                }
            }
         }

        findAdjacent();
    }

    // creates lists of characters that are adjacent to the keypad character
    // uses the keypad character as a key in the adjacents hashmap.
    // This means that the keypad searches for each key only need to be done once.
    private void findAdjacent(){
        for (int row = 1; row < keys.length-1; row++) { 
            for (int col = 1; col < keys[row].length-1; col++) { 
                List<String> listAdjacent = new ArrayList<String>();
                listAdjacent.add(keys[row-1][col-1]);
                listAdjacent.add(keys[row-1][col]);
                listAdjacent.add(keys[row-1][col+1]);
                listAdjacent.add(keys[row][col-1]);
                listAdjacent.add(keys[row][col+1]);
                listAdjacent.add(keys[row+1][col-1]);
                listAdjacent.add(keys[row+1][col]);
                listAdjacent.add(keys[row+1][col+1]);
                listAdjacent.add(keys[row][col]);
                adjacents.put(keys[row][col],listAdjacent);
            } 
        }
    }

    // Checks if two characters are adjacent by looking up the lists of adjacent
    // characters associated with the character key
    private boolean checkAdjacent(String s1,String s2){
        if(adjacents.get(s1).contains(s2)) {
            return true;
        }
        return false;
    }

    // Checks if consecutive pairs of characters are adjacent on the keypad
    public boolean checkEasyNumber(String s) {
        //strip out all the non-valid characters
        s = s.replaceAll("\\s+","");
        for(int i=0;i<s.length()-1;i++){            
            if(!checkAdjacent(Character.toString(s.charAt(i)),Character.toString(s.charAt(i+1)))) {
                return false;
            }
        }

        return true;
    }
}