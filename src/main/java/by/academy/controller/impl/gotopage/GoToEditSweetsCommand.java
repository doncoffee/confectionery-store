package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.BrandService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.SweetsService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class GoToEditSweetsCommand implements Command {
    private final SweetsService sweetsService = new SweetsServiceImpl();
    private final Extractor extractor = new SweetsExtractor();
    private final BrandService brandService = new BrandServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final SupplierService supplierService = new SupplierServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        List<BrandDTO> brandList = brandService.readAllBrands();
        List<StoreDTO> storeList = storeService.readAllStores();
        List<SupplierDTO> supplierList = supplierService.readAllSuppliers();
        SweetsDTO sweetsDTO = sweetsService.selectSweetsById(id);
        request.setAttribute(BRANDS, brandList);
        request.setAttribute(STORES, storeList);
        request.setAttribute(SUPPLIERS, supplierList);
        request.setAttribute(SWEET, sweetsDTO);
        extractor.extract(request);
        return JSP_EDIT_EDIT_SWEETS_JSP;
    }
}
