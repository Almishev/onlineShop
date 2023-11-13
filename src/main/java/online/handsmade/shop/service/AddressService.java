package online.handsmade.shop.service;

import online.handsmade.shop.repo.AddressRepo;
import online.handsmade.shop.model.AddressAndPersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public AddressAndPersonalData save(AddressAndPersonalData addressAndPersonalData) {
        return addressRepo.save(addressAndPersonalData);
    }
}
