package welcomeEmojiDiscordBot.extensions
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import welcomeEmojiDiscordBot.TEST_SERVER_ID

// Contains all methods related to debugging.
// This class is separate, so I can use it in future bots.
class DebugExtension : Extension() {
	override val name: String = "debug"

	override suspend fun setup() {
		publicSlashCommand {
			name = "stop"
			description = "Stops the bot"

			guild(TEST_SERVER_ID)  // Otherwise it will take up to an hour to update

			action {
				respond {
					content = "${event.interaction.user.mention} stopped the QRBot."
				}

				bot.stop() // Kills the process.
			}
		}
	}
}
