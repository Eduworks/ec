EC UI Framework
===============

Developed by Devlin Junker (devlin.junker@eduworks.com)


This framework can be used to develop web browser based UI using JavaScript and Java (compiled into JavaScript
using ST-JS). The framework depends on jQuery, the Foundation UI Framework, and ST-JS to compile and run without
any errors. It also uses the browser HTML5 history API to track back button usage, which requires the user to be 
using IE 10+.


Using ST-JS permits us to write in both (or either) ST-JS Java and JavaScript languages. Writing in Java, developers are 
afforded type-safety and compilation to JavaScript that can catch syntax or dependency issues. Eduworks has also
written a number of libraries in ST-JS Java that simplify networking with LEVR servers and provide access to specific 
LEVR web services services.  Writing in JavaScript, developers are given flexibility and dynamic typing as well as the
ability to work closely with the jQuery libraries and browser API to manipulate what the user sees. 
 
 
The EC UI framework tries to encapsulate functionality with an MVC type of organization: 
- 'Controller' classes handle communication with the server end points and can manipulate web service parameters to
send specific messages and/or retrieve data from the server. Recommended written with ST-JS Java for easy access to Eduworks
ST-JS Java LEVR Libraries.
- 'View' classes manage HTML generation, browser event handlers, DOM manipulation, and error handling/display on the
web page. Recommended defined with ST-JS Java but implemented in JavaScript for close connection with the jQuery and 
DOM APIs.
- 'Model' classes are used to wrap the data/objects retrieved from the database. They contain fields for each of the 
typical properties of the object type and also can contain methods that interact with the server to manipulate or 
retrieve information related to the data contained in the instance. Recommended written with ST-JS Java for Object 
Oriented organization.


Views can be further split up into a few different types defined in the EC UI Framework, and each of these types 
is handled and displayed differently within an application. These different types are defined and each view in your
application should inherit one of these types:
	EcView - The most simple type that can be inherited, these will handle UI code for elements of the application that
		either don't fit in to the following types, or for components that are within multiple different other views, 
		and the code/functions can be re-used. Views only need to define the display function.
	EcScreen - Screens are tracked with the history API, because of this they need a display name as well as the display
		function. The display name is displayed in the URL bar so the user knows what page they are on. It is also used 
		with the history API to load the correct page when the back/forward button is pressed.
	EcOverlay - Overlays are essentially the same as screens, except that they <em>overlay</em> on top of the current
		screen and can be closed. They also need a display name and display function defined.
	EcModal - Modals are displayed in pop up boxes, they are not tracked by history and thus are not re-opened if the
		back/forward button is pressed and do not have a display name that is shown in the URL bar. Modals need to 
		define the display function and a modal size that dictates the dimensions of the pop-up box shown. Modals also 
		can have a closeModal function that is run when the modal is hidden/closed.


The EC UI Framework also provides Manager classes that help show/hide and track the different views that are displayed 
on the screen. There is a general ViewManager that associates a view instance with a DOM element, and also specific
Manager classes for the different sub-types of views that extend the ViewManager.
	ScreenManager - Provides functions for changing the current screen, and setting the default screen that the application
		loads on startup. Also allows callbacks on startup that check if a different page should be loaded rather than
		the default screen.
	OverlayManager - Provides functions for showing/hiding an overlay and determining if we are showing an overlay 
		currently. Also allows callbacks that can check if an overlay should be shown over the first screen that is 
		displayed on startup.
	ModalManager - Provides functions for showing/hiding a modal and determining if we are currently showing a modal.
		Also manages calling the current modal's closeModal function when it is closed. 

All projects should also have an entry point, that runs any code needed to start the application, which includes
initializing the EC UI Framework and configuring any controllers that needed to be pointed at servers.
This entry point can be written either in ST-JS Java or JavaScript also.
- In ST-JS Java an Application Manager Class can be created with a static main method that runs once all web 
application files have been loaded by the browser. 
- In Javascript, an event handler on the document ready event can be defined that will also run once all web
application files have been loaded by the browser.  

The simplified structure of the source code for an EC UI Project (with an entry point written in Java), looks like:

src/main
	java
		ApplicationManager.java  	-> Contains the main method that will run on application startup, any general
										use helper functions could be defined in here as well (or in a separate JavaScript
										file).
		controller 					-> Contains any controllers written specifically for this application that will 
										communicate with web services written for this application 
		model						-> Contains any model classes that are specific to this application
		view
			modal					-> Contains the Java definition for each Modal class in this application
			screen					-> Contains the Java definition for each Screen class in this application 
			overlay					-> Contains the Java definition for each Overlay class in this application
			other					-> Contains the Java definition for any other View classes in this application
	
	resources						-> Contains any LEVR rs2s that are application specific
	
	webapp							
		index.html					-> Simple HTML file that defines the <head> element and a <body> with at least a few 
										HTML elements (Screen Container; Overlay Wrapper, Close Button and Container; Modal
										Container), and JavaScript include directives for each 3rd party JavaScript file,
										compiled ST-JS JavaScript file, and JavaScript view file. 
		css							-> Contains any CSS needed for the application
		partials					-> Contains View-Specific HTML snippets that can be loaded by View's display functions 
		js							
			vendor					-> Contains 3rd party JavaScript files
			modal					-> Contains JavaScript implementations for each Modal class
			screen					-> Contains JavaScript implementations for each Screen class
			overlay					-> Contains JavaScript implementations for each Overlay class
			other					-> Contains JavaScript implementations for any other View class
		
