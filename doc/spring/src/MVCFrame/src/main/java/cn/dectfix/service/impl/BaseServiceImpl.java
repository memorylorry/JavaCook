package cn.dectfix.service.impl;

import cn.dectfix.dao.BaseDAO;
import cn.dectfix.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by huqian on 2017/12/6.
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService{

    //auto inject baseDAP object
    @Autowired
    @Qualifier("baseDAO")
    private BaseDAO baseDAO;

    public String look(String msg) {
        return "Service-look#"+baseDAO.look(msg);
    }
}
