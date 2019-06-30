package net.darkdevelopers.magmarun.events

import net.darkdevelopers.darkbedrock.darkness.spigot.functions.events.listen
import net.darkdevelopers.darkbedrock.darkness.spigot.manager.game.EventsTemplate
import net.darkdevelopers.magmarun.functions.firstWorld
import org.bukkit.Location
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.Plugin

/**
 * Created on 30.06.2019 01:54.
 * @author Lars Artmann | LartyHD
 */
object PlayerEvents : EventsTemplate() {

    fun setup(plugin: Plugin) {

        listen<PlayerJoinEvent>(plugin) {
            it.player.teleport(Location(firstWorld, 0.0, 101.0, 0.0))
        }.add()

    }

}