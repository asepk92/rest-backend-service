package com.nostra.util;

import java.math.BigDecimal;

public class Constants {

    public static final class ERROR{
        public static final String NOT_FOUND = "Report Hobby";
    }

    public static final class PageParameter {
        public static final String LIST_DATA = "listData";
        public static final String TOTAL_PAGES = "totalPages";
        public static final String TOTAL_ELEMENTS = "totalElements";
    }

    public static final class StatusPenyakit{
        public static final String YES = "Iya";
        public static final String NO = "Tidak";
    }

    public static final class Database {
        public static final String schema="JSADM";
        public static final String polis="POLIS";
    }

    public static final class ResikoAwal {
        public static final String tarif="TEBUS";
    }

    public static final class Komponen {
        public static final String USIA="USIA";
        public static final String STATUS="STATUS";
        public static final String STATUSKWN="STATUSKWN";
        public static final String MASA="MASA";
        public static final String KDVALUTA="KDVALUTA";
        public static final String KDBASIS="KDBASIS";
        public static final String CB="CB";
        public static final String STATUSMEROKOK="STATUSMEROKOK";
        public static final String JENKEL="JENKEL";
        public static final String F_KDVALUTA="FKDVALUTA";
        public static final String F_CB="FCB";
        public static final String F_MASA="FMASA";
        public static final String F_MASA_PREMI="FMASAPREMI";
        public static final String F_TAHUN="FTAHUN";
        public static final String RA="RA";
        public static final String RESIKO="RESIKO";
        public static final String PENURUNAN="PENURUNAN";

    }

    public static final class Status {
        public static final String YA="Y";
        public static final String TIDAK="T";
        public static final String DITERIMA="DITERIMA";
        public static final String DITOLAK="DITOLAK";
    }

    public static final class MapRumus {
        public static final String USIA_PRODUKTIF="USIA_PRODUKTIF";
        public static final String USIA="USIA";
        public static final String GAJI="GAJI";
        public static final String JUA="JUA";
        public static final String JUASTANDARD="JUASTANDARD";
        public static final String PREMISTANDARD="PREMISTANDARD";
        public static final String PREMIKOMISI="PREMIKOMISI";
        public static final String JUARIDERSTANDARD="JUARIDERSTANDARD";
        public static final String PREMIRIDERSTANDARD="PREMIRIDERSTANDARD";
        public static final String KDBASIS="KDBASIS";
        public static final String TARIF="TARIF";
        public static final String PREMI="PREMI";
        public static final String PREMI_REG="PREMI_REG";
        public static final String PREMI_TOPUP="PREMI_TOPUP";
        public static final String BIAYA_UA="BIAYA_UA";
        public static final String LIST_BIAYA_TAMBAHAN="LIST_BIAYA_TAMBAHAN";
        public static final String TOTAL_BIAYA_UA ="TOTAL_BIAYA_UA";
        public static final String TOTAL_PREMI="TOTAL_PREMI";
        public static final String BIAYA_AKUSISI="BIAYA_AKUSISI";
        public static final String BIAYA_AKUSISI_VALUE="BIAYA_AKUSISI_VALUE";
        public static final String BIAYA_AKUSISI_VALUE_TOPUP="BIAYA_AKUSISI_VALUE_TOPUP";
        public static final String BIAYA_AKUSISI_VALUE_REG="BIAYA_AKUSISI_VALUE_REG";
        public static final String BIAYA_AKUSISI_REG="BIAYA_AKUSISI_REG";
        public static final String NET_PREMI_POKOK="NET_PREMI_POKOK";
        public static final String NET_PREMI_REG="NET_PREMI_REG";
        public static final String NET_PREMI_POKOK_SETELAH_PEMBELIAN_UNIT="NET_PREMI_POKOK_SETELAH_PEMBELIAN_UNIT";
        public static final String BIAYA_ADMIN = "BIAYA_ADMIN";
        public static final String BIAYA_PREMI = "BIAYA_PREMI";
        public static final String UNITLINK_DESISI = "UNITLINK_DESISI";
        public static final String SPAJ_PREMI_BERKALA="SPAJ.PREMI_BERKALA";
        public static final String CBA="CBA";
        public static final String STATUS_BUJANG="STATUSBUJANG";
        public static final String SPAJ_UA="SPAJ.UA";
        public static final String SPAJ_JUA="SPAJ.JUA";
        public static final String SPAJ_PREMI_SEKALIGUS_BUJANG="SPAJ.PREMI_SEKALIGUS_BUJANG";
        public static final String SPAJ_PREMI_SEKALIGUS="SPAJ.PREMI_SEKALIGUS";
        public static final String FAKTOR="FAKTOR";
        public static final String FAKTOR_RA="FAKTOR_RA";
        public static final String FAKTOR_RESIKO="FaktorRisiko";
        public static final String FAKTOR_PENURUNAN_RESIKO="FaktorPenurunanRisiko";
        public static final String SPAJ_GAJI_BULANAN="SPAJ.GajiBulanan";
        public static final String SPAJ_GAJI="SPAJ.Gaji";
        public static final String _RA_="(RA)";
        public static final String RA="RA";
        public static final String RA_NT="RA - NT";
        public static final String NT="NT";
        public static final String SPAJ_PREMI="SPAJ.PREMI";
        public static final String RIDER="RIDER";
        public static final String RIDER_MAX="RIDER_MAX";
        public static final String JUA_DASAR="JUA_DASAR";
        public static final String JUA_RIDER="JUA_RIDER";
        public static final String RND="RND";
        public static final String JUA_TL1="JUA_TL1";
        public static final String JUA_TL2="JUA_TL2";
        public static final String TL1="TL1";
        public static final String TL2="TL2";
        public static final String VALIDASI_PREMI="VALIDASI_PREMI";
        public static final String VALIDASI_JUA="VALIDASI_JUA";
        public static final String VALIDASI_PREMI_TOPUP="VALIDASI_PREMI_TOPUP";
    }

    public static final class Produk {
        public static final String JL4="JL4";
    }
    
    public static final class PenggantianBiaya{
        public static final String DITANGGUNG_SENDIRI="Ditanggung Sendiri";
        public static final String DITANGGUNG_JIWASRAYA="Ditanggung Jiwasraya";
    }

}
