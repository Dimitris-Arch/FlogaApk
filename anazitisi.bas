Type=Activity
Version=3.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim sc As ScrollView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label

Dim AdView1 As AdView




	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("sadr.bal")
    

	AdView1.Initialize("Ad", "ca-app-pub-6889311870331566/2287503739")
	 Activity.AddView(AdView1, 0dip, 100%y - 50dip, 100%x, 50dip)
   AdView1.LoadAd
	
		
		
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


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray
 clv2.AddTextItem("0000-0100" ,"miden100")
clv2.AddTextItem("0100-0200" ,"miden200")
clv2.AddTextItem("0200-0300" ,"miden300")
clv2.AddTextItem("0300-0400" ,"miden400")
clv2.AddTextItem("0400-0500" ,"miden500")
clv2.AddTextItem("0500-0600" ,"miden600")
 
clv2.AddTextItem("1000-1100" ,"xilia100")
clv2.AddTextItem("1100-1200" ,"xilia200")
clv2.AddTextItem("1200-1300" ,"xilia300")
clv2.AddTextItem("1300-1400" ,"xilia400")
clv2.AddTextItem("1400-1500" ,"xilia500")
clv2.AddTextItem("1500-1600" ,"xilia600")
clv2.AddTextItem("1600-1700" ,"xilia700")
clv2.AddTextItem("1700-1800" ,"xilia800")
clv2.AddTextItem("1800-1900" ,"xilia900")
clv2.AddTextItem("1900-2000" ,"xilia1000")
clv2.AddTextItem("2000-2100" ,"dyoxil100")
clv2.AddTextItem("2100-2200" ,"dyoxil200")
clv2.AddTextItem("2200-2300" ,"dyoxil300")
clv2.AddTextItem("2300-2400" ,"dyoxil400")
clv2.AddTextItem("2400-2500" ,"dyoxil500")
clv2.AddTextItem("2500-2600" ,"dyoxil600")
clv2.AddTextItem("2600-2700" ,"dyoxil700")
clv2.AddTextItem("2700-2800" ,"dyoxil800")
clv2.AddTextItem("2800-2900" ,"dyoxil900")
clv2.AddTextItem("2900-3000" ,"dyoxil1000")
clv2.AddTextItem("3000-3100" ,"triaxil100")
clv2.AddTextItem("3100-3200" ,"triaxil200")
clv2.AddTextItem("3200-3300" ,"triaxil300")
clv2.AddTextItem("3300-3400" ,"triaxil400")
clv2.AddTextItem("3400-3500" ,"triaxil500")
clv2.AddTextItem("3500-3600" ,"triaxil600")

End Sub

Sub clv2_ItemClick (Index As Int, Value As Object)
	
	

	If Value ="miden100" Then 
StartActivity("miden100")
End If

If Value = "miden200" Then 
StartActivity("miden200")
End If
If Value = "miden300" Then 
StartActivity("miden300")
End If
If Value = "miden400" Then 
StartActivity("miden400")
End If
If Value = "miden500" Then 
StartActivity("miden500")
End If
If Value = "miden600" Then 
StartActivity("miden600")
End If



If Value = "xilia100" Then 
StartActivity("xilia100")
End If
If Value = "xilia200" Then 
StartActivity("xilia200")
End If
If Value = "xilia300" Then 
StartActivity("xilia300")
End If
If Value = "xilia400" Then 
StartActivity("xilia400")
End If
If Value = "xilia500" Then 
StartActivity("xilia500")
End If
If Value = "xilia600" Then 
StartActivity("xilia600")
End If
If Value = "xilia700" Then 
StartActivity("xilia700")
End If
If Value = "xilia800" Then 
StartActivity("xilia800")
End If
If Value = "xilia900" Then 
StartActivity("xilia900")
End If
If Value = "xilia1000" Then 
StartActivity("xilia1000")
End If



If Value = "dyoxil100" Then 
StartActivity("dyoxil100")
End If

If Value = "dyoxil200" Then 
StartActivity("dyoxil200")
End If
If Value = "dyoxil300" Then 
StartActivity("dyoxil300")
End If
If Value = "dyoxil400" Then 
StartActivity("dyoxil400")
End If
If Value = "dyoxil500" Then 
StartActivity("dyoxil500")
End If
If Value = "dyoxil600" Then 
StartActivity("dyoxil600")
End If
If Value = "dyoxil700" Then 
StartActivity("dyoxil700")
End If
If Value = "dyoxil800" Then 
StartActivity("dyoxil800")
End If
If Value = "dyoxil900" Then 
StartActivity("dyoxil900")
End If
If Value = "dyoxil1000" Then 
StartActivity("dyoxil1000")
End If
If Value = "triaxil100" Then 
StartActivity("triaxil100")
End If
If Value = "triaxil200" Then 
StartActivity("triaxil200")
End If
If Value = "triaxil300" Then 
StartActivity("triaxil300")
End If
If Value = "triaxil400" Then 
StartActivity("triaxil400")
End If
If Value = "triaxil500" Then 
StartActivity("triaxil500")
End If
If Value = "triaxil600" Then 
StartActivity("triaxil600")
End If
	
End Sub

	
	
Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub
Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
Sub Ad_FailedToReceiveAd (ErrorCode As String)
   Log("failed: " & ErrorCode)
End Sub
Sub Ad_ReceiveAd
    Log("received")
End Sub
Sub Ad_AdScreenDismissed
   Log("screen dismissed")
End Sub