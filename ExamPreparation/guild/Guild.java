package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> players=new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                players.add(player);
            }
        }
        for (Player player : players) {
            roster.remove(player);
        }
        Player [] kickedPlayers=new Player[players.size()];
        for (int i = 0; i <players.size() ; i++) {
            kickedPlayers[i]=players.get(i);
        }
        return kickedPlayers;
    }

    public int count () {
        return this.roster.size();
    }

    public String report () {
        StringBuilder sb=new StringBuilder();
        sb.append("Players in the guild: "+this.name+":").append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
