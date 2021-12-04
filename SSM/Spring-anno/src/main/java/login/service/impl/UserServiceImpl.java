package login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import login.dao.UserDao;
import login.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("userService")
@Scope("singleton")
//@Scope("protoType")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
//    @Resource(name = "userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("init...");

    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }

}
