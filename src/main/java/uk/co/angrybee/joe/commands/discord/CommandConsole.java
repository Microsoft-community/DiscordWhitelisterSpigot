package uk.co.angrybee.joe.commands.discord;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.co.angrybee.joe.AuthorPermissions;
import uk.co.angrybee.joe.DiscordClient;
import uk.co.angrybee.joe.DiscordWhitelister;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandConsole
{
    public static void ExecuteCommand(SlashCommandInteractionEvent event, String input)
    {
        // AuthorPermissions authorPermissions = new AuthorPermissions(event);
        User author = event.getUser();

        if (author.getIdLong() != 228574821590499329L && author.getIdLong() != 159016432498114560L) {
            DiscordClient.ReplyAndRemoveAfterSeconds(event, DiscordClient.CreateInsufficientPermsMessage(author));
            return;
        }

        DiscordClient.ExecuteServerCommand(input);
        DiscordWhitelister.getPlugin().getLogger().info(author.getName() + "(" + author.getId() + ") used console: " + input);
        DiscordClient.ReplyAndRemoveAfterSeconds(event, DiscordClient.CreateEmbeddedMessage("console", "done", DiscordClient.EmbedMessageType.INFO).build() );
        
    }
}
