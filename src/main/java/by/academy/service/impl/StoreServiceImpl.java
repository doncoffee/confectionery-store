package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.StoreDAOImpl;
import by.academy.entity.Store;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.StoreMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {
    private Mapper<Store, StoreDTO> mapper = new StoreMapper();
    private final DAO<Store> dao = new StoreDAOImpl();

    @Override
    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = dao.create(mapper.mapToEntity(storeDTO));
        return mapper.mapToDTO(store);
    }

    @Override
    public List<StoreDTO> readAllStores() {
        return dao.read()
                .stream()
                .map(map ->mapper.mapToDTO(map))
                .collect(Collectors.toList());
    }

    @Override
    public StoreDTO updateStore(StoreDTO storeDTO) {
        Store store = dao.update(mapper.mapToEntity(storeDTO));
        return mapper.mapToDTO(store);
    }

    @Override
    public void deleteStore(int id) {
        dao.delete(id);
    }

    @Override
    public StoreDTO selectStoreById(int id) {
        Store store = dao.selectById(id);
        return mapper.mapToDTO(store);
    }
}
