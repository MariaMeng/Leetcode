package Experience;

import java.util.*;

/**
 * Created by apple on 17/3/6.
 */
public class TestList {
    public static final int N=50000;

    public static List values;

    static {
        Integer vals[]=new Integer[N];

        Random r=new Random();

        for(int i=0,currval=0;i<N;i++) {
            vals[i]=new Integer(currval);
            currval+=r.nextInt(100)+1;
        }

        values= Arrays.asList(vals);
    }

    static long timeList(List lst) {
        long start=System.currentTimeMillis();
        for(int i=0;i<N;i++) {
            int index= Collections.binarySearch(lst, values.get(i));
            if(index!=i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis()-start;
    }
    public static void main(String args[]){
        //System.out.println("ArrayList消耗时间："+timeList(new ArrayList(values)));
        //System.out.println("LinkedList消耗时间："+timeList(new LinkedList(values)));

        Hashtable<String, Integer> table = new Hashtable<>();
        int[] nums = {1, 2, 3};

        Collections.sort(new ArrayList<Integer>());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 1);
        map.put("a", 2);
        map.put("d", 5);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return o1.getValue().compareTo(o2.getValue());
           }
        });
        System.out.println(entryList);



        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("aa");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        System.out.println();
        //采用Collections.sort对ListJingxing paixu
        List<String> myList = new ArrayList<>();
        myList.add("string");
        myList.add("String");
        myList.add("aa");
        myList.add("bbbbb");
        for (String str : myList)
            System.out.println(str);

        System.out.println();
        System.out.println("Sort");
        Collections.sort(myList);
        for (String st : myList)
            System.out.println(st);

        System.out.println();
        System.out.println("Suffle:");

        Collections.shuffle(myList);
        for (String st : myList)
            System.out.println(st);

        Thread myThread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("myThread2");
                }catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        myThread2.start();
        try {
            Thread.sleep(8000);
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("start");

        try {
            Thread.sleep(8000);
        }catch(Exception e) {
            System.out.println(e);
        }

        System.out.println("balabala");

        try {
            myThread2.join();
        }catch(InterruptedException e) {
            System.out.println(e);
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        Hashtable<String, Integer> Atable = new Hashtable<>();
    }
}
