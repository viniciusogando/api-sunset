package com.vinicius.store.controller.v1;

import com.vinicius.store.model.Sunset;
import com.vinicius.store.service.SunsetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor // Essa anotação é responsável por gerar um construtor com 1 parametro
@RestController
@RequestMapping("/v1/sunset")
public class SunsetController {

    private final SunsetService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Sunset saveSunset(@RequestBody @Valid Sunset sunset,
                             @RequestHeader(value="Accept") String acceptHeader,
                             @RequestHeader(value="Authorization") String authorizationHeader ) {
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("Accept", acceptHeader);
        returnValue.put("Authorization", authorizationHeader);
        System.out.println(returnValue);
        return service.saveSunset(sunset);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public Sunset updateSunsetById(@RequestBody Sunset sunset,@PathVariable String id){
        return service.updateSunsetById(sunset, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public Sunset patchBrand(@RequestBody @Valid Sunset sunset, @PathVariable String id){
        return service.patchPrice(sunset, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        service.deleteByID(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(OK)
    public List<Sunset> findAll() {
        return service.findAll();
    }


}



//   MODEL ( ENTIDADE ) -> REPOSITORY ( FAZER MAPEAMENTO DE ENTIDADE PARA BANCO ) -> SERVICE ( CONTRATO )