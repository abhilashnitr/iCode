package main.LeetCode.Easy.April27;


import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    if(s.length()==0)
      return true;
    if(s.length()==1)
      return false;

    Stack<Character> st=new Stack();

    for(int i=0;i<s.length();i++)
    {
      char c=s.charAt(i);
      if(c=='('||c=='['||c=='{')
        st.push(c);
      if(c==')'||c==']'||c=='}'){

        if(st.isEmpty())
          return false;
        else if ( !isMatchingPair(st.pop(), c) )
        {
          return false;
        }
      }
    }
    return st.isEmpty();

  }

  public boolean isMatchingPair(char character1, char character2)
  {
    if (character1 == '(' && character2 == ')')
      return true;
    else if (character1 == '{' && character2 == '}')
      return true;
    else if (character1 == '[' && character2 == ']')
      return true;
    else
      return false;
  }


}
