package GUI.Projekt1_NEW;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Station.createStations();




        Train train1 = new Train("feniks");
        train1.addFirstStation("Warszawa");
        train1.addLastStation("Koszalin");
        train1.start();



        Train train2 = new Train("panda");
        train2.addFirstStation("Police");
        train2.addLastStation("Koło");
        train2.start();

        Train train3 = new Train("lew");
        train3.addFirstStation("Katowice");
        train3.addLastStation("Krosno");
        train3.start();
    }
}
