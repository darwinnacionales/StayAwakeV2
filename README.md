# StayAwakeV2

Your computer, by default, sleeps (and shutdowns) after a couple of minutes of inactivity. This is not good if by intention you prefer it to stay awake due to whatever reason (downloading files overnight, etc.). 

And yes, you may opt to changing the settings in Energy Saver for MacOS or Power Options for Windows. But if your use case is to remain active in some applications, say Slack or Skype, keeping your machine awake will still change your status in these applications as "Away" after a couple of minutes.

This is where StayAwake app comes in. It will move your cursor 1px to the right and back every 30 seconds (by default) to simulate a moving mouse. You can also configure its frequency.

# How-To
If you just prefer to download the app and run it, follow the steps below:
1. Go to this link: https://www.dropbox.com/s/axdgbjhlkwgow0v/StayAwake.jar?dl=0
2. Click `Download` then `Direct Download`
3. Download the file to a directory you prefer
4. Double click the file and it should show an icon similar to the one below:

MacOS:

<img width="555" alt="Screenshot 2020-06-20 at 12 51 25 PM" src="https://user-images.githubusercontent.com/7297625/85192395-f6c39a80-b2f4-11ea-8ec0-a069cf09f05f.png">

Windows:

<img width="300" alt="Screenshot 2020-06-20 at 12 51 25 PM" src="https://user-images.githubusercontent.com/7297625/85192459-2d011a00-b2f5-11ea-8a01-030139a39168.JPG">

*Note: It may ask permission first depending on your machine. Just allow it and it should work.*

5. Right-click the icon and select `Start`. By default, it will move the cursor 1px to the right then left every 30 seconds.
6. To change the frequency, right-click the icon and select `Configure`. Update the Frequency Field then click `Save`. Right-click the icon once again, select `Stop` then select `Start` for the changes to reflect immediately.

For anyone doubting the application for any malicious codes, you may explore the the GitHub below for the source code. Feel free to build the codes by yourself. :)

https://github.com/darwinnacionales/StayAwakeV2

# Run App on Login

**For Windows**
1. Create a desktop shortcut or a shortcut of the downloaded file.
2. Open Windows Explorer and type %AppData% into the file explorer address bar.
3. Open the Microsoft folder -> Windows -> Start Menu -> Programs -> Start-up
4. Copy and paste the shortcut you created earlier

**For MacOS**
1. Open `System Preferences`
2. Select `Users and Groups`
3. Select `Login Items` tab
4. Add the downloaded file in the list

<img width="674" alt="Screenshot 2020-06-20 at 8 48 33 PM" src="https://user-images.githubusercontent.com/7297625/85202222-7a05e000-b337-11ea-90ce-6060937e000a.png">

## Note
This tool is not intended to promote laziness in work or school. I find it useful for personal reasons and I hope it will be the same for you too. :)

# Future Improvements
- Launch application upon Login
- Start mouse movement upon launch of application
- Automatically stop after certain period of time

Feel free to suggest if you have any feature preferences!
