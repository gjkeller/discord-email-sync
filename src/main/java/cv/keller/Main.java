package cv.keller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static final String PROPERTIES_FILE = "app.properties";
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private BotManager botManager;
    private MailManager mailManager;


    public static void main(String[] args) {
        File propertiesFile = new File(PROPERTIES_FILE);

        if (!propertiesFile.exists()) {
            log.error("No properties file exists at {}", PROPERTIES_FILE);
            System.exit(1);
        }

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            log.error("Error reading properties file ({})", PROPERTIES_FILE, e);
            System.exit(1);
        }

        log.info("Retrieving properties from {}", PROPERTIES_FILE);
        String discordToken = getPropertyOrExit(properties, "discord_token");
        String googleCredentialsFilename = getPropertyOrExit(properties, "google_credentials_filename");
        log.info("RETRIEVED FILE NAME: {}", googleCredentialsFilename);

        log.info("Retrieved properties, starting discord-email-sync");
        new Main(discordToken, googleCredentialsFilename);
        log.info("Started discord-email-sync");
    }

    private Main(String botToken, String googleCredentialsFilename) {
        botManager = new BotManager(botToken);
        mailManager = new MailManager(googleCredentialsFilename);
    }

    private static String getPropertyOrExit(Properties properties, String key) {
        String value = properties.getProperty(key);

        if(value == null) {
            log.error("Missing value for key '{}' in {}", key, PROPERTIES_FILE);
            System.exit(1);
        }

        return value;
    }

    public BotManager getBotManager() {
        return botManager;
    }

    public MailManager getMailManager() {
        return mailManager;
    }
}