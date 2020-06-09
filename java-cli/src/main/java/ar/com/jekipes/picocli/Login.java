package ar.com.jekipes.picocli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.Callable;

/**
 * mvn -q exec:java -DmainClass="ar.com.jekipes.picocli.Login" -Dexec.args="-h"
 *
 * mvn -q exec:java -DmainClass="ar.com.jekipes.picocli.Login" -Dexec.args="-u=juan -p"
 */

@Command(name = "login", mixinStandardHelpOptions = true, version = "login 1.0",
        description = "Encode password.")
public class Login implements Callable<Integer> {

    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    char[] password;

    @Override
    public Integer call() throws Exception {
        byte[] bytes = new byte[password.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) password[i];
        }

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);

        System.out.printf("Hi %s, your password is hashed to %s.%n", user, base64(md.digest()));

        // null out the arrays when done
        Arrays.fill(bytes, (byte) 0);
        Arrays.fill(password, ' ');
        return 0;
    }

    private String base64(byte[] arr) {
        return Base64.getEncoder().encodeToString(arr);
    }

    public static void main(String[] args) {
        System.out.println(args);
        int exitCode = -1;
        if(args.length == 0){
            exitCode = new CommandLine(new Login()).execute("-h");
        }else{
            exitCode = new CommandLine(new Login()).execute(args);
        }
        //int exitCode = new CommandLine(new Login()).execute("-u", "user123", "-p");
        System.exit(exitCode);
    }
}
