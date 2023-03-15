package by.academy.service;

import by.academy.service.dto.PhoneNumberDTO;

import java.util.List;

public interface PhoneNumberService {
    PhoneNumberDTO createPhoneNumber(PhoneNumberDTO phoneNumberDTO);

    List<PhoneNumberDTO> readAllPhoneNumbers();

    PhoneNumberDTO updatePhoneNumber(PhoneNumberDTO phoneNumberDTO);

    void deletePhoneNumber(int id);

    PhoneNumberDTO selectPhoneNumberById(int id);
}