package com.anr.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;

import com.anr.config.ConfigProperties;
import com.google.gson.Gson;

@Component
public class SBUtil {
    @Autowired
    private ConfigProperties appProps;

    @Autowired
    private Gson gson;

    private static final Logger logger = LoggerFactory.getLogger(SBUtil.class);
    private static final String LOG_MSG_FORMAT = "[transmissionID = %s] %s (ts=%s)%n";
    private static final String DATE_FORMAT_WITH_MS = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String SPACE = " ";

    public void logDebug(String transactionID, String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(LOG_MSG_FORMAT,
                    StringUtils.isEmpty(transactionID) ? StringUtils.EMPTY : transactionID, message,
                    new SimpleDateFormat(DATE_FORMAT_WITH_MS).format(new Date())));
        }
    }

    public void logInfo(String transactionID, String message) {
        if (logger.isInfoEnabled()) {
            logger.debug(String.format(LOG_MSG_FORMAT,
                    StringUtils.isEmpty(transactionID) ? StringUtils.EMPTY : transactionID, message,
                    new SimpleDateFormat(DATE_FORMAT_WITH_MS).format(new Date())));
        }
    }

    public void logError(String transactionID, String message) {
        if (logger.isErrorEnabled()) {
            logger.debug(String.format(LOG_MSG_FORMAT,
                    StringUtils.isEmpty(transactionID) ? StringUtils.EMPTY : transactionID, message,
                    new SimpleDateFormat(DATE_FORMAT_WITH_MS).format(new Date())));
        }
    }

    public void logTrace(String transactionID, String message) {
        if (logger.isTraceEnabled()) {
            logger.debug(String.format(LOG_MSG_FORMAT,
                    StringUtils.isEmpty(transactionID) ? StringUtils.EMPTY : transactionID, message,
                    new SimpleDateFormat(DATE_FORMAT_WITH_MS).format(new Date())));
        }
    }

    public void logStackTrace(String transactionID, String message, Throwable e) {
        String txnID = StringUtils.isEmpty(transactionID) ? StringUtils.EMPTY : transactionID;
        String dtNow = new SimpleDateFormat(DATE_FORMAT_WITH_MS).format(new Date());
        Boolean isStackTraceLoggingEnabled = appProps.getLogStackTrace();

        if (logger.isErrorEnabled() && isStackTraceLoggingEnabled) {
            logger.error(LOG_MSG_FORMAT, txnID, message, dtNow);
            logger.error(LOG_MSG_FORMAT, txnID, ExceptionUtils.getRootCause(e), dtNow);
            ExceptionUtils.printRootCauseStackTrace(e);
        }
    }

    public String getRootCauseMessage(Throwable e) {
        String rootCauseMsg = null;
        Throwable rootExcept = NestedExceptionUtils.getMostSpecificCause(e);
        rootCauseMsg = ExceptionUtils.getRootCauseMessage(e);
        rootCauseMsg = StringUtils.isBlank(rootCauseMsg) ? rootExcept.getMessage() : rootCauseMsg;
        rootCauseMsg = rootCauseMsg + SPACE + rootExcept.getStackTrace()[0].toString();

        return rootCauseMsg;
    }
}
