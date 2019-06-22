package net.darkdevelopers.magmarun

import net.darkdevelopers.darkbedrock.darkness.general.modules.Module
import net.darkdevelopers.darkbedrock.darkness.general.modules.ModuleDescription
import org.bukkit.Bukkit
import org.bukkit.World

class MagmaRun : Module {

    override val description: ModuleDescription = ModuleDescription(
        MagmaRun::class.simpleName.orEmpty(),
        "1.0.0",
        "Finn Artmann | Pandaro003",
        "A Minecraft jump and run game"
    )

    override fun start() {

        val world: World = Bukkit.getWorlds().get(0)

        println("${description.name} started")
    }

}