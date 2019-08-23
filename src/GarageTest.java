import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GarageTest {
    public static void main(String[] args) {
        File file = new File("saved queue.csv");
        System.out.println(printMenu());

        try (Scanner in = new Scanner(System.in)) {
            Queue<Vehicle> carsToCheck = restoreQueueFromFile(file);
            System.out.println("Samochodów oczekujących na przegląd: " + carsToCheck.size());
            int input = in.nextInt();
            in.nextLine();

            while (input != 0) {
                if (input == 1) {
                    System.out.println("Podaj typ, markę, model, rocznik, przebieg i nr VIN pojazdu: (oddzielone przecinkiem)");
                    String vehicleInput = in.nextLine();
                    carsToCheck.offer(createNewVehicle(vehicleInput));
                } else if (input == 2) {
                    if (carsToCheck.isEmpty()) {
                        System.out.println("Kolejka jest pusta");
                    } else {
                        checkVehicle(carsToCheck);
                    }
                } else {
                    System.out.println("Nieprawidłowy numer");
                }
                System.out.println(printMenu());
                input = in.nextInt();
                in.nextLine();
            }

            saveToFile(carsToCheck, file);

        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Błędny format");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Queue<Vehicle> restoreQueueFromFile(File file) throws IOException {
        Queue<Vehicle> carsToCheck = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        Vehicle vehicle;
        while ((line = br.readLine()) != null) {
            vehicle = createNewVehicle(line);
            carsToCheck.offer(vehicle);
        }
        br.close();
        return carsToCheck;
    }

    private static Vehicle createNewVehicle(String input) {
        String[] split = input.split(",");

        return new Vehicle(split[0], split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5]);
    }

    private static void saveToFile(Queue<Vehicle> carsToCheck, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Vehicle v : carsToCheck) {
            bw.write(v.getType() + "," + v.getManufacturer() + "," + v.getModel()
                    + "," + v.getYear() + "," + v.getMileage() + "," + v.getVinNumber());
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }

    private static void checkVehicle(Queue<Vehicle> carsToCheck) {
        Vehicle vehicle = carsToCheck.peek();
        System.out.println(vehicle.toString() + "w trakcie przeglądu");
        vehicle = carsToCheck.poll();
        System.out.println(vehicle.toString() + "przegląd zakończony");
    }

    private static String printMenu() {
        return "Menu - wcisnij odpowiednią cyfrę:\n" +
                "0, aby zakończyć działanie programu\n" +
                "1, aby dodać nowy pojazd do kolejki\n" +
                "2, aby dokonać przeglądu pierwszego pojazdu z kolejki";
    }


}
