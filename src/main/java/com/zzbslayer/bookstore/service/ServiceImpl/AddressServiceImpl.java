package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.AddressRepository;
import com.zzbslayer.bookstore.datamodel.domain.Address;
import com.zzbslayer.bookstore.service.AddressService;
import com.zzbslayer.bookstore.utils.AddressRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    public Address findByUsername(String username){
        Address address = addressRepository.findByUsername(username);
        if (address == null){
            address = new Address();
            address.setUsername(username);
            address.setAddresses(new ArrayList<>());
            addressRepository.save(address);
        }
        return address;
    }

    public Address deleteAddress(Integer addressid){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Address address = addressRepository.findByUsername(name);
        List<AddressRow> addressRows = address.getAddresses();
        for (AddressRow i : addressRows){
            if (i.getAddressid() == addressid){
                addressRows.remove(i);
                break;
            }
        }
        return addressRepository.save(address);
    }

    public Address updateAddress(AddressRow addr){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Address address = addressRepository.findByUsername(name);
        List<AddressRow> addressRows = address.getAddresses();
        for (AddressRow i : addressRows) {
            if (i.getAddressid()==addr.getAddressid()){
                i.update(addr);
                break;
            }
        }
        return addressRepository.save(address);
    }

    public Address save (AddressRow addr){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Address address = addressRepository.findByUsername(name);

        List<AddressRow> addressRows;

        if (address==null){
            address = new Address();
            address.setUsername(name);
            addressRows = new ArrayList<>();
        }
        else
            addressRows = address.getAddresses();
        addr.setAddressid(addressRows.get(addressRows.size()-1).getAddressid()+1);
        addressRows.add(addr);
        return addressRepository.save(address);
    }
}
