package GUI.Projekt1_NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Station {
    public static String [] cities = {
            "Warszawa", "Kraków", "Łódź", "Wrocław", "Poznań", "Gdańsk", "Szczecin", "Bydgoszcz",
            "Lublin", "Katowice", "Białystok", "Gdynia", "Częstochowa", "Radom", "Sosnowiec", "Toruń",
            "Kielce", "Rzeszów", "Gliwice", "Zabrze", "Olsztyn", "Bielsko-Biała", "Ruda Śląska",
            "Tychy", "Gorzów Wielkopolski", "Elbląg", "Płock", "Opole", "Kalisz", "Koszalin", "Legnica",
            "Słupsk", "Jastrzębie-Zdrój", "Przemyśl", "Dąbrowa Górnicza", "Mielec", "Tarnów", "Chorzów",
            "Nowy Sącz", "Ełk", "Świętochłowice", "Jarosław", "Zamość", "Kędzierzyn-Koźle", "Będzin",
            "Suwałki", "Piła", "Tarnowskie Góry", "Sandomierz", "Krotoszyn", "Kołobrzeg", "Kościerzyna",
            "Świdnica", "Biała Podlaska", "Ostrołęka", "Ostrów Wielkopolski", "Bolesławiec", "Lębork",
            "Zgorzelec", "Zduńska Wola", "Ostróda", "Police", "Mysłowice", "Ciechanów", "Pleszew", "Krapkowice",
            "Piekary Śląskie", "Włocławek", "Kętrzyn", "Namysłów", "Mińsk Mazowiecki", "Tomaszów Lubelski",
            "Żary", "Koło", "Wodzisław Śląski", "Sieradz", "Goleniów", "Chrzanów", "Jaworzno", "Oława",
            "Śrem", "Kłodzko", "Mikołów", "Ropczyce", "Kwidzyn", "Sulejów", "Skierniewice", "Żyrardów",
            "Otwock", "Ząbki", "Świecie", "Poddębice", "Kartuzy", "Bartoszyce", "Lubin", "Trzebinia","Ciechanów",
            "Dębów","Krosno","Starachowice"
    };
    String name;
    public Station(String name){
        this.name = name;
    }
    public static HashMap<String, List<String>> stations = new HashMap<>();
    public static void createStations(){

        for (String city:cities){
            stations.put(city,new ArrayList<String>());
        }
        connectStations();




    }

    private static void connectStations() {

        for (String city : cities) {
            int connectCount = (int) (Math.random() * 5 + 1);
            for (int j = 0; j < connectCount; j++) {

                int cityNumber = (int) (Math.random() * 100);
                if (cities[cityNumber].equals(city)) {
                    cityNumber = (int) (Math.random() * 100);
                    stations.get(city).add(getStation(cityNumber));


                } else {
                    stations.get(city).add(getStation(cityNumber));
                }
            }
        }

    }
    public static void printStations(){
        for( HashMap.Entry<String, List<String>> entry : stations.entrySet() ){
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
    }
    public static List<String> getConnection(String station){

        return stations.get(station);
    }

    public static String getStation(int number){
        return Station.cities[number];
    }


}
