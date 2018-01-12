package com.mmnttech.ma.merchant.server.common.dto;

import com.mmnttech.ma.merchant.server.database.entity.Attach;
import com.mmnttech.ma.merchant.server.database.entity.Merchant;

import java.util.List;

/**
 * @author Stelo
 * @createAt 2018/1/12
 **/
public class MerchantDto {

    private Merchant merchant;

    private List<Attach> attachList;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<Attach> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<Attach> attachList) {
        this.attachList = attachList;
    }
}
