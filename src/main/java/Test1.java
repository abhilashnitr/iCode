public class Test1 {

  public static void main(String[] args) {
    int numberOfIngredients=4;
    int maxval=(numberOfIngredients%3==0)?(int) Math.round(numberOfIngredients*0.6):(int) Math.round(numberOfIngredients*0.6)+1;

    System.out.println(maxval);
  }
}
