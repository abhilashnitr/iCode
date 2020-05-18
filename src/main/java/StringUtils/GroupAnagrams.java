package StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

  //fucntion to generate the key
  public String genKey(String str){

    char[] arr = str.toCharArray();

    //sort the letters
    Arrays.sort(arr);

    //return the key
    return new String(arr);
  }

  public List<List<String>> groupAnagrams(String[] strs) {

    //initialise the result
    List<List<String>> result = new ArrayList<>();

    //if the input array is empty return result
    if(strs.length == 0)
      return result;

    //create a hashmap to map a key with the set of anagrams which correspond to the key
    HashMap<String,List<String>> map = new HashMap<>();

    //traverse the array String by String
    for(int i=0; i< strs.length; i++){

      //generate the key for current String
      String key = genKey(strs[i]);

      //if the key is not present in the map, create a new list to store anagrams corresponding to this new key
      if(!map.containsKey(key)){
        map.put(key,new ArrayList<String>());
      }

      //add the word in the list of its anagrams
      map.get(key).add(strs[i]);
    }

    //add all lists of anagrams into the result list
    result.addAll(map.values());

    //return result
    return result;
  }


}
