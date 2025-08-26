package ArrayExercises;
public class threearayko {
    public static void main(String[] args) {
        int [] [] traydeyaray = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int leftdia = 0;
        int rightdia = 0;

        for (int i = 0; i < traydeyaray.length; i++){
            leftdia += traydeyaray [i] [i];
        }

        for (int i = 0; i < traydeyaray.length; i++){
            rightdia += traydeyaray[i][traydeyaray.length - 1 - i];
        }

        System.out.println("Top left to Bottom right sum : " + leftdia);
        System.out.println("Top right to bottom left: " + rightdia);
    }
}
// Create a 2D array (3x3) and compute the sum of its diagonal elements