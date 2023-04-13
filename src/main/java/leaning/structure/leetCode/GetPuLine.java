package leaning.structure.leetCode;

/**
 *
 */
public class GetPuLine {
    public static void main(String[] args) {
        String[] arr = {"afleut", "vflever", "flevar"};
        System.out.println(getPuLine(arr));
    }

    public static String getPuLine(String[] arr) {

        String tmp = "";
        for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (i == arr[j].length() || arr[j].charAt(i) != c) {
                    return arr[0].substring(0, i);
                }
            }
        }
       return arr[0];
    }
}
