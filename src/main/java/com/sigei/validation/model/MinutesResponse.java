package com.sigei.validation.model;

import lombok.Data;


@Data
public class MinutesResponse {

    public int responseCode;
    public String responseMessage;
    public int minutes;
}

