package com.sigei.validation.service.impl;

import com.sigei.validation.config.ConfigProperties;
import com.sigei.validation.model.MinutesRequest;
import com.sigei.validation.model.MinutesResponse;
import com.sigei.validation.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sigei.validation.utils.ApiVariables.*;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {
    private final ConfigProperties properties;

    @Override
    public MinutesResponse getMinutes(MinutesRequest payload) {
        MinutesResponse minutesResponse = new MinutesResponse();
        int loanGrade = 250;
        if (payload.getAmount()<minPrice(payload.getValidity(), loanGrade) || payload.getAmount()>maxPrice(payload.getValidity())){
            minutesResponse.setResponseCode(1000);
            minutesResponse.setResponseMessage("Invalid Amount");
        }else{
            double rate =  getRate(payload.getValidity(), getPricePoint(payload.getAmount()));
            minutesResponse.setResponseCode(0);
            minutesResponse.setResponseMessage("Success");
            minutesResponse.setMinutes((int) Math.ceil(payload.getAmount()/rate));
        }
        return minutesResponse;
    }

    private int maxPrice(String Validity) {
        if (Validity.equals(VALIDITY_1HR)) {
            return 36;
        } else if (Validity.equals(VALIDITY_3HR)) {
            return 100;
        } else if (Validity.equals(VALIDITY_MIDNIGHT )) {
            return 250;
        } else if (Validity.equals(VALIDITY_24HR )) {
            return 250;
        } else if (Validity.equals(VALIDITY_7DAYS)) {
            return 5000;
        } else if (Validity.equals(VALIDITY_15DAYS)) {
            return 10000;
        } else if (Validity.equals(VALIDITY_30DAYS)) {
            return 10000;
        } else
            return -1;
    }
    }

    private int minPrice(String Validity, int loanGrade) {
        if (Validity.equals(VALIDITY_1HR) && loanGrade <= 250) {
            return 5;
        } else if (Validity.equals(VALIDITY_1HR) && loanGrade > 250) {
            return 5;
        } else if (Validity.equals(VALIDITY_3HR) && loanGrade < 250) {
            return 5;
        } else if (Validity.equals(VALIDITY_3HR) && loanGrade > 250) {
            return 5;
        } else if (Validity.equals(VALIDITY_MIDNIGHT) && loanGrade < 250) {
            return 10;
        } else if (Validity.equals(VALIDITY_MIDNIGHT) && loanGrade > 250) {
            return 10;
        } else if (Validity.equals(VALIDITY_24HR) && loanGrade < 250) {
            return 20;
        } else if (Validity.equals(VALIDITY_24HR) && loanGrade > 250) {
            return 20;
        } else if (Validity.equals(VALIDITY_7DAYS) && loanGrade < 250) {
            return 50;
        } else if (Validity.equals(VALIDITY_7DAYS) && loanGrade > 250) {
            return 100;
        } else if (Validity.equals(VALIDITY_15DAYS) && loanGrade < 250) {
            return 50;
        } else if (Validity.equals(VALIDITY_15DAYS) && loanGrade > 250) {
            return 250;
        } else if (Validity.equals(VALIDITY_30DAYS) && loanGrade < 250) {
            return 50;
        } else if (Validity.equals(VALIDITY_30DAYS) && loanGrade > 250) {
            return 250;
        } else
            return -1;
    }

    private String getPricePoint(int Amount) {
        if (Amount >= 5 && Amount <= 9) {
            return PRICE_POINT_1;
        } else if (Amount >= 10 && Amount <= 19) {
            return PRICE_POINT_2 ;
        } else if (Amount >= 20 && Amount <= 49) {
            return PRICE_POINT_3;
        } else if (Amount >= 50 && Amount <= 200) {
            return PRICE_POINT_4;
        } else if (Amount >= 201 && Amount <= 499) {
            return PRICE_POINT_5;
        } else if (Amount >= 500 && Amount <= 999) {
            return PRICE_POINT_6;
        } else if (Amount >= 1000 && Amount <= 2000) {
            return PRICE_POINT_7;
        } else if (Amount >= 2001 && Amount <= 3000) {
            return PRICE_POINT_8;
        } else if (Amount >= 3001 && Amount <= 10000) {
            return PRICE_POINT_9;
        } else {
            return "Invalid";
        }
    }

    private double getRate(String Validity, String pricePoint) {
        if (Validity.equals(VALIDITY_1HR) && pricePoint.equals(PRICE_POINT_1)) {
            return properties.getValidity1HrPp1();
        }

        if (Validity.equals(VALIDITY_1HR) && pricePoint.equals(PRICE_POINT_2 )) {
            return properties.getValidity1HrPp2();
        }

        if (Validity.equals(VALIDITY_1HR) && pricePoint.equals(PRICE_POINT_3)) {
            return properties.getValidity1HrPp3();
        }

        if (Validity.equals(VALIDITY_3HR) && pricePoint.equals(PRICE_POINT_1)) {
            return properties.getValidity3HrPp3();
        }

        if (Validity.equals(VALIDITY_3HR) && pricePoint.equals(PRICE_POINT_2)) {
            return properties.getValidity3HrPp3();
        }

        if (Validity.equals(VALIDITY_3HR) && pricePoint.equals(PRICE_POINT_3)) {
            return properties.getValidity3HrPp3();
        }

        if (Validity.equals(VALIDITY_3HR) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidity3HrPp3();
        }

        if (Validity.equals(VALIDITY_MIDNIGHT) && pricePoint.equals(PRICE_POINT_2)) {
            return properties.getValidityMidnightPp2();
        }

        if (Validity.equals(VALIDITY_MIDNIGHT) && pricePoint.equals(PRICE_POINT_3)) {
            return properties.getValidityMidnightPp3();
        }

        if (Validity.equals(VALIDITY_MIDNIGHT) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidityMidnightPp4();
        }

        if (Validity.equals(VALIDITY_MIDNIGHT) && pricePoint.equals(PRICE_POINT_5)) {
            return properties.getValidityMidnightPp5();
        }

        if (Validity.equals(VALIDITY_24HR ) && pricePoint.equals(PRICE_POINT_3)) {
            return properties.getValidity24HrPp3();
        }

        if (Validity.equals(VALIDITY_24HR ) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidity24HrPp4();
        }

        if (Validity.equals(VALIDITY_24HR ) && pricePoint.equals(PRICE_POINT_5)) {
            return properties.getValidity24HrPp5();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidity7daysPp4();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_5)) {
            return properties.getValidity7daysPp5();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_6)) {
            return properties.getValidity7daysPp6();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_7)) {
            return properties.getValidity7daysPp7();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_8)) {
            properties.getValidity7daysPp8();
        }

        if (Validity.equals(VALIDITY_7DAYS) && pricePoint.equals(PRICE_POINT_9)) {
            properties.getValidity7daysPp9();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidity15daysPp4();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_5)) {
            return properties.getValidity15daysPp5();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_6)) {
            return properties.getValidity15daysPp6();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_7)) {
            return properties.getValidity15daysPp7();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_8)) {
            return properties.getValidity15daysPp8();
        }

        if (Validity.equals(VALIDITY_15DAYS) && pricePoint.equals(PRICE_POINT_9)) {
            return properties.getValidity15daysPp9();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_4)) {
            return properties.getValidity30daysPp4();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_5)) {
            return properties.getValidity30daysPp5();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_6)) {
            return properties.getValidity30daysPp6();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_7)) {
            return properties.getValidity30daysPp7();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_8)) {
            return properties.getValidity30daysPp8();
        }

        if (Validity.equals(VALIDITY_30DAYS) && pricePoint.equals(PRICE_POINT_9)) {
            return properties.getValidity30daysPp9();
        }
        return -1;
    }
}
