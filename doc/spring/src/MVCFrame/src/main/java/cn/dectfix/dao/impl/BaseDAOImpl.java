package cn.dectfix.dao.impl;

import cn.dectfix.dao.BaseDAO;
import org.springframework.stereotype.Service;

/**
 * Created by huqian on 2017/12/6.
 */
@Service("baseDAO")
public class BaseDAOImpl implements BaseDAO {
    public String look(String msg) {
        return "DAO-look#"+msg;
    }
}
