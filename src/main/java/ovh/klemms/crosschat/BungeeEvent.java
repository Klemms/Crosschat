package ovh.klemms.crosschat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeeEvent implements Listener {
	
	@EventHandler
	public void onPlayerChat(ChatEvent event) {
		if (event.getSender() instanceof ProxiedPlayer) {
			if (!event.getMessage().startsWith("/")) {
				ProxiedPlayer player = (ProxiedPlayer)event.getSender();
				ChatColor playerColor = ChatColor.getByChar(CrosschatBungee.getPlayerColor(player));

				ProxyServer.getInstance().broadcast(
						new ComponentBuilder(CrosschatBungee.getFormattedDate() + " ")
						.color(ChatColor.DARK_GRAY)
						.append(new ComponentBuilder(player.getServer().getInfo().getName() + " | [").color(ChatColor.GRAY).create())
						.append(new ComponentBuilder(player.getDisplayName()).color(playerColor).create())
						.append(new ComponentBuilder("]").color(ChatColor.GRAY).create())
						.append(new ComponentBuilder(" " + event.getMessage()).color(ChatColor.WHITE).create())
						.create());
				
				event.setCancelled(true);
			}
		}
	}
}
