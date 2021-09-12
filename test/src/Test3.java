import java.util.*;

public class Test3 {
   static HashMap<String,Integer> hashmap = new HashMap<>();
    public static void main(String[] args) {
        String string = new String("Hello word");
        String[] strings = string.split("");
        HashSet set = new HashSet<String>();
        for (int i = 0; i < strings.length; i++) {
            set.add(strings[i]);
        }
        set.remove(" ");
        System.out.println(set);
        Iterator<String> setIter = set.iterator();
        while (setIter.hasNext()){
            String str = setIter.next();
            int sum = 0;
            for(int i = 0; i < strings.length; i++){
                if(strings[i].equals(str)){
                    sum++;
                }
            }
            System.out.println(sum + " " + str);
            hashmap.put(str,sum);
        }
        hashmap.forEach((k,v) -> System.out.println("kay:" + k + " value:" + v));
//      var iter = hashmap.entrySet().iterator();
//      while (iter.hasNext()){
//         System.out.println(iter.next().getValue());
//      }
    }
}
