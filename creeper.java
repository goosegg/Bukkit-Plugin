package com.github.goosegg.creeper;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class creeper extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("Creeper No-clip ENABLED!");
	}
 
	public void onDisable(){
		log.info("Regular Creepers D:");
	}
	
    public void onPlayerMove(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
    	Location loc = player.getLocation();
        generateCube(loc, 5);
    }

	public void generateCube(Location point, int length){
        World world = point.getWorld();
        
    	int x_start = point.getBlockX();     // Set the startpoints to the coordinates of the given location
    	int y_start = point.getBlockY();     // I use getBlockX() instead of getX() because it gives you a int value and so you dont have to cast it with (int)point.getX()
    	int z_start = point.getBlockZ();
     
    	int x_lenght = x_start + length;    // now i set the lenghts for each dimension... should be clear.
    	int y_lenght = y_start + length;
    	int z_lenght = z_start + length;
     
    	for(int x_operate = x_start; x_operate <= x_lenght; x_operate++){ 
    		// Loop 1 for the X-Dimension "for x_operate (which is set to x_start) 
    		//do whats inside the loop while x_operate is 
    		//<= x_length and after each loop increase 
    		//x_operate by 1 (x_operate++ is the same as x_operate=x_operate+1;)
    		for(int y_operate = y_start; y_operate <= y_lenght; y_operate++){// Loop 2 for the Y-Dimension
    			for(int z_operate = z_start; z_operate <= z_lenght; z_operate++){// Loop 3 for the Z-Dimension
     
    				Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); // get the block with the current coordinates
    				blockToChange.setTypeId(00);    // set the block to Type 34
    			}
    		}
    	}
    }



    public boolean onCommand(CommandSender sender, Command cmd, int commandLabel, int l){
    	if(cmd.getName().equalsIgnoreCase("ec")){ // If the player typed /basic then do the following...
    		Player player = (Player)sender;
    		Location tempLocation = player.getLocation();
			generateCube(tempLocation, l);
    		return true;
    	} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
    	return false; 
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if(cmd.getName().equalsIgnoreCase("rm")){ // If the player typed /basic then do the following...
    		Player player = (Player)sender;
    		Location tempLocation = player.getLocation();
			generateCube(tempLocation, 5);
    		return true;
    	} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
    	return false; 
    }
    

}
