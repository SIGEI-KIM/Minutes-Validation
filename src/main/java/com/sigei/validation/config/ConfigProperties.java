package com.sigei.validation.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class ConfigProperties {
    @Value("${rate.validity1HrPp1}")
    private double validity1HrPp1;

    @Value("${rate.validity1HrPp2}")
    private double validity1HrPp2;

    @Value("${rate.validity1HrPp3}")
    private double validity1HrPp3;

    @Value("${rate.validity3HrPp1}")
    private double validity3HrPp1;

    @Value("${rate.validity3HrPp2}")
    private double validity3HrPp2;

    @Value("${rate.validity3HrPp3}")
    private double validity3HrPp3;

    @Value("${rate.validity3HrPp4}")
    private double validity3HrPp4;

    @Value("${rate.validityMidnightPp2}")
    private double validityMidnightPp2;

    @Value("${rate.validityMidnightPp3}")
    private double validityMidnightPp3;

    @Value("${rate.validityMidnightPp4}")
    private double validityMidnightPp4;

    @Value("${rate.validityMidnightPp5}")
    private double validityMidnightPp5;

    @Value("${rate.validity24HrPp3}")
    private double validity24HrPp3;

    @Value("${rate.validity24HrPp4}")
    private double validity24HrPp4;

    @Value("${rate.validity24HrPp5}")
    private double validity24HrPp5;

    @Value("${rate.validity7daysPp4}")
    private double validity7daysPp4;

    @Value("${rate.validity7daysPp5}")
    private double validity7daysPp5;

    @Value("${rate.validity7daysPp6}")
    private double validity7daysPp6;

    @Value("${rate.validity7daysPp7}")
    private double validity7daysPp7;

    @Value("${rate.validity7daysPp8}")
    private double validity7daysPp8;

    @Value("${rate.validity7daysPp9}")
    private double validity7daysPp9;

    @Value("${rate.validity15daysPp4}")
    private double validity15daysPp4;

    @Value("${rate.validity15daysPp5}")
    private double validity15daysPp5;

    @Value("${rate.validity15daysPp6}")
    private double validity15daysPp6;

    @Value("${rate.validity15daysPp7}")
    private double validity15daysPp7;

    @Value("${rate.validity15daysPp8}")
    private double validity15daysPp8;

    @Value("${rate.validity15daysPp9}")
    private double validity15daysPp9;

    @Value("${rate.validity30daysPp4}")
    private double validity30daysPp4;

    @Value("${rate.validity30daysPp5}")
    private double validity30daysPp5;

    @Value("${rate.validity30daysPp6}")
    private double validity30daysPp6;

    @Value("${rate.validity30daysPp7}")
    private double validity30daysPp7;

    @Value("${rate.validity30daysPp8}")
    private double validity30daysPp8;

    @Value("${rate.validity30daysPp9}")
    private double validity30daysPp9;

}
