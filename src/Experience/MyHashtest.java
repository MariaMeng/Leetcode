package Experience;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by apple on 16/12/28.
 */
public class MyHashtest {
    //int[] nums=new int[]{24,35,44,24,28,14,3,7,9};
    Map<Integer,Integer> myMap=new HashMap<>();
    public void setMap(int[] num){
        for(int i=0;i<num.length;i++){
            myMap.put(num[i],i);
        }
    }
    public void getMap(){
        //me是存放hashmap中取出的内容，并用Map.Entry<Integer, String> 指定其泛型
        /*
        for(Map.Entry<Integer, Integer> me: myMap.entrySet()) {
            //System.out.println(me.getKey() + "-->" + me.getKey());
            System.out.println(me.toString());
        }
        Set<Map.Entry<Integer, Integer>> mapEntries = myMap.entrySet();
        */
        Iterator it = myMap.values().iterator();
        do{
            System.out.println(it.next());
        }while(it.hasNext());

    }

    public static void main(String[] args){
        int[] nums=new int[]{24,35,44,24,28,14,3,7,9};
        MyHashtest mytest=new MyHashtest();
        mytest.setMap(nums);
        mytest.getMap();
    }

}
