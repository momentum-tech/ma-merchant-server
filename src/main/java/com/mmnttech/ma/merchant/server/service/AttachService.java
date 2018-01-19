package com.mmnttech.ma.merchant.server.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.AttachMapper;
import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.util.StringUtil;

/**
 * @author Stelo
 * @createAt 2018/1/12
 **/

@Service("attachService")
public class AttachService {
    @Autowired
    private AttachMapper attachMapper;

    public Attach create(Attach attach) {
        attachMapper.insert(attach);
        return attach;
    }
    
    @Transactional(rollbackFor = DatabaseException.class)
    public boolean createAll(List<Attach> attachListElements, String masterId) {
        for (Attach element : attachListElements) {
            element.setMasterId(masterId);
            element.setRecId(StringUtil.getUUID());
            if (attachMapper.insert(element) != 1) {
                throw new DatabaseException("error.attach.insert");
            }
        }
        return true;
    }

    public List<Attach> findByMasterId(String masterId) {
        Attach attach = new Attach();
        attach.setMasterId(masterId);
        return attachMapper.select(attach);
    }
}
