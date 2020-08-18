package com.anr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sbsvc")
public class ConfigProperties {

    private Boolean logStackTrace;
    private WaitProperty waitperiod;

    public static class WaitProperty {
        private int apiDefaultService;
        private int apiSecondService;
        private String apiDefServiceKey;
        private String apiGroupKey;
        private int hyxThrdPoolCoreSizeApi;

        private int hyxCbSleepWindowMS;
        private int hyxCbReqVolmThreshold;
        private int hyxCbErrThresholdPercentage;
        private String hyxDefCircuitBrkrKey;
        private String hyxDefGroupKey;
        private Boolean hyxAllowMaxSizToDiverge;
        private int hyxThrdPoolCoreSize;
        private int hyxThrdPoolMaxSize;
        private int hyxThrdPoolMaxQueSize;
        private int hyxThrdPoolQueSizeRejThreshold;

        public int getApiDefaultService() {
            return apiDefaultService;
        }

        public void setApiDefaultService(int defaultapi) {
            apiDefaultService = defaultapi;
        }

        public int getApiSecondService() {
            return apiSecondService;
        }

        public void setApiSecondService(int secondapi) {
            apiSecondService = secondapi;
        }

        public int getHyxCbSleepWindowMS() {
            return hyxCbSleepWindowMS;
        }

        public void setHyxCbSleepWindowMS(int hyxCbSleepWindowMS) {
            this.hyxCbSleepWindowMS = hyxCbSleepWindowMS;
        }

        public int getHyxCbReqVolmThreshold() {
            return hyxCbReqVolmThreshold;
        }

        public void setHyxCbReqVolmThreshold(int hyxCbReqVolmThreshold) {
            this.hyxCbReqVolmThreshold = hyxCbReqVolmThreshold;
        }

        public int getHyxCbErrThresholdPercentage() {
            return hyxCbErrThresholdPercentage;
        }

        public void setHyxCbErrThresholdPercentage(int hyxCbErrThresholdPercentage) {
            this.hyxCbErrThresholdPercentage = hyxCbErrThresholdPercentage;
        }

        public String getHyxDefCircuitBrkrKey() {
            return hyxDefCircuitBrkrKey;
        }

        public void setHyxDefCircuitBrkrKey(String hyxDefCircuitBrkrKey) {
            this.hyxDefCircuitBrkrKey = hyxDefCircuitBrkrKey;
        }

        public String getHyxDefGroupKey() {
            return hyxDefGroupKey;
        }

        public void setHyxDefGroupKey(String hyxDefGroupKey) {
            this.hyxDefGroupKey = hyxDefGroupKey;
        }

        public Boolean getHyxAllowMaxSizToDiverge() {
            return hyxAllowMaxSizToDiverge;
        }

        public void setHyxAllowMaxSizToDiverge(Boolean hyxAllowMaxSizToDiverge) {
            this.hyxAllowMaxSizToDiverge = hyxAllowMaxSizToDiverge;
        }

        public int getHyxThrdPoolCoreSize() {
            return hyxThrdPoolCoreSize;
        }

        public void setHyxThrdPoolCoreSize(int hyxThrdPoolCoreSize) {
            this.hyxThrdPoolCoreSize = hyxThrdPoolCoreSize;
        }

        public int getHyxThrdPoolMaxSize() {
            return hyxThrdPoolMaxSize;
        }

        public void setHyxThrdPoolMaxSize(int hyxThrdPoolMaxSize) {
            this.hyxThrdPoolMaxSize = hyxThrdPoolMaxSize;
        }

        public int getHyxThrdPoolMaxQueSize() {
            return hyxThrdPoolMaxQueSize;
        }

        public void setHyxThrdPoolMaxQueSize(int hyxThrdPoolMaxQueSize) {
            this.hyxThrdPoolMaxQueSize = hyxThrdPoolMaxQueSize;
        }

        public int getHyxThrdPoolQueSizeRejThreshold() {
            return hyxThrdPoolQueSizeRejThreshold;
        }

        public void setHyxThrdPoolQueSizeRejThreshold(int hyxThrdPoolQueSizeRejThreshold) {
            this.hyxThrdPoolQueSizeRejThreshold = hyxThrdPoolQueSizeRejThreshold;
        }

        public int getHyxThrdPoolCoreSizeApi() {
            return hyxThrdPoolCoreSizeApi;
        }

        public void setHyxThrdPoolCoreSizeApi(int hyxThrdPoolCoreSizeApi) {
            this.hyxThrdPoolCoreSizeApi = hyxThrdPoolCoreSizeApi;
        }

        public String getApiDefServiceKey() {
            return apiDefServiceKey;
        }

        public void setApiDefServiceKey(String apiDefServiceKey) {
            this.apiDefServiceKey = apiDefServiceKey;
        }

        public String getApiGroupKey() {
            return apiGroupKey;
        }

        public void setApiGroupKey(String apiGroupKey) {
            this.apiGroupKey = apiGroupKey;
        }

    }

    public Boolean getLogStackTrace() {
        return logStackTrace;
    }

    public void setLogStackTrace(Boolean flag) {
        logStackTrace = flag;
    }

    public WaitProperty getWaitperiod() {
        return waitperiod;
    }

    public void setWaitperiod(WaitProperty waitperiod) {
        this.waitperiod = waitperiod;
    }

}
