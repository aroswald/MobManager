package io.github.aroswald.MobManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MobManager extends JavaPlugin implements Listener{
	private File configFile;
	private FileConfiguration config;
	
	@Override
	public void onEnable() {
		createConfig();
		getConfig();
		getServer().getPluginManager().registerEvents(this, this);
		clean();
	}
	@Override
	public void onDisable() {
		HandlerList.unregisterAll();
	}
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		boolean remove = checkEntity(e.getEntity());
		if(remove) e.setCancelled(true);
	}
	public boolean checkEntity(Entity e) {
		boolean remove = false;
		switch(e.getType()) {
		case BAT: 			
			if(!config.getBoolean("bat")){
				remove=true;
			}	
			break;
		case BEE: 			
			if(!config.getBoolean("bee")){
				remove=true;
			}	
			break;
		case BLAZE:			
			if(!config.getBoolean("blaze")){
				remove=true;
			}	
			break;
		case CAT:			
			if(!config.getBoolean("cat")){
				remove=true;
			}
			break;
		case CAVE_SPIDER: 	
			if(!config.getBoolean("spiderjockey")){
				if(e.eject()){
					remove=true;
				}			
			}
			if(!config.getBoolean("cavespider")){
				remove=true;
			}	
			break;
		case CHICKEN:
			if(!config.getBoolean("chickenjockey")){
				if(e.eject()){
					remove=true;
				}			
			}
			if(!config.getBoolean("chicken")){
				remove=true;
			}
			
			break;
		case COD:
			if(!config.getBoolean("cod")){
				remove=true;
			}	
			break;
		case COW:
			if(!config.getBoolean("cow")){
				remove=true;
			}	
			break;
		case CREEPER:
			if(!config.getBoolean("creeper")){
				remove=true;
			}	
			break;
		case DOLPHIN:
			if(!config.getBoolean("dolphin")){
				remove=true;
			}	
			break;
		case DONKEY:
			if(!config.getBoolean("donkey")){
				remove=true;
			}	
			break;
		case DROWNED:
			if(!config.getBoolean("babydrowned")) {
				Drowned d = (Drowned)e;
				if(d.isBaby()) {
					remove = true;
				}
			}
			if(!config.getBoolean("drowned")){
				remove=true;
			}	
			break;
		case ELDER_GUARDIAN:
			if(!config.getBoolean("elderguardian")){
				remove=true;
			}	
			break;
		case ENDER_DRAGON:
			if(!config.getBoolean("enderdragon")){
				remove=true;
			}	
			break;
		case ENDERMAN:
			if(!config.getBoolean("enderman")){
				remove=true;
			}	
			break;
		case ENDERMITE:
			if(!config.getBoolean("endermite")){
				remove=true;
			}	
			break;
		case EVOKER:
			if(!config.getBoolean("evoker")){
				remove=true;
			}	
			break;
		case FOX:
			if(!config.getBoolean("fox")){
				remove=true;
			}	
			break;
		case GHAST:
			if(!config.getBoolean("ghast")){
				remove=true;
			}	
			break;
		case GUARDIAN:
			if(!config.getBoolean("guardian")){
				remove=true;
			}	
			break;
		case HORSE:
			if(!config.getBoolean("horse")){
				remove=true;
			}	
			break;
		case HUSK:
			if(!config.getBoolean("babyhusk")) {
				Husk h = (Husk)e;
				if(h.isBaby()) {
					remove = true;
				}
			}
			if(!config.getBoolean("husk")){
				remove=true;
			}	
			break;
		case IRON_GOLEM:
			if(!config.getBoolean("irongolem")){
				remove=true;
			}	
			break;
		case LLAMA:
			if(!config.getBoolean("llama")){
				remove=true;
			}	
			break;
		case MAGMA_CUBE:
			if(!config.getBoolean("magmacube")){
				remove=true;
			}	
			break;
		case MULE:
			if(!config.getBoolean("mule")){
				remove=true;
			}	
			break;
		case MUSHROOM_COW:
			if(!config.getBoolean("mooshroom")){
				remove=true;
			}	
			break;
		case OCELOT:
			if(!config.getBoolean("ocelot")){
				remove=true;
			}	
			break;
		case PANDA:
			if(!config.getBoolean("panda")){
				remove=true;
			}	
			break;
		case PARROT:
			if(!config.getBoolean("parrot")){
				remove=true;
			}	
			break;
		case PHANTOM:
			if(!config.getBoolean("phantom")){
				remove=true;
			}	
			break;
		case PIG:
			if(!config.getBoolean("pig")){
				remove=true;
			}	
			break;
		case PIG_ZOMBIE:
			if(!config.getBoolean("babyzombiepigman")) {
				PigZombie pz = (PigZombie)e;
				if(pz.isBaby()) {
					remove = true;
				}
			}
			if(!config.getBoolean("zombiepigman")){
				remove=true;
			}	
			break;
		case PILLAGER:
			if(!config.getBoolean("pillager")){
				remove=true;
			}	
			break;
		case POLAR_BEAR:
			if(!config.getBoolean("polarbear")){
				remove=true;
			}	
			break;
		case PUFFERFISH:
			if(!config.getBoolean("pufferfish")){
				remove=true;
			}	
			break;
		case RABBIT:
			if(!config.getBoolean("rabbit")){
				remove=true;
			}	
			break;
		case RAVAGER:
			if(!config.getBoolean("ravager")){
				remove=true;
			}	
			break;
		case SALMON:
			if(!config.getBoolean("salmon")){
				remove=true;
			}	
			break;
		case SHEEP:
			if(!config.getBoolean("sheep")){
				remove=true;
			}	
			break;
		case SHULKER:
			if(!config.getBoolean("shulker")){
				remove=true;
			}	
			break;
		case SILVERFISH:
			if(!config.getBoolean("silverfish")){
				remove=true;
			}	
			break;
		case SKELETON:
			if(!config.getBoolean("skeleton")){
				remove=true;
			}	
			break;
		case SKELETON_HORSE:
			if(!config.getBoolean("skeletonhorseman")){
				if(e.eject()){
					remove=true;
				}			
			}
			if(!config.getBoolean("skeletonhorse")){
				remove=true;
			}	
			break;
		case SLIME:
			if(!config.getBoolean("slime")){
				remove=true;
			}	
			break;
		case SPIDER:
			if(!config.getBoolean("spiderjockey")){
				if(e.eject()){
					remove=true;
				}			
			}
			if(!config.getBoolean("spider")){
				remove=true;
			}	
			break;
		case SQUID:
			if(!config.getBoolean("squid")){
				remove=true;
			}	
			break;
		case STRAY:
			if(!config.getBoolean("stray")){
				remove=true;
			}	
			break;
		case TRADER_LLAMA:
			if(!config.getBoolean("traderllama")){
				remove=true;
			}	
			break;
		case TROPICAL_FISH:
			if(!config.getBoolean("tropicalfish")){
				remove=true;
			}	
			break;
		case TURTLE:
			if(!config.getBoolean("seaturtle")){
				remove=true;
			}	
			break;
		case VEX:
			if(!config.getBoolean("vex")){
				remove=true;
			}	
			break;
		case VILLAGER:
			if(!config.getBoolean("villager")){
				remove=true;
			}	
			break;
		case VINDICATOR:
			if(!config.getBoolean("vindicator")){
				remove=true;
			}	
			break;
		case WANDERING_TRADER:
			if(!config.getBoolean("wanderingtrader")){
				remove=true;
			}	
			break;
		case WITCH:
			if(!config.getBoolean("witch")){
				remove=true;
			}	
			break;
		case WITHER:
			if(!config.getBoolean("wither")){
				remove=true;
			}	
			break;
		case WITHER_SKELETON:
			if(!config.getBoolean("witherskeleton")){
				remove=true;
			}	
			break;
		case WOLF:
			if(!config.getBoolean("wolf")){
				remove=true;
			}	
			break;
		case ZOMBIE:
			if(!config.getBoolean("babyzombie")) {
				Zombie z = (Zombie)e;
				if(z.isBaby()) {
					remove = true;
				}
			}
			if(!config.getBoolean("zombie")){
				remove=true;
			}	
			break;
		case ZOMBIE_VILLAGER:
			if(!config.getBoolean("babyzombievillager")) {
				ZombieVillager zv = (ZombieVillager)e;
				if(zv.isBaby()) {
					remove = true;
				}
			}
			if(!config.getBoolean("zombievillager")){
				remove=true;
			}	
			break;
		default:
			break;
		}
		return remove;
	}
	public void clean() {
		for (World w : getServer().getWorlds()) {
			for(Chunk c : w.getLoadedChunks()) {
				for(Entity e : c.getEntities()) {
					boolean remove = checkEntity(e);
					if(remove) {
						e.remove();
					}
				}
			}
		}
	}

	@EventHandler	
	public void onPlayerChat(AsyncPlayerChatEvent e){
		String message = e.getMessage().toLowerCase();
		Player p = e.getPlayer();
		//p.sendMessage("message is " + message + ".");
		//p.sendMessage("index of mmset is " + message.indexOf("mmset", 0));
		//if(p.isOp()){p.sendMessage(p.getName() + "is Op");}
		if((message.indexOf("mmset",0) == 0) && (p.isOp())) {
			boolean pass = true;
			int start=6;
			int end=message.indexOf(' ', start);
			//p.sendMessage("end index is "+ end +".");
			
			String mob=message.substring(start,end);
			//p.sendMessage("mob is "+ mob + ".");
			if (!config.isSet(mob)) {
				p.sendMessage(mob +" is not recognized by the config file.");
				pass=false;
			}
			
			String bool=message.substring(end+1,message.length());
			//p.sendMessage("bool is " + bool + ".");
			boolean value = false;
			if((bool.equals("true")) || (bool.equals("false"))){
				if(bool =="true")value=true;
				if(bool =="false")value=false;
			}else {
				p.sendMessage("value must be either true or false");
				pass=false;
			}
			if(pass) {
				config.set(mob,value);
				try{
					config.save(configFile);
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
				p.sendMessage(mob + " has been set to " + bool);
				if(!value) {
					clean();
				}
			}
		}
	}
	private void addConfigDefaults() {
		//passive mobs
		config.set("bat"			, true);
		config.set("cat"			, true);
		config.set("chicken"		, true);
		config.set("cod"			, true);
		config.set("cow"			, true);
		config.set("donkey"			, true);	
		config.set("fox"			, true);	
		config.set("horse"			, true); 
		config.set("mooshroom"		, true);
		config.set("mule"			, true);
		config.set("ocelot"			, true);
		config.set("parrot"			, true);
		config.set("pig"			, true);
		config.set("rabbit"			, true);
		config.set("salmon"			, true); 
		config.set("seaturtle"		, true);
		config.set("sheep"			, true);
		config.set("skeletonhorse"	, true);
		config.set("snowgolem"		, true);
		config.set("squid"			, true);
		config.set("tropicalfish"	, true);
		config.set("villager"		, true);
		config.set("wanderingtrader", true);
		config.set("traderllama"	, true);
		//Defensive Mobs
		config.set("pufferfish"		, true);
		//Neutral Mobs
		config.set("bee"			, true);
		config.set("caveSpider"		, true);
		config.set("dolphin"		, true);
		config.set("enderman"		, true);
		config.set("irongolem"		, true);
		config.set("llama"			, true);
		config.set("panda"			, true);
		config.set("polarbear"		, true);
		config.set("spider"			, true);
		config.set("wolf"			, true);
		config.set("zombiepigman"	, true);
		config.set("babyzombiepigman",true);
		//Hostile Mobs
		config.set("blaze"			, true);
		config.set("chickenjockey"	, true);	
		config.set("creeper"		, true);	
		config.set("drowned"		, true);
		config.set("babydrowned"	, true);
		config.set("elderguardian"	, true);	
		config.set("endermite"		, true);	
		config.set("evoker"			, true);	
		config.set("ghast"			, true);	
		config.set("guardian"		, true);
		config.set("husk"			, true);
		config.set("babyhusk"		, true);
		config.set("magmacube"		, true);	
		config.set("phantom"		, true);	
		config.set("pillager"		, true);
		config.set("ravager"		, true);	
		config.set("shulker"		, true);	
		config.set("silverfish"		, true);	
		config.set("skeleton"		, true);	
		config.set("skeletonhorseman",true);
		config.set("slime"			, true);
		config.set("spiderjockey"	, true);	
		config.set("stray"			, true);	
		config.set("vex"			, true);	
		config.set("vindicator"		, true);	
		config.set("witch"			, true);	
		config.set("witherskeleton"	, true);	
		config.set("zombie"			, true);
		config.set("babyzombie" 	, true);
		config.set("zombievillager"	, true);
		//Boss Mobs
		config.set("enderdragon"	, true);
		config.set("wither"			, true);
		
		try{
			config.save(configFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void createConfig() {
		configFile = new File(getDataFolder(),"config.yml");
		boolean add = false;
		if(!configFile.exists()) {
			add = true; 
			configFile.getParentFile().mkdirs();
			saveResource("config.yml",false);
		}
		config = new YamlConfiguration();
		try {
			config.load(configFile);
		}
		catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		if(add){addConfigDefaults();}
	}
	public FileConfiguration getConfig() {
		return this.config;
	}
}
