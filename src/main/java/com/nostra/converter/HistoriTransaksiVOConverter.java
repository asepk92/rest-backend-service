package com.nostra.converter;


import com.nostra.domain.HistoriTransaksi;
import com.nostra.util.ExtendedSpringBeanUtil;
import com.nostra.vo.HistoriTransaksiVO;

import org.springframework.stereotype.Component;

/**
 * Created by sagungrp on 6/16/2017.
 */
@Component
public class HistoriTransaksiVOConverter extends BaseVOConverter<HistoriTransaksiVO, HistoriTransaksiVO, HistoriTransaksi> implements IBaseVOConverter<HistoriTransaksiVO, HistoriTransaksiVO, HistoriTransaksi> {

    @Override
    public HistoriTransaksiVO transferModelToVO(HistoriTransaksi model, HistoriTransaksiVO vo) {
        if (null == vo) vo = new HistoriTransaksiVO();

        super.transferModelToVO(model, vo);
        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"kdTransaksi", "userFrom", "noRekening", "kdJenisTransaksi", "amount", "kdBank", "noRekeningTujuan", "userTo", "Keterangan", "createdDate"}
               );

        return vo;
    }

    @Override
    public HistoriTransaksi transferVOToModel(HistoriTransaksiVO vo, HistoriTransaksi model) {
        if (null == model) model = new HistoriTransaksi();

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"kdTransaksi", "userFrom", "noRekening", "kdJenisTransaksi", "amount", "kdBank", "noRekeningTujuan", "userTo", "Keterangan", "createdDate"});

        return model;
    }
}
