package com.nostra.converter;


import com.nostra.domain.TarikSetorTunai;
import com.nostra.util.ExtendedSpringBeanUtil;
import com.nostra.vo.TarikSetorTunaiVO;

import org.springframework.stereotype.Component;

/**
 * Created by sagungrp on 6/16/2017.
 */
@Component
public class TarikSetorTunaiVOConverter extends BaseVOConverter<TarikSetorTunaiVO, TarikSetorTunaiVO, TarikSetorTunai> implements IBaseVOConverter<TarikSetorTunaiVO, TarikSetorTunaiVO, TarikSetorTunai> {

    @Override
    public TarikSetorTunaiVO transferModelToVO(TarikSetorTunai model, TarikSetorTunaiVO vo) {
        if (null == vo) vo = new TarikSetorTunaiVO();

        super.transferModelToVO(model, vo);
        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"id", "idKlien", "noRekening", "kdJenisTransaksi", "amount", "createdDate"}
               );

        return vo;
    }

    @Override
    public TarikSetorTunai transferVOToModel(TarikSetorTunaiVO vo, TarikSetorTunai model) {
        if (null == model) model = new TarikSetorTunai();

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"id", "idKlien", "noRekening", "kdJenisTransaksi", "amount", "createdDate"});

        return model;
    }
}
