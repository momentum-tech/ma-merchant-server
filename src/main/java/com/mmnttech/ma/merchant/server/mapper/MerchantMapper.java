package com.mmnttech.ma.merchant.server.mapper;

import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.util.BaseMapper;

import java.util.List;

public interface MerchantMapper extends BaseMapper<Merchant> {
    List<String> queryRecIdByCpyName(String cpyName);
}
