package com.mmnttech.ma.merchant.server.service;


import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.database.entity.Attach;
import com.mmnttech.ma.merchant.server.database.entity.AttachExample;
import com.mmnttech.ma.merchant.server.database.mappers.AttachMapper;
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
            if (attachMapper.insert(element) != 1) {
                throw new DatabaseException("error.attach.insert");
            }
        }
        return true;
    }

    public List<Attach> findByMasterId(String masterId) {
        AttachExample attachExample = new AttachExample();
        AttachExample.Criteria criteria = attachExample.createCriteria();
        criteria.andMasterIdEqualTo(masterId);
        return attachMapper.selectByExample(attachExample);
    }
}
