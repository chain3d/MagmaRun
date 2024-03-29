package net.darkdevelopers.magmarun

import de.astride.minecraft.servercore.spigot.ServerCoreSpigotPlugin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.darkdevelopers.darkbedrock.darkness.general.modules.Module
import net.darkdevelopers.darkbedrock.darkness.general.modules.ModuleDescription
import net.darkdevelopers.darkbedrock.darkness.spigot.functions.schedule
import net.darkdevelopers.magmarun.events.PlayerEvents
import net.darkdevelopers.magmarun.functions.firstWorld
import net.darkdevelopers.magmarun.functions.removeBlock
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.plugin.Plugin
import kotlin.random.Random

/**
 * Created on 30.06.2019 01:37.
 * @author Lars Artmann | LartyHD
 */
class MagmaRun : Module {

    override val description: ModuleDescription = ModuleDescription(
        javaClass.simpleName,
        "1.0.0",
        "Lars Artmann | LartyHD",
        "A Minecraft jump and run game"
    )

    override fun start() {

        spawnPlatform()
        PlayerEvents.setup(ServerCoreSpigotPlugin.javaPlugin)
        startRemoveTask()

    }

    override fun stop() {
        PlayerEvents.reset()
    }

    private fun startRemoveTask() {
        GlobalScope.launch {
            while (ServerCoreSpigotPlugin.javaPlugin.isEnabled) {
                delay(50) //wait 5 seconds
                for (player in Bukkit.getOnlinePlayers())
                    player.removeBlock()
            }
        }
    }

    private fun spawnPlatform(plugin: Plugin = ServerCoreSpigotPlugin.javaPlugin) {

        GlobalScope.launch {

            for (x in 0 until 50) {
                for (z in 0 until 50) {
                    val block = Location(firstWorld, x.toDouble(), 100.0, z.toDouble()).block

                    plugin.schedule {
                        block.type = Material.WOOL
                        @Suppress("DEPRECATION")
                        block.data = Random.nextBits(4).toByte()
                    }

                }
            }

        }

    }

}