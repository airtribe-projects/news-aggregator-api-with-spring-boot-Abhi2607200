package com.airtribe.aggregatorApi.Service;

import com.airtribe.aggregatorApi.DTO.AuthResponse;
import com.airtribe.aggregatorApi.DTO.Loginrequest;

public interface Authservice {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(Loginrequest request);
}
