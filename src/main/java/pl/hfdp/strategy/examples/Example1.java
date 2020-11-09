package pl.hfdp.strategy.examples;

import java.util.*;

class Team {
    // stores the number of players
    int players;
    // stores the number of goals scored by the team
    int goalScored;
    // stores the number of goals scored against the team
    int goalAgainst;

    public Team(int players, int goalScored, int goalAgainst) {
        this.players = players;
        this.goalScored = goalScored;
        this.goalAgainst = goalAgainst;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                ", goalScored=" + goalScored +
                ", goalAgainst=" + goalAgainst +
                '}';
    }
}


class PlayerCountComparator implements Comparator<Team> {
    public int compare(Team t1, Team t2) {
        return Integer.compare(t1.players, t2.players);
    }
}

class GoalDifferenceComparator implements Comparator<Team> {
    public int compare(Team t1, Team t2) {
        return Integer.compare(t1.goalScored - t1.goalAgainst, t2.goalScored - t2.goalAgainst);
    }
}


public class Example1 {
    public static void main(String[] args) {
        Random generator = new Random();
        List<Team> teamList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            Team team = new Team(generator.nextInt() % 10, generator.nextInt() % 10, generator.nextInt() % 10);
            teamList.add(team);
        }

        teamList.sort(new PlayerCountComparator());
        System.out.println(teamList);

        teamList.sort(new GoalDifferenceComparator());
        System.out.println(teamList);
    }
}
