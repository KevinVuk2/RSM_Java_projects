
package AssignmentProject;

import java.util.*;

public class Location {
    private String name;
    private String context;
    private List<String> enemies;
    private List<Location> nextLocations;

    public Location(String name, String context) {
        this.name = name;
        this.context = context;
        this.enemies = new ArrayList<>();
        this.nextLocations = new ArrayList<>();
    }

    public void addEnemy(String enemy) {
        enemies.add(enemy);
    }

    public void addNextLocation(Location location) {
        nextLocations.add(location);
    }

    public void displayLocationInfo() {
        System.out.println("\n📍 Location: " + name);
        System.out.println("📖 Context: " + context);
        System.out.println("⚔️ Enemies: " + (enemies.isEmpty() ? "None" : enemies));
        if (!nextLocations.isEmpty()) {
            System.out.println("➡️ Next possible destinations:");
            for (int i = 0; i < nextLocations.size(); i++) {
                System.out.println((i + 1) + ". " + nextLocations.get(i).name);
            }
        }
    }

    public List<Location> getNextLocations() {
        return nextLocations;
    }

    public String getName() {
        return name;
    }
}
