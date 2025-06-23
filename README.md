# Discord-Email Sync

A Java application that bridges communication between Discord and email, enabling seamless interaction between recruiters and students. This project is designed for [Texas ACM](https://texasacm.org)'s Industry Affairs team to connect industry partners with UT Austin's wide base of students, allowing each party to communicate on the platform they are most comfortable with.

## Overview

Discord-Email Sync listens to messages in a specified Discord channel and forwards them as emails to a designated recipient. This helps recruiters and students communicate efficiently, regardless of whether they prefer Discord or email.

## Features

- Listens to messages in a specific Discord channel.
- Forwards messages as emails using the Gmail API.
- Simple configuration using a properties file.
- Designed for easy deployment and use by Texas ACM's Industry Affairs team.

## Getting Started

### Prerequisites

- Java 21 or higher
- Gradle (or use the provided Gradle wrapper)
- A Discord bot token
- Google Cloud project with Gmail API enabled and OAuth 2.0 credentials

### Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-org/discord-email-sync.git
   cd discord-email-sync
   ```

2. **Configure application properties:**

   - Copy `src/main/resources/app.properties.example` to `src/main/resources/app.properties`.
   - Fill in your Discord bot token and the filename of your Google client secret JSON.

   ```
   discord_token=YOUR_DISCORD_BOT_TOKEN
   google_credentials_filename=YOUR_CLIENT_SECRET.json
   ```

3. **Add your Google client secret:**

   - Download your OAuth 2.0 client secret from the Google Cloud Console.
   - Place the JSON file in `src/main/resources/`.

4. **Build the project:**

   ```sh
   ./gradlew build
   ```

5. **Run the application:**

   ```sh
   ./gradlew run
   ```

   The application will prompt you to authorize access to your Gmail account on first run.

### Discord Bot Setup Notes

To allow the bot to read messages and function properly, you must enable the **Message Content Intent** in your Discord application settings:

1. Go to the [Discord Developer Portal](https://discord.com/developers/applications) and select your application.
2. Navigate to the **Bot** tab.
3. Under **Privileged Gateway Intents**, enable **MESSAGE CONTENT INTENT**.
4. Save your changes.
5. Invite the bot to your server with the appropriate permissions (at minimum: `Read Messages/View Channels`, `Send Messages`).

### Gmail API Setup Notes

To allow the application to send emails on your behalf, you need to set up a Google Cloud project and enable the Gmail API:

1. Go to the [Google Cloud Console](https://console.cloud.google.com/).
2. Create a new project (or select an existing one).
3. Navigate to **APIs & Services > Library** and search for **Gmail API**.
4. Click **Enable** to activate the Gmail API for your project.
5. Go to **APIs & Services > Credentials**.
6. Click **Create Credentials** > **OAuth client ID**.
   - If prompted, configure the consent screen (set the app name, user support email, and developer contact info).
   - Choose **Desktop app** as the application type.
   - Name your client and click **Create**.
7. Download the client secret JSON file using the **Download** button.
8. Place the downloaded JSON file in `src/main/resources/` and reference its filename in your `app.properties` as `google_credentials_filename`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request if you have suggestions or improvements.

## License

This project is licensed under the GNU General Public License 3.0 (GPLv3). See the [LICENSE](LICENSE) file for details.
