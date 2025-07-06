package com.airtribe.aggregatorApi.Service;

import com.airtribe.aggregatorApi.DTO.AuthResponse;
import com.airtribe.aggregatorApi.DTO.Loginrequest;
import com.airtribe.aggregatorApi.DTO.RegistrationRequest;

public interface Authservice {

    AuthResponse register(RegistrationRequest request);

    AuthResponse login(Loginrequest request);
}
