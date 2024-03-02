package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketguru.service.LippuService;
import ohjelmistoprojekti.ticketguru.service.MyyntitapahtumaService;

import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/myynti")
public class MyytitapahtumaRestController {

    private LippuService lippuService;
    private MyyntitapahtumaService myyntitapahtumaService;
    private Mapper mapper;
    
    public MyytitapahtumaRestController(LippuService lippuService, MyyntitapahtumaService myyntitapahtumaService,
            Mapper mapper) {
        this.lippuService = lippuService;
        this.myyntitapahtumaService = myyntitapahtumaService;
        this.mapper = mapper;
    }

    


}
