package com.github.yanglikun.common.logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author yanglikun
 */
public class LogLevelChangeLog4j {

    public static void change(String loggerName, String levelName) {
        if (StringUtils.isBlank(loggerName) || StringUtils.isBlank(levelName)) {
            return;
        }

        Logger logger = org.apache.log4j.LogManager.getLogger(loggerName);
        if (logger != null) {
            Level level = org.apache.log4j.Level.toLevel(levelName, null);
            if (level != null) {
                logger.setLevel(level);
            }
        }
    }

}
