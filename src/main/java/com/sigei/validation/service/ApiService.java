package com.sigei.validation.service;

import com.sigei.validation.model.MinutesRequest;
import com.sigei.validation.model.MinutesResponse;

public interface ApiService {
    MinutesResponse getMinutes(MinutesRequest payload);

}