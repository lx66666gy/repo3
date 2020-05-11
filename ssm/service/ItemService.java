package com.it.ssm.service;

import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItemService {
    void addItem(Item item);
    List<Item> queryAll(Item item, Integer startPos,Integer pageSize);
    int count();
    void delItem(Item item);
    Item findById(Item item);
    void updItem(Item item);
    int itemDelete(String delIds);
}
