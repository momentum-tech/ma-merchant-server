package com.mmnttech.ma.merchant.server.common.entity;

/**
 * @类名 CommonDictionary
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月8日 上午10:02:46
 * @版本 v1.0
 * 
 */
public interface DictionaryConst {

    enum PayName {
        WEIX("weix"), ALIPAY("alipay");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        PayName(String value) {

            this.value = value;
        }

    }

    enum AuthStat {
        UNAUTHORIZED("0"), WAITING_4_AUTHORIZETION("1"), ONLINE_AUTHORIZETION("2"), OFFLINE_AUTHORIZETION("3"), AUTHORIZETION_FAILUE("4");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        AuthStat(String value) {

            this.value = value;
        }
    }

    enum TypeStat {
        NORMAL("normal"), CHECK("check");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        TypeStat(String value) {

            this.value = value;
        }
    }

    enum Stat {
        DISABLE("0"), ENABLE("1");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        Stat(String value) {

            this.value = value;
        }
    }

    enum MerchantComStat {
        COM_STAT_UNAUTHORIZED("0"), COM_STAT_WAITING_4_AUTHORIZETION("1"), COM_STAT_AUTHORIZETION_PASS("2"), COM_STAT_AUTHORIZETION_DENY("3");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        MerchantComStat(String value) {

            this.value = value;
        }

        public static MerchantComStat forValue(String value) {
            switch (value) {
                case "0":
                    return COM_STAT_UNAUTHORIZED;
                case "1":
                    return COM_STAT_WAITING_4_AUTHORIZETION;
                case "2":
                    return COM_STAT_AUTHORIZETION_PASS;
                case "3":
                    return COM_STAT_AUTHORIZETION_DENY;
                default:
                    return null;
            }
        }
    }

    enum SvcUserStatus {
        NORMAL("1"), DISABLE("2");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        SvcUserStatus(String value) {

            this.value = value;
        }
    }

    enum MerchantAuthType {
        BASIC_INFO("1"), LICENSE_AUTH("2"), HONEST_MERCHANT("3");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        MerchantAuthType(String value) {

            this.value = value;
        }

        public static MerchantAuthType forValue(String value) {
            switch (value) {
                case "1":
                    return BASIC_INFO;
                case "2":
                    return LICENSE_AUTH;
                case "3":
                    return HONEST_MERCHANT;
                default:
                    return null;
            }
        }
    }

    enum AttachType {
        HEAD_IMAGE("1"), ID_FRONT_IMAGE("2"), ID_BACK_IMAGE("3"), MERCHANT_LICENSE_IMAGE("4"), MERCHANT_QR("5");

        private String value;

        AttachType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static AttachType forValue(String value) {
            switch (value) {
                case "1":
                    return HEAD_IMAGE;
                case "2":
                    return ID_FRONT_IMAGE;
                case "3":
                    return ID_BACK_IMAGE;
                case "4":
                    return MERCHANT_LICENSE_IMAGE;
                default:
                    return null;
            }
        }
    }

    enum ComplaintsStat {
        WAITING("1"), ENDING("2"), PROCESSING("P");

        private String value;

        ComplaintsStat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static ComplaintsStat forValue(String value) {
            switch (value) {
                case "1":
                    return WAITING;
                case "2":
                    return ENDING;
                case "P":
                    return PROCESSING;
                default:
                    return null;
            }
        }
    }


    enum TaskType {
        TYPE_MERCHANT("01"), TYPE_COMPLAINT("02");

        private String value;

        TaskType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static TaskType forValue(String value) {
            switch (value) {
                case "1":
                    return TYPE_MERCHANT;
                case "2":
                    return TYPE_COMPLAINT;
                default:
                    return null;
            }
        }
    }

    enum TaskStatus {
        STATUS_STANDBY("1"), STATUS_FINISH("2"), STATUS_PROCESSING("P");

        private String value;

        TaskStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static TaskStatus forValue(String value) {
            switch (value) {
                case "1":
                    return STATUS_STANDBY;
                case "2":
                    return STATUS_FINISH;
                case "P":
                    return STATUS_PROCESSING;
                default:
                    return null;
            }
        }
    }

    enum MerchantStat {
        OPENING("0"), HALF_BREAKING("1"), BREAKING("2"), BLACK_LIST("3");

        private String value;

        MerchantStat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static MerchantStat forValue(String value) {
            switch (value) {
                case "0":
                    return OPENING;
                case "1":
                    return HALF_BREAKING;
                case "2":
                    return BREAKING;
                case "3":
                    return BLACK_LIST;
                default:
                    return null;
            }
        }
    }
	
}
