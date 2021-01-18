
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

public class test {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashSet<String> set = new HashSet<>();
        int size = input.length();
        StringBuilder str = new StringBuilder();
        
        for (int i=0;i<size;i++){
            for (int j=0;j<4;j++){//حداکثر 4حرفی
                if(i+j<size){//چک کنیم که از سایز کوچک تر باشد
                    str.append(input.charAt(i+j));
                    set.add(str.toString());
                }
            }
            str = new StringBuilder();
        }
        int temp=0;
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
            if(set.contains(sc.next()))
                temp+=1;
        System.out.println(temp);
    }
}