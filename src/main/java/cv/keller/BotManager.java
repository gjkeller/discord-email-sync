package cv.keller;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

public class BotManager extends ListenerAdapter {

    private static final Logger log = LoggerFactory.getLogger(BotManager.class);
    private final JDA jda;
    private final Main main;

    public BotManager(Main main, String token) {
        this.main = main;
        this.jda = JDABuilder.createLight(token, EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
                .addEventListeners(this)
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!(event.getChannel().getIdLong() == 1386572322542063717L)) return;

        System.out.printf("[%s] %#s: %s\n",
                event.getChannel(),
                event.getAuthor(),
                event.getMessage().getContentDisplay());

        main.getMailManager().sendMessage("New message in Discord channel #%s from %s:\n\n%s".formatted(
                event.getChannel().getName(),
                event.getAuthor().getAsTag(),
                event.getMessage().getContentDisplay()
        ));
    }
}
