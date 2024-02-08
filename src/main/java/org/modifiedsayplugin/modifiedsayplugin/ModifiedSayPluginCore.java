package org.modifiedsayplugin.modifiedsayplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

class ModifiedSayPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registrar el comando
        getCommand("say").setExecutor(new ModifiedSayCommand());
    }

    private class ModifiedSayCommand implements CommandExecutor, org.modifiedsayplugin.modifiedsayplugin.ModifiedSayCommand {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            // Verificar permisos
            if (!sender.hasPermission("modifiedsay.use")) {
                sender.sendMessage("No tienes permiso para usar este comando.");
                return true;
            }

            // Procesar el mensaje
            String message = String.join(" ", args);
            message = "<color:#ff0000>[SAY] </color>" + message;

            // Enviar el mensaje formateado
            Bukkit.broadcastMessage(message);
            return true;
        }
    }
}
