package com.github.yanglikun.common.logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yanglikun
 */
public class LogChangeLogback {

    public static void change(String loggerName, String levelName) {
        if (StringUtils.isBlank(loggerName) || StringUtils.isBlank(levelName)) {
            return;
        }

        LoggerContext loggerContext = (LoggerContext) org.slf4j.LoggerFactory.getILoggerFactory();//这里有强制转换
        Logger logger = loggerContext.getLogger(loggerName);
        if (logger != null) {
            Level level = Level.toLevel(levelName, null);
            if (level != null) {
                logger.setLevel(level);
            }
        }
    }

}
