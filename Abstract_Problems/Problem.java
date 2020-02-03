import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Problem {

   public static void main (String [] args) throws Exception{
       File file = new File ("E:/TestFile.txt");
       BufferedReader br = new BufferedReader(new FileReader(file));
       String st;
       int run = 0;
       String [] names;
       List<String> l1 = new ArrayList<String>();
       List<String> batsmen = new ArrayList<String>();
       List<String> l3 = new ArrayList<String>();
       List<Integer> runs = new ArrayList<Integer>();
       while((st =br.readLine())!=null){
           l1.add(st);
       }
       for(int i=0; i<l1.size(); i++){
        names = l1.get(i).split(" ");
        String fullname = names[0] +" "+ names[1];  
        if(names[2].contains("*")){
            fullname = fullname + " NOT OUT";
            run = Integer.parseInt(names[2].substring(0,names[2].length()-1));
        }
        else{
            run = Integer.parseInt(names[2]);
        }
        batsmen.add(fullname);
        l3.add(names[2]);
        runs.add(run);
       }
       int maxRunsIndex1= runs.indexOf(Collections.max(runs));
       int secondMax =0;
       if(batsmen.get(maxRunsIndex1).contains(" NOT OUT")){
           System.out.println("Maximum Not Out runs");
           System.out.println(batsmen.get(maxRunsIndex1).substring(0, batsmen.get(maxRunsIndex1).length()-8));
           System.out.println(runs.get(maxRunsIndex1));
           for(int i=0; i<batsmen.size(); i++){
               if(!batsmen.get(i).contains(" NOT OUT")){
                   if(runs.get(i)>secondMax){
                       secondMax = runs.get(i);
                   }
               }
           }
           System.out.println("Maximum Out runs");
           System.out.println(batsmen.get(runs.indexOf(secondMax)));
           System.out.println(runs.get(runs.indexOf(secondMax)));
       }
       else{
           System.out.println("Maximum Out runs");
           System.out.println(batsmen.get(maxRunsIndex1));
           System.out.println(runs.get(maxRunsIndex1));
           for(int i=0; i<batsmen.size(); i++){
               if(batsmen.get(i).contains(" NOT OUT")){
                   if(runs.get(i)>secondMax){
                       secondMax = runs.get(i);
                   }
               }
           }
           System.out.println("Maximum Not Out runs");
           System.out.println(batsmen.get(runs.indexOf(secondMax)).substring(0, batsmen.get(runs.indexOf(secondMax)).length()-8));
           System.out.println(runs.get(runs.indexOf(secondMax)));
       }
   } 
}
