package StringUtils;

public class StringPrograms {
  static final int NO_OF_CHARS = 256;
  static char count[] = new char[NO_OF_CHARS];

  public void MaxOccuringChar(String str){

  }

  public static String reverse(String str){

    return str;
  }

  public static boolean CheckAnagrams(String s1,String s2){
   if(s1.length()!=s2.length())
     return false;
   int count1[]=new int[NO_OF_CHARS];
    for (int i = 0; i < s1.length();  i++)
      count1[s1.charAt(i)]++;
    for (int i=0;i<s2.length();i++){
      count1[s2.charAt((i))]--;
      if(count1[s2.charAt((i))]<0){
        return false;
      }
    }

    return true;
  }

  public static String removeDup(String str){

    char[] ch=str.toCharArray();
    int k=0;
    int counter=0;
    for(int i=0;i<str.length();i++){
      int bit=str.charAt(i)-'a';
      if((counter&(1<<bit))==0){
        ch[k++]=str.charAt(i);
      }
      counter=counter|(1<<bit);
    }

    str=String.valueOf(ch);
    str=str.substring(0,k);

    return str;
  }

  public static void  printDuplicate(String str){
    int counter=0;
    for(int i=0;i<str.length();i++){
      int bit=str.charAt(i)-'a';
      if((counter&(1<<bit))>0){
        System.out.println(str.charAt(i));
      }
      counter=counter|(1<<bit);
    }
  }

  public static int longStrWithOutRepChar(String str){
    int n = str.length();
    int cur_len = 1; // length of current substring
    int max_len = 1; // result
    int prev_index; // previous index
    int i;
    int visited[] = new int[NO_OF_CHARS];

    for (i = 0; i < NO_OF_CHARS; i++) {
      visited[i] = -1;
    }
    visited[str.charAt(0)] = 0;
    for (i = 1; i < n; i++) {
      prev_index = visited[str.charAt(i)];
      /* If the current character is not present in
           the already processed substring or it is not
              part of the current NRCS, then do cur_len++ */
      if (prev_index == -1 || i - cur_len > prev_index)
        cur_len++;
      /* If the current character is present in currently
               considered NRCS, then update NRCS to start from
               the next character of the previous instance. */
      else {
        /* Also, when we are changing the NRCS, we
                   should also check whether length of the
                   previous NRCS was greater than max_len or
                   not.*/
        if (cur_len > max_len)
          max_len = cur_len;

        cur_len = i - prev_index;
      }
      visited[str.charAt(i)] = i;
    }
    if (cur_len > max_len)
      max_len = cur_len;

    return max_len;


  }

}
