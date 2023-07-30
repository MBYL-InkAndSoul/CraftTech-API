package inkandsoul.ctapi.main.common.both.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    public static PackagedLogger get(String modName, String classes) {
        return new PackagedLogger(modName, classes);
    }

    public static PackagedLogger get(String modName, Class<?> classes) {
        return new PackagedLogger(modName, classes);
    }

    public static class PackagedLogger {
        private final Logger logger;

        private final String modName;

        private PackagedLogger(String modName, Class<?> classes) {
            this.modName = modName;
            logger = LoggerFactory.getLogger(classes);
        }

        private PackagedLogger(String modName, String classes) {
            this.modName = modName;
            logger = LoggerFactory.getLogger(classes);
        }

        public void info(String t, Object ... o) {
            logger.info("[{}]" + t, modName, o);
        }

        public void warn(String t, Object ... o) {
            logger.warn("[{}]" + t, modName, o);
        }

        public void error(String t, Object ... o) {
            logger.error("[{}]" + t, modName, o);
        }
    }
}
