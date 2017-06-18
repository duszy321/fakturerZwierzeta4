package eu.programisci.app.zwierzeta.dto;

/**
 * Created by student on 17.06.17.
 */
public class ZwierzeNazwaIWiekDTO {
    private String nazwa;
    private Integer wiek;

    public ZwierzeNazwaIWiekDTO() {
    }

    public ZwierzeNazwaIWiekDTO(String aNazwa, Integer aWiek) {
        nazwa = aNazwa;
        wiek = aWiek;
    }

    public String getNazwa(){return nazwa;}
    public void setNazwa(String aNazwa){nazwa = aNazwa;}
    public Integer getWiek(){return wiek;}
    public void setWiek(Integer aWiek){wiek = aWiek;}
}
