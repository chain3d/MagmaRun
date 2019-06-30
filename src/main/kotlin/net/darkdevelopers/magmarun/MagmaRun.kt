package net.darkdevelopers.magmarun

import de.astride.minecraft.servercore.spigot.ServerCoreSpigotPlugin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.darkdevelopers.darkbedrock.darkness.general.modules.Module
import net.darkdevelopers.darkbedrock.darkness.general.modules.ModuleDescription
import net.darkdevelopers.magmarun.events.PlayerEvents
import net.darkdevelopers.magmarun.functions.firstWorld
import org.bukkit.Location
import org.bukkit.Material
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

    }

    override fun stop() {
        PlayerEvents.reset()
    }

    private fun spawnPlatform() {

        GlobalScope.launch {

            for (x in 0 until 50) {
                for (z in 0 until 50) {
                    val block = Location(firstWorld, x.toDouble(), 100.0, z.toDouble()).block

                    block.type = Material.WOOL
                    @Suppress("DEPRECATION")
                    block.data = Random.nextBits(4).toByte()

                }
            }

        }

    }

}