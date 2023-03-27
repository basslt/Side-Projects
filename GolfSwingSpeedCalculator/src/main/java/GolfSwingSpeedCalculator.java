import java.util.Scanner;




public class GolfSwingSpeedCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the distance in yards of your golf shot: ");
        double distance = input.nextDouble();

        System.out.println("Enter the time in seconds for your golf ball to land:");
        double time = input.nextDouble();

        double swingSpeed = (distance / time) * 2.237;
        System.out.printf("Your Swingspeed was %.1f mph", swingSpeed);
    }

}

