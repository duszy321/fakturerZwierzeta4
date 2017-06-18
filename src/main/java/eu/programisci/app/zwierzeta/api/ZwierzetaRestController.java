package eu.programisci.app.zwierzeta.api;


import eu.programisci.app.zwierzeta.dto.ZwierzeNazwaIWiekDTO;
import eu.programisci.app.zwierzeta.dto.ZwierzetaDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.service.IZwierzetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.MessageHandler;
import java.util.List;

@RestController
@RequestMapping(value = "/api/zwierzeta")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ZwierzetaRestController {

    @Autowired
    private IZwierzetaService zwierzetaService;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZwierzetaDTO findOne(@RequestParam("id") Long aId) {
        return zwierzetaService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzetaDTO> findAll() {
        return zwierzetaService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        zwierzetaService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZwierzetaDTO save(@RequestBody ZwierzetaDTO aKontrahentDTO) {
        return zwierzetaService.save(aKontrahentDTO);
    }

    @RequestMapping(value = "/znajdzStarszeNiz", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeNazwaIWiekDTO> znajdzStarszeNiz(@RequestParam("wiek") Integer aWiek) {
        return zwierzetaService.znajdzStarszeNiz(aWiek);
    }

    @RequestMapping(value = "/znajdzWgGatunku ", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzetaDTO> znajdzWgGatunku (@RequestParam("gatunek") EGatunek aGatunek) {
        return zwierzetaService.znajdzWgGatunku(aGatunek);
    }

    @RequestMapping(value = "/znajdzZwierzetaZImieniemZaczynajacymSieOd", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeNazwaIWiekDTO> znajdzZwierzetaZImieniemZaczynajacymSieOd(@RequestParam("nazwa") String aNazwa) {
        return zwierzetaService.znajdzZwierzetaZImieniemZaczynajacymSieOd(aNazwa);
    }
}
