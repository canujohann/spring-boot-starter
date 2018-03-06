package hello.services;

import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl  implements InformationService{
    @Override
    public String getUser() {
        return "Nick";
    }
}
