package GUI.Projekt1_NEW;

import java.util.*;

public class Train  extends Thread{
    String lastStation;
    String firstStation;

    final String name;
    String currentStation;
    String finalStation;

    public Train(String name){
        this.name = name;
    }


    public void addFirstStation(String station){

        firstStation = station;
    }
    public void addLastStation(String station){
        lastStation = station;

    }
    public synchronized void run(){

        try {
            travel();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void travel() throws InterruptedException {

        finalStation = lastStation;
        currentStation = firstStation;
        Queue<String> queue = new LinkedList<>(Station.getConnection(firstStation));
        Set<String> visited = new HashSet<>();

        Map<String,String> prev = new HashMap<>();
        List<String> reversePath = new ArrayList<>();

        queue.add(currentStation);
        visited.add(currentStation);
        while(!queue.isEmpty()){

            currentStation = queue.poll();
            visited.add(currentStation);

            if (currentStation.equals(finalStation)){

                while (currentStation != null) {
                    reversePath.add(currentStation);
                    currentStation = prev.get(currentStation);
                }

                Collections.reverse(reversePath);
                for (String station : reversePath) {
                    Thread.sleep(2000);
                    System.out.println("pociag " +name+" przyjechal do "+station);
                }

                System.out.println("pociag "+ name+" dojechal do "+ finalStation +" z "+firstStation);


                Thread.sleep(10000);
                String change = finalStation;
                lastStation = firstStation;
                firstStation = change;
                travel();
            }

            for (String nextStation : Station.getConnection(currentStation)) {

                if (!visited.contains(nextStation)) {
                    visited.add(nextStation);
                    queue.add(nextStation);
                    prev.put(nextStation, currentStation);
                }
            }
        }
    }






}
