package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.PhoneNumberDAOImpl;
import by.academy.entity.PhoneNumber;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.PhoneNumberMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumberServiceImpl implements PhoneNumberService {
    private final Mapper<PhoneNumber, PhoneNumberDTO> mapper = new PhoneNumberMapper();
    private final DAO<PhoneNumber> dao = new PhoneNumberDAOImpl();

    @Override
    public PhoneNumberDTO createPhoneNumber(PhoneNumberDTO phoneNumberDTO) {
        PhoneNumber phoneNumber = dao.create(mapper.mapToEntity(phoneNumberDTO));
        return mapper.mapToDTO(phoneNumber);
    }

    @Override
    public List<PhoneNumberDTO> readAllPhoneNumbers() {
        return dao.read()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PhoneNumberDTO updatePhoneNumber(PhoneNumberDTO phoneNumberDTO) {
        PhoneNumber phoneNumber = dao.update(mapper.mapToEntity(phoneNumberDTO));
        return mapper.mapToDTO(phoneNumber);
    }

    @Override
    public void deletePhoneNumber(int id) {
        dao.delete(id);
    }

    @Override
    public PhoneNumberDTO selectPhoneNumberById(int id) {
        PhoneNumber phoneNumber = dao.selectById(id);
        return mapper.mapToDTO(phoneNumber);
    }

    @Override
    public List<PhoneNumberDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult) {
        return dao.findAllByPageAndSearch(currentPage, recordsPerPage, searchResult)
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows(String searchResult) {
        return dao.getNumberOfRows(searchResult);
    }
}
