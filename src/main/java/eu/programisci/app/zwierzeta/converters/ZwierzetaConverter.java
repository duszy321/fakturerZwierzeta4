package eu.programisci.app.zwierzeta.converters;

import eu.programisci.app.zwierzeta.dto.ZwierzetaDTO;
import eu.programisci.app.zwierzeta.ob.ZwierzetaOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZwierzetaConverter {

    public ZwierzetaDTO obToDto(ZwierzetaOB in) {
        ZwierzetaDTO out = new ZwierzetaDTO();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setGatunek(in.getGatunek());
        out.setPlec(in.getPlec());
        out.setWiek(in.getWiek());
        return out;
    }

    public ZwierzetaOB dtoToOb(ZwierzetaDTO in) {
        ZwierzetaOB out = new ZwierzetaOB();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setGatunek(in.getGatunek());
        out.setPlec(in.getPlec());
        out.setWiek(in.getWiek());
        return out;
    }


    public List<ZwierzetaDTO> obListToDtoList(List<ZwierzetaOB> inList) {
        if (inList == null) {
            return null;
        }
        List<ZwierzetaDTO> outList = new ArrayList<>();
        for (ZwierzetaOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
