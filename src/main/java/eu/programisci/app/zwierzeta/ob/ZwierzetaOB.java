package eu.programisci.app.zwierzeta.ob;

import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.enums.EPlec;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "zwierzeta")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_zwierzeta_id")
public class ZwierzetaOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "dataUtworzenia", columnDefinition = "TIMESTAMP")
    private Date creationDate;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "gatunek")
    private EGatunek gatunek;

    @Column(name = "plec")
    private EPlec plec;

    @Column(name = "wiek")
    private Integer wiek;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date aCreationDate) {
        creationDate = aCreationDate;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String aNazwa) {
        nazwa = aNazwa;
    }

    public EGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(EGatunek aGatunek) { gatunek = aGatunek; }

    public EPlec getPlec() { return plec; }

    public void setPlec(EPlec aPlec) {
        plec = aPlec;
    }

    public Integer getWiek(){return wiek;}

    public void setWiek(Integer aWiek){wiek = aWiek;}
}
