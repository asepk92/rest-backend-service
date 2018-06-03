package com.nostra.converter;


import com.nostra.domain.MasterUser;
import com.nostra.util.ExtendedSpringBeanUtil;
import com.nostra.vo.MasterUserVO;

import org.springframework.stereotype.Component;

/**
 * Created by sagungrp on 6/16/2017.
 */
@Component
public class MasterUserVOConverter extends BaseVOConverter<MasterUserVO, MasterUserVO, MasterUser> implements IBaseVOConverter<MasterUserVO, MasterUserVO, MasterUser> {

    @Override
    public MasterUserVO transferModelToVO(MasterUser model, MasterUserVO vo) {
        if (null == vo) vo = new MasterUserVO();

        super.transferModelToVO(model, vo);
        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"idUser", "email", "noHp", "password", "username"}
               );

        return vo;
    }

    @Override
    public MasterUser transferVOToModel(MasterUserVO vo, MasterUser model) {
        if (null == model) model = new MasterUser();

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"idUser", "email", "noHp", "password", "username"});

        return model;
    }
}
