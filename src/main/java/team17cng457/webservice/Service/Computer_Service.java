package team17cng457.webservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import team17cng457.webservice.JPA.entity.Comment;
import team17cng457.webservice.JPA.entity.Computer;
import team17cng457.webservice.Repository.CommentRepository;
import team17cng457.webservice.Repository.ComputerRepository;

public class Computer_Service {
    @Autowired
    private ComputerRepository Computerrep;

    public Computer saveComputer(Computer computer){
        return Computerrep.save(computer);
    }
    public Computer getComputer(long Computer_id){
        return  Computerrep.getOne(Computer_id);
    }
}
