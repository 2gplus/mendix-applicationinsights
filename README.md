# mendix-applicationinsights
This module was created to integrate the logging from the Mendix applciation into Azure Application Insights. The purpose of this module is two-fold:
* Send default Mendix logging to Application Insights
* Send custom metrics information to Application Insights

The reason for this is that if you are already using Application Insights to monitor your other Azure components (like Functions or Logic apps) you can now use a single location for your system / functional administrators for their logging information.

You can use custom attributes to provide correlation information to the Application Insights.

## Usage

The Java action InitializeApplicationInsights needs to be called when the Mendix application starts. So add a call to this Java action in your AfterStartup flow. You need to provide an instrumentation key which is the unique identifier for your App Insights instance. Make a constant for this. You need this key later on to send custom traces.

By default only informational messages and up are logged. If you want you can also send the traces to AppInsights. Be aware that this will also include the Jetty logs!

After the initialization is done you can use one of the other Java actions to send custom information to AppInsights:
* Traces
* Dependency calls
* Metrics
* Request information
