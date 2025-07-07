
package AssignmentProject;

import java.util.*;

public class RotterdamGameMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Location centralStation = new Location("Central Station", "Context 1");
        centralStation.addEnemy("Enemy 1");

        Location beurs = new Location("Beurs", "Context 2");
        beurs.addEnemy("Enemy 2");

        Location erasmusBridge = new Location("Erasmus Bridge", "Context 3");
        erasmusBridge.addEnemy("Enemy 3");

        Location rotterdamZuid = new Location("Rotterdam Zuid", "Context 4");
        rotterdamZuid.addEnemy("Enemy 4");

        Location blaak = new Location("Blaak", "Context 5");
        blaak.addEnemy("Enemy 5");

        Location oostplein = new Location("Oostplein", "Context 6");
        oostplein.addEnemy("Enemy 6");

        Location eur = new Location("Erasmus University Rotterdam", "Context 7");
        eur.addEnemy("Enemy 7");

        centralStation.addNextLocation(beurs);
        beurs.addNextLocation(erasmusBridge);
        beurs.addNextLocation(blaak);
        erasmusBridge.addNextLocation(rotterdamZuid);
        rotterdamZuid.addNextLocation(eur);
        blaak.addNextLocation(oostplein);
        oostplein.addNextLocation(eur);

        Location currentLocation = centralStation;
        while (true) {
            currentLocation.displayLocationInfo();
            List<Location> nextLocations = currentLocation.getNextLocations();

            if (nextLocations.isEmpty()) {
                System.out.println("\n🎓 You have reached Erasmus University Rotterdam. Congratulations!");
                break;
            }

            int choice = -1;
            while (choice < 1 || choice > nextLocations.size()) {
                System.out.print("Choose your next destination (enter number): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > nextLocations.size()) {
                        System.out.println("❌ Invalid choice. Try again.");
                    }
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.next(); // consume invalid input
                }
            }

            currentLocation = nextLocations.get(choice - 1);
        }

        scanner.close();
    }
}
