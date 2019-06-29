package net.darkdevelopers.magmarun

import net.darkdevelopers.darkbedrock.darkness.general.modules.Module
import net.darkdevelopers.darkbedrock.darkness.general.modules.ModuleDescription
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import kotlin.random.Random

class MagmaRun : Module {

    override val description: ModuleDescription = ModuleDescription(
        MagmaRun::class.simpleName.orEmpty(),
        "1.0.0",
        "Finn Artmann | Pandaro003",
        "A Minecraft jump and run game"
    )

    override fun start() {

        val world: World = Bukkit.getWorlds()[0]

        for (x in 0 until 50)
            for (z in 0 until 50) {
                val block = Location(world, x.toDouble(), 100.0, z.toDouble()).block
                block.type = Material.WOOL
                @Suppress("DEPRECATION")
                block.data = Random.nextBits(4).toByte()
            }


        println("${description.name} started")
    }

}