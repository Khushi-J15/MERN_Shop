package com.ecom.first.service.interf;

import com.ecom.first.dto.AddressDto;
import com.ecom.first.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress(AddressDto addressDto);
}