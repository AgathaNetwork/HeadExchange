package com.mws.HeadExchange;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeadExchange
  extends JavaPlugin
{
  String prefix;
  
  public void onEnable()
  {
    getLogger().info("已加载HeadExchange插件");
  }
  
  public void onDisable() {}
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (cmd.getName().equalsIgnoreCase("he")) { // 如果玩家输入了/basic则执行如下内容...
      // 所需要执行的事（此处略）
    	  Player senp = (Player) sender;
    	  getLogger().info(senp.getInventory().getItemInMainHand().getType().toString());
    	  if (args.length==0) 
    	  {
    		  return true;
    	  }
    	  if(senp.getInventory().getItemInMainHand().getType()==Material.SKELETON_SKULL || senp.getInventory().getItemInMainHand().getType()==Material.WITHER_SKELETON_SKULL || senp.getInventory().getItemInMainHand().getType()==Material.CREEPER_HEAD || senp.getInventory().getItemInMainHand().getType()==Material.PLAYER_HEAD || senp.getInventory().getItemInMainHand().getType()==Material.ZOMBIE_HEAD || senp.getInventory().getItemInMainHand().getType()==Material.DRAGON_HEAD) {
    		  senp.getInventory().clear(senp.getInventory().getHeldItemSlot());
    		  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give "+senp.getName()+" player_head{SkullOwner:"+args[0]+"}");
    	  }
          return true;
      } //如果以上内容成功执行，则返回true 
      // 如果执行失败，则返回false.
      return false;
  }
  
}
