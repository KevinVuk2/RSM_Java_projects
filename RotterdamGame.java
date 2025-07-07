// Enemy class
class Enemy {
    String name;
    int hp;
    int intStat;
    int moneyDrop;

    public Enemy(String name, int hp, int intStat, int moneyDrop) {
        this.name = name;
        this.hp = hp;
        this.intStat = intStat;
        this.moneyDrop = moneyDrop;
    }
}

// Player class
class Player {
    String name;
    int level;
    int intStat;
    int fightsWon;
    int money;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.intStat = 10;
        this.fightsWon = 0;
        this.money = 0;
    }

    public void gainStatsAfterWin() {
        fightsWon++;
        intStat += 2;
        System.out.println("INT has increased by +2, You are getting smarter! INT: " + intStat);
    }

    public void levelUp() {
        if (fightsWon % 20 == 0) {
            level++;
            System.out.println("You have leveled up! Level: " + level);
        }
    }

    public void showStats() {
        System.out.println("Player Stats:");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("INT: " + intStat);
        System.out.println("Fights Won: " + fightsWon);
        System.out.println("Money: " + money);
    }
}

// Combat System
class CombatSystem {
    public static void fightEnemy(Scanner input, Player player, Enemy enemy) {
        System.out.println("A wild " + enemy.name + " appears!");
        
        int playerHp = 100;
        int enemyHp = enemy.hp;
        boolean fled = false;

        while (playerHp > 0 && enemyHp > 0) {
            System.out.println("Your HP: " + playerHp + " | Enemy HP: " + enemyHp);
            System.out.println("Choose action: 1. Attack 2. Defend 3. Flee");
            
            String action = input.nextLine();
            
            if (action.equals("1")) { // Attack
                boolean crit = ((int) (Math.random() * 100)) < 10;
                boolean miss = ((int) (Math.random() * 100)) < 10;
                int damage = player.intStat;
                
                if (crit) {
                    damage *= 2;
                    System.out.println("Critical Hit!");
                } else if (miss) {
                    damage = 0;
                    System.out.println("You missed!");
                }
                enemyHp -= damage;
                System.out.println("You dealt " + damage + " damage.");
            } else if (action.equals("2")) { // Defend
                System.out.println("You defend yourself.");
            } else if (action.equals("3")) { // Flee
                System.out.println("You ran away!");
                fled = true;
                break;
            } else {
                System.out.println("Invalid action, choose a proper action.");
                continue;
            }
            
            if (enemyHp > 0) { // Enemy attacks
                int enemyDamage = enemy.intStat;
                if (action.equals("2")) { // Reduce damage when defending
                    enemyDamage /= 2;
                }
                playerHp -= enemyDamage;
                System.out.println(enemy.name + " hits you for " + enemyDamage + " damage.");
            }
        }

        if (playerHp <= 0) {
            System.out.println("You were defeated. No graduation for you.");
            System.exit(0);
        } else if (!fled) {
            System.out.println("You defeated " + enemy.name + "!");
            player.gainStatsAfterWin();
            player.levelUp();
            player.money += enemy.moneyDrop;
            System.out.println("You earned " + enemy.moneyDrop + " money!");
        }
    }
}

// Enemy Factory
class EnemyFactory {
    public static Enemy getEnemy(String locationName) {
        switch (locationName) {
            case "Central Station": return new Enemy("Angry Commuter", 50, 10, 10);
            case "Beurs": return new Enemy("Lost Tourist", 60, 12, 15);
            case "Erasmus Bridge": return new Enemy("Drunk Student", 70, 15, 20);
            case "Rotterdam Zuid": return new Enemy("Scooter Guy", 80, 18, 25);
            case "Blaak": return new Enemy("Market Vendor", 90, 20, 30);
            case "Oostplein": return new Enemy("Cyclist", 100, 22, 35);
            case "Erasmus University Rotterdam": return new Enemy("Professor Ting Li (Final Boss)", 200, 30, 100);
            default: return new Enemy("Suspicious Stranger", 50, 10, 10);
        }
    }
}