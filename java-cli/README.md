**Examples of command line programs with java**

*****Apache Commons CLI*****

*mvn exec:java -DmainClass="ar.com.jekipes.apacheCli.CliRandom" -Dexec.args="--min 5 --max 20 -c java.security.SecureRandom -s 123"*

*Picocli*

*mvn -q exec:java -DmainClass="ar.com.jekipes.picocli.CheckSum" -Dexec.args="pom.xml"*

*mvn -q exec:java -DmainClass="ar.com.jekipes.picocli.Login" -Dexec.args="-u=juan -p"*

*mvn -q exec:java -DmainClass="ar.com.jekipes.picocli.git.Git"*