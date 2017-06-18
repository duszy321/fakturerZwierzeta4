package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO;
import eu.programisci.app.zwierzeta.dto.ZwierzetaDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;

import javax.websocket.MessageHandler;
import java.util.List;

public interface IZwierzetaService {

    ZwierzetaDTO findOne(Long id);

    List<ZwierzetaDTO> findAllForTable();

    void deleteOne(Long id);

    ZwierzetaDTO save(ZwierzetaDTO zwierzeDTO);

    List<ZwierzeNazwaIWiekDTO> znajdzStarszeNiz(Integer aWiek);

    List<ZwierzetaDTO> znajdzWgGatunku(EGatunek aGatunek);

    List<ZwierzeNazwaIWiekDTO> znajdzZwierzetaZImieniemZaczynajacymSieOd(String aNazwa);

}
