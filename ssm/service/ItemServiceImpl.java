package com.it.ssm.service;

import com.it.ssm.dao.DeptDAO;
import com.it.ssm.dao.ItemDAO;
import com.it.ssm.pojo.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Resource
    ItemDAO itemDAO;
    @Override
    public void addItem(Item item) {
        itemDAO.addItem(item);
    }

    @Override
    public List<Item> queryAll(Item item, Integer startPos, Integer pageSize) {
        return itemDAO.queryAll(item,startPos,pageSize);
    }

    @Override
    public int count() {
        return itemDAO.count();
    }

    @Override
    public void delItem(Item item) {
        itemDAO.delItem(item);
    }

    @Override
    public Item findById(Item item) {

        return itemDAO.findById(item);
    }

    @Override
    public void updItem(Item item) {
        itemDAO.updItem(item);
    }

    @Override
    public int itemDelete(String delIds) {
        return itemDAO.itemDelete(delIds);
    }
}
