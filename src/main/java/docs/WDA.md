## iOS tests require WebDriverAgent runner handling

to handle WebDriverAgent runner manually: </br>
run 'npx appium driver run xcuitest open-wda' to open WebDriverAgent project in Xcode

for WebDriverAgentRunner target:

- enable 'Automatically manage signing'
- select personal team
- modify bundle identifier by adding a custom string to 'com.facebook.WebDriverAgentRunner'

execute and keep script running in a separate terminal window,
where IOS_DEVICE_UDID - UDID of iOS device to run tests

#!/bin/bash
cd $HOME/node_modules/appium-xcuitest-driver/node_modules/appium-webdriveragent/
xcodebuild build-for-testing test-without-building -allowProvisioningUpdates -project
WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<IOS_DEVICE_UDID>'
