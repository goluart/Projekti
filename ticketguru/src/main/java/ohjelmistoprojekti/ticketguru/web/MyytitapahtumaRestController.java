package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.service.MyyntitapahtumaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/myyntitapahtuma")
public class MyytitapahtumaRestController {

    @Autowired
    private MyyntitapahtumaService myyntitapahtumaService;
    
    @PostMapping
    public ResponseEntity<MyyntitapahtumaDTO> luoMyyntitapahtuma(@RequestBody LuoMyyntitapahtumaDTO mtDto ) {
        MyyntitapahtumaDTO myyntitapahtumaDto = myyntitapahtumaService.luoMyyntitapahtuma(mtDto);
        return ResponseEntity.ok(myyntitapahtumaDto);
    }




    


}
