B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
    'These global variables will be declared once when the application starts.
    'These variables can be accessed from all modules.
   
   
Dim Orientation As PhoneOrientation
	Dim tmrUpdater As Timer

End Sub

Sub Globals
    'These global variables will be redeclared each time the activity is created.
    'These variables can only be accessed from this module.
   Dim pnlRose As Panel
	Dim Rotation As Animation
	Dim dblAngle As Double
	Dim pnlNeedle As Panel
	Private Label1 As Label

    
  
 
 Dim pw As PhoneWakeState



Dim ili As Button
Dim ousia As Button
Dim simansi As Button


Dim lista As Button

	Private katigor As Button
	
	
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label


	
	Private Label2 As Label
	Private Label3 As Label
	
	Private Label4 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
    'Do not forget to load the layout file created with the visual designer. For example:
    Activity.LoadLayout("pixida")
	
Activity.Color = Colors.Black

    simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y
pw.KeepAlive(True)
 simanseislabel.BringToFront
	 listabel.BringToFront
	 katigorlabel.BringToFront
	 ousialabel.BringToFront
	 ililabel.BringToFront
	

	
End Sub

Sub Activity_Resume
	
	dblAngle = 0
	pnlRose.SetBackgroundImage(LoadBitmapSample(File.DirAssets, "compass.png", pnlRose.Width, pnlRose.Width))
	pnlNeedle.SetBackgroundImage(LoadBitmapSample(File.DirAssets, "needle.png", pnlRose.Width/9.6, pnlRose.Width))
	Rotation.InitializeRotateCenter("Animation", dblAngle, dblAngle, pnlNeedle)
	Rotation.Duration = 20000
	tmrUpdater.Initialize("tmrUpdater",100)
	Orientation.StartListening("Orientation")
	tmrUpdater.Enabled = True
	Label1.BringToFront

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
	Dim bmpClear As Bitmap
	bmpClear.InitializeMutable(1,1)
	pnlRose.SetBackgroundImage(bmpClear)
	pnlNeedle.SetBackgroundImage(bmpClear)

End Sub
Sub Animation_AnimationEnd
	Try
		Rotation.Start(pnlNeedle)
	Catch
		Log(LastException.Message)
	End Try
End Sub

Sub Orientation_OrientationChanged (Azimuth As Float, Pitch As Float, Roll As Float)
	dblAngle = -Azimuth
	Label1.Text = Round2( 360 -  (dblAngle + 360), 1)  & "°"
   
	Label4.Text =  360 -  (dblAngle + 360)
	
	If Label4.Text > 0 And Label4.Text < 90 Then
		Label3.textColor = Colors.Green
		Label3.Text = "ΒΑ"
	End If
	If Label4.Text > 90 And Label4.Text < 180 Then
		Label3.textColor = Colors.red
		Label3.Text = "NA"
	End If
	If Label4.Text > 180 And Label4.Text < 270 Then
		Label3.textColor = Colors.Blue
		Label3.Text = "NΔ"
	End If
	If Label4.Text > 270 And Label4.Text < 360 Then
		Label3.textColor = Colors.Yellow
		Label3.Text = "BΔ"
	End If
	
	
	If Label4.Text = 0.0 Then
		Label3.textColor = Colors.Green
		Label3.Text = "B"
	End If
	If Label4.Text = 90.0 Then
		Label3.textColor = Colors.red
		Label3.text = "A"
	End If
	If Label4.Text = 180.0 Then
		Label3.textColor = Colors.Blue
		Label3.text = "N"
	End If
	If Label4.Text = 270.0 Then
		Label3.textColor = Colors.Yellow
		Label3.text = "Δ"
	End If
End Sub

Sub tmrUpdater_Tick
	Rotation.InitializeRotateCenter("Animation", dblAngle, dblAngle, pnlNeedle)
	Rotation.Duration = 20000
	Rotation.Start(pnlNeedle)
	
	
	
End Sub

Sub ili_Click
	StartActivity("firstaid")
End Sub
Sub ousia_Click
	StartActivity("gpssignal")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("thlefona")
End Sub

Sub katigor_Click
	StartActivity("camera")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("thlefona")
End Sub
Sub katigorlabel_Click
	StartActivity("camera")
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
End Sub
Sub ililabel_Click
	StartActivity("firstaid")
End Sub
Sub simansi_Click
	StartActivity("Main")
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
        Dim bmpClear As Bitmap
	bmpClear.InitializeMutable(1,1)
	pnlRose.SetBackgroundImage(bmpClear)
	pnlNeedle.SetBackgroundImage(bmpClear)
             Activity.Finish
       End If
End Sub





Sub Label1_Click
	Msgbox("","Μοίρες απο τον βορρά")
End Sub

Sub Label2_Click
	Msgbox("Για ακριβεστερη ένδειξη κουνήστε την συσκευή πάνω κάτω και γύρω γύρω","")
End Sub