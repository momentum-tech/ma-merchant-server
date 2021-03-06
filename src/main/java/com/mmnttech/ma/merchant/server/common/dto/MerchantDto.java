package com.mmnttech.ma.merchant.server.common.dto;



import java.util.List;

import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.model.Merchant;

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
