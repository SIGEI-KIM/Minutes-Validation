package com.sigei.validation.controller;

import com.sigei.validation.model.MinutesRequest;
import com.sigei.validation.model.MinutesResponse;
import com.sigei.validation.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/v1")
public class RequestController {

    @Autowired
    private ApiService apiService;
    @PostMapping("/get-minutes")
    public ResponseEntity<MinutesResponse>  getMinutes(@RequestBody MinutesRequest payload) {
        return new ResponseEntity<>(apiService.getMinutes(payload), HttpStatus.OK);
    }

}
