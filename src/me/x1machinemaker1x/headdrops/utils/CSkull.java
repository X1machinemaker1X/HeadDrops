package me.x1machinemaker1x.headdrops.utils;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

/**
 * Represents some special mob heads, also support creating player skulls and custom skulls.
 *
 * @author xigsag, SBPrime
 */
public enum CSkull {

    ARROW_LEFT("MHF_ArrowLeft"),
    ARROW_RIGHT("MHF_ArrowRight"),
    ARROW_UP("MHF_ArrowUp"),
    ARROW_DOWN("MHF_ArrowDown"),
    QUESTION("MHF_Question"),
    EXCLAMATION("MHF_Exclamation"),
    CAMERA("FHG_Cam"),

    ZOMBIE_PIGMAN("MHF_PigZombie"),
    PIG("MHF_Pig"),
    SHEEP("MHF_Sheep"),
    BLAZE("MHF_Blaze"),
    CHICKEN("MHF_Chicken"),
    COW("MHF_Cow"),
    SLIME("MHF_Slime"),
    SPIDER("MHF_Spider"),
    SQUID("MHF_Squid"),
    VILLAGER("MHF_Villager"),
    OCELOT("MHF_Ocelot"),
    HEROBRINE("MHF_Herobrine"),
    LAVA_SLIME("MHF_LavaSlime"),
    MOOSHROOM("MHF_MushroomCow"),
    GOLEM("MHF_Golem"),
    GHAST("MHF_Ghast"),
    ENDERMAN("MHF_Enderman"),
    CAVE_SPIDER("MHF_CaveSpider"),

    CACTUS("MHF_Cactus"),
    CAKE("MHF_Cake"),
    CHEST("MHF_Chest"),
    MELON("MHF_Melon"),
    LOG("MHF_OakLog"),
    PUMPKIN("MHF_Pumpkin"),
    TNT("MHF_TNT"),
    DYNAMITE("MHF_TNT2");

    private static final Base64 base64 = new Base64();
    private String id;

    private CSkull(String id) {
        this.id = id;
    }

    /**
     * Return a skull that has a custom texture specified by url, name, and randomUUID
     *
     * @param url skin url
     * @param name displayName
     * @param randomUUID pick a random UUID
     * @return itemstack
     */
    public static ItemStack getCustomSkull(String url, String name, UUID randomUUID) {
        GameProfile profile = new GameProfile(randomUUID, null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        Class<?> headMetaClass = headMeta.getClass();
        Reflections.getField(headMetaClass, "profile", GameProfile.class).set(headMeta, profile);
        headMeta.setDisplayName(ChatColor.RESET + name);
        head.setItemMeta(headMeta);
        net.minecraft.server.v1_12_R1.ItemStack nms = CraftItemStack.asNMSCopy(head);
        NBTTagCompound tag;
        if (nms.getTag() != null) 
        	tag = nms.getTag();
        else
        	tag = new NBTTagCompound();
        tag.setString("mob_head", name);
        nms.setTag(tag);
        head = CraftItemStack.asCraftMirror(nms);
        return head;
    }
    
    /**
     * Return a skull from a url, and a displayName
     * 
     * @param uri skin url
     * @param name displayName
     */
    public static ItemStack getCustomSkull(String url, String name) {
    	UUID headUUID = UUID.fromString(JSONUtil.readJSON("head-uuids", name));
        GameProfile profile = new GameProfile(headUUID, null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        Class<?> headMetaClass = headMeta.getClass();
        Reflections.getField(headMetaClass, "profile", GameProfile.class).set(headMeta, profile);
        headMeta.setDisplayName(ChatColor.RESET + name);
        head.setItemMeta(headMeta);
        net.minecraft.server.v1_12_R1.ItemStack nms = CraftItemStack.asNMSCopy(head);
        NBTTagCompound tag;
        if (nms.getTag() != null) 
        	tag = nms.getTag();
        else
        	tag = new NBTTagCompound();
        tag.setString("mob_head", name);
        nms.setTag(tag);
        head = CraftItemStack.asCraftMirror(nms);
        return head;
    }

    /**
     * Return a skull of a player.
     *
     * @param name player's name
     * @return itemstack
     */
    public static ItemStack getPlayerSkull(String name) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * Return the skull's id.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Return the skull of the enum.
     *
     * @return itemstack
     */
    public ItemStack getSkull() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(id);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

}
 