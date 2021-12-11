package ovh.klemms.crosschat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.score.Team;

public class CrosschatBungee extends Plugin {

	@Override
	public void onEnable() {
		this.getProxy().getPluginManager().registerListener(this, new BungeeEvent());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static String getFormattedDate() {
		TimeZone tz = TimeZone.getTimeZone("Europe/Paris");
		DateFormat date = new SimpleDateFormat("HH:mm:ss");
		date.setTimeZone(tz);
		
		return date.format(new Date().getTime());
	}
	
	public static char getPlayerColor(ProxiedPlayer player) {
		for(Team team : player.getScoreboard().getTeams()) {
			for(String str : team.getPlayers()) {
				//System.out.println(player.getName() + " // " + str + " ** " + player.getName().equals(str) + " -- " + Integer.toHexString(team.getColor()).charAt(0) + " ++ " + team.getName());
				if (player.getName().equals(str))
					return Integer.toHexString(team.getColor()).charAt(0);
			}
			
		}
		
		return 'f';
	}
}
