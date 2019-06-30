package net.darkdevelopers.magmarun.functions

import de.astride.minecraft.servercore.spigot.ServerCoreSpigotPlugin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.darkdevelopers.darkbedrock.darkness.spigot.functions.schedule
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.util.concurrent.TimeUnit

/*
 * Created on 30.06.2019 02:10.
 * @author Lars Artmann | LartyHD
 */

fun Player.removeBlock(plugin: Plugin = ServerCoreSpigotPlugin.javaPlugin) {
    val location = player.location.subtract(0.0, 1.0, 0.0)
    val type = location.block.type
    if (type == Material.AIR) return

    GlobalScope.launch {
        delay(TimeUnit.SECONDS.toMillis(1)) //waited a second
        plugin.schedule {
            location.block.type = Material.AIR //removes the block
        }
    }
}