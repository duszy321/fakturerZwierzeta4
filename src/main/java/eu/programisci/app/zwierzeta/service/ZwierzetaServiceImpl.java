package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.converters.ZwierzetaConverter;
import eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO;
import eu.programisci.app.zwierzeta.dto.ZwierzetaDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.ob.ZwierzetaOB;
import eu.programisci.app.zwierzeta.repository.IZwierzetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.MessageHandler;
import java.util.Date;
import java.util.List;

@Service
public class ZwierzetaServiceImpl implements IZwierzetaService {

    @Autowired
    private IZwierzetaRepository zwierzetaRepository;

    @Autowired
    private ZwierzetaConverter zwierzetaConverter;

    @Override
    public ZwierzetaDTO findOne(Long id) {
        ZwierzetaOB ob = zwierzetaRepository.findOne(id);
        ZwierzetaDTO dto = zwierzetaConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<ZwierzetaDTO> findAllForTable() {
        List<ZwierzetaOB> obList = zwierzetaRepository.findAll();
        List<ZwierzetaDTO> dtoList = zwierzetaConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        zwierzetaRepository.delete(id);
    }

    @Override
    public ZwierzetaDTO save(ZwierzetaDTO dto) {
        if (dto.getId() == null) {
            return zwierzetaConverter.obToDto(create(dto));
        } else {
            return zwierzetaConverter.obToDto(update(dto));
        }
    }

    private ZwierzetaOB create(ZwierzetaDTO dto) {
        ZwierzetaOB ob = zwierzetaConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = zwierzetaRepository.save(ob);
        return ob;
    }

    private ZwierzetaOB update(ZwierzetaDTO dto) {
        ZwierzetaOB ob = zwierzetaRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setGatunek(dto.getGatunek());
        ob.setPlec(dto.getPlec());
        ob.setWiek(dto.getWiek());
        ob = zwierzetaRepository.save(ob);
        return ob;
    }

    @Override
    public List<ZwierzeNazwaIWiekDTO> znajdzStarszeNiz(Integer aWiek) {
        return zwierzetaRepository.znajdzStarszeNiz(aWiek);
    }

    @Override
    public List<ZwierzetaDTO> znajdzWgGatunku(EGatunek aGatunek) {
        return zwierzetaRepository.znajdzWgGatunku(aGatunek);
    }

    @Override
    public List<ZwierzeNazwaIWiekDTO> znajdzZwierzetaZImieniemZaczynajacymSieOd(String aNazwa) {
        return zwierzetaRepository.znajdzZwierzetaZImieniemZaczynajacymSieOd(aNazwa);
    }
}
