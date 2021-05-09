package ar.com.juanek;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;

/**
 * mvn exec:java -Dexec.mainClass="ar.com.juanek.MyApp"
 */
public class MyApp {


    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter future date (yyyy-MM-dd HH:mm:ss): ");

        String strDate = myObj.nextLine();  // Read user input
        LocalDateTime localDateTime = LocalDateTime.parse(strDate,dateTimeFormatter);
        System.out.println("");



        TaskCountDown taskCountDown = new TaskCountDown(localDateTime);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(taskCountDown, 0, 1000);

        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to quit...");
        input.nextLine();


    }
}
