package eu.programisci.app.zwierzeta.repository;


import eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO;
import eu.programisci.app.zwierzeta.dto.ZwierzetaDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.ob.ZwierzetaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.MessageHandler;
import java.util.List;

@Repository
public interface IZwierzetaRepository extends JpaRepository<ZwierzetaOB,Long> {
    @Query("SELECT new eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO(z.nazwa, z.wiek) FROM ZwierzetaOB z WHERE z.wiek > :wiek ORDER BY z.wiek ASC")
    List<ZwierzeNazwaIWiekDTO> znajdzStarszeNiz(@Param("wiek") Integer aWiek);

    @Query("SELECT z FROM ZwierzetaOB z WHERE upper(z.gatunek) LIKE upper(:gatunek) ORDER BY z.id ASC")
    List<ZwierzetaDTO> znajdzWgGatunku(@Param("gatunek") EGatunek eGatunek);

    @Query("SELECT new eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO(z.nazwa, z.wiek) FROM ZwierzetaOB z WHERE upper(z.nazwa) LIKE upper(concat(:nazwa, '%'))")
    List<ZwierzeNazwaIWiekDTO> znajdzZwierzetaZImieniemZaczynajacymSieOd(@Param("nazwa") String aNazwa);

}
