package com.sigei.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MinutesRequest {
    private int msisdn;
    private int amount;
    private String validity;


}
