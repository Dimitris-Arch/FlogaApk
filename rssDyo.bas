B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public rp As RuntimePermissions

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	'Dim AdView1 As AdView

	
	Private mple As Label
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
	Dim WebView1 As WebView
	Dim wvXtender As WebViewXtender
	Dim lblProgress As Label
	Dim HTML As String
	Dim p As PhoneIntents
	Dim webviewText As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("rssdyo")
		

 

	simanseislabel.Top = 3%y
	simanseislabel.left = 3.5%x
	simanseislabel.height = 28%y
	simanseislabel.Width  = 45%x

	listabel.Top = 3%y
	listabel.left = 51.75%x
	listabel.height = 13%y
	listabel.Width  = 21.25%x





	katigorlabel.Top = 18%y
	katigorlabel.left = 51.75%x
	katigorlabel.height = 13%y
	katigorlabel.Width  = 21.25%x

	ousialabel.Top = 3%y
	ousialabel.left = 76%x
	ousialabel.height = 13%y
	ousialabel.Width  = 21.25%x


	ililabel.Top = 18%y
	ililabel.left = 76%x
	ililabel.height = 13%y
	ililabel.Width  = 21.25%x
   

	mple.top = 93%y
	mple.left = 3%x
	mple.width = 94%x
	mple.height = 7%y

	Dim job1 As HttpJob
	job1.Initialize("Job1", Me)
	job1.Download("http://www.google.com")
	
	HTML = File.GetText(File.DirAssets, "twit.html")
	Dim WebViewExtras1 As WebViewExtras
	WebViewExtras1.addWebChromeClient(WebView1, "WebViewExtras1")
	'   το λινκ για google news καπως ετσι :    https://news.google.com/rss/search?cf=all&pz=1&q=πυροσβεστικη&hl=el&gl=GR&ceid=GR:el
	'No Cookies
	wvXtender.setAcceptCookie(WebView1,True)
	'No JavaScript
	wvXtender.setJavaScriptEnabled(WebView1,True)
	'No Images
	wvXtender.setLoadsImagesAutomatically(WebView1,True)
	'No Plugins
	wvXtender.setPluginState(WebView1,"OFF")

	'Check if it works or not
	'ShowStates
	
	'Run Loading Progress Demo

	WebView1.Top = 33%y
	WebView1.Left = 3%x
	WebView1.height = 57.5%y
	WebView1.Width = 94%x
	WebView1.LoadHtml(HTML)
	webviewText = WebView1.Url

End Sub



Sub ShowStates
	Msgbox("Are cookies enabled? " & wvXtender.getAcceptCookie(WebView1),"Cookie State")
	Msgbox("Is JavaScript enabled? " & wvXtender.getJavaScriptEnabled(WebView1),"JavaScript State")
	Msgbox("Is Image Loading enabled? " & wvXtender.getLoadsImagesAutomatically(WebView1),"Image Loading State")
	Msgbox("ArePlugIns enabled? " & wvXtender.getPluginState(WebView1),"PlugIns State")
End Sub



Sub webView1_PageFinished (Url As String)

End Sub

Sub btnScroll_Click
	Dim Send As Button
	Dim strWich As String
	Dim bolZ As Boolean
	
	Send = Sender
	strWich = Send.Tag
	
	Select strWich
	
		Case "DownH"
			wvXtender.pageDown(WebView1,False)
		Case "DownF"
			wvXtender.pageDown(WebView1,True)
		Case "UpH"
			wvXtender.pageUp(WebView1,False)
		Case "UpF"
			wvXtender.pageUp(WebView1,True)
		Case "In"
			bolZ = wvXtender.zoomIn(WebView1)
		Case "Out"
			bolZ = wvXtender.zoomOut(WebView1)
	End Select
End Sub
Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then


		Log(Job.GetString)

	
	Else
		ToastMessageShow("Χωρις σύνδεση στο διαδίκτυο",True)
		Activity.Finish
	End If
	Job.Release
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	'Activity.Finish
	
End Sub





Sub simanseislabel_Click
	StartActivity("rss")
End Sub
Sub listabel_Click
	StartActivity("firstaid")
End Sub
Sub katigorlabel_Click
	StartActivity("pixida")
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
End Sub
Sub ililabel_Click

	StartActivity(p.OpenBrowser("https://www.facebook.com/groups/256720274824210/"))
	
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
	

	Activity.Finish

End Sub
Sub WebViewExtras1_ProgressChanged(NewProgress As Int)
	'   NewProgress is Current page loading progress, represented by an integer between 0 and 100.
	'ToastMessageShow("WebView1 loading progress: "&NewProgress&"%",True)
	
	
	
	If Not(WebView1.Url = webviewText) Then
		If WebView1.Url = "about:blank" Then
			
		Else
			StartActivity(p.OpenBrowser(WebView1.Url))
			WebView1.LoadHtml(HTML)
		
		End If
	
	End If
End Sub
