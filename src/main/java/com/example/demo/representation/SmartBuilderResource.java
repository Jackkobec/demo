package com.example.demo.representation;

import com.example.demo.domain.PerfectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/smartbuilder")
public class SmartBuilderResource {


//    @PreAuthorize("hasAuthority('manager')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PerfectDTO> testSmartBuilder(@RequestBody final PerfectDTO perfectDTO) {

        return new ResponseEntity<>(perfectDTO, HttpStatus.OK);
    }
}
