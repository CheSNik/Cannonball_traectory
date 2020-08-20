import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Lab 3 P6.15
 * @author Sergei Chekhonin
 * This program simulates cannonball traectory
 */

public class Main {
    /**
     * Delta T constant
     */
    public static final double DELTA_T = 0.01;
    /**
     * Gravity constant
     */
    public static final double GRAVITY_CONST = 9.81;

    public static void main(String[] args) {
        //This block initialize printWriter and dateFormatter
        PrintWriter out = null;
        try {
            out = new PrintWriter("Lab3_P6.15output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        final JFrame frame = new JFrame();

        //declare variables
        /**
         * variables to store Position according to Book calculus and simulation, time, velocity
         */
        double formulaS=0.0, simulatedS=0.0, time=DELTA_T, velocity;
        double startV = 100.0;
        velocity = startV;
        int count=1;

        //printout data
        out.println(dtf.format(now));
        out.println("Cannonball simulation");
        out.println("Book formula:   |    Sumulation: ");
        out.println("S(t):           |    Ssim(t):    ");
        out.println("    0.00        |      0.00    ");

        //computational loop
        while (velocity>0){
            formulaS = -0.5*GRAVITY_CONST*Math.pow(time,2) + startV*time;
            velocity=velocity-DELTA_T*GRAVITY_CONST;
            simulatedS = simulatedS + velocity*DELTA_T;

            time=time+DELTA_T;
            count++;
            if (count%100==0)
                out.printf("%8.2f        |    %6.2f     \n", formulaS, simulatedS);

        }

        out.close();
        //System.exit(0);

    }
}
