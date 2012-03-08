package me.Mirco.MircCMD;
import java.util.Timer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
public class mirccmd extends JavaPlugin
{	
	Timer timer = new Timer();
	@Override
	public void onDisable() 
	{
		System.out.println("[MircCMD] Plugin deaktiviert!");
	}

	@Override
	public void onEnable() {
		System.out.println("[MircCMD] Plugin aktiviert!");
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player player = null;
    	if (sender instanceof Player) {
    		player = (Player) sender;
    	}    
    	if (cmd.getName().equalsIgnoreCase("mcmdversion")){
    		player.sendMessage("MircCMD Version 0.3 Plugin for what we need!");
    		return true;
    	} else if (cmd.getName().equalsIgnoreCase("cool")) {
    		if (player == null) {
    			sender.sendMessage("Log dich doch ins Spiel ein du Idiot");
    		} else {
    			player.sendMessage(player.getDisplayName() + " is cool!");
    		}
    		return true;
    	} else if (cmd.getName().equalsIgnoreCase("getfreeop")) {
    		if (player == null) {
    			sender.sendMessage("Log dich doch ins Spiel ein du Idiot");
    		} else {
    			getServer().dispatchCommand(getServer().getConsoleSender(), "kick " + player.getDisplayName() + " Please read the signs! Thank you!");
    			getServer().dispatchCommand(getServer().getConsoleSender(), "say " + player.getDisplayName() + " was kicked by Notch (Can't read signs!)");
    		}
    		return true;
       	} else if (cmd.getName().equalsIgnoreCase("tgrain")) {
    		if (player == null) {
    			sender.sendMessage("Log dich doch ins Spiel ein du Idiot");
    		} else {
    			getServer().dispatchCommand(getServer().getConsoleSender(), "toggledownfall");
        		player.sendMessage("Das Wetter wurde getoggled!");
    		}
    		return true;
       	} else if (cmd.getName().equalsIgnoreCase("buytp")) {
    		if (player == null) {
    			sender.sendMessage("Log dich doch ins Spiel ein du Idiot");
    		} else {
    			if (args.length > 1) {
 		           sender.sendMessage("Too many arguments!");
 		           return true;
 		        } 
 		        if (args.length < 1) {
 		           sender.sendMessage("Not enough arguments!");
 		           return true;
 		        }
 		       Player player1 = player.getPlayer();
 		      PlayerInventory inventory = player1.getInventory(); // The player's inventory
 		      ItemStack themap = new ItemStack(Material.MAP, 1); // A stack of diamonds
 		   
 		      if (inventory.contains(themap)) {
 		          inventory.remove(themap);
 		          player1.sendMessage(ChatColor.GOLD + "Teleport...");
 		         getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + player1.getName() + " " + args[0]);
 		      }
 		      else {
 		    	 player1.sendMessage(ChatColor.GOLD + "No teleport! Make 1 map seperatly in your inventory!");
 		    	  return true;
 		      }
    		}
    		return true;
    	}
    	if (cmd.getName().equalsIgnoreCase("prom")){
    		player.sendMessage("Your are now Member!");
    		player.setPlayerListName(getName()+ "");
    		getServer().dispatchCommand(getServer().getConsoleSender(), "permissions player setgroup " + player.getDisplayName() + " Member");
            
    		return true;
    	}
    	return false;
    }
    
    
    
}