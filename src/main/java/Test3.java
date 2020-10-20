
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {

  final int num=10;
  public void display(){
    int num=12;
    Runnable r=new Runnable() {
      final int num=15;
      @Override
      public void run () {
        int num=20;
        System.out.println(this.num);
      }
    };
    r.run();
  }
  public static void main (String[] args) {
    Test3 t=new Test3();
    t.display();
    List<String> language= Arrays.asList("Python","Java","python");
    Map<String,Integer> lng=language.stream().collect(Collectors.toMap(Function.identity(),String::length));
    System.out.println(language);
  }

  private static int getCount (List<Integer> list) {
    int n=list.size();
    if(n<3)
      return 0;
    int[] leftMax=new int[n];
    int[] rightMax=new int[n];
    int[] leftMin=new int[n];
    int[] rightMin=new int[n];
    int result=0;
    for(int i=1;i<n-1;i++){
      for(int j=0;j<i;j++){
        if(list.get(j)>list.get(i))
          leftMax[i]++;
        if(list.get(j)<list.get(i))
          leftMin[i]++;
      }
    }
    for(int i=1;i<n-1;i++){
      for(int j=n-1;j>i;j--){
        if(list.get(j)>list.get(i))
          rightMax[i]++;
        if(list.get(j)<list.get(i))
          rightMin[i]++;
      }
    }

    for(int i=1;i<n-1;i++){
      if(leftMax[i]!=0&&rightMin[i]!=0)
        result+=leftMax[i]*rightMin[i];
      if(leftMin[i]!=0&&rightMax[i]!=0)
        result+=leftMin[i]*rightMax[i];
    }

    return result;
  }

}
