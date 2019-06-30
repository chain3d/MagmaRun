package net.darkdevelopers.magmarun.functions

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.Material
import org.bukkit.entity.Player
import java.util.concurrent.TimeUnit

/*
 * Created on 30.06.2019 02:10.
 * @author Lars Artmann | LartyHD
 */

fun Player.removeBlock() {
    val location = player.location.subtract(0.0, 1.0, 0.0)
    GlobalScope.launch {
        delay(TimeUnit.SECONDS.toMillis(1)) //waited a second
        location.block.type = Material.AIR //removes the block
    }
}