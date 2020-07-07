package com.github.yanglikun.common.logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;

/**
 * @author yanglikun
 */
public class LogLevelChangeLog4j2 {

    public static void change(String loggerName, String levelName) {
        if (StringUtils.isBlank(loggerName) || StringUtils.isBlank(levelName)) {
            return;
        }

        Level level = org.apache.logging.log4j.Level.toLevel(levelName);
        org.apache.logging.log4j.core.config.Configurator.setLevel(loggerName, level);
    }

}
