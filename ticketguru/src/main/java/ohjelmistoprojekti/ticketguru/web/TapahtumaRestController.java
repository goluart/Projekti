package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;



@CrossOrigin
@Controller
public class TapahtumaRestController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    
    @RequestMapping(value="/tapahtumat", method = RequestMethod.GET)
    public @ResponseBody List<Tapahtuma> tapahtumatListRest() {
    	return (List<Tapahtuma>)tapahtumaRepository.findAll();
    }

    
    
	
}
