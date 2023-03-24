package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;
import by.academy.service.dto.PhoneNumberDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadPhoneNumberCommand implements Command {
    private final Extractor<PhoneNumberDTO> extractor = new PhoneNumberExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/phoneNumbers.jsp";
    }
}
