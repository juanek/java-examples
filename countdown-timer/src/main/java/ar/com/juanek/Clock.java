package ar.com.juanek;

import java.util.Date;
public class Clock {
    public static void main(String args[]) {
        System.out.print(new Date());
        while(true){
            try{
                Thread.sleep(1000);
                System.out.print((char)13);
                System.out.print(new Date());
            }catch(Exception e){
                e.printStackTrace();

            }
        }
    }
}
