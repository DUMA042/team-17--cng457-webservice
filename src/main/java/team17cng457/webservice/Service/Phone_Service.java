package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.JPA.entity.Phone;
import team17cng457.webservice.Repository.ComputerRepository;
import team17cng457.webservice.Repository.PhoneRepository;

public class Phone_Service {
    @Autowired
    private PhoneRepository Phonerep;

    public Phone savePhone(Phone phone){
        return Phonerep.save(phone);
    }
    public Phone getPhone(long Phone_id){
        return  Phonerep.getOne(Phone_id);
    }
}
