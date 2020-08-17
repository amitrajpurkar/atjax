package com.anr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(hidden = true)
@RequestMapping("/**/probe")
public class ProbeController {

    @RequestMapping(method = RequestMethod.GET, path = "/readiness")
    @ApiOperation(hidden = true, value = "POD Readiness Probe")
    public String readiness() {
        return "Readiness Probe";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/liveness")
    @ApiOperation(hidden = true, value = "POD Liveness Probe")
    public String liveness() {
        return "Liveness Probe";
    }
}
