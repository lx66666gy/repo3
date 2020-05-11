package com.it.ssm.service;

import com.it.ssm.dao.Update_logDAO;
import com.it.ssm.dao.Work_hourDAO;
import com.it.ssm.pojo.Update_log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class Update_logServiceImpl implements Update_logService {

    @Resource
    Update_logDAO update_logDAO;
    @Override
    public void addUpdate_log(Update_log update_log) {
        update_logDAO.addUpdate_log(update_log);
    }

    @Override
    public void delUpdate_log(Update_log update_log) {
        update_logDAO.delUpdate_log(update_log);
    }

    @Override
    public void updUpdate_log(Update_log update_log) {
        update_logDAO.updUpdate_log(update_log);
    }

    @Override
    public List<Update_log> queryAll(Integer startPos, Integer pageSize) {
        return update_logDAO.queryAll(startPos,pageSize);
    }

    @Override
    public Update_log findById(Update_log update_log) {
        return update_logDAO.findById(update_log);
    }

    @Override
    public int count() {
        return update_logDAO.count();
    }
}
