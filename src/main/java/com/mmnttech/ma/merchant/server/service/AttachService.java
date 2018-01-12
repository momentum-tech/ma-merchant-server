package com.mmnttech.ma.merchant.server.service;


import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.AttachMapper;
import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Stelo
 * @createAt 2018/1/12
 **/

@Transactional(rollbackFor = DatabaseException.class)
@Service("attachService")
public class AttachService {
    @Autowired
    private AttachMapper attachMapper;

    public Attach create(Attach attach) {
        if (attachMapper.insert(attach) != 1) {
            throw new DatabaseException("error.attach.insert");
        }
        return attach;
    }

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
