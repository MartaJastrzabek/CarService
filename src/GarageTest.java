import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GarageTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Vehicle> carsToCheck = new LinkedList<>();

        System.out.println(printMenu());
        try {
            int input = in.nextInt();
            in.nextLine();
            Vehicle vehicle;

            while (input!=0) {
                if(input == 1){
                    vehicle = addNewVehicle(in);
                    carsToCheck.offer(vehicle);
                } else if(input == 2){
                    checkVehicle(carsToCheck);
                } else {
                    System.out.println("Nieprawidłowy numer");
                }
                System.out.println(printMenu());
                input = in.nextInt();
                in.nextLine();
            }
        } catch (InputMismatchException e){
            System.out.println("Błędny format");
        } catch (NullPointerException e){
            System.out.println("Kolejka jest pusta");
        }
        in.close();
    }

    private static void checkVehicle(Queue<Vehicle> carsToCheck) {
        Vehicle vehicle = carsToCheck.peek();
        System.out.println(vehicle.toString() + "w trakcie przeglądu");
        vehicle = carsToCheck.poll();
        System.out.println(vehicle.toString() + "przegląd zakończony");
    }

    private static Vehicle addNewVehicle(Scanner in) {
        System.out.println("Podaj typ, markę, model, rocznik, przebieg i nr VIN pojazdu:");
        String typ = in.nextLine();
        String manufacturer = in.nextLine();
        String model = in.nextLine();
        int year = in.nextInt();
        in.nextLine();
        int mileage = in.nextInt();
        in.nextLine();
        String vinNumber = in.nextLine();

        return new Vehicle(typ, manufacturer, model, year, mileage, vinNumber);
    }

    private static String printMenu() {
        return "Menu - wcisnij odpowiednią cyfrę:\n" +
                "0, aby zakończyć działanie programu\n" +
                "1, aby dodać nowy pojazd do kolejki\n" +
                "2, aby dokonać przeglądu pierwszego pojazdu z kolejki";
    }


}
