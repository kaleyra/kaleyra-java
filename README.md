<p align="center">
<img src=https://media.licdn.com/dms/image/C4E1BAQEhWsmiOrN0jA/company-background_10000/0?e=2159024400&v=beta&t=e-l5A60dSZUlQxmOUUnjJFTA8FyBQzPME_2tK0avqm8>
</p>

# [Kaleyra](https://www.kaleyra.com/)
Kaleyra is a global communications solutions provider that offers an extensive range of telecommunication services for banks, retail and e-commerce companies, and enterprises. Through a global platform, Kaleyra enables its customers to reach, engage and manage an integrated and multi-channel notification services such as messages, push notifications, emails, instant messaging and voice services. Our services help businesses connect and communicate with their customers, increasing customer retention and satisfaction in an easy and effective manner.

Our mission is to make customer communication between business and their customers uncomplicated by removing the technology barrier with our cutting edge communication platforms. 
## Getting Started
### Prerequisites
- Java has to be installed on your system (Java 8 or above)
- An IDE for working on the library ([Intellij](https://www.jetbrains.com/idea/download/#section=windows),[Eclipse](https://www.eclipse.org/downloads/) are recommended ones)

### Creating an account
- To use the library,you will need a Kaleyra account,valid sender ID and API key.
- Sign up for a Kaleyra account by clicking [here](http://accounts.kaleyra.com/login?next=home)
- Click on New Service and select Alert
- Verify your mobile number and email id
- Visit [Alerts Kaleyra](https://alerts.kaleyra.com/)
- Login using the credentials provided in the email sent after signing up
- From the left hand menu, go to Developer->API keys and request for a new API key
- API Key will be sent to your email
- Apply for approval of your sender ID by sending a mail to support@kaleyra.com

### Getting the library on your system
- Git clone or download the library package onto your system

### Configuring the library
- Enter your approved sender ID and API Key in the file named SMS.properties 
- You have successfully configured the library and you are now free to send messages across the globe.

### Using the library
The library contains functions to consume 14 different types of APIs provided by Kaleyra:
 - Send SMS
 - Schedule SMS
 - Edit Scheduled SMS
 - Delete Scheduled SMS
 - Check SMS Status
 - Check Credits
 - Check Credit Usage in a date range
 - Create Txtly Link
 - Extract Txtly Reports
 - Pull Individual Txtly Logs
 - Delete Txtly Link
 - Create SMS group
 - Add contacts to SMS group
 - Send SMS to group
 
 ## Quickstart
 ### Send an SMS
 - Number and message are mandatory parameters
 - Other parameters such as dlrURL, custom, unicode, flash and port are optional parameters which can be null
 ```java
 SMSMessageRequest smsMessageRequest = new SMSMessageRequest("91XXXXXXXXXX","message",null,null,null,null,null);
 SMSMessageResponse smsMessageResponse = smsMessageRequest.sendSMS();
 System.out.println(smsMessageResponse.toJSON());
 ```
 ### Schedule an SMS
 - Number,message and dateAndTime are mandatory parameters
 - Other parameters such as dlrURL, custom, unicode, flash and port are optional parameters which can be null
 ```java
 SMSMessageRequest smsMessageRequest = new SMSMessageRequest("91XXXXXXXXXX","message",null,null,null,null,null);        
 smsMessageRequest.setSchedule("12-6-2019 12:45 PM", "dd-MM-yyyy hh:mm a");
 SMSMessageResponse smsMessageResponse = smsMessageRequest.scheduleSMS(); 
 System.out.println(smsMessageResponse.toJSON());
 ```
 ### Create a Txtly Link
 - Parameters except url are optional which can be null
 ```java
  TxtlyRequest txtlyRequest = new TxtlyRequest("https://www.kaleyra.com/",null,null,null,null,null,null);
  TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();
  System.out.println(txtlyResponse.toJSON());
 ```
 ### Create a Group
 - GroupName is mandatory whereas format is optional parameter
 ```java
  GroupRequest groupRequest = new GroupRequest("GroupName",null);
  GroupResponse groupResponse = groupRequest.create();
  System.out.println(groupResponse.toJSON());
 ```
 # Documentation
 The documentation for the Kaleyra API can be found [here](https://apidocs-sms.kaleyra.com/?version=latest).

# Getting help
If you need help configuring or using the library, please check the [Kaleyra Support Help Center](http://support.kaleyra.com/support/home) first, and file a support ticket if you don't find an answer to your question.

If you've instead found a bug in the library or would like new features added, go ahead and open issues or pull requests against this repo!
