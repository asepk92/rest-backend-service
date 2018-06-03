package com.nostra.converter;


import com.nostra.domain.Transfer;
import com.nostra.util.ExtendedSpringBeanUtil;
import com.nostra.vo.TransferVO;

import org.springframework.stereotype.Component;

/**
 * Created by sagungrp on 6/16/2017.
 */
@Component
public class TransferVOConverter extends BaseVOConverter<TransferVO, TransferVO, Transfer> implements IBaseVOConverter<TransferVO, TransferVO, Transfer> {

    @Override
    public TransferVO transferModelToVO(Transfer model, TransferVO vo) {
        if (null == vo) vo = new TransferVO();

        super.transferModelToVO(model, vo);
        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"id", "userFrom", "noRekening", "kdJenisTransaksi", "amount", "kdBank", "noRekeningTujuan", "userTo", "Keterangan", "createdDate"}
               );

        return vo;
    }

    @Override
    public Transfer transferVOToModel(TransferVO vo, Transfer model) {
        if (null == model) model = new Transfer();

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"id", "userFrom", "noRekening", "kdJenisTransaksi", "amount", "kdBank", "noRekeningTujuan", "userTo", "Keterangan", "createdDate"});

        return model;
    }
}
